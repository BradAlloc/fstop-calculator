package yeldarb.photo.fstop;

import yeldarb.photo.fstop.calculator.DifferenceCalculator;
import yeldarb.photo.fstop.interfaces.cli.DoubleValueQuestion;

public class Main {
    public static void main(String[] args) {
        Double  fstop1 = null,
                fstop2 = null;

        //Attempt to run the program with fstops passed as arg1 and arg2
        try{
            fstop1 = Double.parseDouble( args[0] );
            fstop2 = Double.parseDouble( args[1] );

        }catch( ArrayIndexOutOfBoundsException | NumberFormatException | NullPointerException e){
            //Ask for values that weren't provided.
            DoubleValueQuestion fstopQuestion1, fstopQuestion2;

            fstopQuestion1 = new DoubleValueQuestion("What is the first fstop?\n");
            fstopQuestion2 = new DoubleValueQuestion("What is the second fstop?\n");

            fstopQuestion1.ask();
            fstopQuestion2.ask();

            fstop1 = fstopQuestion1.getValue();
            fstop2 = fstopQuestion2.getValue();
        }

        Double stopDifference = DifferenceCalculator.calculateStopDifference(fstop1, fstop2);

        System.out.println(stopDifference);
    }
}