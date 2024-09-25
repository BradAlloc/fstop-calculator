package yeldarb.photo.fstop.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DifferenceCalculatorTest {

    /**This is a small test to ensure the size logic in this test hasn't been reversed. <br />
     * We check to ensure floating point values are close to the expected values as we cannot be sure that exact
     * values will be representable by the format.*/
    @Test
    @DisplayName("Difference in light in raw numbers")
    void calculateLightDifferenceTest() {
        final Double verySmallNumber = 0.01D;
        Double difference;

        //Illegal Arguments
        assertThrows(IllegalArgumentException.class, () -> DifferenceCalculator.calculateLightDifference(0D, 2.8285));
        assertThrows(IllegalArgumentException.class, () -> DifferenceCalculator.calculateLightDifference(2.8285, 0D));
        assertThrows(IllegalArgumentException.class, () -> DifferenceCalculator.calculateLightDifference(0D, 0D));

        //Sane known outputs
        difference = DifferenceCalculator.calculateLightDifference(2.8285, 4.0);
        assert( Math.abs( 2.0 - difference ) < verySmallNumber);

        difference = DifferenceCalculator.calculateLightDifference(4.0, 2.8285);
        assert( Math.abs( 0.5 - difference ) < verySmallNumber );
    }

    @Test
    @DisplayName("Difference in Stops")
    void calculateStopDifferenceTest(){
        final Double verySmallNumber = 0.1D; //this is logarithmic (base2)
        Double difference;

        //Illegal Arguments
        assertThrows(IllegalArgumentException.class, () -> DifferenceCalculator.calculateStopDifference(0D, 2.8285));
        assertThrows(IllegalArgumentException.class, () -> DifferenceCalculator.calculateStopDifference(2.8285, 0D));
        assertThrows(IllegalArgumentException.class, () -> DifferenceCalculator.calculateStopDifference(0D, 0D));

        //Sane known outputs
        difference = DifferenceCalculator.calculateStopDifference(2.8, 11.0);
        assert( Math.abs( 4.0 - difference ) < verySmallNumber);

        difference = DifferenceCalculator.calculateStopDifference(11.0, 2.8);
        assert( Math.abs( -4.0 - difference ) < verySmallNumber);
    }
}