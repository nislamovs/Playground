public class Car2 {

    {
        System.out.println("Inside init block!");
        color = "Red";              //init second
    }

    String color = "Green";         //init first as null
                                    //init third as "Greem"
    String type;



    Car2() {
        color = "Blue";                              //init forth
    }

    Car2(String clr) {
        color = clr;                                //init forth
    }

    Car2(String clr, String t) {
        color = clr;                                //init forth
        type = t;                                   //init forth
    }

    void start() {
        System.out.println("Get started!");
    }

    void printDescription() {
        System.out.println("This is a " + color + " " + type);
    }

    public static void main(String[] args) {
        Car2 myCar = new Car2();
        myCar.printDescription();
    }
}