package lesson6.HomeWork.TicTacToe;

public class TransformToArrayIndex {

    byte collIndex;
    byte rowIndex;

    TransformToArrayIndex(byte userInput) {
        switch (userInput) {
            case 1:
                //collIndex = 0;
                //rowIndex = 0;
                break;
            case 2:
                //collIndex = 0;
                rowIndex = 1;
                break;
            case 3:
                //collIndex = 0;
                rowIndex = 2;
                break;
            case 4:
                collIndex = 1;
                //rowIndex = 0;
                break;
            case 5:
                collIndex = 1;
                rowIndex = 1;
                break;
            case 6:
                collIndex = 1;
                rowIndex = 2;
                break;
            case 7:
                collIndex = 2;
                //rowIndex = 0;
                break;
            case 8:
                collIndex = 2;
                rowIndex = 1;
                break;
            case 9:
                collIndex = 2;
                rowIndex = 2;
                break;
            default:
                System.out.println("Error!!");
        }

    }

    public byte getCollIndex() {
        return collIndex;
    }

    public byte getRowIndex() {
        return rowIndex;
    }

    public boolean checkExisting(byte[][] arr) {
        boolean isNumberExist = false;
        if (arr[collIndex][rowIndex] != 0) {
            isNumberExist = true;
        }
        return isNumberExist;
    }

}
