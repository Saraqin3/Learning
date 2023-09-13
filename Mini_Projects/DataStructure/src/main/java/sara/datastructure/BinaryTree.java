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
    
    public void add(int value)
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
    
    public void search(int value)
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
    
    public void printInOrder()//From small to big? 
    {
       Node node=rootNode;
       
       if (node==null)
       {
           return;
       }
       
       inOrder(node);
        
    }
    
    public void inOrder(Node node)
    {
        
        
        if(node.leftNode!=null)
        {
            Node node1=node.leftNode;
            inOrder(node1);
        }
        
        System.out.println(node.data);
        
        if(node.rightNode!=null)
        {
            Node node2=node.rightNode;
            inOrder(node2);
        }
    }
    
    public void preOrder(Node node)
    {
       Node node1;
        
        if (node.leftNode!=null)
        {
            System.out.println(node.leftNode.data);
            node1=node.leftNode;
            preOrder(node1);
        } 
        
        
        if(node.rightNode!=null)
        {
        System.out.println(node.rightNode.data);
        node=node.rightNode;
        preOrder(node);
        }  
        
    }
    
    public void printPreOrder()//pre-order
    {
        if(rootNode!=null)
        {
           System.out.println(rootNode.data); 
        }
        
        Node node=rootNode;
        
        
        preOrder(node);
           
    }
    
    public void postOrder(Node node)
    {
        
        if(node.leftNode!=null)
        {
            Node node1=node.leftNode;
            postOrder(node1);
            System.out.println(node1.data);
        }
        
        if(node.rightNode!=null)
        {
            node=node.rightNode;
            postOrder(node);
            System.out.println(node.data);
        }
    }
    
    public void printPostOrder()//post-order
    {
        Node node = rootNode;
        if(node!=null)
        {
        postOrder(node);
        System.out.println(node.data);
        }

    }
    
    public void remove (int value)//small scale balance?
    {
        
    }
    
    public void balance ()
    {
        
    }
}
