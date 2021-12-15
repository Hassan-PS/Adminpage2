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
@Table(name = "MENUITEMWEBB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menuitemwebb.findAll", query = "SELECT m FROM Menuitemwebb m"),
    @NamedQuery(name = "Menuitemwebb.findByFoodname", query = "SELECT m FROM Menuitemwebb m WHERE m.foodname = :foodname"),
    @NamedQuery(name = "Menuitemwebb.findById", query = "SELECT m FROM Menuitemwebb m WHERE m.id = :id"),
    @NamedQuery(name = "Menuitemwebb.findByPrice", query = "SELECT m FROM Menuitemwebb m WHERE m.price = :price"),
    @NamedQuery(name = "Menuitemwebb.findByFoodtype", query = "SELECT m FROM Menuitemwebb m WHERE m.foodtype = :foodtype"),
    @NamedQuery(name = "Menuitemwebb.findByTime", query = "SELECT m FROM Menuitemwebb m WHERE m.time = :time")})
public class Menuitemwebb implements Serializable {

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
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private int price;
    @Column(name = "FOODTYPE")
    private Integer foodtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIME")
    private String time;

    public Menuitemwebb() {
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
}
