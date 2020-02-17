import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Tester class for Warehouse and BikeParts
 */
public class Test {

    /**
     * Main method for the tester class
     * @throws IOException throws exception
     */
    public static void main(String[] args) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            ArrayList<BikePart> list = new ArrayList<>();

            //File yourFile = new File("warehouseDB.txt");
            //yourFile.createNewFile(); // if file already exists will do nothing
            //FileOutputStream oFile = new FileOutputStream(yourFile, false);

            toBikeArray("warehouseDB.txt", list);
            //clearTheFile();
            // System.out.println(list.get(1).quantity);

            boolean quitFlag = false;
            while (!quitFlag) {
                System.out.println("What would you like to do?: \nRead File | Enter BikePart | Sell BikePart\n" +
                        "Display BikePart | Sort By Name | Sort By Number\n" +
                        "Quit");
                String user_input = in.nextLine();


                if (user_input.equals("Quit")) {
                    quitFlag = true;
                    PrintWriter out = new PrintWriter("warehouseDB.txt");
                    for (int i = 0; i < list.size(); i++) {
                        BikePart temp = list.get(i);
                        out.println(temp.partName + "," +
                                    temp.partNumber + "," +
                                    temp.price + "," +
                                    temp.salesPrice + "," +
                                    temp.onSale + "," +
                                    temp.quantity);
                    }
                    out.close();
                    System.out.println("warehouseDB.txt file successfully processed");


                } else if (user_input.equals("Read File")) {
                    boolean readFileFlag = false;
                    while (!readFileFlag) {
                        System.out.println("Please enter your inventory file name: ");

                        String invFileName = in.nextLine();

                        //ArrayList<BikePart> temp = new ArrayList<BikePart>();

                        toBikeArray(invFileName, list);

                        System.out.println(invFileName + " successfully processed");

                        readFileFlag = true;

                        //test that it works
                        /*for (int i = 0; i < list.size(); i++){
                            System.out.println(list.get(i).quantity);
                        }

                         */

                    }


                } else if (user_input.equals("Enter BikePart")) {
                    boolean enterBikePartFlag = false;
                    while (!enterBikePartFlag) {
                        System.out.println("Please enter your bike part's attributes: ");

                        System.out.println("Name: ");
                        String enterName = in.nextLine();
                        System.out.println("Number: ");
                        String enterNumber = in.nextLine();
                        System.out.println("Price: ");
                        double enterPrice = in.nextDouble();
                        System.out.println("Sales Price: ");
                        double enterSalesPrice = in.nextDouble();
                        System.out.println("Is it on sale? (Enter 'true' or 'false'): ");
                        boolean enterOnSale = in.nextBoolean();
                        System.out.println("Quantity: ");
                        int enterQuantity = in.nextInt();

                        BikePart tempPart = new BikePart(enterName, enterNumber, enterPrice, enterSalesPrice, enterOnSale, enterQuantity);

                        boolean exists = false;
                        for (int i = 0; i < list.size(); i++) {
                            BikePart temp = list.get(i);
                            if (temp.partNumber.equals(tempPart.partNumber)) {
                                temp.quantity += tempPart.quantity;
                                temp.price = tempPart.price;
                                temp.salesPrice = tempPart.salesPrice;
                                temp.onSale = tempPart.onSale;
                                temp.partName = tempPart.partName;
                                list.set(i, temp);
                                exists = true;
                            }
                        }
                        if (!exists) {
                            list.add(tempPart);
                            System.out.println("BikePart successfully added");
                            exists = true;
                        }

                        enterBikePartFlag = true;
                        System.out.println();
                        in.nextLine();
                    }


                } else if (user_input.equals("Sell BikePart")) {
                    boolean sellBikePartFlag = false;
                    while (!sellBikePartFlag) {
                        System.out.println("Please enter bike part number: ");
                        String enterNumber = in.nextLine();

                        System.out.println("Please enter the amount to sell: ");
                        int enterSellQuantity = in.nextInt();

                        for (int i = 0; i < list.size(); i++) {
                            BikePart temp = list.get(i);

                            if (temp.partNumber.equals(enterNumber)) {

                            /*if ((temp.quantity - enterSellQuantity) < 0) {
                                System.out.println("Error: can't sell more bike parts than there are available.\n" +
                                        "Number available: " + temp.quantity);
                            } else {
                                temp.quantity -= enterSellQuantity;
                            }
                             */
                                if (temp.onSale) {
                                    System.out.println(temp.partName + "," +
                                            temp.salesPrice);
                                } else {
                                    System.out.println(temp.partName + "," +
                                            temp.price);
                                }

                                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                                Date date = new Date();
                                System.out.println(formatter.format(date));
                                temp.quantity -= enterSellQuantity;

                                sellBikePartFlag = true;
                            }
                        }
                        if (!sellBikePartFlag) {
                            System.out.println("Bike part does not exist.");
                            sellBikePartFlag = true;
                        }
                        in.nextLine();
                    }




                } else if (user_input.equals("Display BikePart")) {
                    System.out.println("Please enter bike part name: ");
                    String enterName = in.nextLine();

                    for (int i = 0; i < list.size(); i++) {
                        BikePart temp = list.get(i);

                        //System.out.println(temp.partName.equals(enterName));
                        if (temp.partName.equals(enterName)) { ;
                            if (temp.onSale) {
                                System.out.println("Part name: " + temp.partName + "\n" +
                                        "Current price: " + temp.salesPrice);
                            } else {
                                System.out.println("Part name: " + temp.partName + "\n" +
                                        "Current price: " + temp.price);
                            }
                        }
                    }

                } else if (user_input.equals("Sort By Name")) {
                    sortName(list);
                } else if (user_input.equals("Sort By Number")) {
                    sortNum(list);
                } else{
                    System.out.println("Please enter a valid command");
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File given isn't found.");
        } catch (IllegalArgumentException E) {
            System.out.println("The attribute you entered is in an incorrect format.");
        }
    }

    /**
     * Creates a bike part from input
     * @param item String formatted with commas
     * @return bike part
     */
    private static BikePart toBikeParts(String item) {
        BikePart newPart = new BikePart("0", "0", 0, 0, false, 0);
        String[] itemInfo = item.split(",");
        newPart.partName = itemInfo[0];
        newPart.partNumber = itemInfo[1];
        newPart.price = Double.parseDouble(itemInfo[2]);
        newPart.salesPrice = Double.parseDouble(itemInfo[3]);
        newPart.onSale = Boolean.parseBoolean(itemInfo[4]);
        newPart.quantity = Integer.parseInt(itemInfo[5]);
        return newPart;
    }

    /**
     * Creates array from toBikePart
     * @param fileName reads from file
     * @param bikeparts ArrayList
     * @throws FileNotFoundException throws exception
     */
    private static void toBikeArray(String fileName, ArrayList<BikePart> bikeparts) throws FileNotFoundException {
        File fileIn = new File(fileName);
        Scanner input = new Scanner(fileIn);
        while (input.hasNextLine()) {
            bikeparts.add(toBikeParts(input.nextLine()));
        }
        //Replace with similar code, currently the quantities are getting doubled when read in
            for (int i = 0; i < bikeparts.size() - 1; i++) {
                BikePart temp = bikeparts.get(i);
                for (int j = 1; j < bikeparts.size(); j++) {
                    BikePart temp2 = bikeparts.get(j);
                    if (temp.partNumber.equals(temp2.partNumber)) {
                        temp.quantity = temp.quantity + temp2.quantity;
                        temp.price = temp2.price;
                        temp.salesPrice = temp2.salesPrice;
                        temp.onSale = temp2.onSale;
                        bikeparts.remove(i);
                        bikeparts.set(i, temp);
                    }

                }
            }

    }

    /**
     * Sorts bikeParts by numerical order
     * @param bikeparts ArrayList
     */
    private static void sortNum(ArrayList<BikePart> bikeparts){
        ArrayList<BikePart> temp = bikeparts;
        ArrayList<String> sortNum= new ArrayList<>(  );
        for (int i=0;i<temp.size(); i++){
            sortNum.add(  temp.get( i ).partNumber);
        }

        Collections.sort( sortNum );
        for (int i=0;i<sortNum.size();i++){
            for (int j=0;j<bikeparts.size();j++){
                BikePart tempPart = bikeparts.get( j );
                if (sortNum.get(i).equals( tempPart.partNumber )){
                    System.out.println( tempPart.partName + "," + tempPart.partNumber + "," + tempPart.salesPrice + "," + tempPart.onSale + "," +tempPart.quantity );
                }
            }
        }
    }

    /**
     * Sorts BikeParts by name
     * @param bikeparts ArrayList
     */
    private static void sortName(ArrayList<BikePart> bikeparts){
        ArrayList<BikePart> temp = bikeparts;
        ArrayList<String> sortName= new ArrayList<>(  );
        for (int i=0;i<temp.size(); i++){
            sortName.add(  temp.get( i ).partName);
        }
        System.out.println(sortName.size());

        Collections.sort( sortName );
        for (int i=0;i<sortName.size();i++){
            BikePart tempPart = bikeparts.get( i );
            for (int j=0;j<bikeparts.size();j++){
               // BikePart tempPart = bikeparts.get( i );
                if (sortName.get(j).equals( tempPart.partName )){
                    System.out.println( tempPart.partName + ","   +
                                        tempPart.partNumber + "," +
                                        tempPart.price + "," +
                                        tempPart.salesPrice + "," +
                                        tempPart.onSale + "," +
                                        tempPart.quantity );
                }
            }
        }
    }

    /**
     * Clears the file
     * @throws IOException throws exception
     */
    public static void clearTheFile() throws IOException{
        FileWriter fwOb = new FileWriter("warehouseDB.txt", false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }
}
