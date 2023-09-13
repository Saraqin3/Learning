/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sara.datastructure;

/**
 *
 * @author saraqin
 */
public class Queue {
    
    Node headNode = null;
    Node tailNode = headNode;
    
    public class Node {
    
    int data;
    Node nextNode;
    
    public Node (int data, Node nextNode)
    {
        this.data=data;
        this.nextNode=nextNode;
    }
    
    public int getData ()
    {
        return data;
    }
    
    public Node getNextNode ()
    {
        return nextNode;
    }
    
    public void setData (int data)
    {
        this.data=data;
    }
    
    public void setNextNode (Node nextNode)
    {
        this.nextNode=nextNode;
    }
    
    }
    
    public Queue ()
    {
        
    }
    
    public void Add (int value)
    {
        Node newNode = new Node (value, null);
        
        if (headNode==null)
        {
            headNode=newNode;
            tailNode=headNode;
        }
        else
        {
            tailNode.nextNode=newNode;
            tailNode=newNode;
        }
    }
    
    
    
    public Integer Remove ()//remove one per time,first in first out
    {
        if(headNode==null)//if empty, end function
        {
            return null;
        }
        
        int value=headNode.data;
        
        if(headNode.equals(tailNode))//in the case of there is only one node left
        {
            headNode=null;
            tailNode=headNode;
        }
        
        else
        {
            headNode=headNode.nextNode;
        }
        
        return value;
    }
    
    public void PrintQueue ()//print output order
    {
        System.out.print("The queue output order is: ");
        
        Node node=headNode;
        
        while (node!=null)
        {
            System.out.print(node.data+" ");
            node=node.nextNode;
        }
    }
}
