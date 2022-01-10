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
import se.miun.entities.Lunch;

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
    
    //VARIABLER FÖR MIDDAG
    private String foodname = "fisk";
    private String price = "20";
    private String foodtype = "1";
    private String time = "20";
    
    //VARIABLER FÖR LUNCH
    private String lunch_name = "fisk";
    private String description = "TEST";
    private String day = "1";
    private String day_modified;
    
    private List <Menuitemwebb> resultList;
    private List <Lunch> resultLunch;

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

    public List <Lunch> LunchReaderDB(){
        TypedQuery<Lunch> MyQuery = em.createNamedQuery("Lunch.findAll", Lunch.class);
        resultLunch = MyQuery.getResultList();
        return resultLunch;
    }
    
    public void DBremove(int id) throws NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
        
        //Ta bort Cookingtime - måste göras då denna har en foregin key
        utx.begin();
        Cookingtime c_time = em.find(Cookingtime.class, id);
        em.remove(c_time);
        em.flush();
        utx.commit();

        //Ta bort Menuitem
        utx.begin();
        Menuitem item = em.find(Menuitem.class, id);
        em.remove(item);
        em.flush();
        utx.commit();

    }
    public void DBremoveLunch(int id) throws NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
        //Ta bort Lunch
        utx.begin();
        Lunch item = em.find(Lunch.class, id);
        em.remove(item);
        em.flush();
        utx.commit();

    }

    public void DBaddLunch() throws NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
        if(lunch_name == "" || description == "" || day == "" || Integer.parseInt(day) < 1 || Integer.parseInt(day) > 7) {
            return;
        }
        
        //Lägger till LUNCH
        utx.begin();
        Lunch item = new Lunch();
        item.setLunch_name(lunch_name);
        item.setDescription(description);
        item.setDay(Integer.parseInt(day));
        em.persist(item);
        em.flush();
        em.refresh(item);
        utx.commit();
    }
    public void DBadd() throws NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
        if(foodname == "" || foodtype == "" || time == "" || price == "" || Integer.parseInt(foodtype) < 1 || Integer.parseInt(foodtype) > 2) {
            return;
        }
        
        //Lägger till Menuitem
        utx.begin();
        Menuitem item = new Menuitem();
        item.setFoodname(foodname);
        item.setFoodtype(Integer.parseInt(foodtype));
        item.setPrice(Integer.parseInt(price));
        em.persist(item);
        em.flush();
        em.refresh(item);
        int temp = item.getId();
        utx.commit();

        //Lägger till Cookingtime
        utx.begin();
        Cookingtime itemTime = new Cookingtime();
        itemTime.setTime(time);
        itemTime.setMenuitemid(temp);
        em.persist(itemTime);
        em.flush();
        em.refresh(itemTime);
        utx.commit();
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
    //public int getTHE_ID() {
    //    return THE_ID;
    //}

    /**
     * @param THE_ID the THE_ID to set
     */
    //public void setTHE_ID(int THE_ID) {
    //   this.THE_ID = THE_ID;
    //}

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

    public String getDay() {
        return day;
    }
    public String getDay_modified() {
        return day_modified;
    }

    /**
     * @param foodtype the foodtype to set
     */
    public void setDay(String day) {
        this.day = day;
    }

    public void setLunch_name(String lunch_name) {
        this.lunch_name = lunch_name;
    }
    public String getLunch_name() {
        return lunch_name;
    }


    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
