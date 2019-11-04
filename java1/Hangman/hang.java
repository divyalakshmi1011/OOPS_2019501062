import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;
// import static java.lang.System.*;

class Movie {
    /**
     * movie is movie name.
     */
  private String movie;
  /**
   * level 1 for easy, 2 for medium, 3 for hard, 4 for default.
   */
  private String level;
  /**
   * hint regarding the movie.
   */
  private String hint1;
  /**
   * hint regarding the movie.
   */
  private String hint2;
  Movie(final String movies,
  final String levels,
  final String hint1s,
  final String hint2s) {
    this.movie = movies;
    this.level = levels;
    this.hint1 = hint1s;
    this.hint2 = hint2s;
  }

  public String getMovie() {
    return movie;
  }

  public void setMovie(final String movies) {
    this.movie = movies;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(final String levels) {
    this.level = levels;
  }

  public String getHint1() {
    return hint1;
  }

  public void setHint1(final String hint1s) {
    this.hint1 = hint1s;
  }

  public String getHint2() {
    return hint2;
  }

  public void setHint2(final String hint2s) {
    this.hint2 = hint2s;
  }
}

class Player implements Comparable<Player> {
    /**@ playerName name of the player who plays.
     * @ level indicates the difficulty level
     * @ score marks for guessing
     */
    private String playerName;
    /**@ playerName name of the player who plays.
     * @ level indicates the difficulty level
     * @ score marks for guessing
     */
    private int level;
    /**@ playerName name of the player who plays.
     * @ level indicates the difficulty level
     * @ score marks for guessing
     */
    private int score;

    Player(final String playerNames) {
    this.playerName = playerNames;
    this.level = 0;
    this.score = 0;
       }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(final String name) {
        this.playerName = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(final int l) {
        this.level = l;
    }

    public int getScore() {
        return score;
    }

    public void setScore(final int s) {
        this.score = s;
    }
    public int compareTo(final Player that) {
        if (this.score < that.score) {
             return 1;
        } else if (this.score > that.score) {
            return -1;
         } else {
              return 0;
         }
    }
}


class gameHangMan {

    /**
     * availableletters.
     */
    private String availableLetters;
    /**
     * secretwords.
     */
    private String secretWord;
    /**
     * letters guessed.
     */
    private char[] lettersGussed;
    /**
     * twenty five.
     */
    private final int twentyfive = 25;
    /**
     * ninety seven.
     */
    private final int ninetyseven = 97;

    public void gameHangMans() {
        for (int i = 0; i < twentyfive; i++) {
            availableLetters = availableLetters + (char) (ninetyseven + i);
       }
    }
    public ArrayList<Movie> readFile() {
       try {
        // System.out.println("hfghm");
        File file = new File("E:\\project\\movies.txt");
        Scanner scan = new Scanner(file);
        // int size = 0;
        ArrayList<Movie> movies = new ArrayList<Movie>();
        while (scan.hasNextLine()) {
          String temp = scan.nextLine();
          if (!temp.equals("")) {
             movies.add(new Movie(temp, scan.nextLine(),
              scan.nextLine(), scan.nextLine()));
            }
        }
        return movies;
        } catch (FileNotFoundException exception) {
        System.out.println("File is missing");
        }
    return null;
    }


    public boolean isWordGuessed(final String secretWords,
     final char[] lettersGusseds) {
        String result = "";
        for (int k = 0; k < secretWords.length(); k++) {
            if (secretWords.charAt(k) == ' ') {
                secretWords = secretWords.substring(0, k)
                + secretWords.substring(k + 1);
            }
        }
        result = secretWords;
        int count = 0;
        for (int i = 0; i < result.length(); i++) {
          for (int j = 0; j < lettersGusseds.length; j++) {
            if (result.charAt(i) == lettersGusseds[j]) {
                count++;
          }
        }
        }
        // System.out.println(count);
        if (count == result.length()) {
        return true;
        } else {
        return false;
        }
    }

  public String getGuessedWord(final String secretWords, final char[] lg) {
    String newString = "";
    int isSpace = 0;
    int flag = 0;
    int p = 0;
    for (int i = 0; i < secretWords.length(); i++) {
        flag = 0;
        p = 0;
        for (int j = 0; j < lg.length; j++) {
            if (secretWords.charAt(i) == lg[j]) {
                p = 1;
                //System.out.println(new_string.length());
                // if (newString.length() > 0) {
                //  if (newString.charAt(newString.length()-1) == '_'){
                    //System.out.println(new_string.charAt(
                        // new_string.length()-1));
                        //System.out.println("deepak");
                        // newString+=" ";
                            // }
                // }
                newString += lg[j];
                break;
            } else {
                flag = 1;
            }
        }
        if (flag == 1 && p == 0) {
                newString += "_";
        }
    }
    if (newString.charAt(newString.length() - 1) == ' '
    || newString.charAt(0) == ' ') {
        String s = "";
        for (int i = 0; i < newString.length(); i++) {
            if (!(newString.charAt(i) == ' ' && (i == 0
            || i == (newString.length() - 1)))) {
                s += newString.charAt(i);
            }
        }
        return s;
    } else {
        return newString;
      }
     }

    public String getWithoutSpaceWord(final String s,
     final String secretWords) {
        char ch = ' ';
        char[] charsA = s.toCharArray();
        for (int k = 0; k < s.length(); k++) {
            if (secretWords.charAt(k) == ' ') {
                int index = k;
                charsA[index] = ch;
            } else {
               charsA[k] = s.charAt(k);
            }
            }
        s = String.valueOf(charsA);
        return s;
    }

    public String getAvailableLetters(final char[] lg) {
        String availableLetterss = "";
            String alphabets = "abcdefghijklmnopqrstuvwxyz";
        //    String avail_letters="";
            for (int i = 0; i < alphabets.length(); i++) {
               int flag = 0;
            for (int j = 0; j < lg.length; j++) {
                if (alphabets.charAt(i) == lg[j]) {
                    flag = 1;
                    break;
                }
               }
               if (flag == 0) {
                 availableLetterss += alphabets.charAt(i);
               }
            }
        return availableLetterss;
    }


    public String chooseWord(final int level) {
     try {
        File file = new File("E:\\project\\movies.txt");
        Scanner scan = new Scanner(file);
        // int size = 0;
        ArrayList<Movie> movies = new ArrayList<Movie>();
        while (scan.hasNextLine()) {
          String temp = scan.nextLine();
          if (!temp.equals("")) {
             movies.add(new Movie(temp,
              scan.nextLine(), scan.nextLine(), scan.nextLine()));
          }
        }
        int size1 = 0;
        ArrayList<Movie> hardLevel = new ArrayList<Movie>();
        ArrayList<Movie> easyLevel = new ArrayList<Movie>();
        ArrayList<Movie> mediumLevel = new ArrayList<Movie>();
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        for (int i = 0; i < movies.size(); i++) {
          if (movies.get(i).getLevel().equals("Hard")) {
            hardLevel.add(movies.get(i));
          } else if (movies.get(i).getLevel().equals("Easy")) {
            easyLevel.add(movies.get(i));
           } else if (movies.get(i).getLevel().equals("Medium")) {
            mediumLevel.add(movies.get(i));
        }
        movieList.add(movies.get(i));
      }
      Random r = new Random();
      final int a = 1;
      final int b = 2;
      final int c = 3;
      final int d = 4;
      if (level == a) {
          int minRange = 0;
          int maxRange = easyLevel.size();
          int value = r.nextInt(maxRange - minRange) + minRange;
          String secretWords = easyLevel.get(value).getMovie();
          return secretWords;
        } else if (level == b) {
          int minRange = 0;
          int maxRange = mediumLevel.size();
          int value = r.nextInt(maxRange - minRange) + minRange;
          String secretWords = mediumLevel.get(value).getMovie();
          return secretWords;
        } else if (level == c) {
          int minRange = 0;
          int maxRange = hardLevel.size();
          int value = r.nextInt(maxRange - minRange) + minRange;
          String secretWords = hardLevel.get(value).getMovie();
          return secretWords;
        } else if (level == d) {
          int minRange = 0;
          int maxRange = movieList.size();
          int value = r.nextInt(maxRange - minRange) + minRange;
          String secretWords = movieList.get(value).getMovie();
          return secretWords;
      }
    } catch (FileNotFoundException exception) {
        System.out.println("File is missing");
    }
    return null;
    }

    public int startHangMan(final String secretWords) {
        int guess = secretWords.length();
        int flag;
        final int thirty = 30;
        char[] lettersGuessed = new char[thirty];
        int score = 0;
        int size = 0;
        int bool;
        int noh = 0;
        String letter;
        Scanner sc = new Scanner(System.in);
        String newStrings;
        String s;
        String alphabets;
        System.out.println("Length of the word to be guessed is "
        + secretWords.length());
        // System.out.println("\n----------------------------------");
        ArrayList<Movie> moviesList = new ArrayList<Movie>();
        moviesList = readFile();
        int size1 = 0;
        final int five = 5;
        final int ten = 10;
        String[] arr = new String[2];
        for (int k = 0; k < moviesList.size(); k++) {
            if (moviesList.get(k).getMovie().toLowerCase().equals(secretWord)) {
                arr[size] = moviesList.get(k).getHint1();
                size++;
                arr[size] = moviesList.get(k).getHint2();
                size++;
            }
        }
        while (guess > 0) {
            System.out.println("\nYou have " + guess + " guesses left");
            System.out.println(
                "Do you want hint? Press 1 for hint 2 for no hint");
            bool = sc.nextInt();
            if (bool == 1) {
                while (true) {
                    System.out.println(noh);
                    if (noh == 0) {
                        System.out.println(arr[0]);
                        System.out.println("Your hint is here proceed");
                        noh++;
                        break;
                    } else if (noh == 1) {
                        System.out.println(arr[1]);
                        System.out.println("Your hint is here proceed");
                        noh++;
                        break;
                    } else {
                        System.out.println("No hints");
                        break;
                    }
                }
            alphabets = getAvailableLetters(lettersGuessed);
            System.out.println("\nAvailable letters : " + alphabets);
            System.out.println("\nGuess a letter : ");
            Scanner sc1 = new Scanner(System.in);
            letter = sc1.nextLine();
            if (Arrays.asList(lettersGuessed).contains(letter)) {
                System.out.println("You have aleady guessed this letter");
                s = getGuessedWord(secretWords, lettersGuessed);
                newStrings = getWithoutSpaceWord(s, secretWords);
                for (int i = 0; i < newStrings.length(); i++) {
                        System.out.print(newStrings.charAt(i));
                }
            } else {
                flag = 0;
                System.out.println();
                lettersGuessed[size++] = letter.charAt(0);
                for (int i = 0; i < secretWords.length(); i++) {
                    if (letter.charAt(0) == secretWords.charAt(i)) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {
                    System.out.println("\nCorrect guess!");
                    score = score + ten;
                    s = getGuessedWord(secretWords, lettersGuessed);
                    newStrings = getWithoutSpaceWord(s, secretWord);
                    for (int j = 0; j < newStrings.length(); j++) {
                        System.out.print(newStrings.charAt(j));
                    }
                } else {
                    System.out.println("Oops! Wrong guess.");
                    score = score - five;
                    guess -= 1;
                    s = getGuessedWord(secretWords, lettersGuessed);
                    newStrings = getWithoutSpaceWord(s, secretWords);
                    for (int j = 0; j < newStrings.length(); j++) {
                        System.out.print(newStrings.charAt(j));
                    }
                }
            }
        } else {
            alphabets = getAvailableLetters(lettersGuessed);
            System.out.println("\nAvailable letters : " + alphabets);
            System.out.println("\nGuess a letter : ");
            Scanner sc1 = new Scanner(System.in);
            letter = sc1.nextLine();
            if (Arrays.asList(lettersGuessed).contains(letter)) {
                System.out.println("You have aleady guessed this letter");
                s = getGuessedWord(secretWords, lettersGuessed);
                newStrings = getWithoutSpaceWord(s, secretWords);
                for (int i = 0; i < newStrings.length(); i++) {
                        System.out.print(newStrings.charAt(i));
                }
            } else {
                flag = 0;
                System.out.println();
                lettersGuessed[size++] = letter.charAt(0);
                for (int i = 0; i < secretWords.length(); i++) {
                    if (letter.charAt(0) == secretWords.charAt(i)) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {
                    System.out.println("\nCorrect guess!");
                    score = score + ten;
                    s = getGuessedWord(secretWords, lettersGuessed);
                    newStrings = getWithoutSpaceWord(s, secretWords);
                    for (int j = 0; j < newStrings.length(); j++) {
                        System.out.print(newStrings.charAt(j));
                    }
                } else if (bool != 1) {
                    System.out.println("Oops! Wrong guess.");
                    score = score - five;
                    guess -= 1;
                    s = getGuessedWord(secretWord, lettersGuessed);
                    newStrings = getWithoutSpaceWord(s, secretWords);
                    for (int j = 0; j < newStrings.length(); j++) {
                        System.out.print(newStrings.charAt(j));
                    }
            }
            }
            if (isWordGuessed(secretWords, lettersGuessed)) {
                System.out.println("\nCongratulations!You have won the game :) "
                + score);
                break;
            }
            // System.out.println("---------------------------------");
        }
        if (guess <= 0) {
            System.out.println("Sorry,you have lost the game :(" + score);
            System.out.println("The word was :" + secretWords);
        }
        return score;
        }
}

public class hang {
    public  void main(final String[] args) {
        // int score;
        gameHangMan hangMan = new gameHangMan();
        final int m = 4;
        ArrayList<Player> playerList = new ArrayList<Player>();
        for (int i = 0; i < m; i++) {
            System.out.println("Enter player name");
            Scanner in = new Scanner(System.in);
            String player = in.nextLine();
            Player play = new Player(player);
            // play.add(new Player(player));
            System.out.println(
                "Press 1 for easy, 2 for medium, 3 for hard, 4 for default");
            Scanner input = new Scanner(System.in);
            int level = input.nextInt();
            play.setLevel(level);
            String secretWords = hangMan.chooseWord(level);
            int score = hangMan.startHangMan(secretWords.toLowerCase());
            play.setScore(score);
            System.out.println(play.getScore());
            System.out.println("Playername: " + play.getPlayerName()
            + "score is :"
            + play.getScore());
            playerList.add(play);
        }
        Collections.sort(playerList);
        System.out.println("============= LEADERBOARD =============");
        System.out.println("\t" + "Player" +  "\t" + "\t"
        + "Score" + "\t" + "\t" + "Level");
        for (int i = 0; i < playerList.size(); i++) {
            System.out.println("\t" + playerList.get(i).getPlayerName()
            + "\t" + "\t"
            + playerList.get(i).getScore() + "\t" + "\t"
            + playerList.get(i).getLevel());
        }
        System.out.println("=======================================");
    }
   }
 }

