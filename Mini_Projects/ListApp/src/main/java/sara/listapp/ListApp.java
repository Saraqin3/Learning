/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package sara.listapp;

/**
 *
 * @author saraqin
 */
public class ListApp {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        // Initial size of list is 5
        // List linearly by 5 when reaching maximum capacity.
        List list = new List(5);

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("D"); // This is duplicate.  It should still add to list.
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");
        list.add("I");

        list.remove(6); // Remove element at index 6.
        System.out.println(list.toString()); // A B C D D E G H I

        list.remove("E");
        System.out.println(list.toString()); // A B C D D G H I

        list.add(6, "E");
        list.add("E");

        System.out.println(list.toString()); // A B C D D G E H I E

        list.add("A");
        list.add("B");

        list.remove("A");
        list.remove("B");

        System.out.println(list.toString()); // C D D G E H I E A B

        System.out.println(list.size()); // 10
    }

}
