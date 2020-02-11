import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

public class DriverTest {
    Driver Travis = new Driver("Travis",101);

    @Test
    public void getDriverNameTest(){

        assertEquals("Travis",Travis.getDriverName());
    }

    @Test
    public void getDriverNumTest() {

        assertEquals(101,Travis.getDriverNum());
    }
    @Test
    public void getDriverNumFalseTest() {

        assertFalse(Travis.getDriverNum() == 102);
    }

    @Test
    public void bannedFalseTest() {
        Travis.check_status();
        assertFalse(Travis.check_status());
    }

    @Test
    public void bannedTrueTest() {
        assertTrue(Travis.check_status() == true);
    }

    @Test
    public void ifNameFailsTest(){
        assertThrows(IllegalArgumentException.class,() -> {Driver frank = new Driver("",102);});
    }

    @Test
    public void waitTillbannedTest() {
        assertTimeout(ofMillis(500), ()-> { Travis.waitTillbanned();});
    }
    @Test
    public void ifDriverNumFailsTest(){
        assertThrows(IllegalArgumentException.class,() -> {Driver Terry = new Driver("Terry",01);});
    }
}
