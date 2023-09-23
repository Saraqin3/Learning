/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sara.treesearch;

import java.util.LinkedList;

/**
 *
 * @author saraqin
 */
public class Node {
    
    
  
    int data;
    LinkedList<Node> children;
    
    
    public Node (int data, LinkedList children)
    {
        this.data=data;
        this.children=children;
    }
    
    public void setData (int data)
    {
        this.data=data;
    }
    
    public void setChildren (LinkedList children)
    {
        this.children=children;
    }
           
    public int getData ()
    {
        return this.data;
    }
    
    public LinkedList getChildren ()
    {
        return this.children;
    }
    
}
