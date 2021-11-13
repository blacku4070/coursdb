/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.essai.test.repository;

import com.gn.essai.test.DataSourceProvider;
import com.gn.essai.test.entity.Joueur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author HAMDOUCH
 */
public class JoueurRepositoryImpl {
    public void create (Joueur joueur){
         Connection conn = null;
        try {
         DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
       
            conn=dataSource.getConnection();
            PreparedStatement prepareStatement =conn.prepareStatement("INSERT INTO JOUEUR (NOM,PRENOM,SEXE) VALUES(?,?,?)");
                prepareStatement.setString(1, joueur.getNom());
                  prepareStatement.setString(2, joueur.getPrenom());
                    prepareStatement.setString(3, joueur.getSexe().toString());
            prepareStatement.executeUpdate();
          
            
            System.out.println("success insert");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn!=null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
    }
    public void update (Joueur joueur){
         Connection conn = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
       
            conn=dataSource.getConnection();
            PreparedStatement prepareStatement =conn.prepareStatement("UPDATE JOUEUR SET NOM=?,PRENOM=?,SEXE=? where ID=?");
                prepareStatement.setString(1, joueur.getNom());
                  prepareStatement.setString(2, joueur.getPrenom());
                    prepareStatement.setString(3, joueur.getSexe().toString());
                    prepareStatement.setLong(4, joueur.getId());
            prepareStatement.executeUpdate();
          
            
            System.out.println("success UPDATE");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn!=null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
    }
    
    public void DELETE (Long id){
         Connection conn = null;
        try {
           DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
       
            conn=dataSource.getConnection();
            PreparedStatement prepareStatement =conn.prepareStatement("DELETE FROM JOUEUR where ID=?");
                    prepareStatement.setLong(1,id);
            prepareStatement.executeUpdate();
          
            
            System.out.println("success DELETE");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn!=null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
    }
    public Joueur getById (Long id){
        Joueur joueur =null;
         Connection conn = null;
        try {
         DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn=dataSource.getConnection();
            PreparedStatement prepareStatement =conn.prepareStatement("SELECT NOM,PRENOM,SEXE FROM JOUEUR where ID=?");
                    prepareStatement.setLong(1,id);
            
           ResultSet rs = prepareStatement.executeQuery();
           if (rs.next()) {
               joueur =new Joueur();
               joueur.setId(id);
               joueur.setNom(rs.getString("NOM"));
                joueur.setPrenom(rs.getString("PRENOM"));
               joueur.setSexe(rs.getString("SEXE").charAt(0));
            }
            System.out.println("success Read");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn!=null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return joueur;
        }
    
    }
    public List<Joueur> list (){
       List<Joueur> joueurs =new ArrayList<>();
         Connection conn = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn=dataSource.getConnection();
            PreparedStatement prepareStatement =conn.prepareStatement("SELECT ID,NOM,PRENOM,SEXE FROM JOUEUR");
           
            prepareStatement.executeQuery();
           ResultSet rs = prepareStatement.executeQuery();
           while (rs.next()) {
              Joueur joueur =new Joueur();
               joueur.setId(rs.getLong("id"));
               joueur.setNom(rs.getString("NOM"));
               joueur.setSexe(rs.getString("SEXE").charAt(0));
               joueurs.add(joueur);
               
              
                
            }
            
            System.out.println("success Read list");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn!=null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return joueurs;
        }
    
    }
    
}
