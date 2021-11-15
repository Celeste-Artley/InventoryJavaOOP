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
 *
 * @author Celeste Artley
 */
public class UserDatabase implements IDatabase<String, User> {
    private List<User> users = new ArrayList<User>();
    
    public UserDatabase()
    {
        
        try
        {
            System.out.println("attempting to load.");
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
    public void Create(User u)
    {
        users.add(u);
    }
    public User Read(String s)
    {
        User val = null;
        for (User u : users)
        {
            if(u.getUsername() == s)
            {
                val = u;
            }
        }
        return val;
    }
    public void Update(String s)
    {
        for (User u : users)
        {
            if(u.getUsername() == s)
            {
               u.setName(s);
            }
        }
    }
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
    public void Save()
    {
        //try's to write with all the user data
        try
        {
            //Checks to see if the file exist
            File file = new File("users.txt");
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
            FileWriter fwriter = new FileWriter("users.txt");
            for(User u : users)
            {
                fwriter.write(u.getUsername() + " " + u.getPassword());
            }
            fwriter.close();
        }
        catch(IOException e)
        {
            System.out.print(e);
        }
        
        
    }
    private List<User> Load() throws FileNotFoundException
    {
        List<User> users = new ArrayList<User>();
        File file = new File("users.txt");
        if(file.canRead())
        {
           System.out.println("Can read the file.");
           Scanner scanner = new Scanner(file);
           while(scanner.hasNext())
           {
               String username = scanner.next();
               String password = scanner.next();
               User u = new User(username, password);
               users.add(u);
               //Looks like the Read function does not do exactly what I want it too here
               
               System.out.println(this.Read(u.getUsername()));
           }
           scanner.close();
        }
        return users;
    }
}
