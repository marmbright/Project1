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

        FileWriter myWriter=new FileWriter( fileOut );
        ArrayList<BikePart> list=new ArrayList<>(  );

        try {
            toBikeArray( readfile, list );

                for (int i=0; i<list.size();i++) {
                    BikePart temp = list.get( i );
                    if (temp.onSale) {
                        if (temp.salesPrice <= maxCost) {
                            myWriter.write( temp.partName + " " + temp.partNumber + " " + temp.salesPrice + " " + temp.onSale + "\n" );
                        }
                    } else {
                        if (temp.price <= maxCost) {
                            myWriter.write( temp.partName + " " + temp.partNumber + " " + temp.salesPrice + " " + temp.onSale + "\n" );
                        }
                    }
                    myWriter.close();
                    System.out.println( readfile + " successfully processed" );
                }
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
        return newPart;
    }
    private static void toBikeArray(String fileName, ArrayList<BikePart> bikeparts) throws FileNotFoundException {
        File fileIn=new File( fileName );
        Scanner input= new Scanner( fileIn );
        while (input.hasNextLine()){
            bikeparts.add(  toBikeParts( input.nextLine() ));
        }

    }
}