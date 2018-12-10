import java.util.Date;

public class OpenTicket {
    private Date time;
    private int id;

    /**
     * New Ticket with a given ID and time
     * @param i ID of the Ticket to create
     * @param t Date of Ticket to create
     */
    public OpenTicket(int i, Date t) {
        setID(i);
        setTime(t);
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
     * Get the time of this Ticket
     * @return Date of when this Ticket was printed
     */
    public final Date getTime() { return time; }

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
     * Get the ID of this Ticket
     * @return Int of the ID
     */
    public final int getID() { return id; }

    /**
     * Override method to return this Ticket in a store-able format
     * @return String delimited on ","
     */
    @Override
    public String toString() {
        return "\n" + id + "," + time.getTime() + "\r";
    }
}
