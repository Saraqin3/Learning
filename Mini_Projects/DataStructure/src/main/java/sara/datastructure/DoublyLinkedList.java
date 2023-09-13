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
            tailNode=headNode;
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
        if (headNode==null)//if list is empty, end function
        {
            return;
        }
        
        //check middle
        Node nodeBefore = headNode;
        
        
        if(nodeBefore.nextNode!=null)//prevent while loop breaks so only at least 2 nodes can run it
        {
        while (nodeBefore.nextNode.equals(tailNode)==false)
        {
            if(nodeBefore.nextNode.data==value)
            {
                nodeBefore.nextNode=nodeBefore.nextNode.nextNode;
                nodeBefore.nextNode.nextNode.previousNode=nodeBefore;
            }
            else
            {
                nodeBefore=nodeBefore.nextNode;
            }
        }
        }
        
        //check head
        if(headNode.data==value)
        {
            headNode=headNode.nextNode;
            
            if(headNode==null)//in case this is the only node left
            {
                tailNode=headNode;
                return;
            }
            
            else
            {
                headNode.previousNode=null;
            }
        }
        
        //check tail
        if(tailNode.data==value)
        {
            tailNode=tailNode.previousNode;
            if(tailNode==null)//in case this is the only node left
            {
                headNode=tailNode;
            }
            else
            {
                tailNode.nextNode=null;
            }
        }
        
    }
    
    public void Remove (int index)//remove by index
    {
        if(headNode==null)
        {
            return;
        }
        
        //check head 
        if(index==0)
        {
            headNode=headNode.nextNode;
            if(headNode==null)//in case this is only node left
            {
                tailNode=headNode;
            }
            else
            {
                headNode.previousNode=null;
            }
            
            return;
        }
        
        //check middle
        Node nodeBefore=headNode;

        int myIndex=1;
        if (nodeBefore.nextNode!=null)//prevent while loop break, so at least 2 nodes can run it
        {
        while(nodeBefore.nextNode.equals(tailNode)==false)
        {
            if(myIndex==index)
            {
                nodeBefore.nextNode=nodeBefore.nextNode.nextNode;
                nodeBefore.nextNode.nextNode.previousNode=nodeBefore;
                return;
            }
            else
            {
                nodeBefore=nodeBefore.nextNode;
          
                myIndex++;
            }
        }
        }
        
        //check tail
        if(myIndex==index)
        {
            tailNode=tailNode.previousNode;
            if(tailNode==null)//in case there is only one node left
            {
                headNode=tailNode;
            }
            else
            {
                tailNode.nextNode=null;
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
