/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.codigof.iguana.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thiago
 */
@Entity
@Table(name = "detalhes_equipamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalhesEquipamento.findAll", query = "SELECT d FROM DetalhesEquipamento d"),
    @NamedQuery(name = "DetalhesEquipamento.findById", query = "SELECT d FROM DetalhesEquipamento d WHERE d.id = :id"),
    @NamedQuery(name = "DetalhesEquipamento.findByMac", query = "SELECT d FROM DetalhesEquipamento d WHERE d.mac = :mac"),
    @NamedQuery(name = "DetalhesEquipamento.findBySistemaOperacional", query = "SELECT d FROM DetalhesEquipamento d WHERE d.sistemaOperacional = :sistemaOperacional"),
    @NamedQuery(name = "DetalhesEquipamento.findByNumSerie", query = "SELECT d FROM DetalhesEquipamento d WHERE d.numSerie = :numSerie"),
    @NamedQuery(name = "DetalhesEquipamento.findByLicencaSistOperacional", query = "SELECT d FROM DetalhesEquipamento d WHERE d.licencaSistOperacional = :licencaSistOperacional"),
    @NamedQuery(name = "DetalhesEquipamento.findByTipoDeOffice", query = "SELECT d FROM DetalhesEquipamento d WHERE d.tipoDeOffice = :tipoDeOffice"),
    @NamedQuery(name = "DetalhesEquipamento.findByLicencaOffice", query = "SELECT d FROM DetalhesEquipamento d WHERE d.licencaOffice = :licencaOffice"),
    @NamedQuery(name = "DetalhesEquipamento.findByNumTombamento", query = "SELECT d FROM DetalhesEquipamento d WHERE d.numTombamento = :numTombamento")})
public class DetalhesEquipamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "mac")
    private String mac;
    @Size(max = 45)
    @Column(name = "sistema_operacional")
    private String sistemaOperacional;
    @Size(max = 45)
    @Column(name = "num_serie")
    private String numSerie;
    @Size(max = 45)
    @Column(name = "licenca_sist_operacional")
    private String licencaSistOperacional;
    @Size(max = 45)
    @Column(name = "tipo_de_office")
    private String tipoDeOffice;
    @Size(max = 45)
    @Column(name = "licenca_office")
    private String licencaOffice;
    @Size(max = 45)
    @Column(name = "num_tombamento")
    private String numTombamento;
    @JoinColumn(name = "equipamento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Equipamentos equipamento;

    public DetalhesEquipamento() {
    }

    public DetalhesEquipamento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getLicencaSistOperacional() {
        return licencaSistOperacional;
    }

    public void setLicencaSistOperacional(String licencaSistOperacional) {
        this.licencaSistOperacional = licencaSistOperacional;
    }

    public String getTipoDeOffice() {
        return tipoDeOffice;
    }

    public void setTipoDeOffice(String tipoDeOffice) {
        this.tipoDeOffice = tipoDeOffice;
    }

    public String getLicencaOffice() {
        return licencaOffice;
    }

    public void setLicencaOffice(String licencaOffice) {
        this.licencaOffice = licencaOffice;
    }

    public String getNumTombamento() {
        return numTombamento;
    }

    public void setNumTombamento(String numTombamento) {
        this.numTombamento = numTombamento;
    }

    public Equipamentos getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamentos equipamento) {
        this.equipamento = equipamento;
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
        if (!(object instanceof DetalhesEquipamento)) {
            return false;
        }
        DetalhesEquipamento other = (DetalhesEquipamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.codigof.iguana.jpa.entities.DetalhesEquipamento[ id=" + id + " ]";
    }
    
}
