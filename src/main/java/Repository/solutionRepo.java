/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Frycz.Mikolaj.Cw4.prototyp.Models.Cash;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author optimuscrime
 */
public class solutionRepo {
    
    public static void createTable() {

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found");
        }
        // make a connection to DB
        try ( Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/changereturner_db", "app", "app")) {
            Statement statement = con.createStatement();
            statement.executeUpdate("CREATE TABLE Solutions "
                    + "(id INTEGER, solution VARCHAR(200) )");
            System.out.println("Table created");
            
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }
    
    public static void insertData(Cash cash){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found");
        }
            // make a connection to DB
        try ( Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/changereturner_db", "app", "app")) {
            Statement statement = con.createStatement();
            //modify the statement
            //find all to get the size
            String id = Integer.toString(parametersRepo.findAll().size()+1);
            String solution = cash.getSolutionAsString();
            
            statement.executeUpdate("INSERT INTO Solutions VALUES ("+id+",'"+solution+"')");

            System.out.println("Data inserted");
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }
    
    public static List<String> findAll() {

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found");
        }
        // make a connection to DB
        List<String> solutions = new ArrayList<>();
        
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/changereturner_db", "app", "app")) {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Solutions");
            
            while(rs.next()){
                StringBuilder builder = new StringBuilder();
                builder.append("solution: ");
                builder.append(rs.getString("solution"));
                solutions.add(builder.toString());
            }
            
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
        
        return solutions;
    }
}
