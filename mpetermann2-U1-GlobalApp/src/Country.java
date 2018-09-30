public class Country {
    private String countryName;
    private int cityCount;
    private int stuffCount;

    /**
     * Creates a Country object with 1 default city and 0 default stuff given its name.
     * @param cName the name of the Country for this object.
     */
    public Country(String cName) {
        countryName = cName;
        cityCount = 1;
        stuffCount = 0;
    }

    public void incrementCityCount(){
        cityCount++;
    }

    public void incrementStuffCount(){
        stuffCount++;
    }

    public String getCountryName(){
        return countryName;
    }

    public int getCityCount(){
        return cityCount;
    }

    public int getStuffCount() {
        return  stuffCount;
    }
}
