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
public class Store {
    
    String name;
    List<Product> products;
    HashMap<String, Integer> productWithCount;
    
    public Store(String name, List<Product> products, HashMap<String, Integer> productWithCount)
    {
       this.name = name;
       this.products = products;
       this.productWithCount = productWithCount;
    }
    
    public String getName()
    {
        return name;
    }
    
    public List<Product> getProductList()
    {
        return products;
    }
    
    public HashMap<String, Integer> getProductWithCount()
    {
        return productWithCount;
    }
    
    public int countForStore()
    {
        int sum = 0;
        for (int count : productWithCount.values())
        {
            sum = sum + count;
        }
        return sum;
    }
}
