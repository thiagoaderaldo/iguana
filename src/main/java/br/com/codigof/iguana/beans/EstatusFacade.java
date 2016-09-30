/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.codigof.iguana.beans;

import br.com.codigof.iguana.jpa.entities.Estatus;
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
public class EstatusFacade extends AbstractFacade<Estatus> {

    @PersistenceContext(unitName = "br.com.codigof_iguana_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstatusFacade() {
        super(Estatus.class);
    }

    public Estatus findByNome(String nome) {
        //Retorna solicitante do mes atual
        Query q = null;
//      O cache é evitado apenas na hora da execução do
//      comando.
        em.getEntityManagerFactory().getCache().evictAll();
        try {
            q = em.createNamedQuery("Estatus.findByNome",
                    Estatus.class).setParameter("nome", nome);
            Estatus est = new Estatus();
            est = (Estatus) q.getSingleResult();
            return est;
        } catch (Exception ex) {
            Logger.getLogger(Estatus.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
