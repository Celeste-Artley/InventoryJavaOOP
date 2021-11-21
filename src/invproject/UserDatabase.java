/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;



/**
 * This is a Static variable database of all User objects. 
 * @author Celeste Artley
 */
public class UserDatabase implements IDatabase<String, User> {
    private List<User> users = new ArrayList<>();
    private final String saveLocation = "users.txt";
    
    public UserDatabase()
    {
        try
        {
            users = Load();
        }
        catch(Exception e)
        {
           System.out.print(e);
        }
    }
 
    public List<User> getUsers()
    {
        return users;
    }
    
    /**
     *Takes a User u as a argument and adds it to the Categories database.
     * @param u
     */
    @Override
    public void Create(User u)
    {
        users.add(u);
    }
    
    /**
     * Reads from the database and looks for a User by String s (name)
     * @param s
     * @return
     */
    @Override
    public User Read(String s)
    {
        //System.out.println("Atempting to get user: " + s + " from the database");
        User val = new User("default","default","default");
        //System.out.println("the number of users in the database are: " + users.size());
        for (User u : users)
        {
           //System.out.println("in the users loop checking the user "+ u.getUsername() + " vs " + s);
            
            if(u.getUsername().equals(s))
            {
                //System.out.println("I found a user in the database with the same name as: " + u);
                val = u;
            }
        }
        return val;
    }
    
    /**
     * Takes in a User and a String to find and replace with the new 
     * User (value). Uses the String (username) to lookup the proper User to 
     * replace.
     * @param username
     * @param value
     */
    @Override
    public void Update(String username, User value) {
        User replace = Read(username);
        if(replace != null)
        {
            users.remove(replace);
            users.add(value);
        }
        else
        {
            System.out.println("Could not find passed username.");
        }
    }
    
    /**
     * Updates a password by taking in a Username (s), and a Password (p) 
     * then find the User (s) and replaces their password with (p)
     * @param s
     * @param p 
     */
    public void UpdatePassword(String s, String p)
    {
        for (User u : users)
        {
            if(u.getUsername() == s)
            {
               u.setPassword(p);
            }
        }
    }
    
    /**
     * Updates a Email by taking in a Username (s), and a Email (p) 
     * then find the User (s) and replaces their password with (p)
     * @param s
     * @param e 
     */
    public void UpdateEmail(String s, String e)
    {
        for (User u : users)
        {
            if(u.getUsername() == s)
            {
               u.setEmail(e);
            }
        }
    }
    
    /**
     * Takes in a String to lookup from the database a User then removes it
     * from the database.
     * @param s
     */
    @Override
    public void Delete(String s)
    {
        for (User u : users)
        {
            if(u.getUsername() == s)
            {
               users.remove(u);
            }
        }
    }
    
    /**
     * Saves the database to a text document in the saveLocation.
     */
    public void Save()
    {
        //try's to write with all the user data
        try
        {
            //Checks to see if the file exist
            File file = new File(saveLocation);
            if(!file.exists())
            {
                //If the file does not exist trys to create a new one
                try
                {
                    file.createNewFile();
                }
                catch(IOException e)
                {
                    System.out.print(e);  
                }
            }
            //writes for each user saved data into users.txt
            FileWriter fwriter = new FileWriter(saveLocation);
            for(User u : users)
            {
                fwriter.write(u.getUsername() + " " + u.getPassword() + " " + u.getEmail() + " " + u.getRole().toString() + "\n");
            }
            fwriter.close();
        }
        catch(IOException e)
        {
            System.out.print(e);
        }
        
        
    }
    
    /**
     * pulls the data from the saveLocation and puts it in the database
     * @return
     * @throws FileNotFoundException 
     */
    public List<User> Load() throws FileNotFoundException
    {
        List<User> returnUsers = new ArrayList<>();
        File file = new File(saveLocation);
        if(file.canRead())
        {
            try (Scanner scanner = new Scanner(file)) {
                while(scanner.hasNext())
                {
                    String username = scanner.next();
                    String password = scanner.next();
                    String email = scanner.next();
                    Boolean role = Boolean.parseBoolean(scanner.next());
                    User u = new User(username, password, email, role);
                    returnUsers.add(u);
                }}
        }
        return returnUsers;
    }

    
}
