/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superstore;

/**
 *
 * @author saraqin
 */
public class ItemStoreCount {
    
    Product product;
    String storeName;
    int count;
     
    public ItemStoreCount(Product product, String storeName, int count)
    {
        this.product = product;
        this.storeName = storeName;
        this.count = count;
    }
    
    public String getProductName()
    {
        return product.getName();
    }
    
    public int getPrice()
    {
        int price = 0;
        if (product != null)
        {
        price = product.getPrice();
        }
        return price;
    }
    
    public String getStoreName()
    {
        return storeName;
    }
    
    public int getCount()
    {
        return count;
    }
    
    public void setItem(Product product)
    {
        this.product = product;
    }
    
    public void setStoreName(String storeName)
    {
        this.storeName = storeName;
    }
    
    public void setCount(int count)
    {
        this.count = count;
    }
}
