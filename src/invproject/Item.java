/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject;
import java.util.*;  
/**
 * Holds all the information about each Item
 * @author Celeste Artley
 */
public class Item {
    
    private List<Tag> tags = new ArrayList<Tag>();
    private String name;
    private String categoryName;
    private Category category;
    private POrder orderInfo = new POrder();
    private Integer quantity;
    private String lDescription, sDescription;
    
    public Item(String Name, String CategoryName, Integer Quantity, String lDesc, String sDesc)
    {
        this.name = Name;
        this.categoryName = CategoryName;
        this.category = new Category(CategoryName);
        this.quantity = Quantity;
        this.lDescription = lDesc;
        this.sDescription = sDesc;
    }
    public Item(String Name, String CategoryName, Integer Quantity, String lDesc, String sDesc, POrder order, List<Tag> tags)
    {
        this.name = Name;
        this.categoryName = CategoryName;
        this.category = new Category(CategoryName);
        this.quantity = Quantity;
        this.lDescription = lDesc;
        this.sDescription = sDesc;
        this.orderInfo = order;
        this.tags = tags;
    }
    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
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
    
   @Override
   public String toString()
   {
       String s;
       String itemTags = itemTagsToString();
       s = name + "," + categoryName + "," + quantity + "," + lDescription + ","
               + sDescription + "," + orderInfo.getammountOrdered() + "," + 
               orderInfo.getDateCreated() + "," + orderInfo.getLastUpdated() + 
               "," + itemTags;
       return s;
   }
   private String itemTagsToString()
   {
       String s = "";
       for(Tag t : tags)
       {
           s += t.getName() + ";";
       }
       return s;           
   }
}
