/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject;

/**
 *contains info about a Category
 * @author Celeste Artley
 */
public class Category {
    private String name = "";
    
    public Category(String name)
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
