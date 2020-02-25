import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;



public class RobotMockInterfaceTest {



    @Test
    public void InterfaceTest() {

        System.out.println("getTotalCost");

        Robot instance = new Robot("robbie", 5);

        /* Call the create Mock to create a mock of the RobotFee class */

        Robot.RobotFees mockRobotFees = Mockito.mock(Robot.RobotFees.class);

        /* Set up the expected values and return values. */
        Mockito.when(mockRobotFees.getCost(5)).thenReturn(100.00);


        double expResult = 10100.00;

        double result = instance.getTotalCost(mockRobotFees);

        assertEquals(expResult, result, 0.5);

        /* verify that the mock was used correctly */
        verify(mockRobotFees).getCost(5);


    }


}
