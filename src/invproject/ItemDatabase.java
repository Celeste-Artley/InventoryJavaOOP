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
public class ItemDatabase implements IDatabase<String, Item> {
    private List<Item> items = new ArrayList<Item>();
    
    void ItemDatabase()
    {
        items = Load();
    }
    
    public List<Item> getItems()
    {
        return items;
    }
    public void Create(Item i)
    {
        items.add(i);
    }
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
    public void UpdateCategory(String s, String c)
    {
        for (Item i : items)
        {
            if(i.getName() == s)
            {
               Category newCat = new Category(c);
               i.setCategory(newCat);
            }
        }
    }
    public void UpdateLongDesc(String s, String l)
    {
        for (Item i : items)
        {
            if(i.getName() == s)
            {
               i.setlDescription(l);
            }
        }
    }
    public void UpdateShortDesc(String s, String d)
    {
        for (Item i : items)
        {
            if(i.getName() == s)
            {
               i.setsDescription(d);
            }
        }
    }
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
    public void Save()
    {
        
    }
    private List<Item> Load()
    {
        List<Item> items = new ArrayList<Item>();
        return items;
    }

    @Override
    public void Update(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
