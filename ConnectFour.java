public class ConnectFour{

    public static void main(String[] args) {
        Board boardVar;
        TextUI textUIVar;
        boolean game = true;
        int turn = 1;
        
        boardVar = new Board();
        textUIVar = new TextUI();

        while (game) {
            // displays board and players turn
            textUIVar.displayBoard(boardVar.getBoard());
            textUIVar.displayTurn(turn);

            // loops until a valid 
            while (true) {
                if (boardVar.setBoard(turn, textUIVar.getColumn())) {
                    break;
                }
            }

            // checks if game has been won
            if (boardVar.win(turn)) {
                textUIVar.displayBoard(boardVar.getBoard());
                textUIVar.displayWinner(turn);
                break;
            }

            if (!boardVar.validBoard()) {
                textUIVar.displayBoard(boardVar.getBoard());
                textUIVar.displayWinner(3);
                break;
            }
            
            // changes players turn
            if (turn == 1) {
                turn = 2;
            } else {
                turn = 1;
            }
        }
    }
}
