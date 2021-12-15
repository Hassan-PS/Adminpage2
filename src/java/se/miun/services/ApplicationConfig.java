/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.miun.services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author hassa
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(se.miun.services.BookingFacadeREST.class);
        resources.add(se.miun.services.CookingtimeFacadeREST.class);
        resources.add(se.miun.services.KitchenorderFacadeREST.class);
        resources.add(se.miun.services.MenuitemFacadeREST.class);
        resources.add(se.miun.services.MenuitemwebbFacadeREST.class);
        resources.add(se.miun.services.ResturangorderFacadeREST.class);
    }
    
}
