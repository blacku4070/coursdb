package com.gn.essai.test.repository;

import com.gn.essai.test.DataSourceProvider;
import com.gn.essai.test.entity.Joueur;
import com.gn.essai.test.entity.Tournoi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HAMDOUCH
 */
public class TournoiRepositoryImpl {
    public void create (Tournoi tournoi){
         Connection conn = null;
        try {
         DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
       
            conn=dataSource.getConnection();
            PreparedStatement prepareStatement =conn.prepareStatement("INSERT INTO TOURNOI (NOM,CODE) VALUES(?,?)");
                
                  prepareStatement.setString(1, tournoi.getNom());
                    prepareStatement.setString(2, tournoi.getCode());
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
    public void update (Tournoi tournoi){
         Connection conn = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
       
            conn=dataSource.getConnection();
            PreparedStatement prepareStatement =conn.prepareStatement("UPDATE TOURNOI SET NOM=?,CODE=? where ID=?");
                prepareStatement.setString(1, tournoi.getNom());
                  prepareStatement.setString(2, tournoi.getCode());
                    prepareStatement.setLong(3, tournoi.getId());
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
            PreparedStatement prepareStatement =conn.prepareStatement("DELETE FROM TOURNOI where ID=?");
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
    public Tournoi getById (Long id){
        Tournoi tournoi =null;
         Connection conn = null;
        try {
         DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn=dataSource.getConnection();
            PreparedStatement prepareStatement =conn.prepareStatement("SELECT ID,NOM,CODE FROM TOURNOI where ID=?");
                    prepareStatement.setLong(1,id);
            prepareStatement.executeQuery();
           ResultSet rs = prepareStatement.executeQuery();
           if (rs.next()) {
              tournoi =new Tournoi();
               tournoi.setId(id);
               tournoi.setNom(rs.getString("NOM"));
               tournoi.setCode("CODE");
               
              
                
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
            return tournoi;
        }
    
    }
    public List<Tournoi> list (){
       List<Tournoi> tournoi =new ArrayList<>();
         Connection conn = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn=dataSource.getConnection();
            PreparedStatement prepareStatement =conn.prepareStatement("SELECT ID,NOM,CODE FROM TOURNOI");
           
            prepareStatement.executeQuery();
           ResultSet rs = prepareStatement.executeQuery();
           while (rs.next()) {
              Tournoi trn =new Tournoi();
               trn.setId(rs.getLong("id"));
               trn.setNom(rs.getString("NOM"));
               trn.setCode(rs.getString("CODE"));
               tournoi.add(trn);
               
              
                
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
            return tournoi;
        }
    
    }
    
}
