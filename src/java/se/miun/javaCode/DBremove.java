/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.miun.javaCode;


import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;




/**
 *
 * @author Oliver
 */
@WebServlet("/DBremove.do")
public class DBremove extends HttpServlet {
private EntityManager em;    

    public DBremove() {
        this.toremove = em.find(DBreader.class, getId());
    }
        

}