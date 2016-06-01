/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.codigof.iguana.jpa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucas.freire
 */
@Entity
@Table(name = "dashboard_diaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DashboardDiaria.findAll", query = "SELECT d FROM DashboardDiaria d"),
    @NamedQuery(name = "DashboardDiaria.findByAtendimentosabertos", query = "SELECT d FROM DashboardDiaria d WHERE d.atendimentosabertos = :atendimentosabertos"),
    @NamedQuery(name = "DashboardDiaria.findByAtendimentospendentes", query = "SELECT d FROM DashboardDiaria d WHERE d.atendimentospendentes = :atendimentospendentes"),
    @NamedQuery(name = "DashboardDiaria.findBySolicitacaoatendidasemp", query = "SELECT d FROM DashboardDiaria d WHERE d.solicitacaoatendidasemp = :solicitacaoatendidasemp"),
    @NamedQuery(name = "DashboardDiaria.findByAtendimentoemspera", query = "SELECT d FROM DashboardDiaria d WHERE d.atendimentoemspera = :atendimentoemspera")})
public class DashboardDiaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "Atendimentos_abertos")
    @Id
    private BigInteger atendimentosabertos;
    @Column(name = "Atendimentos_pendentes")
    private BigInteger atendimentospendentes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Solicitacao_atendidas_em_p")
    private BigDecimal solicitacaoatendidasemp;
    @Column(name = "Atendimento_em_spera")
    private BigInteger atendimentoemspera;

    public DashboardDiaria() {
    }

    public BigInteger getAtendimentosabertos() {
        return atendimentosabertos;
    }

    public void setAtendimentosabertos(BigInteger atendimentosabertos) {
        this.atendimentosabertos = atendimentosabertos;
    }

    public BigInteger getAtendimentospendentes() {
        return atendimentospendentes;
    }

    public void setAtendimentospendentes(BigInteger atendimentospendentes) {
        this.atendimentospendentes = atendimentospendentes;
    }

    public BigDecimal getSolicitacaoatendidasemp() {
        return solicitacaoatendidasemp;
    }

    public void setSolicitacaoatendidasemp(BigDecimal solicitacaoatendidasemp) {
        this.solicitacaoatendidasemp = solicitacaoatendidasemp;
    }

    public BigInteger getAtendimentoemspera() {
        return atendimentoemspera;
    }

    public void setAtendimentoemspera(BigInteger atendimentoemspera) {
        this.atendimentoemspera = atendimentoemspera;
    }
    
}
