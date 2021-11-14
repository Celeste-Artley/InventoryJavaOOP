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
public class TagDatabase implements IDatabase<String> {
    private List<Tag> tags = new ArrayList<Tag>();

    public List<Tag> getTags() {
        return tags;
    }
    public Tag getTag(String s) {
        Tag val = null;
        for (Tag t : tags)
        {
            if(t.GetName() == s)
            {
                val = t;
            }
        }
        return val;
    }
    public void Create(String s)
    {
        Tag newTag= new Tag(s);
        tags.add(newTag);
    }
    public String Read()
    {
       String returnString = "";
       return returnString;
    }
    public void Update(String s)
    {
        for (Tag t : tags)
        {
            if(t.GetName() == s)
            {
               t.SetName(s);
            }
        }
    }
    public void Delete(String s)
    {
        for (Tag t : tags)
        {
            if(t.GetName() == s)
            {
               tags.remove(t);
            }
        }
    }
}
