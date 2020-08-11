public class Car {

    private String color = "default";
    private String model = "default";
    private int vin;
    static int count;

    static {
        setCarCount(5);                                  //Legal
//        printDescription(5);                             //Illegal
    }

    public static void setCarCount(int c) {
        count = c;
    }

    Car(String color, String model, int vin) {
        color = color;                                   //without using this keyword nothing will happen
        model = model;                                  //program will try to change method param values
        vin = vin;
        count++;


        model = "asdasd";                               //same
    }

    void printDescription() {
        System.out.println("this is " + color + " " + model);
    }

    public String toString() {
        return "Color: " + color + ", model: " + model + ", vin: " + String.valueOf(vin) + ", total number: " +  String.valueOf(count);
    }

    public static void main(String[] args) {

        Car car = new Car("blue", "bmw", 123);
        Car car1 = new Car("blue", "bmw", 123);
        Car car2 = new Car("blue", "bmw", 123);
        System.out.println(car.toString());
    }
}