package lesson6.HomeWork.TicTacToe;

public class GameClass {

    public static void main(String[] args) {
        PrepareBoard prepareBoardboard = new PrepareBoard();
        PrintBoard printBoard = new PrintBoard();
        PlayerTurn playerTurn = new PlayerTurn();
        AiPlayer ai = new AiPlayer();

        System.out.println("Welcome to Tic Tak Toe game!");
        byte gameTypeInput = playerTurn.GameTypeInput();

        System.out.println("Make you turn by entering number:");
        System.out.println(" 1 | 2 | 3 ");
        System.out.println("-----------");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("-----------");
        System.out.println(" 7 | 8 | 9 ");
        System.out.println();

        byte[][] gameBoard = prepareBoardboard.boardPrepear();
        boolean transformCondition;
        byte cellIndex;
        byte rowIndex;
        boolean CrossZeroLogic;
        for (int i = 0; i < (gameBoard.length*gameBoard.length); i++) {
            if ((i%2) != 1) {
                CrossZeroLogic = true;
                System.out.println("Player one turn");
            } else {
                CrossZeroLogic = false;
                System.out.println("Player two turn");
            }
            if (((gameTypeInput == 2) && CrossZeroLogic) || gameTypeInput == 3) {                                                               //Game Mode Logic
                do {
                    TransformToArrayIndex transformTrue = new TransformToArrayIndex(playerTurn.playerInput());
                    transformCondition = transformTrue.checkExisting(gameBoard);
                    rowIndex = transformTrue.getCollIndex();
                    cellIndex = transformTrue.getRowIndex();
                } while (transformCondition);
            } else {
                do {
                    TransformToArrayIndex transformTrue = new TransformToArrayIndex(ai.simpleAiTurnGenerate());
                    transformCondition = transformTrue.checkExisting(gameBoard);
                    rowIndex = transformTrue.getCollIndex();
                    cellIndex = transformTrue.getRowIndex();
                } while (transformCondition);
            }
            playerTurn.fillGameBard(CrossZeroLogic, gameBoard, cellIndex, rowIndex);
            printBoard.printBoard(gameBoard);                                                                           //print game board
            if (playerTurn.winConditionAcross(gameBoard) == 1 || playerTurn.winConditionHorizontal(gameBoard) == 1 || playerTurn.winConditionVertical(gameBoard)== 1) {
                System.out.println("X Player is a winer!!");
                break;
            }
            if (playerTurn.winConditionAcross(gameBoard) == 2 || playerTurn.winConditionHorizontal(gameBoard) == 2 || playerTurn.winConditionVertical(gameBoard)== 2) {
                System.out.println("O Player is a winer!!");
                break;
            }
            if (i == ((gameBoard.length*gameBoard.length)-1)) {                                                         //wining and draw conditions
                System.out.println("Draw!");
            }
        }
    }
}
