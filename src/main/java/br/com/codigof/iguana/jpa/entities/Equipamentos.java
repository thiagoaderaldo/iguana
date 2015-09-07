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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "equipamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipamentos.findAll", query = "SELECT e FROM Equipamentos e"),
    @NamedQuery(name = "Equipamentos.findById", query = "SELECT e FROM Equipamentos e WHERE e.id = :id"),
    @NamedQuery(name = "Equipamentos.findByNome", query = "SELECT e FROM Equipamentos e WHERE e.nome = :nome")})
public class Equipamentos implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipamento")
    private Collection<DetalhesEquipamento> detalhesEquipamentoCollection;
    @JoinColumn(name = "tipo_dispositivo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dispositivos tipoDispositivo;

    public Equipamentos() {
    }

    public Equipamentos(Integer id) {
        this.id = id;
    }

    public Equipamentos(Integer id, String nome) {
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

    @XmlTransient
    public Collection<DetalhesEquipamento> getDetalhesEquipamentoCollection() {
        return detalhesEquipamentoCollection;
    }

    public void setDetalhesEquipamentoCollection(Collection<DetalhesEquipamento> detalhesEquipamentoCollection) {
        this.detalhesEquipamentoCollection = detalhesEquipamentoCollection;
    }

    public Dispositivos getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(Dispositivos tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
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
        if (!(object instanceof Equipamentos)) {
            return false;
        }
        Equipamentos other = (Equipamentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.codigof.iguana.jpa.entities.Equipamentos[ id=" + id + " ]";
    }
    
}
