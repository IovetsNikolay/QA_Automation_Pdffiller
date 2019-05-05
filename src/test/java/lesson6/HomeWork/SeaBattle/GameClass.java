package lesson6.HomeWork.SeaBattle;

public class GameClass {

    public static void main(String[] args) {
        ConsoleVisualization visual = new ConsoleVisualization();
        while (true) {
            System.out.println(visual.checkUserInput(visual.userInput("try")));
//        visual.prindBoard();
        }

    }

}