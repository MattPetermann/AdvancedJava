import java.util.ArrayList;
import java.util.Date;

public class OpenTicketFactory {
    static ArrayList<OpenTicket> ticketList = null;

    /**
     * Gets Ticket ArrayList from file
     */
    private static void loadFromFile() {
        //Declare variables
        ArrayList<OpenTicket> tickets = new ArrayList<>();
        FileInput in = new FileInput(Garage.FILEPATH);
        String line;

        //Read tickets from file
        while((line = in.fileReadLine()) != null) {
            if(line.length() > 0) {
                String values[] = line.split(",");
                tickets.add(new OpenTicket(Integer.parseInt(values[0]), new Date(Long.parseLong(values[1]))));
            }
        }
        in.fileClose();

        //Return the list of tickets
        ticketList = tickets;
    }

    /**
     * If array list has not yet been loaded, load it
     * @return ArrayList of OpenTicket
     */
    public static final ArrayList<OpenTicket> getTickets() {
        if(ticketList == null)
            loadFromFile();

        return ticketList;
    }
}
