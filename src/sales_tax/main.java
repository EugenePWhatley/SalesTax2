package sales_tax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugene on 5/13/2015.
 */
public class main {

    public static void main(String[] args) throws IOException {
        String[] testFiles ={"testOne.txt","testTwo.txt","testThree.txt"};
        for(int i = 0; i < testFiles.length; i++) {
            System.out.println(testFiles[i]);
            List<String> lines = readLines(testFiles[i]);
            List<Product> products = parseProducts(lines);
            printReceipt(products);
            System.out.println();
        }
    }

    private static void printReceipt(List<Product> products) {
        double totalPrice = 0.0;
        double totalTax = 0.0;
        System.out.println("Shelf details:");
        for(Product product: products){
            product.shelfDetails();
        }
        System.out.println("\nReceipt Details:");
        for(Product product: products){
            product.receiptDetails();
            totalPrice+=product.price();
            totalTax+=product.tax();
        }
        System.out.printf("Sales Tax: %.2f\n", totalTax);
        System.out.printf("Total Cost: %.2f\n", totalPrice);
    }

    private static List<Product> parseProducts(List<String> lines) {
        int quantity = 0;
        double price = 0.0;
        List<Product> products = new ArrayList<>();
        for(String line: lines){
            String name = "";
            String[] tokens = line.split(" ");
            quantity = Integer.parseInt(tokens[0]);
            int i = 1;
            while(!tokens[i].equals("at")) {
                name += tokens[i] + " ";
                i++;
            }
            price = Double.parseDouble(tokens[tokens.length-1]);
            products.add(new Product(quantity,name,price));
        }
        return products;
    }

    private static List<String> readLines(String testFile) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(testFile));
        String line = bufferedReader.readLine();
        while(line != null){
            lines.add(line);
            line = bufferedReader.readLine();
        }
        return lines;
    }
}
