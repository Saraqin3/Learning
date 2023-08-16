/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superstore;

/**
 *
 * @author saraqin
 */
public abstract class Product {
    
    int price;

    String name;
    
    
    
    
    public String getName()
    {
        return name;
    }
    
    public int getPrice()
    {
        return price;
    }
    
    
    
    public Product makeCopy()
    {
        
    }
}
