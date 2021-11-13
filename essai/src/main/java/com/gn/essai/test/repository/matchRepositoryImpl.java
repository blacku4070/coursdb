/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.essai.test.repository;

import com.gn.essai.test.DataSourceProvider;
import com.gn.essai.test.entity.Joueur;
import com.gn.essai.test.entity.Match;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author HAMDOUCH
 */
public class matchRepositoryImpl {
 
    public void create (Match match){
         Connection conn = null;
        try {
         DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
       
            conn=dataSource.getConnection();
            PreparedStatement prepareStatement =conn.prepareStatement("INSERT INTO match_tennis (ID_EPREUVE,ID_VAINQUEUR,ID_FINALISTE) VALUES(?,?,?)");
                prepareStatement.setLong(1, match.getEpreuve().getId());
                  prepareStatement.setLong(2, match.getVainquer().getId());
                    prepareStatement.setLong(3, match.getFinaliste().getId());
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
    
}
