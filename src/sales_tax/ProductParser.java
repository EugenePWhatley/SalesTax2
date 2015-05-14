package sales_tax;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Eugene on 5/14/2015.
 */
public class ProductParser {
    public List<Product> parseProducts(List<String> lines) {
        List<Product> products = new ArrayList<>();
        for(String line: lines){
            String name = "";
            String[] tokens = line.split(" ");
            int quantity = Integer.parseInt(tokens[0]);
            int i = 1;
            while(!tokens[i].equals("at")) {
                name += tokens[i] + " ";
                i++;
            }
            double price = Double.parseDouble(tokens[tokens.length-1]);
            products.add(new ProductFactory().create(quantity, name, price));
        }
        return products;
    }
}
