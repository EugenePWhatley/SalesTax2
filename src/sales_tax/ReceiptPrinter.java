package sales_tax;

import java.util.List;

/**
 * Created by Eugene on 5/14/2015.
 */
public class ReceiptPrinter {
    public void printReceipt(List<Product> products) {
        System.out.println("\nReceipt Details:");
        for(Product product: products){
            product.receiptDetails();
        }
        System.out.printf("Sales Tax: %.2f\n", totalTax(products));
        System.out.printf("Total Cost: %.2f\n", totalPrice(products));
    }

    private double totalPrice(List<Product> products) {
        double totalPrice=0.0;
        for (Product product : products) {
            totalPrice+=product.price();
        }
        return totalPrice;
    }

    private double totalTax(List<Product> products) {
        double totalTax=0.0;
        for (Product product : products) {
            totalTax+=product.tax();
        }
        return totalTax;
    }
}
