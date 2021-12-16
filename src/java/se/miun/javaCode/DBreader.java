/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package se.miun.javaCode;

import static java.lang.System.out;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.annotation.FacesConfig;
import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.transaction.Transactional;
import se.miun.entities.Menuitem;
import se.miun.entities.Menuitemwebb;

/**
 *
 * @author hassa
 */

@FacesConfig(
        // Activates CDI build-in beans
        version = JSF_2_3
)
@Named(value = "dbreader")
@Dependent
public class DBreader {
    private String foodname;
    private int id;
    private int price;
    private int foodtype;
    private int time;
    private List <Menuitemwebb> resultList;

    @PersistenceContext(unitName = "AdminPage2PU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Creates a new instance of DBreader
     */
    public DBreader() {
    }
    
    public List <Menuitemwebb> readerDB(){
        TypedQuery<Menuitemwebb> MyQuery = em.createNamedQuery("Menuitemwebb.findAll", Menuitemwebb.class);
        resultList = MyQuery.getResultList();
        return resultList;
    }
    
    public void DBremove(int pos){
        
        try {
            //Menuitemwebb toremove = em.find(Menuitemwebb.class, pos);
            utx.begin();
            em.remove();
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
//        Menuitemwebb toremove = em.find(Menuitemwebb.class, pos);
//        em.getTransaction().begin();
//        int howmanydeleted = em.createQuery("DELETE FROM MENUITEM").executeUpdate();
//        out.println("hej  " + howmanydeleted);
//        //em.remove(toremove);
//        em.getTransaction().commit();
    }


    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * @return the foodname
     */
    public String getFoodname() {
        return foodname;
    }

    /**
     * @param foodname the foodname to set
     */
    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the foodtype
     */
    public int getFoodtype() {
        return foodtype;
    }

    /**
     * @param foodtype the foodtype to set
     */
    public void setFoodtype(int foodtype) {
        this.foodtype = foodtype;
    }

    /**
     * @return the time
     */
    public int getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(int time) {
        this.time = time;
    }
    
}
