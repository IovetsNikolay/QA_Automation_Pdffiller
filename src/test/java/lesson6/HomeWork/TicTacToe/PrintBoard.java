package lesson6.HomeWork.TicTacToe;

public class PrintBoard {

    public void printBoard (byte arr [] []) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[i].length; ++j) {
                if (j < arr.length-1) {
                    System.out.print(" " + transformToChar(arr[i][j]) + " |");
                } else {
                    System.out.print(" " + transformToChar(arr[i][j]));
                }
            }
            System.out.println();
            if (i < arr.length-1) {
                System.out.println("----------");
            }
        }
    }

    public char transformToChar (byte num) {
        char transformedChar;
        switch (num) {
            case 0: transformedChar = ' ';
            break;
            case 1: transformedChar = 'X';
            break;
            case 2: transformedChar = 'O';
            break;
            default: transformedChar = 'E';
        }
        return transformedChar;
    }

}
