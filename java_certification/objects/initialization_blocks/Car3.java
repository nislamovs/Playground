public class Car3 {

    Car3() {
        System.out.println("Inside constructor!");
        color = "Blue";                              //init fifth
    }
    
    {
        System.out.println("Inside init block!");
        color = "Red";              //init second
    }

    String color = "Green";         //init first as null
                                    //init third as "Greem"
    String type;

    {
        System.out.println("Inside init block 2 !");
        color = "Purple";              //init fourth
    }

    

    Car3(String clr) {
        color = clr;                                //init fifth
    }

    Car3(String clr, String t) {
        color = clr;                                //init fifth
        type = t;                                   //init fifth
    }

    void start() {
        System.out.println("Get started!");
    }

    void printDescription() {
        System.out.println("This is a " + color + " " + type);
    }

    public static void main(String[] args) {
        Car3 myCar = new Car3();
        myCar.printDescription();
    }
}