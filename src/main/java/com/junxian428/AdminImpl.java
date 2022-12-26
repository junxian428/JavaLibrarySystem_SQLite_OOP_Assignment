package com.junxian428;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class AdminImpl extends Admin{


    @Override
    public void AddBorrowStatus(int bookid, int userid) {
        // TODO Auto-generated method stub
        Connection connection = null;

        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:User.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * from User");
            int total_Count = 0;
            while (rs.next()) {
                // read the result set
                //System.out.println("id = " + rs.getInt("id"));
                //System.out.println("name = " + rs.getString("username"));
                total_Count += 1;
            }
            total_Count += 1;

            //INSERT INTO User (id, username, password) VALUES (5, "junxian05", "123456789");
            statement.executeUpdate("insert into User_Book (id,bookid, userid) values ("+ total_Count + ", "+ bookid + ","+ userid+  " );");

            System.out.println("Update Successfully...");
            System.out.println();
            System.out.println();
            System.out.println();

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

    @Override
    public void DeleteReserveStatus(int bookid, int userid) {
        // TODO Auto-generated method stub
        String condition = "AVAILABLE";
               // TODO Auto-generated method stub
               Connection connection = null;

               try {
                   // create a database connection
                   connection = DriverManager.getConnection("jdbc:sqlite:User.db");
                   Statement statement = connection.createStatement();
                   statement.setQueryTimeout(30); // set timeout to 30 sec.
                   ResultSet rs = statement.executeQuery("select * from User");
                   int total_Count = 0;
                   while (rs.next()) {
                       // read the result set
                       //System.out.println("id = " + rs.getInt("id"));
                       //System.out.println("name = " + rs.getString("username"));
                       total_Count += 1;
                   }
                   total_Count += 1;
       
                   //INSERT INTO User (id, username, password) VALUES (5, "junxian05", "123456789");
                   //DELETE FROM table_name WHERE condition;
                   try{
                       statement.executeUpdate("delete from Reserved_Book WHERE bookid ==" + bookid + " AND  userid=="+ userid+  " ;");
                   }catch(Exception e){
                       System.out.println(e);
                   }
       
                   System.out.println("Delete Successfully...");
                   System.out.println();
                   System.out.println();
                   System.out.println();
       
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

    @Override
    public void AddReservedStatus(int bookid, int userid) {
        // TODO Auto-generated method stub
        String condition = "RESERVED";
        Connection connection = null;

        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:User.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * from User");
            int total_Count = 0;
            while (rs.next()) {
                // read the result set
                //System.out.println("id = " + rs.getInt("id"));
                //System.out.println("name = " + rs.getString("username"));
                total_Count += 1;
            }
            total_Count += 1;

            //INSERT INTO User (id, username, password) VALUES (5, "junxian05", "123456789");
            statement.executeUpdate("insert into Reserved_Book (id,bookid, userid,condition) values ("+ total_Count + ", "+ bookid + ","+ userid+ " , '" + condition + "' );");

            System.out.println("Update Successfully...");
            System.out.println();
            System.out.println();
            System.out.println();

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

    @Override
    public void RemoveBorrowStatus(int bookid, int userid) {
        // TODO Auto-generated method stub
        Connection connection = null;

        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:User.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * from User");
            int total_Count = 0;
            while (rs.next()) {
                // read the result set
                //System.out.println("id = " + rs.getInt("id"));
                //System.out.println("name = " + rs.getString("username"));
                total_Count += 1;
            }
            total_Count += 1;

            //INSERT INTO User (id, username, password) VALUES (5, "junxian05", "123456789");
            //DELETE FROM table_name WHERE condition;
            try{
                statement.executeUpdate("delete from User_Book WHERE bookid ==" + bookid + " AND  userid=="+ userid+  " ;");
            }catch(Exception e){
                System.out.println(e);
            }

            System.out.println("Delete Successfully...");
            System.out.println();
            System.out.println();
            System.out.println();

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

 

}