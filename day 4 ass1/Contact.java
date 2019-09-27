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
    String Email; 
    String phoneNumber;  
  
    // Constructor Declaration of Class 
    public Contact(String name, String Email, 
                   String phoneNumber) 
    { 
        this.name = name; 
        this.Email = Email; 
        this.phoneNumber = phoneNumber;  
    } 
  
    // method 1 
    public String getName() 
    { 
        return name; 
    } 
  
    // method 2 
    public String getEmail() 
    { 
        return Email; 
    } 
  
    // method 3 
    public String getPhoneNumber() 
    { 
        return phoneNumber; 
    } 

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setEmail(String Email) 
    {
        this.Email = Email;
    }

    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }
  
    public String toString() 
    { 
        return "{ Name = "+this.getName()+", Email = "+this.getEmail()+", Phone Number = "+this.getPhoneNumber()+" }";
 
    }

  
    public static void main(String[] args) 
    { 
        Contact c1 = new Contact("Divya","divya@3", "34566781098");
        Contact c2 = new Contact("Himaja","himaja@1", "1234567");
        System.out.println(c1.toString());
        //System.out.println("=============================");
        System.out.println(c2.toString());
    } 
} 