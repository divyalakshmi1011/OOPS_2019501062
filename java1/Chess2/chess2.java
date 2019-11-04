/**Creating a class for chess game
 * Chess board has 8 rows and 8 columns
 * Predicting valid moves for Queen piece in chess
 */
class Game {
    //Creating a class for chess board
    //@param board
    Piece [][] board;
    // Constructor creates an empty board
    Game() {
    board = new Piece[8][8];
    }
}
class Position {
    /**Calculating the position of a particular piece
     * @param row
     * @param column
     */
    int row;
    int column;
    // Constructor using row and column values
    Position(int row, int column) {
    this.row = row;
    this.column = column;
   }
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
}
class Piece {
    /**Speecifying whether the position of
     * a piece is valid or not
     * @param position
     */
    Position position;
    Piece() {
    //    this.position = position;
    }
    boolean isValidMove(Position newPosition) {
    if(newPosition.row>0 && newPosition.column>0
    && newPosition.row<8 && newPosition.column<8) {
    return true;
    } else {
    return false;
    }
    }
    public void move(Position test) {
        if(isValidMove(test)) {
            this.position = test;
        } 
    }
}

class Queen extends Piece {
    /**Queen is the extension class for piece
     * Specifying the validity of a Queen position when
     * it is moved
     */
    Queen() {
        this.position = new Position(0,3);
    //@Overriding position method
    }
    boolean isValidMove(Position newPosition) {
        if((this.position.row - newPosition.row) == (this.position.column - newPosition.column)) {
            return true;
        }
        else if((this.position.row == newPosition.row) || (this.position.column == newPosition.column)) {
            return true;
        } else {
            return false;
        }
    }
    
}
public class chess2 {
    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.move(new Position(6,3));
        System.out.println("Row");
        System.out.println(queen.position.getRow());
        System.out.println("Column");
        System.out.println(queen.position.getColumn());
        }
    }

