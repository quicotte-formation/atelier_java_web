/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webtest.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import webtest.entity.Chambre;
import webtest.entity.Hotel;

/**
 *
 * @author formation
 */
public class ChambreService {
    
    public void supprimer(long id){
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        em.getTransaction().begin();
        Chambre chambre = em.find(Chambre.class, id);
        em.remove(chambre);
        em.getTransaction().commit();
    }
    
    public void ajouter(Chambre c, long hotelId){
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        em.getTransaction().begin();
        Hotel hotel = em.find(Hotel.class, hotelId);
        c.setHotel(hotel);// Double association
        hotel.getChambres().add(c);// Double association
        em.persist(c);
        em.getTransaction().commit();
    }

    public List<Chambre> lister() {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        return em.createQuery("SELECT c FROM Chambre c ORDER BY c.nom").getResultList();
    }
}
