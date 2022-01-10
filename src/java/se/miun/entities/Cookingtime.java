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
 * @author hassa
 */
@Entity
@Table(name = "COOKINGTIME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cookingtime.findAll", query = "SELECT c FROM Cookingtime c"),
    @NamedQuery(name = "Cookingtime.findById", query = "SELECT c FROM Cookingtime c WHERE c.id = :id"),
    @NamedQuery(name = "Cookingtime.findByMenuitemid", query = "SELECT c FROM Cookingtime c WHERE c.menuitemid = :menuitemid"),
    @NamedQuery(name = "Cookingtime.findByTime", query = "SELECT c FROM Cookingtime c WHERE c.time = :time")})
public class Cookingtime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MENUITEMID")
    private int menuitemid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIME")
    private String time;

    public Cookingtime() {
    }

//    public Cookingtime(Integer id) {
//        this.id = id;
//    }

    public Cookingtime(int menuitemid, String time) {
        this.menuitemid = menuitemid;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public int getMenuitemid() {
        return menuitemid;
    }

    public void setMenuitemid(int menuitemid) {
        this.menuitemid = menuitemid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
        if (!(object instanceof Cookingtime)) {
            return false;
        }
        Cookingtime other = (Cookingtime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.miun.entities.Cookingtime[ id=" + id + " ]";
    }
    
}
