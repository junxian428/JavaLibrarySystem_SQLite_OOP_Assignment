package com.junxian428;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;


public class UserBook {
    private int[] id;
    private int[] bookid;
    private int[] userid;

    // User borrow which boook
    // based on book id and user id
    // Constructor
    public UserBook(){
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:User.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * from User_Book");
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
            this.bookid = new int[total_Count];
            this.userid = new int[total_Count];
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

    public int[] getBookID(int UserID) {
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:User.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select bookid from User_Book where userid ==" + UserID);
            int increment_Count = 0;
  
            // add all database data into array
            while (rs.next()) {
                // read the result set
                //System.out.println("id = " + rs.getInt("id"));
                //System.out.println("name = " + rs.getString("username"));
                //this.username[increment_Count] = rs.getString("username");
                //System.out.println(this.password[increment_Count]);
                this.bookid[increment_Count] = rs.getInt("bookid");

                increment_Count += 1;
            }
            //INSERT INTO User (id, username, password) VALUES (5, "junxian05", "123456789");
    
            return this.bookid;

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

        return this.bookid;
    }


    public String getBookNameByID(int bookid){
        String bookname ="";
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:User.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select title from Book where id ==" + bookid);
            int increment_Count = 0;
  
            // add all database data into array
            while (rs.next()) {
                // read the result set
                //System.out.println("id = " + rs.getInt("id"));
                //System.out.println("name = " + rs.getString("username"));
                //this.username[increment_Count] = rs.getString("username");
                //System.out.println(this.password[increment_Count]);
                bookname = rs.getString("title");

                increment_Count += 1;
            }
            //INSERT INTO User (id, username, password) VALUES (5, "junxian05", "123456789");
    
            return bookname;

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

        return bookname;
    }

}
