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
        this.color = color;
        this.model = model;
        this.vin = vin;
        count++;
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