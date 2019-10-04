import java.util.Arrays;

class Card
{ 
    // Instance Variables 
    String title; 
    String author; 
    String subject;  
  
    // Constructor Declaration of Class 
    public Card(String title, String author, 
                   String subject) 
    { 
        this.title = title; 
        this.author = author; 
        this.subject= subject;  
    } 
  
    // method 1 
    public String getTitle() 
    { 
        return title; 
    } 
  
    // method 2 
    public String getAuthor() 
    { 
        return author; 
    } 
  
    // method 3 
    public String getSubject() 
    { 
        return subject; 
    } 

    public void setName(String title) 
    {
        this.title = title;
    }

    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public void setSubject(String subject) 
    {
        this.subject = subject;
    }
  
    public String toString() 
    { 
        return "{ Title = "+this.getTitle()+", Author = "+this.getAuthor()+", Subject = "+this.getSubject()+" }";
 
    }

  
    public static void main(String[] args) 
    { 
        Card c1 = new Card("Divya","divya", "Maths");
        Card c2 = new Card("Himaja","himaja", "Science");
        System.out.println(c1.toString());
        //System.out.println("=============================");
        System.out.println(c2.toString());
    } 
} 

/**Card Catalog Class
 * Users should be able to addACard() to the catalog and the cards should be filed in the correct order inside of the arrays based on the correct field.
 * Users should be able to getATitle() by specifying the book's title (a String). This method should return the first Card with a title that matches the given title. Bonus: This should be done using a binary search.
 * Users should be able to getAnAuthor() by specifying a specific author. The method should return all the books written by this author.
 * Users should be able to getSubject() which should return a list which contains all the books that involve this subject. This should be implemented using regex to search for the books.
 * Users should be able to removeATitle() which should remove this books from ALL of the card catalog stacks.
 * Users should be able to printTheCatalog() which should neatly print out all of the books in order by either title, or author, or subject based on how the user wants it.
 */
class CardCatalog {
    private Card[] cardArray;
    private int index = 0;
    CardCatalog () {
        final int capacity = 10;
        cardArray = new Card[capacity];
    }
    public void addCard (Card obj) {
        cardArray[index] = obj;
        index += 1;
    }
    public Card getATitle (final String s1) {
        for (int i = 0; i < cardArray.length; i++) {
            if (cardArray[i].getTitle().equals(s1)) {
                return cardArray[i];
            }
        }
        return null;
    }
    public Card[] getAuthor (final String s2) {
        Card[] arr = new Card[index];
        int count = 0;
        for (int i = 0; i < cardArray.length; i++) {
            if (cardArray[i].getAuthor().equals(s2)) {
                arr[count] = cardArray[i];
                count += 1;
            }
        }
        return null;
    }
    public Card getSubject (final String s3) {
        for (int i = 0; i < cardArray.length; i++) {
            if (cardArray[i].getSubject().equals(s3)) {
                cardArray[i] = null;
            }
        }
        return null;
    }
    public void removeAll (final String s4) {
        for (int i = 0; i < cardArray.length; i++) {
            if (cardArray[i].getTitle().equals(s4)) {
                cardArray[i] = null;
            }
        }
    }
    public void printCatalog() {
        for (int i = 0; i < cardArray.length; i++) {
            if (this.cardArray[i] != null) {
                System.out.println(cardArray[i]);
            }
        }
    }
    public void printCatalogByAuthor () {
        String []arr = new String[index];
        for (int i = 0; i < index; i++) {
            arr[i] = cardArray[i].getAuthor().toLowerCase();
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (this.cardArray[i] != null && arr[i].equalsIgnoreCase(cardArray[j].getAuthor())) {
                    System.out.println(cardArray[j]);
                }
            }
        } 
    }
    public void printCatalogBySubject () {
        String []arr = new String[index];
        for (int i = 0; i < index; i++) {
            arr[i] = cardArray[i].getSubject().toLowerCase();
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (this.cardArray[i] != null && arr[i].equalsIgnoreCase(cardArray[j].getSubject())) {
                    System.out.println(cardArray[j]);
                }
            }
        } 
    }
    public void printCatalogByTitle () {
        String []arr = new String[index];
        for (int i = 0; i < index; i++) {
            arr[i] = cardArray[i].getTitle().toLowerCase();
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (this.cardArray[i] != null && arr[i].equalsIgnoreCase(cardArray[j].getTitle())) {
                    System.out.println(cardArray[j]);
                }
            }
        } 
    }
    
}
public class Menu {
    public static void main (String[] args) {
        Card cOne = new Card("ControlSystems", "Pavan", "Electical");
        Card cTwo = new Card("Electronic Devices & Circuits", "Bhakshi", "Electronics");
        CardCatalog cata = new CardCatalog();
        cata.addCard(cOne);
        cata.addCard(cTwo);
        System.out.println("Catalog");
        cata.printCatalog();
        System.out.println("Sort by author");
        cata.printCatalogByAuthor();
        System.out.println("Sort by title");
        cata.printCatalogByTitle();
        System.out.println("Sort by subject");
        cata.printCatalogBySubject();
    }
}