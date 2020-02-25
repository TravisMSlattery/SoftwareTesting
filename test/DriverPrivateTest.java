import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DriverPrivateTest {

    public void testsetDriverNumber() throws Exception {
        System.out.println("setDriverNum");
        /* Set up a new Robot */
        Driver Tom = new Driver("Tom", 3);

        /* get the setAge method details */
        Method method = Driver.class.getDeclaredMethod("setDriverNum", int.class);

        /* make the method assessible */
        method.setAccessible(true);

        /* invoke the method setAge with the value 7 */
        method.invoke(Tom, 7);

        /*access the field age and check its value is set to 7*/
        Class secretClass = Tom.getClass();

        Field f = secretClass.getDeclaredField("age");

        f.setAccessible(true);

        int result =  f.getInt(Tom);
        System.out.println("The value in f driverNum is " + f.get(Tom));
        assertEquals( 7,  result);
    }
}
