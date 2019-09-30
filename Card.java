public class Card
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
    public String gettitle() 
    { 
        return title; 
    } 
  
    // method 2 
    public String getauthor() 
    { 
        return author; 
    } 
  
    // method 3 
    public String getsubject() 
    { 
        return subject; 
    } 

    public void setName(String title) 
    {
        this.title = title;
    }

    public void setauthor(String author) 
    {
        this.author = author;
    }

    public void setsubject(String subject) 
    {
        this.subject = subject;
    }
  
    public String toString() 
    { 
        return "{ Title = "+this.gettitle()+", Author = "+this.getauthor()+", Subject = "+this.getsubject()+" }";
 
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
    Card[] cardTitle;
    Card[] cardAuthor;
    Card[] cardSubject;

    //Constructor
    public CardCatalog () {
        Card[] cardTitle = new Card[10];
        Card[] cardAuthor = new Card[10];
        Card[] cardSubject = new Card[10];


        this.cardTitle = cardTitle;
        this.cardAuthor = cardAuthor;
        this.cardSubject = cardSubject;

    }
    
}