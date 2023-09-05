/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sara.datastructure;

/**
 *
 * @author saraqin
 */
public class LinkedListOpposite {
    
    Node tailNode=null;
    
    public class Node {
    
    int data;
    Node lastNode;
    
    
    public Node (int data, Node lastNode)
    {
        this.data=data;
        this.lastNode=lastNode;
        
    }
    
    public int getData ()
    {
        return data;
    }
    
    public Node getLastNode ()
    {
        return lastNode;
    }
    
    public void setData (int data)
    {
        this.data=data;
    }
    
    public void setLastNode (Node lastNode)
    {
        this.lastNode=lastNode;
    }
   
    
    }
    
    public LinkedListOpposite ()
    {
        
    }
    
    public void Add (int value)
    {
        Node newNode = new Node(value, null);
        
        newNode.lastNode=tailNode;
        tailNode=newNode;
    }
    
    public void RemoveValue (int value)//remove all values
    {
        if (tailNode==null)
        {
            return;
        }
        
        //checking nodes previous of tailNode
        Node nodeBefore=tailNode;
        while (nodeBefore.lastNode!=null)
        {
            if(nodeBefore.lastNode.data==value)
            {
                nodeBefore.lastNode=nodeBefore.lastNode.lastNode;
            }
            else
            {
                nodeBefore=nodeBefore.lastNode;
            }
        }
        
        //check tailNode
        if (tailNode.data==value)
        {
            tailNode=tailNode.lastNode;
        }
    }
    
    
}
