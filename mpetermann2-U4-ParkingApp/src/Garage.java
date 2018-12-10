import java.util.Date;
import java.util.Scanner;

public class Garage {
    public static final String FILEPATH = "tickets.csv";
    private static final Scanner in = new Scanner(System.in);

    public static final void main(String[] a) {
        //Ask user to check in/out
        String choice;
        do {
            //Prompt user
            System.out.println("--Parking Garage--");
            System.out.println("Are you checking in or out? \n" +
                                "1. Checking in \n" +
                                "2. Checking out \n");

            //Get answer
            choice = in.nextLine();

            //Act on user's input
            switch(choice) {
                case "1": Kiosk.checkIn(); break;
                case "2": Kiosk.checkOut(); break;
                default: System.out.println("Invalid entry"); break;
            }
        } while(!(choice.equals("1") || choice.equals("2")));
    }
}
