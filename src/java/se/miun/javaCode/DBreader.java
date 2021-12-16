/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package se.miun.javaCode;


import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import se.miun.entities.Menuitem;
import se.miun.entities.Menuitemwebb;
import se.miun.entities.Cookingtime;

/**
 *
 * @author hassa
 */

@FacesConfig(
        // Activates CDI build-in beans
        version = JSF_2_3
)
@Named(value = "dbreader")
@SessionScoped
public class DBreader implements Serializable {
    
    private String THE_ID = "0";
    private String foodname = "fisk";
    private String price = "20";
    private String foodtype = "1";
    private String time = "20";
    
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
    
    public void DBremove(int id) throws NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
        utx.begin();
        Menuitem item = em.getReference(Menuitem.class, id);
        Cookingtime time = em.getReference(Cookingtime.class, id);
        em.remove(item);
        em.remove(time);
        utx.commit();
    }
    
    public void DBadd(){
        if(foodname == "" || foodtype == "" || time == "" || price == "" || THE_ID == "") {
            return;
        }
        Menuitem item = new Menuitem(Integer.parseInt(THE_ID));
        item.setFoodname(foodname);
        item.setFoodtype(Integer.parseInt(foodtype));
        item.setPrice(Integer.parseInt(price));
        Cookingtime itemTime = new Cookingtime();
        itemTime.setId(Integer.parseInt(THE_ID));
        itemTime.setMenuitemid(Integer.parseInt(THE_ID));
        itemTime.setTime(time);
        persist(item);
        persist(itemTime);
//        setFoodname("");
//        setFoodtype("");
//        setTime("");
//        setPrice("");
        setTHE_ID("");
    }

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException e) {
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
     * @return the THE_ID
     */
    public String getTHE_ID() {
        return THE_ID;
    }

    /**
     * @param THE_ID the THE_ID to set
     */
    public void setTHE_ID(String THE_ID) {
        this.THE_ID = THE_ID;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the foodtype
     */
    public String getFoodtype() {
        return foodtype;
    }

    /**
     * @param foodtype the foodtype to set
     */
    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }
}
