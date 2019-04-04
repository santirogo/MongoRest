/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkyong.rest;

import static com.sun.corba.ee.spi.orbutil.fsm.Guard.Base.ne;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.o7planning.restfulcrud.dao.EquipoDAO;
import org.o7planning.restfulcrud.dao.EquipoDAO;
import org.o7planning.restfulcrud.dao.EquipoDAO;
import org.o7planning.restfulcrud.model.Equipo;
import org.o7planning.restfulcrud.model.Equipo;
import org.o7planning.restfulcrud.model.Equipo;

/**
 *
 * @author brown
 */

@Path("/equipo")
public class EquipoService {
    
    
    
    // URI:
    // /contextPath/servletPath/employees
//    @GET
//    @Produces({ MediaType.APPLICATION_JSON })
//    public List<Equipo> getEquipos() {
//        List<Equipo> equipos = new ArrayList();
//        
//        Equipo eq1 = new Equipo();
//        eq1.setId("1");
//        eq1.setNombre("Millos");
//        
//        Equipo eq2 = new Equipo();
//        eq2.setId("2");
//        eq2.setNombre("Nacional");
//        
//        equipos.add(eq1);
//        equipos.add(eq2);
//        
//        return equipos;
//    }
    
    // URI:
    // /contextPath/servletPath/employees
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Equipo> getEquipos_JSON() {
        List<Equipo> equipos = EquipoDAO.getAllEquipos();
        return equipos;
    }
 
    // URI:
    // /contextPath/servletPath/employees/{empNo}
    @GET
    @Path("/{empNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Equipo getEquipo(@PathParam("empNo") String empNo) {
        return EquipoDAO.getEquipo(empNo);
    }
 
    // URI:
    // /contextPath/servletPath/employees
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Equipo addEquipo(Equipo emp) {
        return EquipoDAO.addEquipo(emp);
    }
 
    // URI:
    // /contextPath/servletPath/employees
    @PUT
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Equipo updateEquipo(Equipo emp) {
        return EquipoDAO.updateEquipo(emp);
    }
 
    @DELETE
    @Path("/{empNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteEquipo(@PathParam("empNo") String empNo) {
        EquipoDAO.deleteEquipo(empNo);
    }
}
