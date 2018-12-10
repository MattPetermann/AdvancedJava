public class LostTicket implements IClosedTicket {
    /**
     * Print the receipt for this ticket
     * @return
     */
    public final void printReceipt(){
        Records.incrementLostTickets();

        System.out.println("The garage will now close.");
        System.out.println("Receipt printing...");
        System.out.println("Lost Ticket: $25.00");
    }
}