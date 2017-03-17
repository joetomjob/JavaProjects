import java.util.Random;
import java.util.Scanner;
/**
 * Created by Rao on 9/15/2016.
 */
public class BattleShipSample {

    // Instances of the class Board represent
// possible states of a player’s board.
    public class Board {
        // member variables: number of rows,
// number of columns, number of battleships
// and the board itself
// Block A
// Constructor: takes a number of rows and
// a number of columns and creates an empty
// board (a zero at each location)
        public Board(int rows, int cols) {
// Block B
        }

        // check if there is a battleship at the
// given location (row, col). If yes,
// returns true and decrements the number
// of remaining ships. Otherwise return false.
        public boolean isHit(int row, int col) {
// Block C
            return true;
        }

        // default board: randomly distribute nrShips
// ships on the board. Attention: do not
// put more than one ship at any location!
// Do not forget to initialize the class
// member variable nrShips.
        public void initBoard(int nrShips) {
// Block D
        }

        // check if the game has been lost, i.e.
// there are no ships left.
        public boolean checkLost() {
// Block E
            return true;
        }
    }

    //-----------------------
    // Class Game uses two instances of the class Board
// to create a game between two players.
    public class Game {
        // member variable: an array of two boards
// Block F
// Constructor: create the two boards with the
// given number of rows and columns, then
// randomly distribute nrShips on each of them.
        public Game(int rows, int cols, int nrShips) {
            for (int i = 0; i < 2; i++) {
// Block G
            }
        }

        // Play the game. Each player enters a move in turn,
// until all the ships of one of the players are hit.
        public void play() {
            int turn = 0; // player 0 starts
            int next = 1; // player 1 is next
            Scanner in = new Scanner(System.in);
            boolean finished = false;
            do {
// get a row number and a column number from
// the player, using the scanner in.
// Block H
// check to see if the move is a hit. Use the
// isHit method from the class Board, with the
// row and column numbers read from the player.
// Print "It’s a hit!" or "No luck...", as
// appropriate
// Block I
// check to see if the move has finished the game.
// Use the checkLost method of the class Board.
// Block J
// change the turn, so that the next player
// has the move (or, if the game has finished,
// turn will point to the loser). Swap the
// values of the variables turn and next
// Block K
            } while (!finished);
            System.out.println("Player " + turn + " has lost!");
            System.out.println("Congrats, player " + next + "!");
        }

    }
}
