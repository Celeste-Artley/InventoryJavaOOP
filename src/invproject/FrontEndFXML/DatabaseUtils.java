package invproject.FrontEndFXML;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import invproject.*;
import java.io.FileNotFoundException;

import javafx.application.Platform;
import javafx.event.ActionEvent;

/**
 * Provides a location for all the Static Databases.
 * @author Celeste Artley
 */
import java.util.Scanner;

public class DatabaseUtils {
    
    public static ItemDatabase itemDatabase = new ItemDatabase();
    public static TagDatabase tagDatabase = new TagDatabase();
    public static UserDatabase userDatabase = new UserDatabase();
    public static CategoryDatabase categoryDatabase = new CategoryDatabase();
   
    public static User loggedInUser;
   
}
