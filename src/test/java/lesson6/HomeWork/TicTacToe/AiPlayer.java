package lesson6.HomeWork.TicTacToe;

import java.util.Random;

public class AiPlayer {

    Random rand = new Random();

    public byte simpleAiTurnGenerate () {
        return (byte)(rand.nextInt(9)+1);
    }

}

