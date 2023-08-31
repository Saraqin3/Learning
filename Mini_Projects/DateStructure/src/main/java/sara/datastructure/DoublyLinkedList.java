/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sara.datastructure;

/**
 *
 * @author saraqin
 */
public class DoublyLinkedList {
    
    Node headNode=null;
    Node tailNode=headNode;
    
    
    public class Node {//both directions
    
    int data;
    Node nextNode;
    Node previousNode;
    
    public Node (int data, Node nextNode, Node previousNode)
    {
        this.data=data;
        this.nextNode=nextNode;
        this.previousNode=previousNode;
    }
    
    public int getData ()
    {
        return data;
    }
    
    public Node getNextNode ()
    {
        return nextNode;
    }
    
    public Node getPreviousNode ()
    {
        return previousNode;
    }
    
    public void setData (int data)
    {
        this.data=data;
    }
    
    public void setNextNode (Node nextNode)
    {
        this.nextNode=nextNode;
    }
    
    public void setPreviousNode (Node previousNode)
    {
        this.previousNode=previousNode;
    }
    
    }
    
    public DoublyLinkedList()
    {
        
    }
    
    public void Add(int value)//although link is hooked towards two directions, when adding, can only add from head to tail
    {
        Node newNode = new Node (value, null, null);
        
        if(headNode==null)
        {
            headNode=newNode;
        }
        
        else
        {
            newNode.previousNode=tailNode;
            tailNode.nextNode=newNode;
            tailNode=newNode;
        }
    }
    
    public void RemoveValue(int value)
    {
        if(headNode.data==value)
        {
            headNode=headNode.nextNode;
            headNode.nextNode=null;
        }
        
        else
        {
        Node node = headNode;
        while (node!=tailNode)
        {
            if(node.data==value)
            {
                node.previousNode.nextNode=node.nextNode;
                node.nextNode.previousNode=node.previousNode;
            }
            
            node=node.nextNode;

        }
        }
        
        
    }
    
    public void Print()
    {
        System.out.print("DoublyLinkedList:");
        Node node=headNode;
        
        while(node!=null)
        {
            System.out.print(" "+node.data);
            node=node.nextNode;
        }
    }
    
    public void PrintReverse()
    {
        System.out.print("DoublyLinkedList(Reverse):");
        Node node=tailNode;
        
        while(node!=null)
        {
            System.out.print(" "+node.data);
            node=node.previousNode;
        }
    }
}
