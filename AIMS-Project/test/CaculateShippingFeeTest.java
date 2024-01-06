import static org.junit.jupiter.api.Assertions.*;

import controller.calculate.CalculateShippingFee;
import org.junit.jupiter.api.Test;
import entity.order.Order;

import java.util.Random;

class CalculateShippingFeeTest {

    @Test
    void testCalculateShippingFee() {
        CalculateShippingFee feeCalculator = new CalculateShippingFee();

        Order order = new Order();
//        order.setAmount(100); // Set the order amount

        int actualFee = feeCalculator.calculateShippingFee(order);
        System.out.println(actualFee);
        int expectedFee = 0;

        assertEquals(0, actualFee);
    }
}
