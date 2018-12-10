import java.util.Date;

public class KeptTicket implements IClosedTicket {
    private Date time;
    private int id;

    /**
     * New Ticket with a given ID and time
     * @param i ID of the Ticket to create
     * @param t Date of Ticket to create
     */
    public KeptTicket(int i, Date t) {
        setID(i);
        setTime(t);
    }

    /**
     * Print the receipt for this ticket
     * @return
     */
    public final void printReceipt(){
        long hours = (new Date().getTime() - time.getTime())/3600000;
        int hoursPastThree = Math.toIntExact(hours > 3 ? hours - 3 : 0);
        int cost = 5 + hoursPastThree;
        cost = cost > 15 ? 15 : cost;
        Records.incrementPaidTickets(cost);

        System.out.println("The garage will now close.");
        System.out.println("Receipt printing...");
        System.out.println("Ticket: " + id);
        System.out.println("Time Parked: " + time);
        System.out.println("Current Time: " + new Date().toString());
        System.out.println("Hours Parked: " + hours);
        System.out.println("You paid $" + cost + ".00");
    }

    /**
     * Set the Ticket time to a given date
     * @param t Date to set the time to
     */
    public final void setTime(Date t) {
        if(!t.before(new Date(0)) && !t.after(new Date()))
            time = t;
        else
            time = new Date(0);
    }

    /**
     * Set the Ticket ID to a given number
     * @param i Int representing Ticket ID
     */
    public final void setID(int i) {
        if (i >= 0)
            id = i;
        else
            id = 0;
    }

    /**
     * Override method to return this Ticket in a store-able format
     * @return String delimited on ","
     */
    @Override
    public String toString() {
        return "\n" + id + "," + time.getTime() + "\r";
    }
}
