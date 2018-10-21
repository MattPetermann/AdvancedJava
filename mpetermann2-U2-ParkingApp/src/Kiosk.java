import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Kiosk {
    private static final Scanner in = new Scanner(System.in);

    /**
     * Called when a driver pulls up to enter the garage
     * Grabs existing Tickets from file and append a new one
     * Time is decided based on program run time
     */
    public static final void checkIn() {
        //Get the tickets and add a new ticket
        ArrayList<Ticket> tickets = DataGrabber.getTickets();
        Ticket newTicket = new Ticket(tickets.size() > 0 ? tickets.get(tickets.size() - 1).getID() + 1 : 0, new Date());
        tickets.add(newTicket);

        //Print the new ticket info to user
        System.out.println("Printing ticket...");
        System.out.println("Ticket ID: " + newTicket.getID());
        System.out.println("Time: " + newTicket.getTime().toString());
        System.out.println("There is a $5 initial charge for the first three hours.\n" +
                "Every additional hour will cost $1.");

        //Build a string of tickets
        String lines = "";
        for (Ticket t : tickets)
            lines += t.toString();

        //Write the string to file
        FileOutput out = new FileOutput(Garage.FILEPATH);
        out.fileWrite(lines);
        out.fileClose();
    }

    /**
     * Called when a driver pulls up to leave the garage
     * When the driver has the ID cost is calculated
     * When the driver has lost the the ID cost is defaulted
     */
    public static final void checkOut() {
        String choice;
        do {
            //Prompt user
            System.out.println("1. I have my ticket ID\n" +
                    "2. I lost my ticket\n");

            //Get answer
            choice = in.nextLine();

            //Act on user's input
            switch(choice) {
                case "1": Register.calculateCost(); break;
                case "2": Register.defaultCharge(); break;
                default: System.out.println("Invalid entry"); break;
            }
        }while(!(choice.equals("1") || choice.equals("2")));
    }
}
