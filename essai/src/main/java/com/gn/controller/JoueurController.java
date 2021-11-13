/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.controller;

import com.gn.essai.test.entity.Joueur;
import com.gn.essai.test.repository.JoueurRepositoryImpl;
import java.util.Scanner;
import services.JoueurServices;

/**
 *
 * @author HAMDOUCH
 */
public class JoueurController {
    private JoueurServices joueurservices;
    public  JoueurController(){
    this.joueurservices = new JoueurServices();
    }
  public Joueur afficheDetailJoueur (long identifiant){
     
      return joueurservices.getJoueur(identifiant);
      
      
      
  }
    
}
