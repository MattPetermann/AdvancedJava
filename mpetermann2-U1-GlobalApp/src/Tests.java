import org.junit.jupiter.api.Test;
import org.testng.Assert;

public final class Tests {
    private Country country;

    @Test
    public void incrementStuffCount_ReturnsOne() {
        final int expected = 1;

        country = new Country("");
        country.incrementStuffCount();

        final int actual = country.getStuffCount();

        Assert.assertEquals(actual, expected);
        country = null;
    }

    @Test
    public void incrementCityCount_ReturnsTwo() {
        final int expected = 2;

        country = new Country("");
        country.incrementCityCount();

        final int actual = country.getCityCount();

        Assert.assertEquals(actual, expected);
        country = null;
    }
}
