/**
 * This class discusses about the Contact Object. The attributes of the contact object
 * are as follows.
 * name : Name of the person / friend.
 * email : mail id of the person / friend.
 * phoneNumber : Phone Number of the person / friend.
 * 
 * @author Siva Sankar
 */

//  Your code goes here... For Contact class
public class Contact 
{ 
    // Instance Variables 
    String name; 
    String email; 
    Long phoneNumber;  
  
    // Constructor Declaration of Class 
    public Contact(String name, String email, 
                   Long phoneNumber) 
    { 
        this.name = name; 
        this.email = email; 
        this.phoneNumber = phoneNumber;  
    } 
  
    // method 1 
    public String getName() 
    { 
        return name; 
    } 
  
    // method 2 
    public String getemail() 
    { 
        return email; 
    } 
  
    // method 3 
    public Long getphoneNumber() 
    { 
        return phoneNumber; 
    } 
  
    public String toString() 
    { 
        return("Name"+ this.getName()+ 
               ".\nemail" + this.getemail()+".\nPhone Number"+ this.getphoneNumber()); 
    } 
  
    public static void main(String[] args) 
    { 
        Contact c1 = new Contact("Divya","divya@3", 34566781098L);
        Contact c2 = new Contact("Himaja","himaja@1", 1234567L);
        System.out.println(c1.toString());
        System.out.println("=============================");
        System.out.println(c2.toString());
    } 
} 