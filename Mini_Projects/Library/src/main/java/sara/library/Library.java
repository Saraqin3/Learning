/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sara.library;

import java.util.List;

/**
 *
 * @author saraqin
 */
public class Library {

    String libraryName;
    String address;
    List<Book> books;
    List<Member> members;
    
    public static void main(String[] args) {
        System.out.println("Welcome to library!");   
    }
    
    public void addBook(Book book)
    {
        books.add(book);
    }
    
    public void removeBook(Book book)
    {
        books.remove(book);
    }
    
    public void addMember(Member member)
    {
        members.add(member);
    }
    
    public void removeMember(Member member)
    {
        members.remove(member);
    }
}
