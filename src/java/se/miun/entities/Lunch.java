/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.miun.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Oliver
 */
@Entity
@Table(name = "LUNCH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lunch.findAll", query = "SELECT m FROM Lunch m ORDER BY m.day"),
    @NamedQuery(name = "Lunch.findByLunch_name", query = "SELECT m FROM Lunch m WHERE m.lunch_name = :lunch_name"),
    @NamedQuery(name = "Lunch.findById", query = "SELECT m FROM Lunch m WHERE m.id = :id"),
    @NamedQuery(name = "Lunch.findByDay", query = "SELECT m FROM Lunch m WHERE m.day = :day"),
    //@NamedQuery(name = "Menuitem.highestID", query = "SELECT m FROM MENUITEM WHERE MENUITEM.ID = (SELECT MAX(MENUITEM.ID) FROM MENUITEM)"),
    @NamedQuery(name = "Lunch.findBydescription", query = "SELECT m FROM Lunch m WHERE m.description = :description")})
public class Lunch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = true)
    @Size(min = 1, max = 50)
    @Column(name = "LUNCH_NAME")
    private String lunch_name;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = true)
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "LUNCH_DAY")
    private Integer day;

    public Lunch() {
    }

//    public Menuitem(Integer id) {
//        this.id = id;
//    }

    public Lunch(String lunch_name, String description) {
        this.lunch_name = lunch_name;
        this.description = description;
    }

    public String getLunch_name() {
        return lunch_name;
    }

    public void setLunch_name(String lunch_name) {
        this.lunch_name = lunch_name;
    }

    public Integer getId() {
        return id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
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
        if (!(object instanceof Lunch)) {
            return false;
        }
        Lunch other = (Lunch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.miun.entities.Lunch[ id=" + id + " ]";
    }
    
}
