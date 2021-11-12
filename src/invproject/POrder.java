/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
/**
 *
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
   }
   
   public String getLastUpdated()
    {
        return lastUpdated;
    }
   public Integer ammountOnOrder()
   {
       return amountOrdered;
   }
   
}
