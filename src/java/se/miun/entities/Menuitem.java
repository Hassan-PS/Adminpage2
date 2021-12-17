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
@Table(name = "MENUITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menuitem.findAll", query = "SELECT m FROM Menuitem m"),
    @NamedQuery(name = "Menuitem.findByFoodname", query = "SELECT m FROM Menuitem m WHERE m.foodname = :foodname"),
    @NamedQuery(name = "Menuitem.findById", query = "SELECT m FROM Menuitem m WHERE m.id = :id"),
    @NamedQuery(name = "Menuitem.findByPrice", query = "SELECT m FROM Menuitem m WHERE m.price = :price"),
    //@NamedQuery(name = "Menuitem.highestID", query = "SELECT m FROM MENUITEM WHERE MENUITEM.ID = (SELECT MAX(MENUITEM.ID) FROM MENUITEM)"),
    @NamedQuery(name = "Menuitem.findByFoodtype", query = "SELECT m FROM Menuitem m WHERE m.foodtype = :foodtype")})
public class Menuitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "FOODNAME")
    private String foodname;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private int price;
    @Column(name = "FOODTYPE")
    private Integer foodtype;

    public Menuitem() {
    }

    public Menuitem(Integer id) {
        this.id = id;
    }

    public Menuitem(Integer id, String foodname, int price) {
        this.id = id;
        this.foodname = foodname;
        this.price = price;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(Integer foodtype) {
        this.foodtype = foodtype;
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
        if (!(object instanceof Menuitem)) {
            return false;
        }
        Menuitem other = (Menuitem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.miun.entities.Menuitem[ id=" + id + " ]";
    }
    
}
