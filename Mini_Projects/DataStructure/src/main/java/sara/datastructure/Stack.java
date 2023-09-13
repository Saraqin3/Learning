/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sara.datastructure;

/**
 *
 * @author saraqin
 */
public class Stack {
    

    
    Node topNode = null;
    
    
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
    
    public Stack ()
    {
        
    }
    
    public void Add (int value)
    {
        Node newNode = new Node(value, null);
        
        newNode.lastNode=topNode;
        topNode=newNode;

    }
    
    public Integer Remove ()//remove one per time, first in last out
    {
        if (topNode==null)
        {
            return null;
        }
        
        int value=topNode.data;
        
        topNode=topNode.lastNode;
        
        return value;
        
    }
    
    public void PrintOutputs ()//print by output order
    {
        System.out.print("The stack output order is: ");
        
        Node node = topNode;
        
        while (node!=null)
        {
            System.out.print(node.data+" ");
            node=node.lastNode;
        }
    }
            
            
}
