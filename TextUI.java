import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class works with terminal, including input and output of text
 * @author Lucas Weber
 * @version 1.0
 */
public class TextUI{
    private Scanner input = new Scanner(System.in);

    /**
     * Displays the board
     * @param board current state of board
     */
    public void displayBoard(ArrayList<ArrayList<Integer>> board) {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).size(); j++) {
                System.out.print(board.get(i).get(j) + " ");
            }
            System.out.print("\n");
        }
    }

    /**
     * Displays whos turn it is
     * @param turn which player turn it is
     */
    public void displayTurn(int turn) {
        System.out.print("Player " + turn + "s Turn!\n");
    }

    /**
     * Displays the winning player
     * @param turn which player turn it is
     */
    public void displayWinner(int turn) {
        System.out.print("Player " + turn + " Won!\n");
    }

    /**
     * Gets column as user input
     * @return valid user inputted column
     */
    public int getColumn() {
        int col;
        System.out.print("Column: ");
        col = input.nextInt();
        while (!(col >= 0) || !(col <= 6)) {
            System.out.print("Column: ");
            col = input.nextInt();
        }
        return col;
    }
}