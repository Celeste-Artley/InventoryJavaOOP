package invproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Platform;
import javafx.event.ActionEvent;

/**
 *
 * @author Celeste Artley
 */

public class Controller {
    
    public static ItemDatabase itemDatabase = new ItemDatabase();
    public static TagDatabase tagDatabase = new TagDatabase();
    public static UserDatabase userDatabase = new UserDatabase();
    public static CategoryDatabase categoryDatabase = new CategoryDatabase();
    
    //User functions ----------------------------------
    public void AddNewUser()
    {
        
    }
    public void DeleteUser()
    {
        
    }
    public void UpdateUser()
    {
        
    }
    //Item functions ----------------------------------------
    public void AddNewItem()
    {
        
    }
    public void DeleteItem()
    {
        
    }
    public void UpdateItem()
    {
        
    }
    //Tag Functions --------------------------------------------
    public void AddNewTag()
    {
        
    }
    public void DeleteTag()
    {
        
    }
    public void UpdateTag()
    {
        
    }
    //Category Functions ----------------------------------------
    public void AddNewCategory()
    {
        
    }
    public void DeleteCategory()
    {
        
    }
    public void UpdateCategory()
    {
        
    }
    // Other Functions -----------------------------------------------
    public void OnCloseButton()
    {
        User Gregg = new User("greggIsTheBest", "password123", "testemail@email.com");
        userDatabase.Create(Gregg);
        userDatabase.Save();
        Platform.exit();
    }
}
