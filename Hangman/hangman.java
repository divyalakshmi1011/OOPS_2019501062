import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
import java.lang.StringBuilder;
import static java.lang.System.*;

class Movie {
  String movie;
  String level;
  String hint1;
  String hint2;
  Movie(String movie,
  String level,
  String hint1,
  String hint2) {
    this.movie = movie;
    this.level = level;
    this.hint1 = hint1;
    this.hint2 = hint2;
  }

  public String getMovie() {
    return movie;
  }

  public void setMovie(String movie) {
    this.movie = movie;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public String getHint1() {
    return hint1;
  }

  public void setHint1(String hint1) {
    this.hint1 = hint1;
  }

  public String getHint2() {
    return hint2;
  }

  public void setHint2(String hint2) {
    this.hint2 = hint2;
  }
  
}

class Player implements Comparable<Player>{
    String playerName;
    int level;
    int score;
    Player(String playerName) {
    
    this.playerName = playerName;
    this.level = 0;
    this.score = 0;
       }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public int compareTo(Player that){
        if(this.score<that.score) return 1;
        else if(this.score>that.score) return -1;
        return 0;
    }
}


class HangMan {

    private String availableLetters;
    private String secretWord;
    private char[] lettersGussed;

    public void HangMan() {
        for(int i=0; i<25; i++)
            availableLetters = availableLetters + (char)(97+i);
       }
    public ArrayList<Movie> readFile() {
       try {
        // System.out.println("hfghm");
        File file = new File("E:\\project\\movies.txt"); 
        Scanner scan = new Scanner(file);
        // int size = 0;
        ArrayList<Movie> movies = new ArrayList<Movie>();
        while(scan.hasNextLine()) {
          String temp = scan.nextLine();
          if(!temp.equals("")){
             movies.add(new Movie(temp,scan.nextLine(),scan.nextLine(),scan.nextLine()));
            }
        }
        return movies;
    }catch(FileNotFoundException exception) {
        System.out.println("File is missing");
    }
    return null;
}


    public boolean isWordGuessed(String secretWord, char[] lettersGussed) {
        String result = "";
        for(int k = 0; k < secretWord.length(); k++) {
            if(secretWord.charAt(k) == ' ') {
                secretWord = secretWord.substring(0,k) + secretWord.substring(k+1);
            }
        }
        result = secretWord;
        int count=0;
        for(int i=0;i<result.length();i++)
        {   
          for(int j=0;j<lettersGussed.length; j++ )
          {
            if(result.charAt(i) == lettersGussed[j])
            {
                count++;
          }
        }
        }
        // System.out.println(count);
        if (count==result.length())
        return true;
        else
        return false;
    }

    public String getGuessedWord(String secretWord, char[] lg) {
        //your code goes here
        //System.out.println(secretWord);
    String newString="";
    int isSpace = 0,flag = 0,p = 0;
    for (int i = 0; i < secretWord.length(); i++)
    {
        flag = 0;
        p = 0;
        for (int j=0;j<lg.length;j++)
        {   
            if (secretWord.charAt(i)==lg[j])
            {
                p=1;
                //System.out.println(new_string.length());
                if (newString.length()>0)
                {
                 if (newString.charAt(newString.length()-1)=='_')
                    {//System.out.println(new_string.charAt(new_string.length()-1));
                
                        //System.out.println("deepak");
                        // newString+=" ";
                            }
                }
                newString+=lg[j];
                break;
            }
            else
                flag=1;
        }
        if (flag==1 && p==0)
                newString+="_";
    }
    if (newString.charAt(newString.length()-1)==' '||newString.charAt(0)==' ')
    {

        String s="";
        for(int i=0;i<newString.length();i++)
        {
            if(!(newString.charAt(i)==' '&&(i==0||i==(newString.length()-1))))
                {s+=newString.charAt(i);}
        }
        return s;
    }
    else{
        return newString;
    }
} 

    public String getWithoutSpaceWord(String s, String secretWord) {
        // System.out.println(s.length());
        // System.out.println(secretWord.length());
        char ch = ' ';
        char[] charsA = s.toCharArray();
        for(int k = 0; k < s.length(); k++) {
            if(secretWord.charAt(k) == ' ') {
                int index = k;
                charsA[index] = ch;
            }else {
               charsA[k] = s.charAt(k);
            }
            }
        s = String.valueOf(charsA);
        return s;
    }

    public String getAvailableLetters(char[] lg) {
        String availableLetters = "";
            String alphabets="abcdefghijklmnopqrstuvwxyz";
        //    String avail_letters="";
            for(int i=0;i<alphabets.length();i++)
            {   int flag=0;
            for(int j=0;j<lg.length;j++){
                if(alphabets.charAt(i)==lg[j])
                {
                    flag=1;
                    break;
                }
               }
               if (flag==0)
                 availableLetters+=alphabets.charAt(i);
            }
        return availableLetters;
    }


    public String chooseWord(int level)
    {
     try {
        File file = new File("E:\\project\\movies.txt"); 
        Scanner scan = new Scanner(file);
        // int size = 0;
        ArrayList<Movie> movies = new ArrayList<Movie>();
        while(scan.hasNextLine()) {
          String temp = scan.nextLine();
          if(!temp.equals("")){
             movies.add(new Movie(temp,scan.nextLine(),scan.nextLine(),scan.nextLine()));
          }
        }
        int size1 = 0;
        ArrayList<String> hardLevel = new ArrayList<String>();
        ArrayList<String> easyLevel = new ArrayList<String>();
        ArrayList<String> mediumLevel = new ArrayList<String>();
        ArrayList<String> movieList = new ArrayList<String>();
        for(int i = 0; i < movies.size(); i++) {
          if(movies.get(i).getLevel().equals("Hard")) {
            hardLevel.add(movies.get(i).getMovie());
          }
          else if(movies.get(i).getLevel().equals("Easy")) {
            easyLevel.add(movies.get(i).getMovie());
          }
          else if(movies.get(i).getLevel().equals("Medium")) {
            mediumLevel.add(movies.get(i).getMovie());
        }
        movieList.add(movies.get(i).getMovie());
      }
      Random r = new Random();
      if(level == 1) {
          int minRange = 0, maxRange = easyLevel.size();
          int value = r.nextInt(maxRange-minRange) + minRange;
          String secretWord = easyLevel.get(value);
          return secretWord;
      }
      else if(level == 2) {
          int minRange = 0, maxRange = mediumLevel.size();
          int value = r.nextInt(maxRange-minRange) + minRange;
          String secretWord = mediumLevel.get(value);
          return secretWord;
      }
      else if(level == 3) {
          int minRange = 0, maxRange = hardLevel.size();
          int value = r.nextInt(maxRange-minRange) + minRange;
          String secretWord = hardLevel.get(value);
          return secretWord;
      }
      else if(level == 4) {
          int minRange = 0, maxRange = movieList.size();
          int value = r.nextInt(maxRange-minRange) + minRange;
          String secretWord = movieList.get(value);
          return secretWord;
      }
    } catch(FileNotFoundException exception) {
        System.out.println("File is missing");
    }
    return null;
    }

    public int startHangMan(String secretWord)
    {
    int guess=secretWord.length(),flag;
    char[] lettersGuessed=new char[30];
    int score=0;
    int size = 0;
    int bool;
    int noh = 0;
    String letter;
    Scanner sc=new Scanner(System.in);
    String alphabets,new_string,s;
    System.out.println("Length of the word to be guessed is "+secretWord.length());
    // System.out.println("\n-----------------------------------------------");
    ArrayList<Movie> moviesList = new ArrayList<Movie>();
    moviesList = readFile();
    int size1 = 0;
    String[] arr = new String[2];
    for(int k = 0; k < moviesList.size(); k++) {
        if(moviesList.get(k).getMovie().toLowerCase().equals(secretWord)) {
             arr[size] = moviesList.get(k).getHint1();
             size++;
             arr[size] = moviesList.get(k).getHint2();
             size++;
        }
    }
    while (guess>0)
    {
        System.out.println("\nYou have "+guess+" guesses left");
        System.out.println("Do you want hint? Press 1 for hint 2 for no hint");
        bool = sc.nextInt();
        if(bool == 1) {
            while(true){
                System.out.println(noh);
                if(noh == 0) {
                    System.out.println(arr[0]);
                    System.out.println("Your hint is here proceed");
                    noh++;
                    break;
                } else if(noh == 1) {
                    System.out.println(arr[1]);
                    System.out.println("Your hint is here proceed");
                    noh++;
                    break;
                } else { 
                    System.out.println("No hints");
                    break;
                }
            }
        alphabets=getAvailableLetters(lettersGuessed);
        System.out.println("\nAvailable letters : "+alphabets);
        System.out.println("\nGuess a letter : ");
        Scanner sc1=new Scanner(System.in);
        letter = sc1.nextLine();
        if(Arrays.asList(lettersGuessed).contains(letter)) {
            System.out.println("You have aleady guessed this letter");
            s=getGuessedWord(secretWord,lettersGuessed);
            new_string = getWithoutSpaceWord(s, secretWord);
            for (int i=0;i<new_string.length();i++)
                    System.out.print(new_string.charAt(i));
            }
        else
        {   
            flag=0;
            System.out.println();
            lettersGuessed[size++]=letter.charAt(0);
            for(int i=0;i<secretWord.length();i++)
            {
                if (letter.charAt(0)==secretWord.charAt(i))
                    {flag=1;
                        break;}
                
            }
            if (flag==1)//if letter in secretWord
            {   System.out.println("\nCorrect guess!");
                score = score + 10;
                s=getGuessedWord(secretWord,lettersGuessed);
                new_string = getWithoutSpaceWord(s, secretWord);
                for (int j=0;j<new_string.length();j++)
                    System.out.print(new_string.charAt(j));
            }
            else
                {
                System.out.println("Oops! Wrong guess.");
                score = score-5;
                guess-=1;
                s=getGuessedWord(secretWord,lettersGuessed);
                new_string = getWithoutSpaceWord(s, secretWord);
                for (int j=0;j<new_string.length();j++)
                    System.out.print(new_string.charAt(j));
                }
        }
    }
        else{
            alphabets=getAvailableLetters(lettersGuessed);
        System.out.println("\nAvailable letters : "+alphabets);
        System.out.println("\nGuess a letter : ");
        Scanner sc1=new Scanner(System.in);
        letter = sc1.nextLine();
        if(Arrays.asList(lettersGuessed).contains(letter)) {
            System.out.println("You have aleady guessed this letter");
            s=getGuessedWord(secretWord,lettersGuessed);
            new_string = getWithoutSpaceWord(s, secretWord);
            for (int i=0;i<new_string.length();i++)
                    System.out.print(new_string.charAt(i));
            }
        else
        {   
            flag=0;
            System.out.println();
            lettersGuessed[size++]=letter.charAt(0);
            for(int i=0;i<secretWord.length();i++)
            {
                if (letter.charAt(0)==secretWord.charAt(i))
                    {flag=1;
                        break;}
                
            }
            if (flag==1)//if letter in secretWord
            {   System.out.println("\nCorrect guess!");
                score = score + 10;
                s=getGuessedWord(secretWord,lettersGuessed);
                new_string = getWithoutSpaceWord(s, secretWord);
                for (int j=0;j<new_string.length();j++)
                    System.out.print(new_string.charAt(j));
            }
            else if(bool != 1)
                {
                System.out.println("Oops! Wrong guess.");
                score = score-5;
                guess-=1;
                s=getGuessedWord(secretWord,lettersGuessed);
                new_string = getWithoutSpaceWord(s, secretWord);
                for (int j=0;j<new_string.length();j++)
                    System.out.print(new_string.charAt(j));
                }
        }
        }
        if (isWordGuessed(secretWord,lettersGuessed))
        {
            System.out.println("\nCongratulations!You have won the game :) " + score);
            break;
        }
        // System.out.println("----------------------------------------------");
     }
    if (guess<=0)
       { System.out.println("Sorry,you have lost the game :(" + score);
        System.out.println("The word was :"+secretWord);
    }
    return score;
    }

    public  void game() {
      // int score;
      // HangMan hangMan = new HangMan();
      ArrayList<Player> playerList = new ArrayList<Player>(); 
      for(int i = 0; i < 4; i++) { 
      System.out.println("Enter player name");
      Scanner in = new Scanner(System.in);
      String player = in.nextLine();
      Player play = new Player(player);
      // play.add(new Player(player));
      System.out.println("Press 1 for easy, 2 for medium, 3 for hard, 4 for default");
      Scanner input = new Scanner(System.in);
      int level = input.nextInt();
      play.setLevel(level);
      String secretWord = chooseWord(level);
      int score = startHangMan(secretWord.toLowerCase());
      play.setScore(score);
      System.out.println(play.getScore());
      System.out.println("Playername: " + play.getPlayerName()+"score is :"+ play.getScore());
      playerList.add(play);
  }
      // for (int i = 0; i < playerList.size(); i++) {
      //     for (int j = 0; j < playerList.size() - i - 1; j++) {
      //         if (playerList.get(i).getScore() < playerList.get(i + 1).getScore()) {
      //             Player temp = playerList.get(i);
      //             playerList.set(i, playerList.get(i + 1));
      //             playerList.set(i + 1, temp);
      //         }
      //     }
      // }
      Collections.sort(playerList);
      System.out.println("============= LEADERBOARD =============");
      System.out.println("\t" + "Player" +  "\t"+"\t" + "Score" + "\t"+"\t" + "Level");
      for (int i = 0; i < playerList.size(); i++) {
          System.out.println("\t" + playerList.get(i).getPlayerName() + "\t" +"\t"+ playerList.get(i).getScore() + "\t"+"\t"+playerList.get(i).getLevel());
      }
      System.out.println("=======================================");
  }
}



public class hangman {
     public static void main(String[] args) {
       HangMan plays = new HangMan();
      //  plays.game();
     }
   }
