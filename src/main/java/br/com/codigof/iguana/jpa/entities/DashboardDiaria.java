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
    @NamedQuery(name = "DashboardDiaria.findByQtdAtdAbertos", query = "SELECT d FROM DashboardDiaria d WHERE d.qtdAtdAbertos = :qtdAtdAbertos"),
    @NamedQuery(name = "DashboardDiaria.findByQtdAtdPdtes", query = "SELECT d FROM DashboardDiaria d WHERE d.qtdAtdPdtes = :qtdAtdPdtes"),
    @NamedQuery(name = "DashboardDiaria.findBySlcAtdEmPercent", query = "SELECT d FROM DashboardDiaria d WHERE d.slcAtdEmPercent = :slcAtdEmPercent"),
    @NamedQuery(name = "DashboardDiaria.findByQtdAtdEspr", query = "SELECT d FROM DashboardDiaria d WHERE d.qtdAtdEspr = :qtdAtdEspr")})
public class DashboardDiaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "qtd_atd_abertos")
    @Id
    private BigInteger qtdAtdAbertos;
    @Column(name = "qtd_atd_pdtes")
    private BigInteger qtdAtdPdtes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "slc_atd_em_percent")
    private BigDecimal slcAtdEmPercent;
    @Column(name = "qtd_atd_espr")
    private BigInteger qtdAtdEspr;

    public DashboardDiaria() {
    }

    public BigInteger getQtdAtdAbertos() {
        return qtdAtdAbertos;
    }

    public void setQtdAtdAbertos(BigInteger qtdAtdAbertos) {
        this.qtdAtdAbertos = qtdAtdAbertos;
    }

    public BigInteger getQtdAtdPdtes() {
        return qtdAtdPdtes;
    }

    public void setQtdAtdPdtes(BigInteger qtdAtdPdtes) {
        this.qtdAtdPdtes = qtdAtdPdtes;
    }

    public BigDecimal getSlcAtdEmPercent() {
        return slcAtdEmPercent;
    }

    public void setSlcAtdEmPercent(BigDecimal slcAtdEmPercent) {
        this.slcAtdEmPercent = slcAtdEmPercent;
    }

    public BigInteger getQtdAtdEspr() {
        return qtdAtdEspr;
    }

    public void setQtdAtdEspr(BigInteger qtdAtdEspr) {
        this.qtdAtdEspr = qtdAtdEspr;
    }
    
}