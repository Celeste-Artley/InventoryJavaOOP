/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject;

/**
 *
 * @author Celeste Artley
 */
public class User {
    private String username = "";
    private String password = "";
    
    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    public String getUsername()
    {
        return username;
    }
    public void setName(String username)
    {
        this.username = username;
    }
    public String getPassWord()
    {
        return password;
    }
    public void setPassWord(String password)
    {
        this.password = password;
    }
    
}
