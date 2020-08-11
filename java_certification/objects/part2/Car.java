public class Car {

    String color;
    String type;

    void start() {
        System.out.println("Get started!");
    }

    void printDescription() {
        System.out.println("This is a " + color + " " + type);
    }

    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.printDescription();
    }
}