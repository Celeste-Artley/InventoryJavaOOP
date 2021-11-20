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
 * @author Celeste Artley and Justin R. Fox
 */
public class UserDatabase implements IDatabase<String, User> {
    private List<User> users = new ArrayList<>();
    
    public UserDatabase()
    {
        try
        {
            //System.out.println("attempting to load.");
            //System.out.println(users.size());
            users = Load();
            //System.out.println(users.size());
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
        //System.out.println("Atempting to get user: " + s + " from the database");
        User val = new User("default","default","default", "Read", false);
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
    public void UpdateRole(String s, String r)
    {
        for (User u : users)
        {
            if(u.getUsername() == s)
            {
               u.setRole(r);
               
               if (r == "Administrator")
               {
                   u.setAdminStatus(true);
               }
               else {
                   u.setAdminStatus(false);
               }
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
                fwriter.write(u.getUsername() + " " + u.getPassword() + " " + u.getEmail() + " " + u.getRole() + " " + u.getAdminStatus().toString() + "\n");
            }
            fwriter.close();
        }
        catch(IOException e)
        {
            System.out.print(e);
        }
        
        
    }
    public List<User> Load() throws FileNotFoundException
    {
        List<User> returnUsers = new ArrayList<User>();
        File file = new File("users.txt");
        if(file.canRead())
        {
           //System.out.println("Can read the file.");
           Scanner scanner = new Scanner(file);
           while(scanner.hasNext())
           {
               String username = scanner.next();
               String password = scanner.next();
               String email = scanner.next();
               String role = scanner.next();
               Boolean isAdmin = Boolean.parseBoolean(scanner.next());
               User u = new User(username, password, email, role, isAdmin);
               returnUsers.add(u);
           }
           scanner.close();
        }
        return returnUsers;
    }

    public void Update(String username, User value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
