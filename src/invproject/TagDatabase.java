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
public class TagDatabase implements IDatabase<String, Tag> {
    private List<Tag> tags = new ArrayList<Tag>();
    
    void TagDatabase()
    {
        tags = Load();
    }

    public List<Tag> getTags() {
        return tags;
    }
    public void Create(Tag t)
    {
        tags.add(t);
    }
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
    public void Update(String s)
    {
        for (Tag t : tags)
        {
            if(t.getName() == s)
            {
               t.setName(s);
            }
        }
    }
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
    public void Save()
    {
        try
        {
            File file = new File("user.txt");
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
        }
    }
    private List<Tag> Load()
    {
        List<Tag> tags = new ArrayList<Tag>();
        return tags;
    }
}
