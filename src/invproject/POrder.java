/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import java.time.LocalTime;
/**
 * Holds the items information about purchasing and ordering.
 * @author Celeste Artley
 */
public class POrder {

   private String dateCreated;
   private String lastUpdated;
   private Integer amountOrdered = 0;
   
   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now();
   
   public POrder()
   {
       dateCreated = dtf.format(now);
       lastUpdated = dtf.format(now);
       //LocalDateTime.parse(dateCreated, dtf)
   }

    /**
     * For creating a purchase order with a desired amount.
     * @param orderedAmount
     */
    public POrder(Integer orderedAmount)
   {
       amountOrdered = orderedAmount;
       dateCreated = dtf.format(now);
       lastUpdated = dtf.format(now);
   }
    
    /**
     * Used for reading from the database.
     * @param orderedAmount
     * @param dateCreated
     * @param lastUpdated 
     */
   public POrder(Integer orderedAmount, String dateCreated, String lastUpdated)
   {
       amountOrdered = orderedAmount;
       this.dateCreated = dateCreated;
       this.lastUpdated = lastUpdated;
   }
   
   //Start of getters and setters
    public String getDateCreated() {
        return dateCreated;
    }
    
   public String getLastUpdated()
    {
        return lastUpdated;
    }
   public Integer getammountOrdered()
   {
       return amountOrdered;
   }
   //End of getters and setters
}
