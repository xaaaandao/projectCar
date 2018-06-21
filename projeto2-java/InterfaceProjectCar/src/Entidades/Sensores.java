/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author a968692
 */
@Entity
@Table(name = "sensores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sensores.findAll", query = "SELECT s FROM Sensores s")
    , @NamedQuery(name = "Sensores.findByIdsensores", query = "SELECT s FROM Sensores s WHERE s.idsensores = :idsensores")
    , @NamedQuery(name = "Sensores.findByNome", query = "SELECT s FROM Sensores s WHERE s.nome = :nome")
    , @NamedQuery(name = "Sensores.findByDescricao", query = "SELECT s FROM Sensores s WHERE s.descricao = :descricao")})
public class Sensores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idsensores")
    private Integer idsensores;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sensoresIdsensores")
    private List<Dados> dadosList;

    public Sensores() {
    }

    public Sensores(Integer idsensores) {
        this.idsensores = idsensores;
    }

    public Integer getIdsensores() {
        return idsensores;
    }

    public void setIdsensores(Integer idsensores) {
        this.idsensores = idsensores;
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
    public List<Dados> getDadosList() {
        return dadosList;
    }

    public void setDadosList(List<Dados> dadosList) {
        this.dadosList = dadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsensores != null ? idsensores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sensores)) {
            return false;
        }
        Sensores other = (Sensores) object;
        if ((this.idsensores == null && other.idsensores != null) || (this.idsensores != null && !this.idsensores.equals(other.idsensores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Sensores[ idsensores=" + idsensores + " ]";
    }
    
}
