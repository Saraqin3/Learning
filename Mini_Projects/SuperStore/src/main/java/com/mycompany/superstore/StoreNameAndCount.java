/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superstore;
import java.util.HashMap;
/**
 *
 * @author saraqin
 */
public class StoreNameAndCount {
    
    String storeName;
    Integer count;
    
    
    public StoreNameAndCount(String storeName, Integer count)
    {
        this.storeName = storeName;
        this.count = count;
    }
    
    public String getStoreName()
    {
        return storeName;
    }
    
    public Integer getCount()
    {
        return count;
    }
    
    
}
