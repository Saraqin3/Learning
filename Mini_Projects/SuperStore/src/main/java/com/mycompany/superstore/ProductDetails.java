/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superstore;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author saraqin
 */
public class ProductDetails {
    
        Product dress = new Clothing(18, "Dress", Gender.FEMALE, 0);
        Product pants = new Clothing(25, "Pants", Gender.MALE, 0);
        Product shirt = new Clothing(9, "Shirt", Gender.MALE, 0);
        
        Product apple = new Grocery(3, "Apple", LocalDate.of(2023, Month.SEPTEMBER, 20), GroceryType.FRUITS, 0);
        Product cucumber = new Grocery(2, "Cucumber", LocalDate.of(2023, Month.AUGUST, 11), GroceryType.VEGGIE, 0);
        Product salmon = new Grocery(7, "Salmon", LocalDate.of(2023, Month.JULY, 5), GroceryType.MEAT, 0);
        
        Product tv = new Electronics(300, "TV", 0);
        Product computer = new Electronics(500, "Computer", 0);
        Product headphone = new Electronics(50, "Headphone", 0);
        
        public ProductDetails(int count)
        {
            
        }
        
        
}
