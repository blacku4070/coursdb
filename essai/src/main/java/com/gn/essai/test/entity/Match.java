/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.essai.test.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author HAMDOUCH
 */

public class Match {
   private Long Id;
   private Joueur vainquer;
   private Joueur finaliste;
   private Epreuve epreuve;
   private Score score;

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
   

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Joueur getVainquer() {
        return vainquer;
    }

    public void setVainquer(Joueur vainquer) {
        this.vainquer = vainquer;
    }

    public Joueur getFinaliste() {
        return finaliste;
    }

    public void setFinaliste(Joueur finaliste) {
        this.finaliste = finaliste;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }
   
    
}
