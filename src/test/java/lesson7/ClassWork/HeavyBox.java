package lesson7.ClassWork;

public class HeavyBox extends Box {

    int weight;
    HeavyBox (double width, double height, double depth, int weight) {
        super(width, height, depth);
        this.weight = weight;
    }

        @Override
    public void printInfo () {
        System.out.println("Обьем коробки" + getVolume());

    }
}
