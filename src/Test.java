import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner( System.in );
        boolean quitFlag = false;

        while (quitFlag == false){
            System.out.println("What would you like to do?: \nRead File | Enter BikePart | Sell BikePart\n" +
                                "Display BikePart | Sort By Name | Sort By Number\n" +
                                "Quit");
            String user_input = in.nextLine();

            ArrayList<BikePart> list=new ArrayList<>(  );


            if (user_input.equals("Quit")) {
                quitFlag = true;
            }

            else if (user_input.equals("Read File")) {
                System.out.println("Please enter your inventory file name: ");
                String invFileName = in.nextLine();
                PrintWriter myWriter = new PrintWriter(invFileName);












            } else if (user_input.equals("Enter BikePart")) {
                System.out.println("What is the name of your BikePart?: ");
                String tempName = in.nextLine();

            } else if (user_input.equals("Sell BikePart")) {

            } else if (user_input.equals("Display BikePart")) {

            } else if (user_input.equals("Sort By Name")) {

            } else if (user_input.equals("Sort By Number")) {

            }


        }
    }
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
