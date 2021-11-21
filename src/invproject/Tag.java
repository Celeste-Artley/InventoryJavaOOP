/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject;

/**
 * Contains information about a Tag
 * @author Celeste Artley
 */
public class Tag {
     private String name = "";
    public Tag(String name)
    {
        this.name = name;
    }
    //Begining of Getters / Setters functions
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    //End of Getters / Setters functions
}
