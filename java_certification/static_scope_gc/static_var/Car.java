public class Car {

    private String color;
    private String model;
    private int vin;
    static int count;

    Car(String color, String model, int vin) {
        this.color = color;
        this.model = color;
        this.vin = vin;
        count++;
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