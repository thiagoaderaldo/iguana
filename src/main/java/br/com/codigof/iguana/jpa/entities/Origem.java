/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.codigof.iguana.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thiago
 */
@Entity
@Table(name = "origem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Origem.findAll", query = "SELECT o FROM Origem o"),
    @NamedQuery(name = "Origem.findById", query = "SELECT o FROM Origem o WHERE o.id = :id"),
    @NamedQuery(name = "Origem.findByNome", query = "SELECT o FROM Origem o WHERE o.nome = :nome"),
    @NamedQuery(name = "Origem.findByDescricao", query = "SELECT o FROM Origem o WHERE o.descricao = :descricao")})
public class Origem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 45)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "origem")
    private Collection<Solicitacoes> solicitacoesCollection;

    public Origem() {
    }

    public Origem(Integer id) {
        this.id = id;
    }

    public Origem(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Solicitacoes> getSolicitacoesCollection() {
        return solicitacoesCollection;
    }

    public void setSolicitacoesCollection(Collection<Solicitacoes> solicitacoesCollection) {
        this.solicitacoesCollection = solicitacoesCollection;
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
        if (!(object instanceof Origem)) {
            return false;
        }
        Origem other = (Origem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.codigof.iguana.jpa.entities.Origem[ id=" + id + " ]";
    }
    
}
