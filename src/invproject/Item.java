/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject;
import java.util.*;  
/**
 *
 * @author Celeste Artley
 */
public class Item {
    private List<Tag> tags = new ArrayList<Tag>();
    private String categoryName;
    
    private Category category = new Category(categoryName);
    
    private POrder orderInfo = new POrder();
    
    private Integer quantity;
    
    private String lDescription, sDescription;
    
    public Item(String Name, Integer Quantity, String lDesc, String sDesc)
    {
        categoryName = Name;
        quantity = Quantity;
        lDescription = lDesc;
        sDescription = sDesc;
    }
}
