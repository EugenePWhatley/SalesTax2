package sales_tax;

/**
 * Created by Eugene on 5/13/2015.
 */
public class Product {

    private int quantity;
    private String name;
    private double tax;
    private double totalPrice;

    public Product(int quantity, String name, double tax, double totalPrice) {
        this.quantity = quantity;
        this.name = name;
        this.tax = tax;
        this.totalPrice = totalPrice;
    }

    public void receiptDetails(){
        System.out.printf("%d %s: %.2f\n", quantity, name, totalPrice);
    }

    public double price() {
        return totalPrice;
    }

    public double tax() {
        return tax;
    }
}
