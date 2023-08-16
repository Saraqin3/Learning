/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superstore;

/**
 *
 * @author saraqin
 */
public class Electronics extends Product{
    
    
  
    
    
    public Electronics(int price, String name)
    {
        this.price = price;
        this.name = name;
    }
    
    @Override
    public Product makeCopy()
    {
        Product copy = new Electronics(this.price, this.name);
        return copy;
    }
    
}
