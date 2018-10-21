import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Register {
    private static final Scanner in = new Scanner(System.in);

    /**
     * Calculates cost based on ticket time
     * $5 initial charge + $1/hr after 3 hrs, Max $15
     */
    public static final void calculateCost() {
        boolean valid = false;
        long time = 0;
        int id;
        String origin = "";

        do {
            //Prompt user
            System.out.println("Enter your ticket ID");

            //Get answer
            id = in.nextInt();

            //Get list of tickets
            ArrayList<Ticket> tickets = DataGrabber.getTickets();

            //Find the ticket specified
            for(Ticket t : tickets) {
                if (t.getID() == id) {
                    Date today = new Date();
                    origin = t.getTime().toString();
                    time = Math.subtractExact(today.getTime(), t.getTime().getTime());
                    valid = true;
                    break;
                }
            }
            if(!valid)
                System.out.println("Invalid ID");
        }while(!valid);

        //Calculate cost
        long hours = time/3600000;
        int hoursPastThree = Math.toIntExact(hours > 3 ? hours - 3 : 0);
        int cost = 5 + hoursPastThree;
        cost = cost > 15 ? 15 : cost;

        //Print cost
        Records.incrementPaidTickets(cost);
        payAndClose(cost, id, hours, origin);
    }

    /**
     * Charges a default amount for lost tickets
     */
    public static final void defaultCharge() {
        //Print cost
        Records.incrementLostTickets();
        payAndClose(25, -1, -1, "Unknown");
    }

    /**
     * Print receipt and "close" garage
     * @param payment Amount to be paid
     * @param id Ticket number
     * @param hours Duration of parking
     * @param time Time entered garage
     */
    public static final void payAndClose(double payment, int id, double hours, String time) {
        System.out.println("The garage will now close.");
        System.out.println("Receipt printing...");
        System.out.println("Ticket: " + (id == -1 ? "LOST" : id));
        System.out.println("Time Parked: " + time);
        System.out.println("Current Time: " + new Date().toString());
        System.out.println("Hours Parked: " + (hours == -1 ? "N/A" : hours));
        System.out.printf("You paid $%.2f \n", payment);

        System.out.println();
        Records.printRecords();
    }
}
