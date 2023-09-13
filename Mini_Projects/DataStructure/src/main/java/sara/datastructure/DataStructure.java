/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sara.datastructure;

/**
 *
 * @author saraqin
 */
public class DataStructure {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        BinaryTree binaryTree = new BinaryTree();
        
        binaryTree.add(4);
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(2);
        binaryTree.add(6);
        binaryTree.add(7);
        binaryTree.add(9);
        
        System.out.println("Search");
        binaryTree.search(3);
        
        System.out.println("printInOrder");
        binaryTree.printInOrder();
        
        System.out.println("printPreOrder");
        binaryTree.printPreOrder();
        
        System.out.println("printPostOrder");
        binaryTree.printPostOrder();
    }
    
    
}
