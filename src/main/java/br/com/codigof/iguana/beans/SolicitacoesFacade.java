/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.codigof.iguana.beans;

import br.com.codigof.iguana.jpa.entities.Estatus;
import br.com.codigof.iguana.jpa.entities.Solicitacoes;
import br.com.codigof.iguana.util.DateManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
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

    public List<Solicitacoes> findAllCurrentDate() {

        Query q = null;
        List<Solicitacoes> solicitacoes = null;
//      O cache é evitado apenas na hora da execução do
//      comando.
        em.getEntityManagerFactory().getCache().evictAll();
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            q = em.createNamedQuery("Solicitacoes.findByDataSolicitacao",
                    Solicitacoes.class).setParameter("dataSolicitacao", DateManager.StringToDateSQL("dd/MM/yyyy", dateFormat.format(date)));
            solicitacoes = q.getResultList();

        } catch (Exception ex) {
            Logger.getLogger(Solicitacoes.class.getName()).log(Level.SEVERE, null, ex);
        }

        return solicitacoes;
    }

    public static List<String> findByCurrentWeek() {
        List<String> currentWeek = new ArrayList<String>();
        try {
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/iguana";
            Class.forName(myDriver).newInstance();
            Connection coon = DriverManager.getConnection(myUrl, "iguana", "1");
            String query = "SELECT data_solicitacao FROM solicitacoes WHERE data_solicitacao >= STR_TO_DATE(CONCAT(YEARWEEK(CURRENT_DATE()),'Sunday'),'%X%V %W') AND data_solicitacao <= STR_TO_DATE(CONCAT(YEARWEEK(CURRENT_DATE()),'Saturday'),'%X%V %W')";
            Statement st = coon.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                currentWeek.add(rs.getString("data_solicitacao"));

            }
            st.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an execption!");
            System.err.println(e.getMessage());
        } catch (InstantiationException ex) {
            Logger.getLogger(SolicitacoesFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SolicitacoesFacade.class.getName()).log(Level.SEVERE, null, ex);
        }

        return currentWeek;
    }

    //Retorna solicitante do mes atual
    public List<String> findBySolicitanteCurrentMonth() {
        List<String> solicitacao = null;
        try {
            solicitacao = em.createNamedQuery("Solicitacoes.findByQtdSolicitacao")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        for (int i = 0; i < solicitacao.size(); i++) {
//            System.out.println(solicitacao.get(i));
//       }
        return solicitacao;
    }

    //Retorna solicitante do mes atual
    public List<Solicitacoes> findByEstatus(Estatus estatus) {
        Query q = null;
        List<Solicitacoes> solicitacoes = null;
//      O cache é evitado apenas na hora da execução do
//      comando.
        em.getEntityManagerFactory().getCache().evictAll();
        try {
            q = em.createNamedQuery("Solicitacoes.findByEstatus",
                    Solicitacoes.class).setParameter("estatus", estatus);
            solicitacoes = q.getResultList();

        } catch (Exception ex) {
            Logger.getLogger(Solicitacoes.class.getName()).log(Level.SEVERE, null, ex);
        }

        return solicitacoes;
    }

}
