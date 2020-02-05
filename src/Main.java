import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    /**
     * Tester class for BikePart.java
     */
    public static void main(String[] args) throws FileNotFoundException {
        String filename = "BikeParts.txt";
        File file = new File(filename);
        Scanner uInput = new Scanner(file);
        uInput.useDelimiter("\\Z");
        System.out.println(uInput.next());

        BikePart[] bpArray = new BikePart[(int) file.length()];
        bpArray.toString();
        System.out.println(Arrays.toString(bpArray));

        String tempPartName;
        int tempPartNum;
        double tempListPrice;
        double tempSalePrice;
        boolean tempOnSale;
/*
        for (int i = 0; i < bpArray.length; i++) {
            String[] tempLine = new String[5];
            tempLine = uInput.next().split(",");

            tempPartName = tempLine[0];
            tempPartNum = Integer.parseInt(tempLine[1]);
            tempListPrice = Double.parseDouble(tempLine[2]);
            tempSalePrice = Double.parseDouble(tempLine[3]);
            tempOnSale = Boolean.parseBoolean(tempLine[4]);

            BikePart tempPart = new BikePart(tempPartName, tempPartNum, tempListPrice, tempSalePrice, tempOnSale);
            bpArray[i] = tempPart;
        }



        ArrayList<BikePart> partUnder20 = new ArrayList();
        for (int i = 0; i < bpArray.length; i++) {
            if (bpArray[i].getOnSale()) {
                if (bpArray[i].getSalePrice() < 20.0) {
                    partUnder20.add(bpArray[i]);
                } else if (bpArray[i].getListPrice() < 20.0) {
                    partUnder20.add(bpArray[i]);
                }
            } else if (!bpArray[i].getOnSale()) {
                if (bpArray[i].getListPrice() < 20.0) {
                    partUnder20.add((bpArray[i]));
                }
            }
        }

        System.out.println();
        System.out.println("Output:");
        for (int i = 0; i < partUnder20.size(); i++) {
            System.out.println(partUnder20.get(i).toString());
*/

        }
    }
