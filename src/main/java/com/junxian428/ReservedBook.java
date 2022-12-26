package com.junxian428;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class ReservedBook extends BookList{
    private int[] id;
    private int[] bookid;
    private int[] userid;
    private String[] condition;

    public ReservedBook(){
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:User.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * from Reserved_Book");
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
            this.condition = new String[total_Count];
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

    public String[] getListOfReservedBook(){
        String[] bookAndCondition = condition;

        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:User.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select userid, condition from Reserved_Book");
            int increment_Count = 0;
            String userID ="";
            String username = "";
            // add all database data into array
            while (rs.next()) {
                // read the result set
                //System.out.println("id = " + rs.getInt("id"));
                //System.out.println("name = " + rs.getString("username"))
                userID = rs.getString("userid");
                UserList userList = new UserList();
                username = userList.getUserNameByID(userID);
                bookAndCondition[increment_Count] = "Username: " + username + " CONDITION: " + rs.getString("condition");
                //System.out.println(this.password[increment_Count]);
                increment_Count += 1;
            }
            //INSERT INTO User (id, username, password) VALUES (5, "junxian05", "123456789");
    
            return  bookAndCondition;

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

        return  bookAndCondition;
    }

    @Override
    public String getBookTitleByID(int id){
        String booktitle= "";
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:User.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            //ResultSet rs = statement.executeQuery("select title from Reserverd_Book where bookid=" + id);
            ResultSet rs = statement.executeQuery("select title from Book INNER JOIN Reserved_Book On Book.id = Reserved_Book.bookid where bookid=" + id);
            int increment_Count = 0;
  
            // add all database data into array
            while (rs.next()) {
                // read the result set
                //System.out.println("id = " + rs.getInt("id"));
                //System.out.println("name = " + rs.getString("username"));
                booktitle= rs.getString("title");
                //System.out.println(this.password[increment_Count]);
                increment_Count += 1;
            }
            //INSERT INTO User (id, username, password) VALUES (5, "junxian05", "123456789");
    
            return booktitle;

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

        return booktitle;


    }

    public String returnCondition(int id){
        String condition = "";
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:User.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select condition from Reserved_Book where bookid ==" + id);
            // add all database data into array
            while (rs.next()) {
                // read the result set
                //System.out.println("id = " + rs.getInt("id"));
                //System.out.println("name = " + rs.getString("username"))
                condition =  rs.getString("condition");
                //System.out.println(this.password[increment_Count]);
            }
            //INSERT INTO User (id, username, password) VALUES (5, "junxian05", "123456789");
    
            return  condition;

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

        return condition;
    }


}
