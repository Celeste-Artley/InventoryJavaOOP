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
        try
        {
            tags = Load();
            //System.out.println(tags.size());
        }
        catch(FileNotFoundException e)
        {
           System.out.print(e);
        }
        //testLoadSaveFunctonality();
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
            if(t.getName().equals(s))
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
            if(t.getName().equals(tagName))
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
            if(t.getName().equals(s))
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
            FileWriter fwriter = new FileWriter(saveLocation);
            for(Tag t : tags)
            {
                fwriter.write(t.toString() + "\n");
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
    private List<Tag> Load() throws FileNotFoundException
    {
        List<Tag> returnTags = new ArrayList<Tag>();
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
                        
                        String name = itemValues[0];

                        Tag t = new Tag(name);
                        returnTags.add(t);
                    }
            }
        }
        return returnTags;
    }
    
    private void testLoadSaveFunctonality()      
    {
        System.out.println("Tag Database before Tags were added: " + tags.size());
        tags.add(new Tag("Red"));
        tags.add(new Tag("Blue"));
        tags.add(new Tag("Summer"));
        Save();
        System.out.println("Tag Database after Tags were added and saved: " + tags.size());
    }
}
