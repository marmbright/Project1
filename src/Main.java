import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static int partCount;

    /**
     * Tester class for BikePart.java
     */
    public static void main(String[] args) {
        Scanner uInput = new Scanner(System.in);

        System.out.println("Enter the number of parts you will be inputting");
        partCount = uInput.nextInt();

        BikePart[] bpArray = new BikePart[partCount];

        String tempPartName;
        int tempPartNum;
        double tempListPrice;
        double tempSalePrice;
        boolean tempOnSale;

        for (int i = 0; i < partCount; i++) {
            String[] tempLine = new String[5];
            System.out.println("Enter the next part...");
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
            }
            else if(!bpArray[i].getOnSale()){
                if(bpArray[i].getListPrice() < 20.0){
                    partUnder20.add((bpArray[i]));
                }
            }
        }

        System.out.println();
        System.out.println("Output:");
        for (int i = 0; i < partUnder20.size(); i++) {
            System.out.println(partUnder20.get(i).toString());
        }
    }
}
