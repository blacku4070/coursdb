/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.gn.essai.test.entity.Tournoi;
import com.gn.essai.test.repository.TournoiRepositoryImpl;

/**
 *
 * @author HAMDOUCH
 */
public class TournoiService {
     private TournoiRepositoryImpl tournoiRepository;
    public TournoiService(){
    this.tournoiRepository =new TournoiRepositoryImpl();
    
    }
    public void creatTournoi (Tournoi tournoi){
    
    tournoiRepository.create(tournoi);
    }
    
    public Tournoi getTournoi (Long id){
   return tournoiRepository.getById(id);
    
    }
    
}
