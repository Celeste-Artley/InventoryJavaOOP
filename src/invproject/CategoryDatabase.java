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
               c.setName(s);
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
}
