/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sara.datastructure;

/**
 *
 * @author saraqin
 */
public class LinkedList {//linked towards one direction
    
    Node headNode=null;
    Node tailNode=headNode;
    
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
    
    public LinkedList ()
    {
        
    }
    
    public void Add(int value)
    {
        Node newNode = new Node(value, null);
        
        if (headNode==null)
        {
            headNode=newNode;
        }
        
        else
        {
            tailNode.nextNode=newNode;
            tailNode=newNode;
        }
    }
    
    public void RemoveValue(int value)//by value
    {
        if(headNode.data==value)//checking if headNode is getting removed
        {
            headNode=headNode.nextNode;
        }
        else
        {
        Node previousNode=headNode;
        int nextNodeValue=previousNode.nextNode.data;
        while (nextNodeValue!=value)//targeting the previous Node of target Node
        {
            previousNode=previousNode.nextNode;
            nextNodeValue=previousNode.nextNode.data;
        }
        
        previousNode.nextNode=previousNode.nextNode.nextNode;
        }
    }
    
    public void Remove(int index)//by index
    {
        Node node=headNode;
        int indexOfList=0;
        
        Node previousNode=null;
        
        while (indexOfList<index+1)
        {
            node=node.nextNode;
            indexOfList++;
            if(indexOfList==index-1)
            {
                previousNode=node;
            }
        }
        if(previousNode==null)//means the headNode is getting removed
        {
            headNode=node;
        }
        else
        {
        previousNode.nextNode=node;
        }
    }
    
    public void PrintList()
    {
        System.out.print("LinkedList:");
        Node node=headNode;
        while (node!=null)
        {
            System.out.print(" "+node.data);
            node=node.getNextNode();  
        }
 
    }
}
