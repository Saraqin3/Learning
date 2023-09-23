/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sara.treesearch;
import java.util.LinkedList;
/**
 *
 * @author saraqin
 */
public class TreeSearch {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Node node1 = new Node(7,null);
        Node node2 = new Node(15,null);
        Node node3 = new Node(28,null);
        Node node4 = new Node(56,null);
        LinkedList<Node> list5 = new LinkedList();
        list5.add(node1);
        list5.add(node2);
        list5.add(node3);
        list5.add(node4);
        Node node5 = new Node(12,list5);
        Node node6 = new Node(6,null);
        LinkedList<Node> list7 = new LinkedList();
        list7.add(node6);
        list7.add(node5);
        Node node7 = new Node(2,list7);
        Node node8 = new Node(9,null);
        LinkedList<Node> list9 = new LinkedList();
        list9.add(node8);
        Node node9 = new Node(1,list9);
        LinkedList<Node> list10 = new LinkedList();
        list10.add(node9);
        Node node10 = new Node(4,list10);
        Node node11 = new Node(8,null);
        Node node12 = new Node(22,null);
        LinkedList<Node> list13 = new LinkedList();
        list13.add(node11);
        list13.add(node12);
        Node node13 = new Node(5,list13);
        LinkedList<Node> listRoot = new LinkedList();
        listRoot.add(node7);
        listRoot.add(node10);
        listRoot.add(node13);
        Node rootNode = new Node(8,listRoot);
      
        Tree tree = new Tree(rootNode);
        
        System.out.println("depthSearch:");
        depthSearch(tree);
        System.out.println("breadthSearch:");
        breadthSearch(tree);
    }
    
    public static void search(Node node)
    {
        if(node==null)
        {
            return;
        }
        System.out.println(node.data);
        
        if(node.children!=null)
        {
            for(int i=0;i<node.children.size();i++)
            {
                Node nextNode = node.children.get(i);
                search(nextNode);
            }
        }
        
    }
    
    
    public static void depthSearch (Tree tree)
    {
        search(tree.rootNode);
    }
    
    public static void searchChildren (LinkedList<Node> list)
    {
        if(list==null || list.isEmpty())
        {
            return;
        }
        LinkedList<Node> newList=new LinkedList();
        for (int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).data);
            if(list.get(i).children!=null)
            {
                for (int m=0;m<list.get(i).children.size();m++)
                {
                    newList.add(list.get(i).children.get(m));
                }
            }
        }
        searchChildren(newList);        
    }
    
    
    public static void breadthSearch(Tree tree)
    {
        if(tree.rootNode==null)
        {
            return;
        }
        System.out.println(tree.rootNode.data);
        
        searchChildren(tree.rootNode.children);
        
                
    }
}
