/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject;
import java.util.*;  
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
/**
 * Holds all the information about each Item
 * @author Celeste Artley
 */
public class Item {
    
    private List<Tag> tags = new ArrayList<>();
    private String name, stringOfTags;
    private String lDescription, sDescription;
    private String categoryName;
    private String dateCreated,dateUpdated,isOnOrder;
    
    private Category category;
    private POrder orderInfo = new POrder();
    private Integer quantity, ammountOrdered;
    
    public Item(String Name, String CategoryName, Integer Quantity, String lDesc, String sDesc)
    {
        this.name = Name;
        this.categoryName = CategoryName;
        this.category = new Category(CategoryName);
        this.quantity = Quantity;
        this.lDescription = lDesc;
        this.sDescription = sDesc;
        this.dateCreated = orderInfo.getDateCreated();
        this.dateUpdated = orderInfo.getLastUpdated();
        this.stringOfTags = tags.toString();
        this.ammountOrdered = orderInfo.getammountOrdered();
        if(orderInfo.getammountOrdered() < 1)
        {
            isOnOrder = "No";
        }
        else
        {
            isOnOrder = "Yes";
        }
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
        this.dateCreated = orderInfo.getDateCreated();
        this.dateUpdated = orderInfo.getLastUpdated();
        this.stringOfTags = this.tags.toString();
        this.ammountOrdered = orderInfo.getammountOrdered();
        if(orderInfo.getammountOrdered() < 1)
        {
            isOnOrder = "No";
        }
        else
        {
            isOnOrder = "Yes";
        }
    }
    
    //Getters and Setters
    public String getIsOnOrder() {
        return isOnOrder;
    }

    //Getters and Setters
    public void setIsOnOrder(String isOnOrder) {    
        this.isOnOrder = isOnOrder;
    }

    public Integer getAmmountOrdered() {
        return ammountOrdered;
    }

    //Getters and Setters
    public void setAmmountOrdered(Integer ammountOrdered) {    
        this.ammountOrdered = ammountOrdered;
    }

    public String getStringOfTags() {
        return stringOfTags;
    }

    public void setStringOfTags(String stringOfTags) {    
        this.stringOfTags = stringOfTags;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public POrder getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(POrder orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getlDescription() {
        return lDescription;
    }

    public void setlDescription(String lDescription) {
        this.lDescription = lDescription;
    }

    public String getsDescription() {
        return sDescription;
    }

    public void setsDescription(String sDescription) {
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
   /**
    * this method is needed to convert the Long description into a property for the table.
    * @return 
    */
   public final ObjectProperty<String> lDescriptionProperty() {
        ObjectProperty<String> desc = new SimpleObjectProperty<>();
        desc.setValue(this.lDescription);
        return desc;
    }
   /**
    * this method is needed to convert the Short description into a property for the table.
    * @return 
    */
   public final ObjectProperty<String> sDescriptionProperty() {
        ObjectProperty<String> desc = new SimpleObjectProperty<>();
        desc.setValue(this.sDescription);
        return desc;
    }
}
