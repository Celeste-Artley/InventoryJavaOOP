/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject;

import java.util.ArrayList;
import java.util.List;

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
        
    }
    private List<Category> Load()
    {
        List<Category> categories = new ArrayList<Category>();
        return categories;
    }
}
