package sales_tax;

/**
 * Created by Eugene on 5/14/2015.
 */
public class ProductFactory {
    public Product create(int quantity, String name, double preTaxPrice){
        double tax = new TaxComputer().computeTax(name, preTaxPrice);
        double totalPrice = preTaxPrice+tax;
        return new Product(quantity,name,tax,totalPrice);
    }
}

