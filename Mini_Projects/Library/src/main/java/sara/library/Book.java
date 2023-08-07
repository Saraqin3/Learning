/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sara.library;

/**
 *
 * @author saraqin
 */
public class Book {
    
    String title;
    String author;
    String ISBN;
    Boolean isAvailable;
    
    public void borrowBook()
    {
        isAvailable=false;
    }
    
    public void returnBook()
    {
        isAvailable=true;
    }
}
