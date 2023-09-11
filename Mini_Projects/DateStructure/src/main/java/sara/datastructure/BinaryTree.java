/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sara.datastructure;

/**
 *
 * @author saraqin
 */
public class BinaryTree {
    
    Node rootNode=null;
           
    
    public class Node 
    {
    
    int data;
    Node leftNode;
    Node rightNode;
    
    public Node (int data, Node leftNode, Node rightNode)
    {
        this.data=data;
        this.leftNode=leftNode;
        this.rightNode=rightNode;
    }
    
    }
    
    public BinaryTree()
    {
        
    }
    
    public void Add(int value)
    {
        Node newNode= new Node (value, null, null);
        
        if (rootNode==null)
        {
            rootNode=newNode;
            return;
        }
        
        Node currtNode=rootNode;
        Node previousNode=rootNode;
        String direction="A";//give direction a random string value
        
        while (currtNode!=null)
        {
            
        previousNode=currtNode;
        
        if(value<=currtNode.data)// ==put left
        {
            currtNode=currtNode.leftNode;
            direction="L";
        }
        
        else
        {
            currtNode=currtNode.rightNode;
            direction="R";
        }
        
        }
        
        
        if (direction.equals("L"))
        {
            previousNode.leftNode=newNode;
        }
        else
        {
            previousNode.rightNode=newNode;
        }
        
                
    }
    
    public void Search(int value)
    {
        if(rootNode==null)
        {
            System.out.println("No result");
            return;
        }
        
       Node currtNode = rootNode;
       
       
       while (currtNode.data!=value)
       {
                  
           if(value<currtNode.data)
           {            
               currtNode=currtNode.leftNode;
           }
           
           else
           {
               currtNode=currtNode.rightNode;
           }
           
           if(currtNode==null)
           {
               System.out.println("No result");
               break;
           }
       }
       
       System.out.println("Value found");
    }
    
    public void PrintInOrder()//From small to big? (in order)//sort and print?
    {
       
        
    }
    
    public void PreOrder(Node node)
    {

        
        if (node.leftNode!=null)
        {
            System.out.println(node.leftNode.data);
            node=node.leftNode;
            PreOrder(node);
        } 
        
        
        if(node.rightNode!=null)
        {
        System.out.println(node.rightNode.data);
        node=node.rightNode;
        PreOrder(node);
        }  
        
    }
    
    public void PrintPreOrder()//pre-order
    {
        if(rootNode!=null)
        {
           System.out.println(rootNode); 
        }
        
        Node node=rootNode;
        
        
        PreOrder(node);
           
    }
    
    public void PrintPostOrder()//post-order
    {
        
    }
    
    public void remove (int value)//small scale balance?
    {
        
    }
    
    public void Balance ()
    {
        
    }
}
