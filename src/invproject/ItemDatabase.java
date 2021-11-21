/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
            if(i.getName().equals(s))
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
        
        Item replace = Read(itemName);
        if(replace != null)
        {
            items.remove(replace);
            items.add(value);
        }
        else
        {
            System.out.println("Could not find passed item by name.");
        }
    }
    
    /**
     * Updates a Category on the item by taking in a Item Name (itemName)
     * a Category Name(s), and a Category ( c) Finds the item to replace the 
     * Category with (itemName) then find the Item's Category with (s) and 
     * replaces their Category with (c)
     * @param itemName
     * @param newCategory
     */
    public void UpdateCategory(String itemName, String newCategory)
    {
        for (Item i : items)
        {
            if(i.getName().equals(itemName))
            {
                Category newCat = new Category(newCategory);
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
        if(s.length() < 250)
        {
            for (Item i : items)
            {
                if(i.getName().equals(itemName))
                {
                   i.setlDescription(s);
                }
            }
        }
        else
        {
            System.out.println("You cannot update Long Descriptions longer than 250 characters.");
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
        if(s.length() < 30)
        {
            for (Item i : items)
            {
                if(i.getName().equals(itemName))
                {
                   i.setlDescription(s);
                }
            }
        }
        else
        {
            System.out.println("You cannot update Long Descriptions longer than 30 characters.");
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
            if(i.getName().equals(s))
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
        try
        {
            File file = new File(saveLocation);
            if(!file.exists())
            {
                try
                {
                    file.createNewFile();
                }
                catch(IOException e)
                {
                    System.out.print(e);  
                }
            }
            FileWriter fwriter = new FileWriter(saveLocation);
            for(Item i : items)
            {
                String orderRequrements = i.getOrderInfo().getammountOrdered() 
                        + i.getOrderInfo().getLastUpdated();
                
                String itemRequrements = i.getName() + " | " + i.getCategory() 
                        + " | " + i.getQuantity()+ " | " +i.getlDescription() 
                        + " | " +i.getsDescription() + " | " + orderRequrements;
                
                fwriter.write(itemRequrements+ "\n");
            }
            fwriter.close();
        }
        catch(IOException e)
        {
            System.out.print(e);
        }
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
