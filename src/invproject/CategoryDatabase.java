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
 * This is a Static variable database of all Category objects. 
 * @author Celeste Artley
 */
public class CategoryDatabase implements IDatabase<String, Category> {
    private List<Category> categories = new ArrayList<>();
    private final String saveLocation = "Categories.txt";
    
    public CategoryDatabase()
    {
        try
        {
            categories = Load();
        }
        catch(FileNotFoundException e)
        {
           System.out.print(e);
        }
    }
    
    public List<Category> getCategories()
    {
        return categories;
    }

    /**
     *Takes a Category c as a argument and adds it to the Category database.
     * @param c
     */
    @Override
    public void Create(Category c)
    {
        categories.add(c);
    }

    /**
     * Reads from the database and looks for a category by String s (name)
     * @param s
     * @return
     */
    @Override
    public Category Read(String s)
    {
       Category val = null;
        for (Category c : categories)
        {
            if(c.getName().equals(s))
            {
                val = c;
            }
        }
        return val;
    }

    /**
     * Takes in a Category and a String to find and replace with the new 
     * Category (value). Uses the String (categoryName) to lookup the proper Category to 
     * replace.
     * @param categoryName
     * @param value
     */
    @Override
    public void Update(String categoryName, Category value)
    {
        Category replace = Read(categoryName);
        if(replace != null)
        {
            categories.remove(replace);
            categories.add(value);
        }
        else
        {
            System.out.println("Could not find passed category name.");
        }
    }

    /**
     * Takes in a String to lookup from the database a Category then removes it
     * from the database.
     * @param s
     */
    @Override
    public void Delete(String s)
    {
        categories.stream().filter(c -> (c.getName().equals(s))).forEachOrdered(c -> {
            categories.remove(c);
        });
    }
    
    /**
     * Saves the database to a text document 
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
           for(Category c : categories)
           {
               fwriter.write(c.getName()+ "\n");
           }
           fwriter.close();
      }
      catch(IOException e)
      {
          System.out.print(e);
      }
    }
    
    /**
     * Pulls the data from the saveLocation and puts it in the database
     * @return
     * @throws FileNotFoundException 
     */
    private List<Category> Load() throws FileNotFoundException
    {
        List<Category> returnCategories = new ArrayList<Category>();
        File file = new File(saveLocation);
        if(file.canRead())
        {
           Scanner scanner = new Scanner(file);
           while(scanner.hasNext())
           {
               String value = scanner.next();
               Category c = new Category(value);
               returnCategories.add(c);
           }
           scanner.close();
        }
        return categories;
    }
}
