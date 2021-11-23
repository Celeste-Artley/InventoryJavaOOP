/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This is a Static variable database of all Item objects. 
 * @author Celeste Artley
 */
public class ItemDatabase implements IDatabase<String, Item> {
    private List<Item> items = new ArrayList<>();
    private final String saveLocation = "items.txt";
    
    public ItemDatabase()
    {
        try
        {
            items = Load();
            //System.out.println(items.size());
        }
        catch(FileNotFoundException e)
        {
           System.out.print(e);
        }
        //testLoadSaveFunctonality();
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
                fwriter.write(i.toString() + "\n");
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
    private List<Item> Load() throws FileNotFoundException
    {
        List<Item> returnItems = new ArrayList<>();
        File file = new File(saveLocation);
        if(file.canRead())
        {
            try (Scanner scanner = new Scanner(file)) 
            {
                while(scanner.hasNext())
                    {
                        String read = scanner.nextLine();
                        String[] itemValues = read.split(",");
                        
                        String itemName = itemValues[0];
                        String itemCategory = itemValues[1];
                        Integer itemQuantity = Integer.parseInt(itemValues[2]);
                        String lDescription = itemValues[3];
                        String sDescription = itemValues[4];
                        
                        Integer orderQuantity = Integer.parseInt(itemValues[5]);
                        String dateCreated = itemValues[6];
                        String lastEdited = itemValues[7];
                        POrder order = new POrder(orderQuantity,dateCreated,lastEdited);
                        
                        List<Tag> tags = new ArrayList<>();
                        String[] tagNames = itemValues[8].split(";");
                        for(String s : tagNames)
                        {
                            tags.add(new Tag(s));
                        }
                        Item i = new Item(itemName,itemCategory,itemQuantity, lDescription, sDescription,order,tags);
                        returnItems.add(i);
                    }
            }
        }
        return returnItems;
    }  

    /**
     * converts the ArrayList to an Observable List for use in FXML
     * @return
     */
    public ObservableList<Item> getObsItems()
    {
        ObservableList<Item> itemsObsList;
        itemsObsList = FXCollections.observableArrayList(items);
        return itemsObsList;
        
    }
    private void testLoadSaveFunctonality() {
        System.out.println("Item Database before items were added: " + items.size());
        POrder order = new POrder(5);
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag("Red"));
        tags.add(new Tag("Blue"));
        tags.add(new Tag("Summer"));
        Item i = new Item("Shirt", "Clothes", 20, "a shirt that looks pretty", "a shirt", order,tags);
        items.add(i);
        Save();
        System.out.println("Item Database after items were added and saved: " + items.size());
    }
}
