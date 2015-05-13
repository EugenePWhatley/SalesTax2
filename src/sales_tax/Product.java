package sales_tax;

/**
 * Created by Eugene on 5/13/2015.
 */
public class Product {
    private double totalPrice;
    private double tax;
    private int quantity;
    private String name;
    private double unitPrice;
    private boolean taxable = true;
    private boolean imported = false;

    public Product(int quantity, String name, double unitPrice) {
        this.quantity = quantity;
        this.name = name;
        this.unitPrice = unitPrice;
        setProductType(name);
        setTax();
        totalPrice = roundToNearestPenny(tax+unitPrice*quantity);
    }

    private void setTax(){
        double tax;
        if(imported) {
            if(taxable){
                tax = unitPrice*.15;
            } else {
                tax = unitPrice*.05;
            }
        } else {
            if(taxable){
                tax = unitPrice*0.1;
            } else {
                tax = 0.0;
            }
        }
        this.tax = roundToNearestPenny(tax);
    }

    private void setProductType(String name) {
        if(name.contains("imported")){
            imported=true;
        }
        if(name.contains("chocolate")||name.contains("book")||name.contains("pills")){
            taxable=false;
        }
    }

    private double roundToNearestPenny(double n) {
        n = n*100;
        n = Math.round(n);
        n = n/100;
        return n;
    }

    public void shelfDetails() {
        System.out.printf("%d %s: %.2f\n", quantity, name, unitPrice);
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
