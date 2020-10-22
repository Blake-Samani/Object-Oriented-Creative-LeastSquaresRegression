package test;

import java.awt.Color;
import java.util.ArrayList;


import model.idemo.lsRegression;

public class GraphTest {
    

    public static void main(String[] args){
        
        ArrayList<Float> xpoints = new ArrayList<>();
        ArrayList<Float> ypoints = new ArrayList<>();

        xpoints.add((float)1.0);
        xpoints.add((float)2);
        xpoints.add((float)3);
        xpoints.add((float)4);
        xpoints.add((float)5);
        xpoints.add((float)6);
        xpoints.add((float)7);

        ypoints.add((float)1.5);
        ypoints.add((float)3.8);
        ypoints.add((float)6.7);
        ypoints.add((float)9.0);
        ypoints.add((float)11.2);
        ypoints.add((float)13.6);
        ypoints.add((float)16);

        lsRegression leastSquares = new lsRegression(Color.green, 7);//create object/green/7 points

        for (var e: xpoints){ //add points to lsregression X
            leastSquares.addPointsX(e);
        }

        for (var e: ypoints){ //add points to lsregression Y
            leastSquares.addPointsY(e);
        }

        leastSquares.calcSumX();// calculate the sum of all X points
        leastSquares.calcSumY(); // calculate sum of all Y points
        leastSquares.calcSumXY(); // calculate sum of product of all X and Y points
        leastSquares.calcSquareSumX(); // calculate sum of square of all X points
        leastSquares.computeSlope(leastSquares.getN(), leastSquares.getSumXY(), leastSquares.getSumX(), leastSquares.getSumY(), leastSquares.getSquareSumX());
        leastSquares.calcYint(); //calculate the y intercept of our equation
   

        System.out.println("Sum of X: " + leastSquares.getSumX()); // test for sum of all Xpoints // Passed
        System.out.println("Sum of Y: " + leastSquares.getSumY()); //passed
        System.out.println("Sum of XY: " + leastSquares.getSumXY()); //passed
        System.out.println("Sum of X^2: " + leastSquares.getSquareSumX()); //passed
        System.out.println("Slope: " + leastSquares.getSlopebo()); //passed
        System.out.println("Y int: " + leastSquares.getYintb1()); //passed
        System.out.println("Our linear equation is Y =" + leastSquares.getSlopebo() + "x + " + leastSquares.getYintb1());
     
 
        
       
    }
}
