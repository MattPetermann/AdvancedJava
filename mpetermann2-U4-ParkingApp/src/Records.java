public class Records {
    private static final String FILEPATH = "records.csv";

    /**
     * Prints historical records to console
     * First line: Count of tickets paid
     * Second Line: Sum of $ from tickets paid
     * Third Line: Count of lost tickets
     * Fourth Line: Sum of $ from lost tickets
     */
    public static final void printRecords() {
        String[] values = getValues();

        //Print the values
        System.out.println("--Summary--");
        System.out.println("Tickets paid: " + values[0]);
        System.out.println("Collected from paid tickets: $" + values[1]);
        System.out.println("Tickets lost: " + values[2]);
        System.out.println("Collected from lost tickets: $" + values[3]);
    }

    /**
     * Adds one to the lost ticket count
     * Adds $25 to sum of lost ticket amount
     */
    public static final void incrementLostTickets() {
        //Get values
        String[] values = getValues();

        //Increment values
        values[2] = "" + (Integer.parseInt(values[2]) + 1);
        values[3] = "" + (Integer.parseInt(values[3]) + 25);

        //Store values
        storeValues(values);
    }

    /**
     * Adds one to the paid ticket count
     * Adds given amount to sum of paid ticket amount
     * @param sum Amount to increment paid ticket sum by
     */
    public static final void incrementPaidTickets(int sum) {
        //Get values
        String[] values = getValues();

        //Increment values
        values[0] = "" + (Integer.parseInt(values[0]) + 1);
        values[1] = "" + (Integer.parseInt(values[1]) + sum);

        //Store values
        storeValues(values);
    }

    /**
     * Gets values stored in file representing historical records
     * @return String array of values from file
     */
    private static final String[] getValues() {
        //Declare variables
        FileInput in = new FileInput(FILEPATH);
        String line;
        while ((line = in.fileReadLine()) != null) {
            if (line.length() > 0) {
                in.fileClose();
                return line.split(",");
            }
        }
        //If file read fails
        in.fileClose();
        return new String[]{"0","0","0","0"};
    }

    /**
     * Saves values to file
     * @param values String array representing historical records to save
     */
    private static final void storeValues(String[] values) {
        //Write back to file
        FileOutput out = new FileOutput(FILEPATH);
        out.fileWrite(values[0] + "," + values[1] + "," + values[2] + "," + values[3]);
        out.fileClose();
    }
}
