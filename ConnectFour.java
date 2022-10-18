package connectfour;

public class ConnectFour{

    public static void main(String[] args) {
        Board boardVar;
        TextUI textUIVar;
        boolean game = true;
        int turn = 1;
        
        boardVar = new Board();
        textUIVar = new TextUI();

        while (game) {
            textUIVar.displayBoard(boardVar.getBoard());
            textUIVar.displayTurn(turn);
            while (true) {
                if (boardVar.setBoard(turn, textUIVar.getColumn())) {
                    break;
                }
            }

            if (boardVar.win(turn)) {
                textUIVar.displayBoard(boardVar.getBoard());
                textUIVar.displayWinner(turn);
                break;
            }

            if (turn == 1) {
                turn = 2;
            } else {
                turn = 1;
            }
        }
    }
}