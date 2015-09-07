/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.codigof.iguana.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thiago
 */
@Entity
@Table(name = "solicitacoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitacoes.findAll", query = "SELECT s FROM Solicitacoes s"),
    @NamedQuery(name = "Solicitacoes.findById", query = "SELECT s FROM Solicitacoes s WHERE s.id = :id"),
    @NamedQuery(name = "Solicitacoes.findByProtocolo", query = "SELECT s FROM Solicitacoes s WHERE s.protocolo = :protocolo"),
    @NamedQuery(name = "Solicitacoes.findByProtocoloOrigem", query = "SELECT s FROM Solicitacoes s WHERE s.protocoloOrigem = :protocoloOrigem"),
    @NamedQuery(name = "Solicitacoes.findByTituloSolicitacao", query = "SELECT s FROM Solicitacoes s WHERE s.tituloSolicitacao = :tituloSolicitacao"),
    @NamedQuery(name = "Solicitacoes.findByDataSolicitacao", query = "SELECT s FROM Solicitacoes s WHERE s.dataSolicitacao = :dataSolicitacao"),
    @NamedQuery(name = "Solicitacoes.findByHoraSolicitacao", query = "SELECT s FROM Solicitacoes s WHERE s.horaSolicitacao = :horaSolicitacao"),
    @NamedQuery(name = "Solicitacoes.findByLocalizacao", query = "SELECT s FROM Solicitacoes s WHERE s.localizacao = :localizacao")})
public class Solicitacoes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 45)
    @Column(name = "protocolo")
    private String protocolo;
    @Size(max = 45)
    @Column(name = "protocolo_origem")
    private String protocoloOrigem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo_solicitacao")
    private String tituloSolicitacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_solicitacao")
    @Temporal(TemporalType.DATE)
    private Date dataSolicitacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_solicitacao")
    @Temporal(TemporalType.TIME)
    private Date horaSolicitacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "localizacao")
    private String localizacao;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "solicitante", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Solicitante solicitante;
    @JoinColumn(name = "origem", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Origem origem;
    @JoinColumn(name = "estatus", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estatus estatus;
    @JoinColumn(name = "atendimentos", referencedColumnName = "id")
    @ManyToOne
    private Atendimentos atendimentos;
    @JoinColumn(name = "dispositivo", referencedColumnName = "id")
    @ManyToOne
    private Dispositivos dispositivo;
    @JoinColumn(name = "assunto", referencedColumnName = "id")
    @ManyToOne
    private Assuntos assunto;

    public Solicitacoes() {
    }

    public Solicitacoes(Long id) {
        this.id = id;
    }

    public Solicitacoes(Long id, String tituloSolicitacao, Date dataSolicitacao, Date horaSolicitacao, String localizacao, String descricao) {
        this.id = id;
        this.tituloSolicitacao = tituloSolicitacao;
        this.dataSolicitacao = dataSolicitacao;
        this.horaSolicitacao = horaSolicitacao;
        this.localizacao = localizacao;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getProtocoloOrigem() {
        return protocoloOrigem;
    }

    public void setProtocoloOrigem(String protocoloOrigem) {
        this.protocoloOrigem = protocoloOrigem;
    }

    public String getTituloSolicitacao() {
        return tituloSolicitacao;
    }

    public void setTituloSolicitacao(String tituloSolicitacao) {
        this.tituloSolicitacao = tituloSolicitacao;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Date getHoraSolicitacao() {
        return horaSolicitacao;
    }

    public void setHoraSolicitacao(Date horaSolicitacao) {
        this.horaSolicitacao = horaSolicitacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    public Atendimentos getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(Atendimentos atendimentos) {
        this.atendimentos = atendimentos;
    }

    public Dispositivos getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivos dispositivo) {
        this.dispositivo = dispositivo;
    }

    public Assuntos getAssunto() {
        return assunto;
    }

    public void setAssunto(Assuntos assunto) {
        this.assunto = assunto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitacoes)) {
            return false;
        }
        Solicitacoes other = (Solicitacoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.codigof.iguana.jpa.entities.Solicitacoes[ id=" + id + " ]";
    }
    
}
