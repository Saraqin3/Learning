/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.superstore;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author saraqin
 */
public class SuperStore {

    List<Store> m_stores = new ArrayList();
    List<Customer> m_customers = new ArrayList();
    Map<String, List> m_receipts = new HashMap<>();
    List<Product> m_products = new ArrayList();

    public void run() {
        Product dress = new Clothing(18, "Dress", Gender.FEMALE);
        Product pants = new Clothing(25, "Pants", Gender.MALE);
        Product shirt = new Clothing(9, "Shirt", Gender.MALE);
        
        Product apple = new Grocery(3, "Apple", LocalDate.of(2023, Month.SEPTEMBER, 20), GroceryType.FRUITS);
        Product cucumber = new Grocery(2, "Cucumber", LocalDate.of(2023, Month.AUGUST, 11), GroceryType.VEGGIE);
        Product salmon = new Grocery(7, "Salmon", LocalDate.of(2023, Month.JULY, 5), GroceryType.MEAT);

        Product tv = new Electronics(300, "TV");
        Product computer = new Electronics(500, "Computer");
        Product headphone = new Electronics(50, "Headphone");
        
        m_products.add(dress);
        m_products.add(pants);
        m_products.add(shirt);
        m_products.add(apple);
        m_products.add(cucumber);
        m_products.add(salmon);
        m_products.add(tv);
        m_products.add(computer);
        m_products.add(headphone);

        //StoreA
        List<Product> storeAStock = new ArrayList();
        storeAStock.add(dress);
        storeAStock.add(shirt);
        storeAStock.add(apple);
        storeAStock.add(salmon);
        storeAStock.add(tv);
        storeAStock.add(headphone);

        HashMap<String, Integer> productWithCountA = new HashMap<>();
        productWithCountA.put("Dress", 20);
        productWithCountA.put("Shirt", 18);
        productWithCountA.put("Apple", 30);
        productWithCountA.put("Salmon", 15);
        productWithCountA.put("TV", 17);
        productWithCountA.put("Headphone", 10);

        //StoreB
        List<Product> storeBStock = new ArrayList();
        storeBStock.add(pants);
        storeBStock.add(shirt);
        storeBStock.add(cucumber);
        storeBStock.add(salmon);
        storeBStock.add(computer);
        storeBStock.add(headphone);

        HashMap<String, Integer> productWithCountB = new HashMap<>();
        productWithCountB.put("Pants", 25);
        productWithCountB.put("Shirt", 36);
        productWithCountB.put("Cucumber", 30);
        productWithCountB.put("Salmon", 29);
        productWithCountB.put("Computer", 16);
        productWithCountB.put("Headphone", 30);

        //StoreC
        List<Product> storeCStock = new ArrayList();
        storeCStock.add(dress);
        storeCStock.add(pants);
        storeCStock.add(shirt);
        storeCStock.add(apple);
        storeCStock.add(cucumber);
        storeCStock.add(salmon);
        storeCStock.add(tv);
        storeCStock.add(computer);
        storeCStock.add(headphone);

        HashMap<String, Integer> productWithCountC = new HashMap<>();
        productWithCountC.put("Dress", 21);
        productWithCountC.put("Pants", 25);
        productWithCountC.put("Shirt", 36);
        productWithCountC.put("Apple", 28);
        productWithCountC.put("Cucumber", 30);
        productWithCountC.put("Salmon", 29);
        productWithCountC.put("TV", 15);
        productWithCountC.put("Computer", 16);
        productWithCountC.put("Headphone", 30);

        Store storeA = new Store("StoreA", storeAStock, productWithCountA);
        Store storeB = new Store("StoreB", storeBStock, productWithCountB);
        Store storeC = new Store("StoreC", storeCStock, productWithCountC);

        m_stores.add(storeA);
        m_stores.add(storeB);
        m_stores.add(storeC);

        //CustomerA
        StoreNameAndCount dressCustomerAWantedItem = new StoreNameAndCount("StoreA", 5);
        StoreNameAndCount appleCustomerAWantedItem = new StoreNameAndCount("StoreB", 10);

        HashMap<String, StoreNameAndCount> shoppingListCustomerA = new HashMap<>();
        shoppingListCustomerA.put("Dress", dressCustomerAWantedItem);
        shoppingListCustomerA.put("Apple", appleCustomerAWantedItem);

        //CustomerB
        StoreNameAndCount shirtCustomerBWantedItem = new StoreNameAndCount("StoreB", 10);
        StoreNameAndCount salmonCustomerBWantedItem = new StoreNameAndCount("StoreC", 7);

        HashMap<String, StoreNameAndCount> shoppingListCustomerB = new HashMap<>();
        shoppingListCustomerA.put("Shirt", shirtCustomerBWantedItem);
        shoppingListCustomerA.put("Salmon", salmonCustomerBWantedItem);

        //CustomerC
        StoreNameAndCount pantsCustomerCWantedItem = new StoreNameAndCount("StoreC", 15);
        StoreNameAndCount headphoneCustomerCWantedItem = new StoreNameAndCount("StoreB", 32);

        HashMap<String, StoreNameAndCount> shoppingListCustomerC = new HashMap<>();
        shoppingListCustomerC.put("Pants", pantsCustomerCWantedItem);
        shoppingListCustomerC.put("Headphone", headphoneCustomerCWantedItem);

        Customer customerA = new Customer("CustomerA", shoppingListCustomerA);
        Customer customerB = new Customer("CustomerB", shoppingListCustomerB);
        Customer customerC = new Customer("CustomerC", shoppingListCustomerC);

        m_customers.add(customerA);
        m_customers.add(customerB);
        m_customers.add(customerC);

    }

    public static void main(String[] args) {

        SuperStore piggySuperStore = new SuperStore();
        piggySuperStore.run();

        System.out.println("Welcome to PiggyMarket!");

        //Q1 Inventory Check (for all stores)
        System.out.println("How many items in the market? " + piggySuperStore.countForStores());
        
        //Q2 Purchase, restocking, receipt
        piggySuperStore.purchaseAllCustomer();

        //Q3 Which customer spent the most today?
        System.out.println("Which customer spent the most today? (will be name + date) " + piggySuperStore.customerSpentMost());
        
        //Q4 How many items were sold in storeA?
        System.out.println("How many items were sold in storeA? " + piggySuperStore.numberOfItemsSoldInStore("StoreA"));
        
        //Q5 Print out receipt for customerC
        String date = LocalDate.now().toString();
        System.out.println("Print out receipt for customerC "); 
        piggySuperStore.receiptPrinting("CustomerC"+date);
        
        //Q7 check inventory of headphone in store B
        System.out.println("Check inventory of headphone in store B: "+piggySuperStore.checkInventory("Headphone","StoreB"));
        
        //Q6-1 return
        piggySuperStore.returnItem ("Headphone", "StoreB", 2, "CustomerC"+date);
        
        //Q6-2 print receipt for Customer C again
        System.out.println("Print out receipt for customerC again (after CustomerC returned 2 Headphones) "); 
        piggySuperStore.receiptPrinting("CustomerC"+date);
        
        //Q7 check inventory of headphone in store B
        System.out.println("Check inventory of headphone in store B: "+piggySuperStore.checkInventory("Headphone","StoreB"));
        

       

    }

    //Function 1  How many items across all stores?
    public int countForStores() {
        int totalCount = 0;
        for (Store store : m_stores) {
            totalCount = totalCount + store.countForStore();
        }

        return totalCount;
    }

    
    //Function 2-1 Finding the store with the biggest number of item
    public String findStore (String customerItemName)
    {
        int bigNumber = 0;
        String storeName = null;
        
        for (Store store : m_stores)
        {
           Integer number = 0;
           number = store.getProductWithCount().get(customerItemName);
           
           if (number>=bigNumber)
           {
               bigNumber = number;
               storeName = store.getName();
           }
                      
        }
        
        return storeName;    
    }
    
    //Function 2-2 Finding biggest number and divide it to half
    public int findNumber (String customerItemName)
    {
        String storeName = findStore(customerItemName);
        int halfNumber = 0;
        
        for (Store store : m_stores)
        {
                       
            if (storeName.equals(store.getName()))
            {              
                HashMap<String, Integer> StoreItemWithCount = store.getProductWithCount();
                int number = StoreItemWithCount.get(customerItemName);
                halfNumber = number/2;
                int newNumber = number - halfNumber;
                StoreItemWithCount.replace(customerItemName, newNumber);
            }
            
        }
        
       return halfNumber; 
    }

    //Function 2-3 restocking
    public void restocking (Map<String, Integer> storeItemWithCount, String customerItemName, int newCount)
    {
        int newNumber = findNumber(customerItemName) + newCount;
        storeItemWithCount.replace(customerItemName, newNumber);
    }
            
    //Function 2-4 Make purchase for each item
    public void purchaseItem (HashMap.Entry<String, StoreNameAndCount> entry, List<ItemStoreCount> items)
    {
        for (Store store : m_stores) 
            {
                String storeName = store.getName();
                Map<String, Integer> storeItemWithCount = store.getProductWithCount();
                List<Product> products = store.getProductList();

                StoreNameAndCount customerItem = entry.getValue();
                String customerItemName = entry.getKey();
                String customerStoreName = customerItem.getStoreName();
                int customerItemCount = customerItem.getCount();
                

                if (storeName.equals(customerStoreName)) 
                {
                
                    Integer storeItemCount = storeItemWithCount.get(customerItemName);

                    if (storeItemCount != null) 
                    {

                        int newCount = storeItemCount - customerItemCount;
                        
                        if (newCount>0)
                        {
                           store.getProductWithCount().replace(customerItemName, newCount); 
                        }

                        else 
                        {
                           restocking(storeItemWithCount, customerItemName, newCount);
                        }
                        
                    }
                    
                    Product product = lookForProduct(customerItemName, products);
                    ReceiptForItem(product, customerStoreName, customerItemCount, items);
                    
                    
                }
            }
    }
            
    //Function 2-5 Make purchase --- for each customer
    public void purchaseCustomer(Customer customer) 
    {
        Map<String, StoreNameAndCount> shoppingList = customer.getShoppingList();
        
        List<ItemStoreCount> items = new ArrayList();
        
        m_receipts.put(customer.getName()+LocalDate.now().toString(), items);

        for (HashMap.Entry<String, StoreNameAndCount> entry : shoppingList.entrySet()) 
        {
            purchaseItem(entry, items);

        }
        
   
    }
    
    //Function 2-6 Make purchase --- for all customer
    public void purchaseAllCustomer()
    {
        for (Customer customer : m_customers)
        {
            purchaseCustomer(customer);
        }
    }

    //Function 2-7 Look for product
    public Product lookForProduct(String customerItemName, List<Product> products)
    {
        Product product1 = null;
        
        for (Product product : products)
        {
            if (customerItemName.equals(product.getName()))
            {
                product1 = product;
            }
        }
        
        return product1;
    }

    //Function 2-8 Make receipt for one item
    public void ReceiptForItem(Product product, String storeName, int count, List<ItemStoreCount> items)
            
    {
        ItemStoreCount receiptItem = new ItemStoreCount(product, storeName, count);
        items.add(receiptItem);
    }

  
    //Function 3-1 How much each customer spent (sum up for all the items purchased)
    public int eachCustomerSpent(List<ItemStoreCount> list)
    {
        int spent = 0;
        
        for (ItemStoreCount var : list)
        {
            int price = var.getPrice();
            int count = var.getCount();
            spent = spent + price*count;
        }
        
        return spent;
    }

    //Funciton 3 Which customer spent the most? 
    public String customerSpentMost() 
    {
        int mostSpent = 0;
        String name = null;
        for (Map.Entry<String, List> entry : m_receipts.entrySet())
        {
           List<ItemStoreCount> list = entry.getValue();
           int spent = eachCustomerSpent(list);
           if (spent >= mostSpent)
           {
               mostSpent = spent;
               name = entry.getKey();
           }
        }
        return name;
    }

    //Function 4 How many items were sold in StoreA? (check receipt that has storeA)
    public int numberOfItemsSoldInStore (String string) 
    {
        int totalCount = 0;
        
        for (Map.Entry<String, List> entry : m_receipts.entrySet())
        {
            List<ItemStoreCount> list = entry.getValue();
            
            for (ItemStoreCount itemStoreCount : list)
            {
                String storeName = itemStoreCount.getStoreName();
                int count = itemStoreCount.getCount();
                
                if (storeName.equals(string))
                {
                    totalCount = totalCount + count;
                }
            }
        }
        
        return totalCount;
    }

    //Function 5 Receipt printing
    public void receiptPrinting (String string)
    {
        for (Map.Entry<String, List> entry : m_receipts.entrySet())
        {
            String key = entry.getKey();
            List<ItemStoreCount> list = entry.getValue();
            
            if (string.equals(key))
            {
                for (ItemStoreCount itemStoreCount : list)
                {
                    String itemName = itemStoreCount.getProductName();
                    int price = itemStoreCount.getPrice();
                    String storeName = itemStoreCount.getStoreName();
                    int count = itemStoreCount.getCount();
                    int totalPrice = price*count;
                    System.out.println("Item Name: "+itemName + " Store: " + storeName + " Unit Price: " + price + " Count: " + count + " Total Price: " + totalPrice);
                    
                }
            }
        }
    }
            
            
    //Function 6-1 check if an item is returnable(need item name, returning count, store name)
    public boolean itemReturnable(String string)
    {
        boolean boo = true;
        for (Product product : m_products)
        {
            if (product.getName().equals(string))
            {
                Product dress = m_products.get(0);
                Class<?> grocery = dress.getClass();
               
                if (product.getClass().equals(grocery))
                {
                    System.out.println(string+" cannot be refunded");
                    boo = false;
                }
                
                
            }
        }
        return boo;
    }
    
    //Function 6-2 returnItem
    public void returnItem (String itemName, String storeName, int count, String customerNameAndDate)
   {
       
    if (itemReturnable(itemName))
    {
       for (Store store : m_stores)
       {
           String storeName2 = store.getName();
           if (storeName.equals(storeName2))
           {
               HashMap<String, Integer> list = store.getProductWithCount();
               int count2 = list.get(itemName);
               int newCount = count2 + count;
               list.replace(itemName, newCount);
               
               List<ItemStoreCount> receipt = m_receipts.get(customerNameAndDate);
               for (ItemStoreCount itemStoreCount : receipt)
               {
                   String name = itemStoreCount.getProductName();
                   String storeName3 = itemStoreCount.getStoreName();
                   if (name.equals(itemName)&&storeName3.equals(storeName))
                   {                  
                   int oldCount = itemStoreCount.getCount();
                   itemStoreCount.setCount(oldCount-count);
                   
                   }
               }
               
           }
       }
    }
    
   }
    
    //Function 7 check inventory of headphone in store B
    public int checkInventory (String itemName, String storeName)
    {
        int count = 0;
        for (Store store : m_stores)
        {
            String storeName2 = store.getName();
            if (storeName2.equals(storeName))
            {
                HashMap<String, Integer> map = store.getProductWithCount();
                int inventoryCount = map.get(itemName);
                count = inventoryCount;
            }
        }
        return count;
    }
    
}
//Q to Andy: class.toString;compare 2 classes