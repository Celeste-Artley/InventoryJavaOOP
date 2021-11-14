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
    //Getters and Setters
    public List<Tag> getTags() {
        return tags;
    }

    public Category getCategory() {
        return category;
    }

    public POrder getOrderInfo() {
        return orderInfo;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getlDescription() {
        return lDescription;
    }

    public String getsDescription() {
        return sDescription;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setOrderInfo(POrder orderInfo) {
        this.orderInfo = orderInfo;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setlDescription(String lDescription) {
        this.lDescription = lDescription;
    }

    public void setsDescription(String sDescription)
    {
        this.sDescription = sDescription;
    }
    //End of Getters and Setters
   
}
