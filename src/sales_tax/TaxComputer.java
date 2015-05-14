package sales_tax;

/**
 * Created by Eugene on 5/14/2015.
 */
public class TaxComputer {
    public double computeTax(String name, double preTaxPrice){
        double importTax = 0.0;
        double salesTax = 0.0;
        if(isImported(name)) {
            importTax = 0.05;
        }
        if(isTaxable(name)){
            salesTax = 0.1;
        }
        return roundToNearestPenny(preTaxPrice*(salesTax+importTax));
    }

    private boolean isTaxable(String name) {
        return !(name.contains("chocolate")||name.contains("book")||name.contains("pills"));
    }

    private boolean isImported(String name) {
        return name.contains("imported");
    }

    private double roundToNearestPenny(double n) {
        n = n*100;
        n = Math.round(n);
        n = n/100;
        return n;
    }

}
