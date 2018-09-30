import java.util.ArrayList;

/**
 * This program loads data from two files and tracks information
 *  between them.
 */
public class Startup {
    public static void main(String[] args){
        ArrayList<Country> countries = getCountries();
        countStuff(countries);
        displayInfo(countries);
    }

    /**
     * Returns an ArrayList of unique Country objects from file.
     * @return an ArrayList type Country.
     */
    public static ArrayList<Country> getCountries(){
        FileInput file = new FileInput("src/places.csv");
        ArrayList<Country> countries = new ArrayList<>();

        String line;
        while((line = file.fileReadLine()) != null){
            String countryLine = line.split(",")[0];

            boolean countryExists = false;
            for(Country c : countries)
                if(c.getCountryName().equals(countryLine)) {
                    c.incrementCityCount();
                    countryExists = true;
                    break;
                }

            if(!countryExists)
                countries.add(new Country(countryLine));
        }

        file.fileClose();
        return countries;
    }

    /**
     * Increments the stuffCount property of each Country object in the
     *  ArrayList based on data from file.
     * @param countries an ArrayList type Country that holds objects to be
     *                  updated by this method.
     */
    public static void countStuff(ArrayList<Country> countries){
        FileInput file = new FileInput("src/stuff.csv");

        String line;
        while((line = file.fileReadLine()) != null){
            String countryLine = line.split(",")[0];

            for(Country c : countries){
                if(c.getCountryName().equals(countryLine)){
                    c.incrementStuffCount();
                    break;
                }
            }
        }

        file.fileClose();
    }

    /**
     * Prints the information in an ArrayList type Country to the console.
     * @param countries an ArrayList type Country that holds properties needed
     *                  for console output.
     */
    public static void displayInfo(ArrayList<Country> countries){
        String format = "%-25s %-7s%-6s\n";

        System.out.printf(format, "Country", "Cities", "Stuff");
        System.out.printf(format, "=======", "======", "=====");

        for(Country c : countries)
            System.out.printf(format, c.getCountryName(), c.getCityCount(), c.getStuffCount());
    }
}
