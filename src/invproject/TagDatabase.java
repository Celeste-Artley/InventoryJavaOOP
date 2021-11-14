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
public class TagDatabase implements IDatabase {
    private List<Tag> tags = new ArrayList<Tag>();

    public List<Tag> getTags() {
        return tags;
    }
    public Tag getTag(String s) {
        Tag val = null;
        for (Tag t : tags)
        {
            val = t;
        }
        return val;
    }
    public void Create()
    {
        
    }
    public String Read()
    {
       String returnString = "";
       return returnString;
    }
    public void Update()
    {
        
    }
    public void Delete()
    {
        
    }
}
