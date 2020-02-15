import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner( System.in );
        boolean quitFlag = false;

        while (!quitFlag){
            System.out.println("Select your option: \nReadFile\n" +
                                "Enter BikePart\nSell BikePart\n" +
                                "Display BikePart\nSortBy Name\n" +
                                "SortBy Number\nQuit");
            String user_input = in.nextLine();
            if (user_input.equals("Quit")) {
                quitFlag = true;
            } else if (user_input.equals("Help")) {

            }


        }
    }
}
