package sales_tax;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugene on 5/14/2015.
 */
public class FileRead {
    public static List<String> readLines(String testFile) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(testFile));
        String line = bufferedReader.readLine();
        while(line != null){
            lines.add(line);
            line = bufferedReader.readLine();
        }
        return lines;
    }
}
