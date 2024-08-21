package org.siddhantangore.hashing;

import java.util.Scanner;

public class Appendix_1_BirthdayParadox {
    public static void main(String[] args) {
        System.out.println("\nWelcome to the Birthday Paradox Visualizer\n");

        int numberOfPeople;

        // Input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of people in a room = ");
        numberOfPeople = sc.nextInt();

        // Output
        displayResult(numberOfPeople);
    }
    public static void displayResult(int numberOfPeople) {
        double numberOfDaysInYear = 365;

        System.out.println("\nMetric for the room: -");
        System.out.println("No. of people in the room: " + numberOfPeople);
        System.out.println("No. of days in a year: " + numberOfDaysInYear);

        double percentageDifferentBirthday = ((double) 364 / numberOfDaysInYear);
        System.out.println("Chances of 2 people having different birthday [1 - (1/365) = 364/365]: " + percentageDifferentBirthday);

        double totalComparisons = (double) (numberOfPeople * (numberOfPeople - 1)) / 2;
        System.out.println("Total comparisons for " + numberOfPeople + ": " + totalComparisons);

        double percentageAllDifferentBirthday = Math.pow(percentageDifferentBirthday, totalComparisons);
        System.out.println("Chances of all people having different birthday (364/365)^(totalComparisons): " + percentageAllDifferentBirthday);

        double percentageSameBirthday = (1 - percentageAllDifferentBirthday);
        System.out.println("Chances that at least 2 people have same birthday [1 - (above result)]: " + percentageSameBirthday);
        System.out.println("\nTherefore, percent that at least 2 people have same birthday: " + percentageSameBirthday * 100 + " %");
    }
}
