/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.miun.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hassa
 */
@Entity
@Table(name = "KITCHENORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kitchenorder.findAll", query = "SELECT k FROM Kitchenorder k"),
    @NamedQuery(name = "Kitchenorder.findById", query = "SELECT k FROM Kitchenorder k WHERE k.id = :id"),
    @NamedQuery(name = "Kitchenorder.findByOrderid", query = "SELECT k FROM Kitchenorder k WHERE k.orderid = :orderid"),
    @NamedQuery(name = "Kitchenorder.findByDone", query = "SELECT k FROM Kitchenorder k WHERE k.done = :done"),
    @NamedQuery(name = "Kitchenorder.findByDelivered", query = "SELECT k FROM Kitchenorder k WHERE k.delivered = :delivered")})
public class Kitchenorder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERID")
    private int orderid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DONE")
    private Boolean done;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIVERED")
    private Boolean delivered;

    public Kitchenorder() {
    }

    public Kitchenorder(Integer id) {
        this.id = id;
    }

    public Kitchenorder(Integer id, int orderid, Boolean done, Boolean delivered) {
        this.id = id;
        this.orderid = orderid;
        this.done = done;
        this.delivered = delivered;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
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
        if (!(object instanceof Kitchenorder)) {
            return false;
        }
        Kitchenorder other = (Kitchenorder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.miun.entities.Kitchenorder[ id=" + id + " ]";
    }
    
}
