/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tequlate file, choose Tools | Tequlates
 * and open the tequlate in the editor.
 */
package org.o7planning.restfulcrud.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.util.ArrayList;
import java.util.Arrays;
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
 
    public static Equipo addEquipo(Equipo equ) {
        try{

            MongoCredential credential = MongoCredential.createCredential("administrator", "admin", "mypassword".toCharArray());

            MongoClient mongoClient = new MongoClient(new ServerAddress("localhost"), Arrays.asList(credential));
            
            DB db = mongoClient.getDB("admin");

            DBCollection coll = db.getCollection("equipos");

            DBObject doc = new BasicDBObject("id", equ.getId()).append("nombre", equ.getNombre());

            coll.insert(doc);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "
                    + e.getMessage());
        }
        return equ;
    }
 
    public static Equipo updateEquipo(Equipo equ) {

        try {
            
            MongoCredential credential = MongoCredential.createCredential("administrator", "admin", "mypassword".toCharArray());

            MongoClient mongoClient = new MongoClient(new ServerAddress("localhost"), Arrays.asList(credential));

            DB db = mongoClient.getDB("admin");

            DBCollection coll = db.getCollection("equipos");
            BasicDBObject newDocument = new BasicDBObject();
            newDocument.append("$set", new BasicDBObject().append("nombre",equ.getNombre()));
            BasicDBObject searchQuery = new BasicDBObject().append("id",equ.getId());
            coll.update(searchQuery, newDocument);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "
                    + e.getMessage());
        }

        return equ;
    }
 
    public static void deleteEquipo(String equNo) {
        try {
            
            MongoCredential credential = MongoCredential.createCredential("administrator", "admin", "mypassword".toCharArray());

            MongoClient mongoClient = new MongoClient(new ServerAddress("localhost"), Arrays.asList(credential));

            DB db = mongoClient.getDB("admin");
            DBCollection coll = db.getCollection("equipos");
            DBObject doc = new BasicDBObject();
            doc.put("id", equNo);
            coll.remove(doc);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "
                    + e.getMessage());
        }
    }
 
    public static List<Equipo> getAllEquipos() {
        List<Equipo> list = new ArrayList<Equipo>();

        try {
            
            MongoCredential credential = MongoCredential.createCredential("administrator","admin", "mypassword".toCharArray());

            MongoClient mongoClient = new MongoClient(new ServerAddress("localhost"), Arrays.asList(credential));

            DB db = mongoClient.getDB("admin");

            DBCollection coll = db.getCollection("equipos");

            DBCursor cursor = coll.find();
            try {
                while (cursor.hasNext()) {
                    DBObject object = cursor.next();
                    String id = object.get("id").toString();
                    String name = object.get("nombre").toString();
                    Equipo e = new Equipo(id, name);
                    list.add(e);
                    System.out.println(object);
                }
            } finally {
                cursor.close();
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "
                    + e.getMessage());
        }
        
        return list;
    }
     
    List<Equipo> list;
}
