import org.junit.jupiter.api.Test;

import java.time.Duration;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    Robot buddy = new Robot("Buddy");

    @Test
    public void getNameTest(){

        assertEquals("Buddy",buddy.getName());
    }

    @Test
    public void isNotWorkingTest() {

        assertFalse(buddy.isWorking());
    }

    @Test
    public void poweredOnTest() {
        buddy.poweredOn();
        assertTrue(buddy.isWorking());
    }

    @Test
    public void poweredOffTest() {
        buddy.poweredOff();
        assertFalse(buddy.isWorking());
    }

    @Test
    public void getWorkingMessageTest() {
        buddy.poweredOn();
        assertEquals("I am in working mode",buddy.getWarning());

    }
    @Test
    public void getWorkingMessageFailTest() {
        buddy.poweredOff();
        assertThrows(IllegalStateException.class,() -> buddy.getWarning());

    }

    @Test
    public void ifNameFailsTest(){
        assertThrows(IllegalArgumentException.class,() -> {Robot chuck = new Robot("");});
    }

    @Test
    public void timeOutExceededTest() {
        assertTimeout(ofMillis(500), ()-> { buddy.waitTillWorking();});
    }
}