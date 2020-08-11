public class Car {

    String color = "default";
    String model = "default";
    int vin;
    static int count;

    Car() {
        count++;
        vin = count;
    }

    Car(String color, String model, int vin) {
        this();                                                         //calling constructor
//        count++;                                                      //this() constructor calling should be called first
//        vin = count;
        this.color = color;
        //this();                                                         //illegal usage - should be called first
        this.model = model;
    }

    void printDescription() {
        //this();                                                         //illegal usage - cannot be called from method
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