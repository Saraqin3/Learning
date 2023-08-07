/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sara.library;

import java.util.List;
/**
 *
 * @author saraqin
 */
public class Member {
    
    int memberID;
    String name;
    List<Book> borrowedBooks;
    
    public void borrowBook(Book book)
    {
        borrowedBooks.add(book);
    }
    
    public void returnBook(Book book)
    {
        borrowedBooks.remove(book);
    }
}
