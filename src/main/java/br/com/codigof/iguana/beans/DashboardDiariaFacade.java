/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.codigof.iguana.beans;

import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.codigof.iguana.jpa.entities.DashboardDiaria;

/**
 * 
 * @author lucas.freire
 */
@Stateless
public class DashboardDiariaFacade extends AbstractFacade<DashboardDiaria> {

    @PersistenceContext(unitName = "br.com.codigof_iguana_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DashboardDiariaFacade() {
        super(DashboardDiaria.class);
    }
    
    public DashboardDiaria teste(BigInteger atendimentosabertos){
        return find(atendimentosabertos);
    }
    
}
