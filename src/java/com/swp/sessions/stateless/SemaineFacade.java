/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.sessions.stateless;

import com.swp.beans.Semaine;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author genereux
 */
@Stateless
public class SemaineFacade extends AbstractFacade<Semaine> {

    @PersistenceContext(unitName = "swpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SemaineFacade() {
        super(Semaine.class);
    }
    
    
     public Semaine getSemaineById(String id){
        TypedQuery<Semaine> query = em.createNamedQuery( "Semaine.findByIdsemaine", Semaine.class);
        query.setParameter("idsemaine", id);
        Semaine sem = query.getSingleResult();
        return sem;
    }
}
