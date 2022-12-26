package com.junxian428;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class UserList {
    private int[] id;
    private String[] username;
    private String[] password;

    public UserList(){
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:User.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * from User");
            int total_Count = 0;
            //String INPUT;
            // Get integer size
            while (rs.next()) {
                // read the result set
                //System.out.println("id = " + rs.getInt("id"));
                //System.out.println("name = " + rs.getString("username"));
                total_Count += 1;
            }
            this.id = new int[total_Count];
            this.username = new String[total_Count];
            this.password = new String[total_Count];
            // add all database data into array
       
    

        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

      
    }

    public int[] getArray() {
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:User.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * from User");
            int increment_Count = 0;
  
            // add all database data into array
            while (rs.next()) {
                // read the result set
                //System.out.println("id = " + rs.getInt("id"));
                //System.out.println("name = " + rs.getString("username"));
                //this.username[increment_Count] = rs.getString("username");
                //System.out.println(this.password[increment_Count]);
                this.id[increment_Count] = rs.getInt("id");

                increment_Count += 1;
            }
            //INSERT INTO User (id, username, password) VALUES (5, "junxian05", "123456789");
    
            return this.id;

        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        return this.id;
    }

    public String[] getUserName(){
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:User.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * from User");
            int increment_Count = 0;
  
            // add all database data into array
            while (rs.next()) {
                // read the result set
                //System.out.println("id = " + rs.getInt("id"));
                //System.out.println("name = " + rs.getString("username"));
                this.username[increment_Count] = rs.getString("username");
                //System.out.println(this.password[increment_Count]);
                increment_Count += 1;
            }
            //INSERT INTO User (id, username, password) VALUES (5, "junxian05", "123456789");
    
            return this.username;

        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        return this.username;

    }


    public String[] getPassword(){
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:User.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * from User");
            int increment_Count = 0;
  
            // add all database data into array
            while (rs.next()) {
                // read the result set
                //System.out.println("id = " + rs.getInt("id"));
                //System.out.println("name = " + rs.getString("username"));
                this.password[increment_Count] = rs.getString("password");
                //System.out.println(this.password[increment_Count]);
                increment_Count += 1;
            }
            //INSERT INTO User (id, username, password) VALUES (5, "junxian05", "123456789");
    
            return this.password;

        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        return this.password;

    }


    public int getUserID(String username) {
        Connection connection = null;
        int ID = 0;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:User.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select id from User where username == '" + username +"'");
            int increment_Count = 0;
  
            // add all database data into array
            while (rs.next()) {
                // read the result set
                //System.out.println("id = " + rs.getInt("id"));
                //System.out.println("name = " + rs.getString("username"));
                //this.username[increment_Count] = rs.getString("username");
                //System.out.println(this.password[increment_Count]);
                ID = rs.getInt("id");
            }
            //INSERT INTO User (id, username, password) VALUES (5, "junxian05", "123456789");
    
            return ID;

        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        return ID;
    }

    public String getUserNameByID (String userID){
        Connection connection = null;
        String userName = "";
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:User.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select username from User where id == " + userID );
            int increment_Count = 0;
  
            // add all database data into array
            while (rs.next()) {
                // read the result set
                //System.out.println("id = " + rs.getInt("id"));
                //System.out.println("name = " + rs.getString("username"));
                //this.username[increment_Count] = rs.getString("username");
                //System.out.println(this.password[increment_Count]);
                userName = rs.getString("username");
            }
            //INSERT INTO User (id, username, password) VALUES (5, "junxian05", "123456789");
    
            return userName;

        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        return userName;
    }



    
}
