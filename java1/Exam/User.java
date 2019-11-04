import java.util.*;
import java.io.*; 

public class User {
    String nameOfUser;
    String connections;
    int numberOfConnections = connections.length();
    User(String nameOfUser, String connections) {    
        this.nameOfUser = nameOfUser;
        this.connections = connections;
        //this.numberOfConnections = numberOfConnections;
    }
    public String getNameOfUser() {
        return this.nameOfUser;
    }

    public String getconnections() {
        return this.nameOfUser;
    }

    public String numberOfConnections() {
        return this.nameOfUser;
    }

    public String toString() {
        return this.nameOfUser + " " + "is connected to" + " " + this.connections;
    }
    public static void main(String []args) {
        User u1 = new User("Divya","Himaja,Sandhya");
        System.out.println(u1.toString());
        }

    }

    
