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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a968692
 */
@Entity
@Table(name = "dados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dados.findAll", query = "SELECT d FROM Dados d")
    , @NamedQuery(name = "Dados.findByIddados", query = "SELECT d FROM Dados d WHERE d.iddados = :iddados")
    , @NamedQuery(name = "Dados.findByValor", query = "SELECT d FROM Dados d WHERE d.valor = :valor")})
public class Dados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "iddados")
    private Integer iddados;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @JoinColumn(name = "sensores_idsensores", referencedColumnName = "idsensores")
    @ManyToOne(optional = false)
    private Sensores sensoresIdsensores;

    public Dados() {
    }

    public Dados(Integer iddados) {
        this.iddados = iddados;
    }

    public Integer getIddados() {
        return iddados;
    }

    public void setIddados(Integer iddados) {
        this.iddados = iddados;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Sensores getSensoresIdsensores() {
        return sensoresIdsensores;
    }

    public void setSensoresIdsensores(Sensores sensoresIdsensores) {
        this.sensoresIdsensores = sensoresIdsensores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddados != null ? iddados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dados)) {
            return false;
        }
        Dados other = (Dados) object;
        if ((this.iddados == null && other.iddados != null) || (this.iddados != null && !this.iddados.equals(other.iddados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Dados[ iddados=" + iddados + " ]";
    }
    
}
