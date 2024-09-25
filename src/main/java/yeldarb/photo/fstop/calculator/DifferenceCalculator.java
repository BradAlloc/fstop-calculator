package yeldarb.photo.fstop.calculator;

/***
 *  Contains static methods to calculate the difference between two lens f-stops.
 */
public class DifferenceCalculator {
    /**
     * Calculate the difference in light gathering ability between fstop1 and fstop2.
     * For example if fstop1 is 2.8 and fstop2 is 4.0, approx. 2.0 will be returned.
     *
     *
     * @param fstop1 lens fstop as a Double such as 1.8 or 4.0, a non-zero positive value.
     * @param fstop2 lens fstop as a Double such as 1.8 or 4.0, a non-zero positive value.
     *
     * @return  <p>How many times more light is gathered by a lens with a different fstop.</p>
     *          if fstop1 is 2.8 and fstop2 is 4.0, approximately 2.0 will be returned. <br />
     *          if fstop2 is 4.0 and fstop1 is 2.8, approximately 0.5 will be returned
     *
     * @throws IllegalArgumentException when fstops are 0 or negative.  This defies physics.
     * */
    public static Double calculateLightDifference(final Double fstop1, final Double fstop2){
        if(fstop1 == null || fstop2 == null || fstop1.equals(0D) || fstop2.equals(0D) ){
            throw new IllegalArgumentException();
        }

        double  circumference1,
                circumference2;

        //The specific value doesn't really matter, they cancel each other out in the division.
        final Double ARBITRARY_FOCAL_LENGTH = 50.0;

        circumference1 = Math.PI * Math.pow((ARBITRARY_FOCAL_LENGTH / fstop1), 2);
        circumference2 = Math.PI * Math.pow((ARBITRARY_FOCAL_LENGTH / fstop2), 2);

        return circumference1 / circumference2;
    }

    /**
     * Calculate the nubmer of stops between fstop1 and fstop2.
     * For example: if fstop1 is 2.8 and fstop2 is 11, approximately 4 will be returned. <br />
     *              if fstop1 is 11 and fstop2 is 2.8, -4 will be returned.
     *
     * @param fstop1  lens fstop as a Double such as 1.8 or 4.0, a non-zero positive value.
     * @param fstop2  lens fstop as a Double such as 1.8 or 4.0, a non-zero positive value.
     *
     * @return <p>How many times more light is gathered by a lens with a different fstop.</p>
     *           if fstop1 is 4 and fstop2 is 2.8, approximately 2.0 will be returned. <br />
     *           if fstop2 is 4 and fstop1 is 2.8, approximately 0.5 will be returned
     * */
    public static Double calculateStopDifference(final Double fstop1, final Double fstop2){
        Double areaDifference = calculateLightDifference(fstop1, fstop2);

        //Use Log change of Base Rule to take log base 2 of difference.
        Double stops = Math.log10(areaDifference) / Math.log10(2.0);

        return stops;
    }
}
