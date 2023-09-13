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
            tailNode=headNode;
        }
        
        else
        {
            tailNode.nextNode=newNode;
            tailNode=newNode;
        }
    }
    
    public void RemoveValue(int value)//by value (remove all)
    {
    
        if (headNode==null) //if list empty, exit
        {
           return;
        }
    
    
        //checking if value is in between headNode and tailNode
        Node nodeBefore=headNode;
        
        
        if(nodeBefore.nextNode!=null)//Only run when list has at least 2 nodes
        {
        while (nodeBefore.nextNode.equals(tailNode)==false)
        {

            int currtValue=nodeBefore.nextNode.data;
            
            if (currtValue==value)
            {
                nodeBefore.nextNode=nodeBefore.nextNode.nextNode;
            }
            
            else
            {
                nodeBefore=nodeBefore.nextNode;
            }
 
        }
        }
    
        
        //checking if headNode is the value
        if(headNode.data==value)
        {
            headNode=headNode.nextNode;
        }
        
        //if empty, end funciton
        if (headNode==null)
        {
            tailNode=headNode;
            return;
        }
        
        //checking if the last node is also the value, if yes, need to remove here
        if (headNode.equals(tailNode))
        {
            if (headNode.data==value)
            {
                headNode=null;
                tailNode=headNode;
            }
            return;
        }
       
        //checking if tailNode is the value
        if (tailNode.data==value)
        {
            tailNode=nodeBefore;
        }
        
      
    }
  
    
    public void Remove(int index)//by index
    { 
    if (headNode==null)//if list is empty, end function
    {
        return;
    }
        
    if (index==0)//if it is first one being removed
    {
        headNode=headNode.nextNode;
        if(headNode==null)//in case of there is only one node in list
        {
            tailNode=headNode;
        }
        return;
    }

    Node nodeBefore=headNode;
    
    int myIndex=1;
    
    if(headNode.equals(tailNode)==false)//this condition only get to run when there is at least 2 nodes
    {
    while (nodeBefore.nextNode.equals(tailNode)==false)
    {
        if(myIndex==index)
        {
            nodeBefore.nextNode=nodeBefore.nextNode.nextNode;
            return;
        }
        myIndex++;
        nodeBefore=nodeBefore.nextNode;
    }
    }
    
    if(myIndex==index)
    {
        tailNode=nodeBefore;   
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
