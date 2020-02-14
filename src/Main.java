/*
Megan Armbright
Section 1
I hereby declare upon my word of honor that I have neither given nor received unauthorized help on this work.
 */
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    /**
     * Tester class for BikePart.java
     */
    public static void main(String[] args) throws IOException {
        String filename = "BikeParts.txt";
        File file = new File(filename);
        Scanner uInput = new Scanner(file);

        ArrayList<String> bpArray = new ArrayList<>();
        while (uInput.hasNext()) {
            String line = uInput.nextLine();
            bpArray.addAll(Arrays.asList(line.split(" ")));
        }

        String tempPartName;
        String tempPartNum;
        String tempListPrice;
        String tempSalePrice;
        String tempOnSale;

        for (String tempLine : bpArray) {

            tempPartName = tempLine;
            tempPartNum = tempLine;
            tempListPrice = tempLine;
            tempSalePrice = tempLine;
            tempOnSale = tempLine;

            ArrayList<String> bikeParts = new ArrayList<>();
            bikeParts.add(tempPartName);
            bikeParts.add(tempPartNum);
            bikeParts.add(tempListPrice);
            bikeParts.add(tempSalePrice);
            bikeParts.add(tempOnSale);

        }

        ArrayList<ArrayList<String>> partUnder25 = new ArrayList<>();
        while (bpArray.contains('2')) partUnder25.add(bpArray);
        try (PrintWriter writer = new PrintWriter("PartUnder25.txt", StandardCharsets.UTF_8)) {
            for (String bp : bpArray)
                writer.println(bp);
        }
    }
}