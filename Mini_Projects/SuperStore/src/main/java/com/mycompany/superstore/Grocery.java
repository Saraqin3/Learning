/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superstore;

import java.time.LocalDate;
/**
 *
 * @author saraqin
 */
public class Grocery extends Product{
    
    
  
    LocalDate expirationDate;
    GroceryType grocerytype;
    
    
    public Grocery(int price, String name, LocalDate expirationDate, GroceryType grocerytype)
    {
        this.price = price;
        this.name = name;
        this.expirationDate = expirationDate;
        this.grocerytype = grocerytype;
    
    }
    
    public LocalDate getLocalDate()
    {
        return expirationDate;
    }
    
    public GroceryType getGroceryType()
    {
        return grocerytype;
    }
    
    @Override
    public Product makeCopy()
    {
        Product copy = new Grocery(this.price, this.name, this.expirationDate, this.grocerytype);
        return copy;
    }
}
