/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a Static variable database of all Item objects. 
 * @author Celeste Artley
 */
public class ItemDatabase implements IDatabase<String, Item> {
    private List<Item> items = new ArrayList<>();
    private final String saveLocation = "items.txt";
    
    public ItemDatabase()
    {
        items = Load();
    }
    
    public List<Item> getItems()
    {
        return items;
    }
    
    /**
     *Takes a Item u as a argument and adds it to the Items database.
     * @param i 
     */
    @Override
    public void Create(Item i)
    {
        items.add(i);
    }
    
    /**
     * Reads from the database and looks for a Item by String s (name)
     * @param s
     * @return 
     */
    @Override
    public Item Read(String s) {
        Item val = null;
        for (Item i : items)
        {
            if(i.getName() == s)
            {
                val = i;
            }
        }
        return val;
    }
    
    /**
     * Takes in a Item and a String to find and replace with the new 
     * Item (value). Uses the String (username) to lookup the proper It to 
     * replace.
     * @param itemName
     * @param value 
     */
    @Override
    public void Update(String itemName, Item value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Updates a Category on the item by taking in a Item Name (itemName)
     * a Category Name(s), and a Category ( c) Finds the item to replace the 
     * Category with (itemName) then find the Item's Category with (s) and 
     * replaces their Category with (c)
     * @param itemName
     * @param s
     * @param c 
     */
    public void UpdateCategory(String itemName, String s)
    {
        for (Item i : items)
        {
            if(i.getName() == null ? s == null : i.getName().equals(itemName))
            {
               Category newCat = new Category(s);
               i.setCategory(newCat);
            }
        }
    }
    
    /**
     * Updates a Long Description on the item by taking in a Item Name (itemName)
     * a String Description(s), and a String (s) Finds the item to replace the 
     * Long Description with (itemName) then replaces said string with String (s)
     * @param itemName
     * @param s
     */
    public void UpdateLongDesc(String itemName, String s)
    {
        for (Item i : items)
        {
            if(i.getName().equals(itemName))
            {
               i.setlDescription(s);
            }
        }
    }
    
    /**
     * Updates a Short Description on the item by taking in a Item Name (itemName)
     * a String Description(s), and a String (s) Finds the item to replace the 
     * Short Description with (itemName) then replaces said string with String (s)
     * @param itemName
     * @param s
     */
    public void UpdateShortDesc(String itemName, String s)
    {
        for (Item i : items)
        {
            if(i.getName().equals(itemName))
            {
               i.setsDescription(s);
            }
        }
    }
    
    /**
     * Takes in a String to lookup from the database a Item then removes it
     * from the database.
     * @param s 
     */
    @Override
    public void Delete(String s)
    {
        for (Item i : items)
        {
            if(i.getName() == s)
            {
               items.remove(i);
            }
        }
    }
    
    /**
     * Saves the database to a text document in the saveLocation.
     */
    public void Save()
    {
        
    }
    
    /**
     * pulls the data from the saveLocation and puts it in the database
     * @return 
     */
    private List<Item> Load()
    {
        List<Item> items = new ArrayList<Item>();
        return items;
    }  
}
