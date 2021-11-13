/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.gn.essai.test.entity.Match;
import com.gn.essai.test.repository.matchRepositoryImpl;
import com.gn.essai.test.repository.scoreRepositoryImpl;

/**
 *
 * @author HAMDOUCH
 */
public class matchServices {
    private scoreRepositoryImpl scoreRepositoryImpl1;
    private matchRepositoryImpl matchRepositoryImpl;
    public matchServices(){
    this.scoreRepositoryImpl1 = new scoreRepositoryImpl();
    this.matchRepositoryImpl = new matchRepositoryImpl();
    
    }
    
    public  void  enregistrerNouveauMatch(Match match){
        matchRepositoryImpl.create(match);
        scoreRepositoryImpl1.create(match.getScore());
    
    
    }
    
}
