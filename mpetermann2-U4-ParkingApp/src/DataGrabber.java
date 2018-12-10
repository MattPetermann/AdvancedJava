import java.util.ArrayList;
import java.util.Date;

public class DataGrabber {
    /**
     * Gets Ticket ArrayList from file
     * @return ArrayList of Ticket
     */
    public static final ArrayList<OpenTicket> getTickets() {
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
        return tickets;
    }
}
