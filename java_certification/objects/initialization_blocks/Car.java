public class Car {

    String color = "Green";         //init first
    String type;

    {
        System.out.println("Inside init block!");
        color = "Red";              //init second
    }

    Car() {
        color = "Blue";             //init third
    }

    Car(String clr) {
        color = clr;                //init third
    }

    Car(String clr, String t) {
        color = clr;                //init third
        type = t;                //init third
    }

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