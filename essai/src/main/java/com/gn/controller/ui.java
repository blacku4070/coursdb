/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.controller;

import com.gn.essai.test.entity.Joueur;

/**
 *
 * @author HAMDOUCH
 */
public class ui {
    public static void main (String ... args){
    JoueurController controller = new JoueurController();
        Joueur afich =controller.afficheDetailJoueur(1);
        System.out.println(afich.getNom()+" " + afich.getPrenom());
    
    }
}
