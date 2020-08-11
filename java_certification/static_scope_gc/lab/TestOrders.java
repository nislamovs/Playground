class MyDate {
    int day;
    int month;
    int year;

    MyDate(int m, int d, int y) {
        day = d;
        month = m;
        year = y;
    }
}

class Order {
    MyDate orderDate;
    double orderAmount = 0.00;
    String customer;
    String product;
    int quantity;

    static double taxRate;
    static {
         taxRate = 0.05;
    }

    public static void setTaxRate(double newRate) {taxRate = newRate;}

    public static void computeTaxOn(double anAmount) {
        System.out.println("The tax for " + anAmount + " is: " + anAmount * Order.taxRate);
    }

    public double computeTax() {
        System.out.println("The tax for this order is: " + orderAmount * Order.taxRate);
        return orderAmount * Order.taxRate;
    }

    public Order(MyDate d, double amt, String c, String p, int q){
        this.orderDate=d;
        this.orderAmount=amt;
        this.customer=c;
        this.product=p;
        this.quantity=q;
    }

    public String toString(){
        return quantity + " ea. " + product + " for " + customer;
    }
}

public class TestOrders {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MyDate date1 = new MyDate(1,20,2008);
        Order anvil = new Order(date1, 2000.00, "Wile E Coyote", "Anvil", 10);

        MyDate date2 = new MyDate(4,10,2008);
        Order balloons = new Order(date2, 1000.00, "Bugs Bunny", "Balloon", 125);

        System.out.println(anvil);
        System.out.println(balloons);


        System.out.println("The tax Rate is currently: " + Order.taxRate);
        Order.computeTaxOn(3000.00);
        anvil.computeTax();
        balloons.computeTax();
        Order.setTaxRate(0.06);
        System.out.println("The tax Rate is currently: " + Order.taxRate);
        Order.computeTaxOn(3000.00);
        anvil.computeTax();
        balloons.computeTax();

    }

}