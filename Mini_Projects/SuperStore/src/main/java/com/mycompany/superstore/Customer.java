/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 *
 * @author saraqin
 */
public class Customer {
    
    String name;
    HashMap<String, StoreNameAndCount> shoppingList;
 
    
    public Customer(String name, HashMap<String, StoreNameAndCount> shoppingList)
    {
        this.name = name;
        this.shoppingList = shoppingList;

    }
    
    
    
    public String getName()
    {
        return name;
    }
    
    public HashMap<String, StoreNameAndCount> getShoppingList()
    {
        return shoppingList;
    }
    
   
    
}
