package org.example;

import java.lang.Math;
public class Computation {
    public static double computeMean(double [] valueList){
        if(valueList == null || valueList.length == 0){
            throw new IllegalArgumentException("valuesList parameter cannot be null or empty");
        }
        double sumAccumulator = 0;

        for (double value : valueList) {  // Correct way to sum values
            sumAccumulator += value;
        }
        return sumAccumulator / valueList.length;
    }

    public static double computeSquareOfDifferences(double [] valueList, double mean){
        if(valueList == null || valueList.length == 0){
            throw new IllegalArgumentException("valuesList parameter cannot be null or empty");
        }
        double squareAccumulator = 0;
        for (double value : valueList) {  // Correct way to access the actual values
            double difference = value - mean;
            double squareOfDifference = difference * difference;
            squareAccumulator += squareOfDifference;
        }
        return squareAccumulator;
    }

    public static double computeVariance(double squareOfDifferences, double numValues, boolean isPopulation){
        if(!isPopulation){
            numValues = numValues - 1;
        }
        if(numValues < 1){
            throw new IllegalArgumentException("numValues is too low (sample size must be >= 2, population size must be >= 1)");
        }
        return squareOfDifferences / numValues;
    }

    public static double computeStandardDeviation(double [] valueList, boolean isPopulation){
        if(valueList == null || valueList.length == 0){
            throw new IllegalArgumentException("valuesList parameter cannot be null or empty");
        }
        double mean = computeMean(valueList);
        double squareOfDifferences = computeSquareOfDifferences(valueList,mean);
        double variance = computeVariance(squareOfDifferences, valueList.length, isPopulation);

        return (double) Math.sqrt(variance);
    }

    public static double computeSampleStandardDeviation(double [] valueList){
        return computeStandardDeviation(valueList,false);
    }

    public static double computePopulationStandardDeviation(double [] valueList){
        return computeStandardDeviation(valueList, true);
    }

    public static String interpretStandardDeviation(double stdDev){
        stdDev = Math.round(stdDev);
        if(stdDev > 2.0){return "Above Average";}
        else if (stdDev < -2.0) {
            return "Below Average";
        } else if (stdDev == 0.0) {
            return "Exactly Average";
        }
        return "Near Average";
    }
}
