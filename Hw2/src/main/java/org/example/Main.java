package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        double [] sampleValuesList = new double[] {9, 6, 8, 5, 7};
        double sampleStdDev = Computation.computeSampleStandardDeviation(sampleValuesList);
        System.out.println("Sample StdDev = " + sampleStdDev);

        double [] populationValuesList = new double[] {9, 2, 5, 4, 12, 7, 8, 11, 9, 3, 7, 4, 12, 5, 4, 10, 9, 6, 9, 4};
        double popStdDev = Computation.computePopulationStandardDeviation(populationValuesList);
        System.out.println("Population StdDev = " + popStdDev);
    }
}