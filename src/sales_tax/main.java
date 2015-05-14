package sales_tax;

import java.io.IOException;
import java.util.List;

/**
 * Created by Eugene on 5/13/2015.
 */
public class main {

    public static void main(String[] args) throws IOException {
        String[] testFiles ={"testOne.txt","testTwo.txt","testThree.txt"};
        for(int i = 0; i < testFiles.length; i++) {
            register(testFiles[i]);
        }
    }

    private static void register(String testFile) throws IOException {
        System.out.println(testFile);
        List<String> lines = new FileRead().readLines(testFile);
        List<Product> products = new ProductParser().parseProducts(lines);
        new ReceiptPrinter().printReceipt(products);
        System.out.println();
    }
}
