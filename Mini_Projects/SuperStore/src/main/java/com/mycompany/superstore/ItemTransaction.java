/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superstore;

/**
 *
 * @author saraqin
 */
public class ItemTransaction {
    
    Product product;
    String storeName;
    
    public ItemTransaction(Product product, String storeName)
    {
        this.product = product;
        this.storeName = storeName;
    }
    
    public Product getProduct()
    {
        return product;
    }
    
    public String getName()
    {
        return storeName;
    }
}
