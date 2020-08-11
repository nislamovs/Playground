/**
 *
 * This class creates some kind of order, nevermind...
 *
 * @author Nu kto esli ne mi
 *
 */
public class Order {

    /**
     * Order date (month/day/year)
     */
    MyDate orderDate;
    /**
     * Total price
     */
    double orderAmount = 0.00;
    /**
     * Customer data
     */
    String customer;
    /**
     * Product data
     */
    String product;
    /**
     * Product qquantity
     */
    int quantity;

    /**
     *
     * This creates a new order
     * @param d - Order date
     * @param amt - Total price
     * @param c - Customer data
     * @param p - Product data
     * @param q - quantity
     */

    public Order(MyDate d, double amt, String c, String p, int q){
        orderDate=d;
        orderAmount=amt;
        customer=c;
        product=p;
        quantity=q;
    }

    /**
     * Provides report message about order.
     * @return message about order.
     */

    public String toString(){
        return quantity + " ea. " + product + " for " + customer;
    }
}