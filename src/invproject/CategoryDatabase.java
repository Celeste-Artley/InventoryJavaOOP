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
 *
 * @author Celeste Artley
 */
public class CategoryDatabase implements IDatabase<String, Category> {
    private List<Category> categories = new ArrayList<Category>();
    void CategoryDatabase()
    {
        categories = Load();
    }
    public void Create(Category c)
    {
        categories.add(c);
    }
    public Category Read(String s)
    {
       Category val = null;
        for (Category c : categories)
        {
            if(c.getName() == s)
            {
                val = c;
            }
        }
        return val;
    }
    public void Update(String s)
    {
        for (Category c : categories)
        {
            if(c.getName() == s)
            {
               c.setName(s);    // This doesn't actually update anything; it just saves the exact same name it already had.
            }
        }
    }
    public void Delete(String s)
    {
        for (Category c : categories)
        {
            if(c.getName() == s)
            {
               categories.remove(c);
            }
        }
    }
    public void Save()
    {
      try
      {
          File file = new File("categories.txt");
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
           FileWriter fwriter = new FileWriter("categories.txt");
           for(Category c : categories)
           {
               fwriter.write(c.getName()+ " ");
           }
           fwriter.close();
      }
      catch(IOException e)
      {
          System.out.print(e);
      }
    }
    private List<Category> Load()
    {
        List<Category> categories = new ArrayList<Category>();
        return categories;
    }
}
