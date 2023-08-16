/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superstore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author saraqin
 */
public class Transaction {
    
    String customerName;
    LocalDate transactionDate;
    List <ItemTransaction> itemsTransactions;
    
    public Transaction(String customerName, LocalDate transactionDate, List <ItemTransaction> itemsTransactions)
    {
        this.customerName = customerName;
        this.transactionDate = transactionDate;
        this.itemsTransactions = itemsTransactions;
        
    }
    
    public String getName()
    {
        return customerName;
    }
    
    public LocalDate getDate()
    {
        return transactionDate;
    }
    
    public List <ItemTransaction> getListOfItem()
    {
        return itemsTransactions;
    }
}
