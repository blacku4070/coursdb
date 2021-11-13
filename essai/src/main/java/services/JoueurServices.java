/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.gn.essai.test.entity.Joueur;
import com.gn.essai.test.repository.JoueurRepositoryImpl;

/**
 *
 * @author HAMDOUCH
 */
public class JoueurServices {
    private JoueurRepositoryImpl joueurRepositoryImpl;
    public JoueurServices(){
    this.joueurRepositoryImpl =new JoueurRepositoryImpl();
    
    }
    public void creatJoueur (Joueur joueur){
    
    joueurRepositoryImpl.create(joueur);
    }
    
    public Joueur getJoueur (Long id){
   return joueurRepositoryImpl.getById(id);
    
    }
    
    
}
