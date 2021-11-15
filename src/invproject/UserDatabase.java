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
public class UserDatabase implements IDatabase<String, User> {
    private List<User> users = new ArrayList<User>();
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
}
