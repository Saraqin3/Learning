/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superstore;

/**
 *
 * @author saraqin
 */
public class Clothing extends Product{
    
    
  
    Gender gender;
    
        
    public Clothing(int price, String name, Gender gender)
    {
        this.price = price;
        this.name = name;
        this.gender = gender;
      
    }
    
    public Gender getGender()
    {
        return gender;
    }
    
    @Override
    public Product makeCopy()
    {
        Product copy = new Clothing(this.price, this.name, this.gender);
        return copy;
    }
}
