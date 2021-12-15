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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hassa
 */
@Entity
@Table(name = "RESTURANGORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resturangorder.findAll", query = "SELECT r FROM Resturangorder r"),
    @NamedQuery(name = "Resturangorder.findById", query = "SELECT r FROM Resturangorder r WHERE r.id = :id"),
    @NamedQuery(name = "Resturangorder.findByDishid", query = "SELECT r FROM Resturangorder r WHERE r.dishid = :dishid"),
    @NamedQuery(name = "Resturangorder.findByTimestamp", query = "SELECT r FROM Resturangorder r WHERE r.timestamp = :timestamp"),
    @NamedQuery(name = "Resturangorder.findByTablenr", query = "SELECT r FROM Resturangorder r WHERE r.tablenr = :tablenr"),
    @NamedQuery(name = "Resturangorder.findByNotes", query = "SELECT r FROM Resturangorder r WHERE r.notes = :notes")})
public class Resturangorder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DISHID")
    private int dishid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIMESTAMP")
    private String timestamp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TABLENR")
    private int tablenr;
    @Size(max = 500)
    @Column(name = "NOTES")
    private String notes;

    public Resturangorder() {
    }

    public Resturangorder(Integer id) {
        this.id = id;
    }

    public Resturangorder(Integer id, int dishid, String timestamp, int tablenr) {
        this.id = id;
        this.dishid = dishid;
        this.timestamp = timestamp;
        this.tablenr = tablenr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDishid() {
        return dishid;
    }

    public void setDishid(int dishid) {
        this.dishid = dishid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getTablenr() {
        return tablenr;
    }

    public void setTablenr(int tablenr) {
        this.tablenr = tablenr;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
        if (!(object instanceof Resturangorder)) {
            return false;
        }
        Resturangorder other = (Resturangorder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.miun.entities.Resturangorder[ id=" + id + " ]";
    }
    
}
