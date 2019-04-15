package lesson6.HomeWork.TicTacToe;

import java.util.Scanner;

public class PlayerTurn {

    Scanner scan = new Scanner(System.in);

    public byte GameTypeInput (){
        System.out.println("Please choose type of the game:");
        System.out.println("1: Computer vs Computer");
        System.out.println("2: Player VS Computer");
        System.out.println("3: Player VS Player");
        byte userInput;
        do {
            System.out.println("Choose number: ");
            userInput = scan.nextByte();
        }
        while (userInput <= 0 || userInput > 3);
        return userInput;
    }

    public byte playerInput() {
        byte playersTurn;
        do {
            System.out.println("Choose number: ");
            playersTurn = scan.nextByte();
        }
        while (playersTurn <= 0 || playersTurn > 9);
        return playersTurn;
    }

    public void fillGameBard(boolean zeroOrCross, byte[][] boardArr, byte collIndex, byte RowIndex) {
        byte pointer = 2;
        if (zeroOrCross) {
            pointer = 1;
        }
        boardArr[RowIndex][collIndex] = pointer;
    }

    public byte winConditionHorizontal(byte[][] boardArr) {
        byte winLogic = 0;
        for (byte j = 1; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                if (boardArr[i][0] == j && boardArr[i][1] == j && boardArr[i][2] == j) {
                    winLogic = j;
                }
            }
        }
        return winLogic;
    }

    public byte winConditionVertical(byte[][] boardArr) {
        byte winLogic = 0;
        for (byte j = 1; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                if (boardArr[0][i] == j && boardArr[1][i] == j && boardArr[2][i] == j) {
                    winLogic = j;
                }
            }
        }
        return winLogic;
    }
    public byte winConditionAcross(byte[][] boardArr) {
        byte winLogic = 0;
        for (byte i = 1; i < 3; i++)
        {
            if (boardArr[0][0] == i && boardArr[1][1] == i && boardArr[2][2] == i) {
                winLogic = i;
            }
            if (boardArr[0][2] == i && boardArr[1][1] == i && boardArr[2][0] == i) {
                winLogic = i;
            }

        }
        return winLogic;
    }
}
