package invproject.FrontEndFXML;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import invproject.*;

import javafx.application.Platform;
import javafx.event.ActionEvent;

/**
 *
 * @author Celeste Artley
 */
import java.util.Scanner;

public class DatabaseUtils {
    
    public static ItemDatabase itemDatabase = new ItemDatabase();
    public static TagDatabase tagDatabase = new TagDatabase();
    public static UserDatabase userDatabase = new UserDatabase();
    public static CategoryDatabase categoryDatabase = new CategoryDatabase();
    Scanner keyboard = new Scanner(System.in);
    
    //User functions ----------------------------------
    public void AddNewUser()
    {
        String name, pass, email;
        
        System.out.print("\n\n Please enter username:  ");
	name = keyboard.next();
        System.out.print("\n\n Please enter password:  ");
	pass = keyboard.next();
        System.out.print("\n\n Please enter email address:  ");
	email = keyboard.next();
        
        User newUser = new User (name, pass, email);
        userDatabase.Create(newUser);
    }
    public void DeleteUser()
    {
        String name;
        
        System.out.print("\n\n Please enter username:  ");
	name = keyboard.next();
        
        userDatabase.Delete(name);
    }
    public void UpdateUserPassword()
    {
        String name, pass;
        
        System.out.print("\n\n Please enter username:  ");
	name = keyboard.next();
        System.out.print("\n\n Please enter new password:  ");
	pass = keyboard.next();
        
        userDatabase.UpdatePassword(name, pass);
    }
    public void UpdateUserEmail()
    {
        String name, email;
        
        System.out.print("\n\n Please enter username:  ");
	name = keyboard.next();
        System.out.print("\n\n Please enter new email address:  ");
	email = keyboard.next();
        
        userDatabase.UpdateEmail(name, email);
    }
    //Item functions ----------------------------------------
    public void AddNewItem()
    {
        String name, category, lDesc, sDesc;
        Integer quantity;
        
        System.out.print("\n\n Please enter item name:  ");
	name = keyboard.next();
        System.out.print("\n\n Please enter item's category:  ");
	category = keyboard.next();
        System.out.print("\n\n Please enter item quantity:  ");
	quantity = keyboard.nextInt();
        System.out.print("\n\n Please enter long description:  ");
	lDesc = keyboard.next();
        System.out.print("\n\n Please enter short description:  ");
	sDesc = keyboard.next();
        
        Item newItem = new Item (name, category, quantity, lDesc, sDesc);
        itemDatabase.Create(newItem);
    }
    public void DeleteItem()
    {
        String name;
        
        System.out.print("\n\n Please enter item name:  ");
	name = keyboard.next();
        
        itemDatabase.Delete(name);
    }
    public void UpdateItemCategory()
    {
        String name, cat;
        
        System.out.print("\n\n Please enter item name:  ");
	name = keyboard.next();
        System.out.print("\n\n Please enter new category:  ");
	cat = keyboard.next();
        
        itemDatabase.UpdateCategory(name, cat);
    }
    public void UpdateItemLongDescrip()
    {
        String name, longD;
        
        System.out.print("\n\n Please enter item name:  ");
	name = keyboard.next();
        System.out.print("\n\n Please enter new long description:  ");
	longD = keyboard.next();
        
        itemDatabase.UpdateLongDesc(name, longD);
    }
    public void UpdateItemShortDescrip()
    {
        String name, shortD;
        
        System.out.print("\n\n Please enter item name:  ");
	name = keyboard.next();
        System.out.print("\n\n Please enter new short description:  ");
	shortD = keyboard.next();
        
        itemDatabase.UpdateShortDesc(name, shortD);
    }
    //Tag Functions --------------------------------------------
    public void AddNewTag()
    {
        String name;
        
        System.out.print("\n\n Please enter tag name:  ");
	name = keyboard.next();
        
        Tag t = new Tag(name);
        tagDatabase.Create(t);
    }
    public void DeleteTag()
    {
        String name;
        
        System.out.print("\n\n Please enter tag name:  ");
	name = keyboard.next();
        
        tagDatabase.Delete(name);
    }
    public void UpdateTag()
    {
        String name;
        
        System.out.print("\n\n Please enter tag name:  ");
	name = keyboard.next();
        
        tagDatabase.Update(name);
    }
    //Category Functions ----------------------------------------
    public void AddNewCategory()
    {
        String name;
        
        System.out.print("\n\n Please enter category name:  ");
	name = keyboard.next();
        
        Category c = new Category(name);
        categoryDatabase.Create(c);
    }
    public void DeleteCategory()
    {
        String name;
        
        System.out.print("\n\n Please enter category name:  ");
	name = keyboard.next();
        
        categoryDatabase.Delete(name);
    }
    public void UpdateCategory()
    {
        String name;
        
        System.out.print("\n\n Please enter category name:  ");
	name = keyboard.next();
        
        categoryDatabase.Update(name);
    }
    // Other Functions -----------------------------------------------
    public void DatabaseTest(String s)
    {
        //User Gregg = new User("greggIsTheBest", "password123", "testemail@email.com");
        //userDatabase.Create(Gregg);
        //userDatabase.Save();
        System.out.println(userDatabase.Read(s).getPassword());
        
    }
}
