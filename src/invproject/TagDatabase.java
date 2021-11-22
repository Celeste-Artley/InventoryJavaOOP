/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

/**
 * This is a Static variable database of all Tag objects.
 * @author Celeste Artley
 */
public class TagDatabase implements IDatabase<String, Tag> {
    private List<Tag> tags = new ArrayList<>();
    private final String saveLocation = "tags.txt";
    
    public TagDatabase()
    {
        tags = Load();
    }

    public List<Tag> getTags() {
        return tags;
    }
    
    /**
     * Takes a Tag u as a argument and adds it to the Tags database.
     * @param t 
     */
    @Override
    public void Create(Tag t)        
    {
        tags.add(t);
    }
    
    /**
     * Reads from the database and looks for a Tag by String s (name)
     * @param s
     * @return
     */
    @Override
     public Tag Read(String s) {
        Tag val = null;
        for (Tag t : tags)
        {
            if(t.getName() == s)
            {
                val = t;
            }
        }
        return val;
    }
    
     /**
      * Takes in a Tag and a String to find and replace with the new 
      * Tag (value). Uses the String (name) to lookup the proper Tag to 
      * replace
      * @param tagName
      * @param value 
      */
    @Override
    public void Update(String tagName, Tag value)
    {
        for (Tag t : tags)
        {
            if(t.getName() == tagName)
            {
               t.setName(value.getName());  
            }
        }
    }
    
    /**
     * Takes in a String to lookup from the database a Tag then removes it
     * from the database.
     * @param s 
     */
    @Override
    public void Delete(String s)
    {
        for (Tag t : tags)
        {
            if(t.getName() == s)
            {
               tags.remove(t);
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
            try (FileWriter fwriter = new FileWriter(saveLocation)) {
                for(Tag t : tags)
                {
                    fwriter.write(t.getName() + " ");
                }
            }
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
    private List<Tag> Load()
    {
        List<Tag> tags = new ArrayList<Tag>();
        return tags;
    }
}
