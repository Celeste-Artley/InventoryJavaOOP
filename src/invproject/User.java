/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject;

/**
 *
 * @author Celeste Artley and Justin R. Fox
 */
public class User {
    private String username = "";
    private String password = "";
    private String email = "";
    private String role = "";
    private Boolean isAdmin = false;
    
    public User(String username)
    {
        this.username = username;
        this.password = "ExamplePassword";
        this.email = "Example@email.com";
        this.role = "Read";
        this.isAdmin = false;
    }
    public User(String username, String password, String email, String role, Boolean isAdmin)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.isAdmin = isAdmin;
    }
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getRole()
    {
        return role;
    }
    public void setRole(String role)
    {
        this.role = role;
    }
    public Boolean getAdminStatus()
    {
        return isAdmin;
    }
    public void setAdminStatus(Boolean isAdmin)
    {
        this.isAdmin = isAdmin;
    }
    
    
}
