/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a968692
 */
@Entity
@Table(name = "movimentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimentos.findAll", query = "SELECT m FROM Movimentos m")
    , @NamedQuery(name = "Movimentos.findByIdmovimentos", query = "SELECT m FROM Movimentos m WHERE m.idmovimentos = :idmovimentos")
    , @NamedQuery(name = "Movimentos.findByDirecao", query = "SELECT m FROM Movimentos m WHERE m.direcao = :direcao")
    , @NamedQuery(name = "Movimentos.findByTempo", query = "SELECT m FROM Movimentos m WHERE m.tempo = :tempo")})
public class Movimentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idmovimentos")
    private Integer idmovimentos;
    @Column(name = "direcao")
    private String direcao;
    @Column(name = "tempo")
    private String tempo;

    public Movimentos() {
    }

    public Movimentos(Integer idmovimentos) {
        this.idmovimentos = idmovimentos;
    }

    public Integer getIdmovimentos() {
        return idmovimentos;
    }

    public void setIdmovimentos(Integer idmovimentos) {
        this.idmovimentos = idmovimentos;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmovimentos != null ? idmovimentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimentos)) {
            return false;
        }
        Movimentos other = (Movimentos) object;
        if ((this.idmovimentos == null && other.idmovimentos != null) || (this.idmovimentos != null && !this.idmovimentos.equals(other.idmovimentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Movimentos[ idmovimentos=" + idmovimentos + " ]";
    }
    
}
