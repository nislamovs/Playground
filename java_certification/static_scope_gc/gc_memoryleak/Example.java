public class Example {

    static Car myCar;
    static void doSomething(Car car) {
        myCar = car;
        System.out.println("Color is " + myCar.color);
        myCar = null;
    }
}