/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

//import Entities.HistoryRecord;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author optimuscrime
 */
public class historyRepo {
    
    private static List<String> listOfOperations = new ArrayList<String>();
    
    public static void addOperation (String op) {
        listOfOperations.add(op);
    }
    
    public static List<String> getOperations() {
        return listOfOperations;
    }
    
    
    
//    public void persistObject(Object object) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pl.polsl_JPA_Demo_jar_prototypePU");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        try {
//            em.persist(object);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            em.getTransaction().rollback();
//        } finally {
//            em.close();
//        }
//    }
//
//    public void findObject() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pl.polsl_JPA_Demo_jar_prototypePU");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        try {
//            Query query = em.createQuery("SELECT p FROM Person p");
//            //List<HistoryRecord> historyRecordList = query.getResultList();
//            //for (HistoryRecord record : historyRecordList) {
//            //    System.out.println("Found object: " + record.getDenominations());
//           // }
//        } catch (PersistenceException e) {
//            e.printStackTrace();
//            em.getTransaction().rollback();
//        } finally {
//            em.close();
//        }
//    }
    
    
}
