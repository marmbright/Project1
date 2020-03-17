import java.io.*;
import java.util.ArrayList;
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
            ArrayList<String> fleet = new ArrayList<>();

            toBikeArray("warehouseDB.txt", list);
            toVanArray("Fleet.txt", fleet);

            boolean quitFlag = false;
            while (!quitFlag) {
                System.out.println("What would you like to do?: \nRead File | Enter BikePart | Sell BikePart\n" +
                        "Display BikePart | Sort By Name | Sort By Number\n" +
                        "Quit");
                String user_input = in.nextLine();


                if (user_input.equalsIgnoreCase("Quit")) {
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
                    PrintWriter out2 = new PrintWriter("Fleet.txt");
                    for (int i = 0; i < fleet.size(); i++) {
                        String vanName = fleet.get(i);
                        out2.println(vanName);
                    }
                    out2.close();
                    System.out.println("warehouseDB.txt file successfully processed");


                } else if (user_input.equalsIgnoreCase("Read File")) {
                        System.out.println("Please enter your inventory file name: ");

                        String invFileName = in.nextLine();

                        updateBikeArray(invFileName, list);

                        System.out.println(invFileName + " successfully processed\n");


                } else if (user_input.equalsIgnoreCase("Enter BikePart")) {
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

                    BikePart tempPart = new BikePart(enterName,
                                                     enterNumber,
                                                     enterPrice,
                                                     enterSalesPrice,
                                                     enterOnSale,
                                                     enterQuantity);

                    boolean doesExist = false;
                    for (int i = 0; i < list.size(); i++) {
                        BikePart temp = list.get(i);
                        if (temp.partNumber.equals(tempPart.partNumber)) {
                            temp.quantity += tempPart.quantity;
                            temp.price = tempPart.price;
                            temp.salesPrice = tempPart.salesPrice;
                            temp.onSale = tempPart.onSale;
                            temp.partName = tempPart.partName;
                            list.set(i, temp);
                            doesExist = true;
                        }
                    }
                    if (!doesExist) {
                        list.add(tempPart);
                        doesExist = true;
                    }
                    System.out.println("BikePart successfully added\n");
                    in.nextLine();
                } else if (user_input.equalsIgnoreCase("Sell BikePart")) {
                    System.out.println("Please enter bike part number: ");
                    String enterNumber = in.nextLine();

                    System.out.println("Please enter the amount to sell: ");
                    int enterSellQuantity = in.nextInt();
                    boolean isValidAmount = true;
                    if (enterSellQuantity < 0){
                        System.out.print("Please enter an amount over zero.");
                        isValidAmount = false;
                    }
                    if (isValidAmount) {
                        // Search for BikePart
                        int bikePartID = 0; //This is a placeholder for the when we find the part, if it exits
                        boolean doesExist = false;
                        boolean hasEnoughToSell = false;
                        int currentQuantity = 0;
                        for (int i = 0; i < list.size(); i++) {
                            BikePart temp = list.get(i);

                            if (temp.partNumber.equals(enterNumber)) {
                                doesExist = true;
                                bikePartID = i;
                                currentQuantity = temp.quantity;
                                if (temp.quantity - enterSellQuantity >= 0) {
                                    hasEnoughToSell = true;
                                }
                            }

                        }
                        if (!doesExist) {
                            System.out.println("The bike part you're trying to sell does not exist.");
                        } else {
                            if (!hasEnoughToSell) {
                                System.out.println("Not enough units available to complete the sale." +
                                                    " There is currently " + currentQuantity + " unit(s) in stock.\n");
                            } else {
                                list.get(bikePartID).quantity -= enterSellQuantity;
                                if (list.get(bikePartID).onSale) {
                                    System.out.println(list.get(bikePartID).partName + "," +
                                            list.get(bikePartID).salesPrice);
                                } else {
                                    System.out.println(list.get(bikePartID).partName + "," +
                                            list.get(bikePartID).price);
                                }
                                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                                Date date = new Date();
                                System.out.println(formatter.format(date));
                                System.out.println();
                            }

                        }
                    }
                    in.nextLine();

                } else if (user_input.equalsIgnoreCase("Display BikePart")) {
                    System.out.println("Please enter bike part name: ");
                    String enterName = in.nextLine();

                    for (int i = 0; i < list.size(); i++) {
                        BikePart temp = list.get(i);

                        if (temp.partName.equals(enterName)) {
                            if (temp.onSale) {
                                System.out.println("\nPart name: " + temp.partName + "\n" +
                                        "Current price: " + temp.salesPrice + "\n");
                            } else {
                                System.out.println("\nPart name: " + temp.partName + "\n" +
                                        "Current price: " + temp.price + "\n");
                            }
                        }
                    }

                } else if (user_input.equalsIgnoreCase("Sort By Name")) {
                    sortName(list);
                } else if (user_input.equalsIgnoreCase("Sort By Number")) {
                    sortNum(list);
                } else if (user_input.equalsIgnoreCase("Add Van To Fleet")) {
                    System.out.println("Enter van name: ");
                    ArrayList<BikePart> emptyVanInv = new ArrayList<>();
                    Van vanToAdd = new Van(in.nextLine(), emptyVanInv);
                    System.out.println(fleet);
                    addVanToFleet(vanToAdd,fleet);
                    System.out.println(fleet);
                }else{
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
     * @param warehouseArray ArrayList
     * @throws FileNotFoundException throws exception
     */
    private static void updateBikeArray(String fileName, ArrayList<BikePart> warehouseArray) throws FileNotFoundException {
        // We first have an inventory file that we'll be reading into a BikePart Array
        // This code creates our temporary inventory ArrayList of BikeParts
        File fileIn = new File(fileName);
        Scanner input = new Scanner(fileIn);
        ArrayList<BikePart> invArray = new ArrayList<>();
        while (input.hasNextLine()) {
            invArray.add(toBikeParts(input.nextLine()));
        }
        // We're going to create an array list here that we'll add items to in the future so we can eventually add them to
        // our warehouse. This is done so that we don't add elements in the moment of our query and confuse
        // its idea of how big the warehouse is
        ArrayList<BikePart> elementsToAdd = new ArrayList<>();


        // We then have a BikePart Array from the pre-existing file that can be empty
        boolean isEmpty = false;
        if (warehouseArray.size() == 0){
            isEmpty = true;
        }
        // This is the parameter "warehouseArray" that we're already asking for in this method

        // If there are no elements in the warehouse, we simply add each element in the invArray to the warehouseArray
        if (isEmpty){
            for (int i = 0; i < invArray.size(); i++){
                warehouseArray.add(invArray.get(i));
            }
        } else {
            // If there are elements in the warehouse:
            // We want to compare each item in the inventory BikePart Array to each item in the pre-existing array

            // Select each item in our inventory class that we're comparing with each item in the existing array
            for (int i = 0; i < invArray.size(); i++) {
                //because the first element starts at 0, the last item is at 'n'. So, we should
                //stop looping when we end with index 'n'. We do this by setting our condition
                //to have 'i' be less than the size of the Array which is equal to n+1
                // We set up a temporary bikepart object of the inventory bikepart we're looking at so we can compare it so that of each warehouse bikepart
                BikePart invBikePart = invArray.get(i);
                // We're going to set this boolean so that if this BikePart doesn't already exist, we can just add it later
                boolean doesExist = false;
                for (int j = 0; j < warehouseArray.size(); j++) {
                    // We set up a temporary bikepart object of the warehouse bikepart we're looking at so we can compare it to the inventory bikepart at hand
                    BikePart wareBikePart = warehouseArray.get(j);
                    // We compare the inventory BikePart with the warehouse BikePart
                    if (wareBikePart.partNumber.equals(invBikePart.partNumber)) {
                        doesExist = true;
                        wareBikePart.quantity += invBikePart.quantity;
                        wareBikePart.price = invBikePart.price;
                        wareBikePart.salesPrice = invBikePart.salesPrice;
                        wareBikePart.onSale = invBikePart.onSale;
                    }
                }
                if (!doesExist) {
                    // This is where we add the new BikePart, that we don't want added in the moment,
                    // to the elementsToAdd Array
                    elementsToAdd.add(invBikePart);

                }


            }
        }
        // This is where we add the new BikeParts that we didn't add in the moment
        for (int i = 0; i < elementsToAdd.size(); i++) {
            warehouseArray.add(elementsToAdd.get(i));
        }
    }
    private static void toBikeArray(String fileName, ArrayList<BikePart> bikeparts) throws FileNotFoundException {
        File fileIn = new File(fileName);
        Scanner input = new Scanner(fileIn);
        while (input.hasNextLine()) {
            bikeparts.add(toBikeParts(input.nextLine()));
        }


    }
    private static void toVanArray(String fleetFileName, ArrayList<Van> fleet) throws FileNotFoundException {
        File fileIn = new File(fleetFileName);
        Scanner in = new Scanner(fileIn);
        ArrayList<String> fleetNames = new ArrayList<>();
        while (in.hasNextLine()) {
            fleetNames.add(in.nextLine());
        }
        for (int i = 0; i < fleetNames.size(); i++){
            String vanName = fleetNames.get(i);

            File vanFile = new File(i + ".txt.");
            Scanner input = new Scanner(vanFile);
            ArrayList<BikePart> vanInv = new ArrayList<>();
            vanInv.add(toBikeParts(input.nextLine()));

            Van tempVan = new Van(vanName, vanInv);
            fleet.add(tempVan);
        }



    }

    /**
     * Sorts bikeParts by numerical order
     * @param bikeparts ArrayList
     */
    private static void sortNum(ArrayList<BikePart> bikeparts){
        ArrayList<BikePart> tempList = new ArrayList<>(bikeparts);
        tempList.sort(new SortByNumber());

        System.out.println("Sorting bike parts by their IDs:\n");
        for (int i= 0; i < tempList.size(); i++){
            System.out.println(tempList.get(i).partName + ","   +
                    tempList.get(i).partNumber + "," +
                    tempList.get(i).price + "," +
                    tempList.get(i).salesPrice + "," +
                    tempList.get(i).onSale + "," +
                    tempList.get(i).quantity );
        }
        System.out.println();
    }

    /**
     * Sorts BikeParts by name
     * @param bikeparts ArrayList
     */
    private static void sortName(ArrayList<BikePart> bikeparts){
        ArrayList<BikePart> tempList = new ArrayList<>(bikeparts);
        tempList.sort(new SortByName());

        System.out.println("Sorting bike parts by their names:\n");
        for (int i= 0; i < tempList.size(); i++){
            System.out.println(tempList.get(i).partName + ","   +
                    tempList.get(i).partNumber + "," +
                    tempList.get(i).price + "," +
                    tempList.get(i).salesPrice + "," +
                    tempList.get(i).onSale + "," +
                    tempList.get(i).quantity );
        }
        System.out.println();
    }

    private static void addVanToFleet(Van VanToAdd, ArrayList<String> fleet) throws FileNotFoundException {
        // Now we ask for the new Van to be added to the pre-existing fleet
        String newVan = VanToAdd.getVanName();

        // We want to be able to tell the user if he or she entered a name that's already being used
        // We do this by assuming the name they provide is unique and then going through our fleet to check otherwise
        boolean isUnique = true;

        // This is us checking uniqueness against pre-existing elements within our fleet
        for (int i = 0; i < fleet.size(); i++) {
            String fleetVan = fleet.get(i);
            if (newVan.equals(fleetVan)) {
                isUnique = false;
            }
        }
        if (isUnique) {
            // This is where we add the new van to the fleet
            fleet.add(newVan);

        } else {
            System.out.println("The van name you've entered is already being used. Please choose another name.");
        }
















































































































    }
    private static void VanToVan(Van VanToEmpty, Van VanToFill) {
        // We're going to create an array list here that we'll add items to in the future so we can eventually add them to
        // our Van that is going to be filled. This is done so that we don't add elements in the moment of our query and confuse
        // its idea of how big the warehouse is
        ArrayList<BikePart> elementsToAdd = new ArrayList<>();


        // We then have a BikePart Array from the pre-existing file that can be empty
        boolean isEmpty = false;
        if (VanToFill.vanInv.size() == 0){
            isEmpty = true;
        }

        // If there are no elements in the Van to fill, we simply add each element in the invArray to the warehouseArray
        if (isEmpty){
            for (int i = 0; i < VanToEmpty.vanInv.size(); i++){
                VanToFill.vanInv.add(VanToEmpty.vanInv.get(i));
            }
        } else {
            // If there are elements in the warehouse:
            // We want to compare each item in the inventory BikePart Array to each item in the pre-existing array

            // Select each item in our inventory that we're comparing with each item in the existing array
            for (int i = 0; i < VanToEmpty.vanInv.size(); i++) {
                //because the first element starts at 0, the last item is at 'n'. So, we should
                //stop looping when we end with index 'n'. We do this by setting our condition
                //to have 'i' be less than the size of the Array
                // We set up a temporary bikepart object of the Van-to-empty's bikepart we're looking at so we can
                // compare it so that of each Van-to-fill's bikepart
                BikePart EmptyBikePart = VanToEmpty.vanInv.get(i);
                // We're going to set this boolean so that if this BikePart doesn't already exist, we can just add it later
                boolean doesExist = false;
                for (int j = 0; j < VanToFill.vanInv.size(); j++) {
                    // We set up a temporary bikepart object of the Van-to-fill's bikepart we're looking at
                    // so we can compare it to the Van-to-empty's bikepart at hand
                    BikePart FillBikePart = VanToFill.vanInv.get(j);
                    // We compare the Van-to-empty BikePart with the Van-to-fill BikePart
                    if (FillBikePart.partNumber.equals(EmptyBikePart.partNumber)) {
                        doesExist = true;
                        FillBikePart.quantity += EmptyBikePart.quantity;
                        FillBikePart.price = EmptyBikePart.price;
                        FillBikePart.salesPrice = EmptyBikePart.salesPrice;
                        FillBikePart.onSale = EmptyBikePart.onSale;
                    }
                }
                if (!doesExist) {
                    // This is where we add the new BikePart, that we don't want added in the moment, to the elementsToAdd Array
                    elementsToAdd.add(EmptyBikePart);

                }


            }
        }
        // This is where we add the new BikeParts that we didn't add in the moment
        for (int i = 0; i < elementsToAdd.size(); i++) {
            VanToFill.vanInv.add(elementsToAdd.get(i));
        }
    }

    /*
    wareVan needs to read in a .txt file supplied by the van. The file should look something like this:
    warehouseName,vanNam
    Tires,6
    coolCatBell,100
    etc.
     */
    private static void wareVan (Van van, ArrayList<BikePart> bikeParts){
        //how many parts taken by the van then prompt that many times for the part number and how many they want
        Scanner input=new Scanner( System.in );
        System.out.println("Enter how many BikeParts the van will be taking: ");
        int vanNum = input.nextInt();

        for (int i =0; i<vanNum; i++){
            System.out.println("Enter part number: ");
            String compNum = input.nextLine();
            System.out.println("Enter quantity: ");
            int outNum=input.nextInt();

            for (int j=0; j<outNum;j++){
                if (compNum.equals( bikeParts.get(j).partNumber )){
                    BikePart temp=bikeParts.get( j );
                    bikeParts.get( j ).quantity-=outNum;
                    temp.quantity=outNum;
                    van.vanInv.add( temp );
                }
            }
        }
    }
}
