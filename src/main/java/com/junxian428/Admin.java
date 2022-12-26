package com.junxian428;

abstract public class Admin {
    // Abstract method (does not have a body)
    public abstract void RemoveBorrowStatus(int bookid, int userid);
    public abstract void AddBorrowStatus(int bookid, int userid);
    public abstract void DeleteReserveStatus(int bookid, int userid);
    public abstract void AddReservedStatus(int bookid, int userid);

    // Regular method
    public void adminPrivilegeDisclaimer() {
      System.out.println("ADMIN PRIVILEGE: Remove Borrow Status, RECORD WHO IS BORROWING, DELETE Reserved book record and add");
    }
}