/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.essai.test.repository;

import com.gn.essai.test.DataSourceProvider;
import com.gn.essai.test.entity.Score;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author HAMDOUCH
 */
public class scoreRepositoryImpl {
      public void create (Score score){
         Connection conn = null;
        try {
         DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
       
            conn=dataSource.getConnection();
            PreparedStatement prepareStatement =conn.prepareStatement("INSERT INTO score_vainqueur (ID_MATCH,SET_1,SET_2,SET_3,SET_4,SET_5) VALUES(?,?,?,?,?,?)");
                prepareStatement.setLong(1,score.getMatch().getId());
                  prepareStatement.setByte(2, score.getSet1());
                   prepareStatement.setByte(3, score.getSet2());
                    prepareStatement.setByte(4, score.getSet3());
                     prepareStatement.setByte(5, score.getSet4());
                      prepareStatement.setByte(6, score.getSet5());
                  
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
