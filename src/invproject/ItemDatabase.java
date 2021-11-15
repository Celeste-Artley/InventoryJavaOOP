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
    
    public List<Item> getItmes()
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
    public void Update(String s)
    {
        for (Item i : items)
        {
            if(i.getName() == s)
            {
               i.setName(s);
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
    private void Save()
    {
        
    }
    private List<Item> Load()
    {
        List<Item> items = new ArrayList<Item>();
        return items;
    }
}
