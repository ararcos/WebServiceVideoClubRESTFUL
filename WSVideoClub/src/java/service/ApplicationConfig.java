/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author alexa
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
        resources.add(service.ActorFacadeREST.class);
        resources.add(service.ActorPeliculaFacadeREST.class);
        resources.add(service.AlquilerFacadeREST.class);
        resources.add(service.DirectorFacadeREST.class);
        resources.add(service.FormatoFacadeREST.class);
        resources.add(service.GeneroFacadeREST.class);
        resources.add(service.PeliculaFacadeREST.class);
        resources.add(service.SexoFacadeREST.class);
        resources.add(service.SocioFacadeREST.class);
    }
    
}
