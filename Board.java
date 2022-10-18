import java.util.ArrayList;


/**
 * This class works with the board and its subsequent logic
 * @author Lucas Weber
 * @version 1.0
 */
public class Board{
    private ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>();

    /**
     * This is the constructor for the Board class
     */
    public Board() {
        for (int i = 0; i < 6; i++) {
            board.add(new ArrayList<Integer>());
            for (int j = 0; j < 7; j++) {
                board.get(i).add(0);
            }
        }
    }

    /**
     * This is the board accessor
     * @return the board
     */
    public ArrayList<ArrayList<Integer>> getBoard(){
        return board;
    }

    /**
     * This is the board mutator
     * @param turn which player turn it is
     * @param column the chosen column to place piece
     * @return false if column is full and true otherwise
     */
    public boolean setBoard(int turn, int column) {
        if (board.get(0).get(column) != 0) {
            return false;
        }

        for (int i = 0; i < board.size(); i++) {
            if (board.get(i).get(column) != 0) {
                board.get(i-1).set(column, turn);
                return true;
            }
        }
        board.get(5).set(column, turn);


        return true;
    }

    /**
     * This checks if the current player has won
     * @param turn which player turn it is
     * @return true if the player has won and false otherwise
     */
    public boolean win(int turn) {
        // vertical check
        for (int i = 0; i < board.get(0).size(); i++) {
            for (int j = 0; j < board.size()-3; j++) {
                if (board.get(j).get(i) == turn && board.get(j+1).get(i) == turn
                && board.get(j+2).get(i) == turn && board.get(j+3).get(i) == turn) {
                    return true;
                }
            }
        }

        // horizontal check
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(0).size()-3; j++) {
                if (board.get(i).get(j) == turn && board.get(i).get(j+1) == turn
                && board.get(i).get(j+2) == turn && board.get(i).get(j+3) == turn) {
                    return true;
                }
            }
        }

        // acsending diagonal check
        for (int i = 0; i < board.size()-3; i++) {
            for (int j = 0; j < board.get(0).size()-3; j++) {
                if (board.get(i).get(j) == turn && board.get(i+1).get(j+1) == turn
                && board.get(i+2).get(j+2) == turn && board.get(i+3).get(j+3) == turn) {
                    return true;
                }
            }
        }

        // decsending diagonal check
        for (int i = 3; i < board.size(); i++) {
            for (int j = 0; j < board.get(0).size()-3; j++) {
                if (board.get(i).get(j) == turn && board.get(i-1).get(j+1) == turn
                && board.get(i-2).get(j+2) == turn && board.get(i-3).get(j+3) == turn) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * This checks if the board is full or not
     * @return false if the board is full and true otherwise
     */
    public boolean validBoard() {
        for (int i = 0; i < board.get(0).size(); i++) {
            if (board.get(0).get(i) == 0) {
                return true;
            }
        }
        return false;
    }

}
