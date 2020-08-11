//Everything that is in curlybraces is considered as one scope

public class Car
{                                                       //Begin Car scope

    String color;                                       //Instance variable in Car scope
    String model;                                       //Instance variable in Car scope
    int vin;                                            //Instance variable in Car scope
    static int count;                                   //Static variable in Car class scope

    static {
        setCarCount(5);                                  //Legal
//        printDescription(5);                             //Illegal
    }

    public static void setCarCount(int c) {
        count = c;
    }

    Car(String c, String m) {                           //Begin constructor scope
        color = c;                                      //'c' is a Local variable
        model = m;                                      //'m' is a Local variable
        count++;                                        //
        vin = count;                                    //
    }                                                   //Begin constructor scope

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
}                                                           //End car scope