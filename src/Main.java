/*
Megan Armbright
Section 1
I hereby declare upon my word of honor that I have neither given nor received unauthorized help on this work.
 */
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input= new Scanner( System.in );

        System.out.println("Enter Input Filename: ");
        String readfile = input.next();

        System.out.println("Enter Max Cost: ");
        double maxCost=input.nextInt();

        System.out.println("Enter Output Filename: ");
        String fileOut= input.next();

        PrintWriter myWriter= new PrintWriter( fileOut );
        ArrayList<BikePart> list=new ArrayList<>(  );

        try {
            toBikeArray( readfile, list );

                for (int i=0; i<list.size();i++) {
                    BikePart temp = list.get( i );
                    if (temp.onSale) {
                        if (temp.salesPrice <= maxCost) {
                            myWriter.println( temp.partName + " " + temp.partNumber + " " + temp.salesPrice + " " + temp.onSale + " " +temp.quantity );
                        }
                    } else {
                        if (temp.price <= maxCost) {
                            myWriter.println( temp.partName + " " + temp.partNumber + " " + temp.salesPrice + " " + temp.onSale + " " +temp.quantity);
                        }
                    }
                }myWriter.close();
                    System.out.println(readfile + " successfully processed");

        }catch (FileNotFoundException E){
            System.out.println("File not found: try again");
        }

    }

    /**converts inputted strings into the bike parts item
     *
     * @param item normal string input to be converted
     * @return bike part class
     */
    private static BikePart toBikeParts(String item){
        BikePart newPart= new BikePart( "0","0",0,0, false,0 );
        String [] itemInfo=item.split( "," );
        newPart.partName=itemInfo[0];
        newPart.partNumber=itemInfo[1];
        newPart.price=Double.parseDouble( itemInfo[2]);
        newPart.salesPrice=Double.parseDouble( itemInfo[3] );
        newPart.onSale=Boolean.parseBoolean( itemInfo[4] );
        newPart.quantity=Integer.parseInt( itemInfo[5] );
        return newPart;
    }
    private static void toBikeArray(String fileName, ArrayList<BikePart> bikeparts) throws FileNotFoundException {
        File fileIn=new File( fileName );
        Scanner input= new Scanner( fileIn );
        while (input.hasNextLine()){
            bikeparts.add(  toBikeParts( input.nextLine() ));
        }

        for (int i=0;i<bikeparts.size()-1;i++){
            BikePart temp=bikeparts.get( i );
            for (int j=1;j<bikeparts.size();j++){
                BikePart temp2=bikeparts.get( j );
                if (temp.partNumber.equals( temp2.partNumber )){
                    temp.quantity+=temp2.quantity;
                    temp.price=temp2.price;
                    temp.salesPrice=temp2.salesPrice;
                    temp.onSale=temp2.onSale;
                    bikeparts.set( i,temp );
                }
            }
        }

    }
}