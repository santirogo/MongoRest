/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tequlate file, choose Tools | Tequlates
 * and open the tequlate in the editor.
 */
package org.o7planning.restfulcrud.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.o7planning.restfulcrud.model.Equipo;

/**
 *
 * @author brown
 */
public class EquipoDAO {
    private static final Map<String, Equipo> equMap = new HashMap<String, Equipo>();
 
    static {
        initEmps();
    }
 
    private static void initEmps() {
        Equipo equ1 = new Equipo("E01", "Millos");
        Equipo equ2 = new Equipo("E02", "Nacional");
        Equipo equ3 = new Equipo("E03", "Santafecito");
 
        equMap.put(equ1.getId(), equ1);
        equMap.put(equ2.getId(), equ2);
        equMap.put(equ3.getId(), equ3);
    }
 
    public static Equipo getEquipo(String equNo) {
        return equMap.get(equNo);
    }
 
    public static Equipo addEquipo(Equipo equ) {
        equMap.put(equ.getId(), equ);
        return equ;
    }
 
    public static Equipo updateEquipo(Equipo equ) {
        equMap.put(equ.getId(), equ);
        return equ;
    }
 
    public static void deleteEquipo(String equNo) {
        equMap.remove(equNo);
    }
 
    public static List<Equipo> getAllEquipos() {
        Collection<Equipo> c = equMap.values();
        List<Equipo> list = new ArrayList<Equipo>();
        list.addAll(c);
        return list;
    }
     
    List<Equipo> list;
}
