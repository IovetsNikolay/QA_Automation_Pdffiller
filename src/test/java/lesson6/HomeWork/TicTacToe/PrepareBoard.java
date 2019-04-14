package lesson6.HomeWork.TicTacToe;

public class PrepareBoard {

    public byte [][] boardPrepear () {
        byte[][] board = new byte[3][3];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                board[i][j] = 0;
            }
        }
        return board;
    }
}
