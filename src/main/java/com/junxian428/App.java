package com.junxian428;

/**
 * Hello world!
 *
 */
import java.util.Scanner;

import javax.xml.namespace.QName;

import com.junxian428.ClearScreen.ClearScreen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class App{

    public static void DisplayMenu(){
        System.out.println("Library Book OOP Project System");
        System.out.println("Login Portal");
        System.out.println("1- Login");
        System.out.println("2- Sign Up");
        System.out.println("3- Admin Portal");
        System.out.println("4- Exit");
        System.out.println("Please insert your choice: (1-4)");

    }

    public static void LoginPortal(){
        System.out.println("____________________________");
        System.out.println("Please enter your username: ");
        Scanner username = new Scanner(System.in);
        String usernameInput = username.next();
        System.out.println("Please enter your password: ");
        Scanner password = new Scanner(System.in);
        String passwordInput = password.next();

        Boolean loginUsername = false;
        Boolean loginPassword = false;

        UserList user = new UserList();

        for (String element: user.getUserName()) {
            //System.out.println(element);
            if(usernameInput.equals(element)){
                loginUsername = true;
            }
        }
        for (String element: user.getPassword()) {
            //System.out.println(element);
            if(passwordInput.equals(element)){
                loginPassword = true;
            }
        }
        if(loginUsername == false || loginPassword == false){
            System.out.println("Either Password or username is incorrect");
            System.out.println();
            System.out.println();
        } else{
            System.out.println("Login Successfully");
            System.out.println();
            System.out.println();
            LIBRARY__SYSTEM(user, usernameInput);

        }
       

    }

    private static void LIBRARY__SYSTEM(UserList user, String username) {
        System.out.println("Current user : " + username);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Time now: " + localDateTime);
        System.out.println("User ID :" + user.getUserID(username));
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("____Available Book to borrow____");
        BookList booklist = new BookList();
        int index = 1;
        for (String element: booklist.getBookTitle()) {
            System.out.println(index + " " + element);
            index++;
        }
        System.out.println("");
        System.out.println("");
        System.out.println("1- Borrow Book Service ");
        System.out.println("2- Reserve Book Service ");
        System.out.println("3- Check Personal Account ");
        System.out.println("4- Exit");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Insert your choice (1 -4 ) :");
        Scanner bookService = new Scanner(System.in);
        int bookServiceInput; 
        do{

            try{
                bookServiceInput=  bookService.nextInt();
                //System.out.println(input);
                switch( bookServiceInput){
                    case 1:
                        System.out.println("Borrow Book Service");
                        System.out.println("Which book you want to borrow? (insert the number)");
                        Scanner borrowBookNumber = new Scanner(System.in);
                        try{
                            int bookNo = borrowBookNumber.nextInt();
                            for (int element: booklist.getArray()) {
                                if(element == bookNo){  
                                    System.out.println("Book is found!");
                                    System.out.println("Do you really want to borrow this book :\n" +booklist.getBookTitleByID(bookNo) + " ?");
                                    System.out.println("YES OR NO");
                                    Scanner userConfirm = new Scanner(System.in);
                                    String confirm = userConfirm.next();
                                    if(confirm.equals("YES") || confirm.equals("yes") || confirm.equals("Y") ||confirm.equals("y")){
                                        System.out.println("You are going to borrow this book... ... ...");
                                        UserBook userbook = new UserBook();
                                        userbook.addUserBook(bookNo,user.getUserID(username));

                                    } else{
                                        System.out.println("Borrow Book activity is interrupt or stopped");
                                    }
                                }
                            }

                        }catch (Exception e){
                            System.out.println(e);

                        }

                        break;

                    case 2:
                        System.out.println("Reserve Book Service");
                        ReservedBook reservedBook = new ReservedBook();
                        for (String element: reservedBook.getListOfReservedBook()) {
                            System.out.println(element);
                        }
                        System.out.println("Enter the Book ID to check whether is it to be reserved or not? ");
                        Scanner checkerForReseved = new Scanner(System.in);
                        try{
                            int check = checkerForReseved.nextInt();
                            System.out.println(reservedBook.getBookTitleByID(check) + " Condition: " + reservedBook.returnCondition(check));
                        }catch(Exception e){    
                            System.out.println(e);
                        }
                        // Display reserved book condition
                        break;

                    case 3:
                        System.out.println("Check Personal Account");
                        UserBook userbook = new UserBook();
                        //userbook.getBookID(1)
                        for (int element: userbook.getBookID(user.getUserID(username))) {
                            // To avoid print null size = 0 
                            if(element != 0){
                                System.out.println("Book ID  :" + element + " Book Name: " +userbook.getBookNameByID(element));
                                
                            }
                        }

                        System.out.println("");
                        System.out.println("");

                        break;

                    case 4:
                        System.out.println("Exit the program.");
                        break;

                    default:
                        break;
                }


            }catch (Exception e){
                System.out.println(e);
                bookServiceInput = 0;
            }
        }while( bookServiceInput !=4 &&  bookServiceInput != 0);

        

    }

 

    public static void SignUp(){
        System.out.println("____________________________");
        System.out.println("Please enter your username: ");
        Scanner username = new Scanner(System.in);
        String usernameInput = username.next();
        System.out.println("Please enter your password: ");
        Scanner password = new Scanner(System.in);
        String passwordInput = password.next();
        System.out.println(usernameInput + " account with password is created");
        //
        Connection connection = null;

        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:User.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * from User");
            int total_Count = 0;
            String INPUT;
            while (rs.next()) {
                // read the result set
                System.out.println("id = " + rs.getInt("id"));
                System.out.println("name = " + rs.getString("username"));
                total_Count += 1;
            }
            total_Count += 1;

            //INSERT INTO User (id, username, password) VALUES (5, "junxian05", "123456789");
            statement.executeUpdate("insert into User (id,username, password) values  (" + total_Count + ", '" + usernameInput + "' , '"+ passwordInput + " ');");

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


        //

    }



    
      

    public static void AdminPortal() throws ClassNotFoundException{
        System.out.println("____________________________");
        System.out.println("Please enter your username: ");
        Scanner username = new Scanner(System.in);
        String usernameInput = username.next();
        System.out.println("Please enter your password: ");
        Scanner password = new Scanner(System.in);
        String passwordInput = password.next();
        System.out.println("");
        System.out.println("____________________________");

        if(usernameInput.equals("admin") && passwordInput.equals("admin")){
            System.out.println("Login as Administrator");
            System.out.println("Registered User Account");
            System.out.println("");
            //
            DisplayUser();         
            System.out.println("_____________________________________________________");          
            
            System.out.println("_________Privilege Right_____________________________");   
            AdminImpl adminImpl_display = new AdminImpl();
            adminImpl_display.adminPrivilegeDisclaimer();
            System.out.println("\n\n\n");
            System.out.println("1- Remove Borrow Status "); 
            System.out.println("2- Add Borrow Status"); 

            System.out.println("3- Delete Reserve Status"); 
            System.out.println("4- Add Reserve Status"); 
            System.out.println("5- Exit");
            System.out.println("\n\n\n");
            System.out.println("Insert number (1 -5 )");
            Scanner adminSelection = new Scanner(System.in);
            int inputSelection = 0;
            do{
                inputSelection = adminSelection.nextInt();
                try{    
                    switch(inputSelection){
                        case 1:
                            System.out.println("\n\nRemove Borrow Status");
                            System.out.println("What BOOK ID is returned by user? ");
                            Scanner BookIDGet = new Scanner(System.in);
                            try{
                                int BookID = BookIDGet.nextInt();
                                try{
                                    System.out.println("What USER ID is returned by user? ");
                                    Scanner userIDGet = new Scanner(System.in);
                                    int UserID = userIDGet.nextInt();
                                    AdminImpl adminImpl = new AdminImpl();
                                    adminImpl.RemoveBorrowStatus(BookID, UserID);
                                }catch(Exception e){
                                    System.out.println(e);
                                }
                               
                            }catch(Exception e){
                                System.out.println(e);
                            }
                       

                            break;
                        case 2:
                            System.out.println("\n\nAdd Borrow Status");
                            System.out.println("What BOOK ID is borrowed by user? ");
                            Scanner BorrowedBookIDGet = new Scanner(System.in);
                            try{
                                int BookID = BorrowedBookIDGet.nextInt();
                                try{
                                    System.out.println("What is USER ID? ");
                                    Scanner userIDGet = new Scanner(System.in);
                                    int UserID = userIDGet.nextInt();
                                    AdminImpl adminImpl = new AdminImpl();
                                    adminImpl.AddBorrowStatus(BookID, UserID);
                                }catch(Exception e){
                                    System.out.println(e);
                                }
                               
                            }catch(Exception e){
                                System.out.println(e);
                            }
                       
                            break;
                        case 3:                     
                            System.out.println("3- Delete Reserve Status"); 
                            System.out.println("What BOOK ID is reveresed by user? ");
                            Scanner ReservedBookIDGet = new Scanner(System.in);
                            try{
                                int BookID = ReservedBookIDGet.nextInt();
                                try{
                                    System.out.println("What is USER ID are going to be delete? ");
                                    Scanner userIDGet = new Scanner(System.in);
                                    int UserID = userIDGet.nextInt();
                                    AdminImpl adminImpl = new AdminImpl();
                                    adminImpl.DeleteReserveStatus(BookID, UserID);
                                }catch(Exception e){
                                    System.out.println(e);
                                }
                               
                            }catch(Exception e){
                                System.out.println(e);
                            }
                            break;
                        case 4:
                            System.out.println("4- Add Reserve Status"); 
                            System.out.println("What BOOK ID is reveresed by user? ");
                            Scanner AddReservedBookIDGet = new Scanner(System.in);
                            try{
                                int BookID = AddReservedBookIDGet.nextInt();
                                try{
                                    System.out.println("What is USER ID are going to be added? ");
                                    Scanner userIDGet = new Scanner(System.in);
                                    int UserID = userIDGet.nextInt();
                                    AdminImpl adminImpl = new AdminImpl();
                                    adminImpl.AddReservedStatus(BookID, UserID);
                                }catch(Exception e){
                                    System.out.println(e);
                                }
                               
                            }catch(Exception e){
                                System.out.println(e);
                            }

                            break;
                        case 5: 
                            System.out.println("Exiting the program...");
                            break;
                        default:
                            break;
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }while(inputSelection != 5);

            //
        }

    }

    public static void DisplayUser(){
        UserList user = new UserList();
        //System.out.println(user.getArray());
        for (String element: user.getUserName()) {
            System.out.println(element);
        }
        //for (String element: user.getPassword()) {
            //System.out.println(element);
        //}
        //for (int element: user.getArray()){
            //System.out.println("User ID: " + element);
        //}
        //System.out.println(user.getUserName().toString());
        //System.out.println(user.UserFromID(3));
    }

    public static void main(String args[]){
        System.out.println("_______OOP Project__________");
        System.out.println("Author:  Ho Weng Yin");
        System.out.println("Author:  D210044A");
        System.out.println("____________________________");
        
        Scanner MenuSelection = new Scanner(System.in);
        int input = 0;
        do{
            ClearScreen ClsScreen = new ClearScreen();
            DisplayMenu();

            try{
                input= MenuSelection.nextInt();
                System.out.println(input);
                switch(input){
                    case 1:
                        ClsScreen.clearscreen();
                        System.out.println("____________________________");
                        System.out.println("Login Portal");
                        LoginPortal();
                        break;

                    case 2:
                        ClsScreen.clearscreen();
                        System.out.println("____________________________");
                        System.out.println("Sign Up");
                        SignUp();
                        break;

                    case 3:
                        ClsScreen.clearscreen();
                        System.out.println("____________________________");
                        System.out.println("Admin Portal");
                        AdminPortal();
                        break;

                    case 4:
                        System.out.println("Exit the program.");
                        break;

                    default:
                        break;
                }


            }catch (Exception e){
                System.out.println(e);
                input = 0;
            }
        }while(input !=4 && input != 0);

    
     
  
     

    }
}