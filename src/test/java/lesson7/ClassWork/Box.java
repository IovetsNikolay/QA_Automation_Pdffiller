package lesson7.ClassWork;

public class Box {

    public double width;    //
    public double height;   //
    public double depth;    //

    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public double getVolume() {
        return width * height * depth;
    }

    public void setDim(int w, int h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    public void volume() {
        System.out.print("Oбъeм равен ");
        System.out.println(width * height * depth);
    }

    public void printInfo() {
        System.out.println("Обьем коробки" + getVolume());
    }
}
