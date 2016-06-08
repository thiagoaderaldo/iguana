/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.codigof.iguana.beans;

import br.com.codigof.iguana.jpa.entities.Solicitacoes;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author thiago
 */
@Stateless
public class SolicitacoesFacade extends AbstractFacade<Solicitacoes> {
    @PersistenceContext(unitName = "br.com.codigof_iguana_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitacoesFacade() {
        super(Solicitacoes.class);
    }
    
    public List<Solicitacoes> findByCurrentMonth() {

        Query q = null;
//      O cache é evitado apenas na hora da execução do
//      comando.
        em.getEntityManagerFactory().getCache().evictAll();
        try {
            q = em.createNamedQuery("Solicitacoes.findByCurrentMonth",
                    Solicitacoes.class);

        } catch (Exception ex) {
            Logger.getLogger(Solicitacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return q.getResultList();
    }
}
