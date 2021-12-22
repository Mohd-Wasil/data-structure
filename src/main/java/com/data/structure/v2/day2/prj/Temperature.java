package com.data.structure.v2.day2.prj;

import java.util.Scanner;

public class Temperature {

    float[] temperature;

    public Temperature(int length) {
        temperature = new float[length];
        Scanner consoleScanner = new Scanner(System.in);
        for (int i = 0; i < temperature.length; i++) {
            System.out.println("Please enter day " + (i + 1) + " high temperature");
            temperature[i] = consoleScanner.nextInt();
        }
    }

    private float calculateAvg() {
        int sum = 0;
        for (int i = 0; i < temperature.length; i++) {
            sum += temperature[i];
        }
        return sum / temperature.length;
    }

    private int noOfDaysAboveAvgTemp(float avg) {
        int daysAboveAvgTemp = 0;
        for (int i = 0; i < temperature.length; i++) {
            if (temperature[i] > avg) {
                ++daysAboveAvgTemp;
            }
        }
        return daysAboveAvgTemp;
    }

    public static void main(String[] args) {
        System.out.println("how many day's temperature : ");
        Scanner scanner = new Scanner(System.in);
        Temperature temperature = new Temperature(scanner.nextInt());
        float avg = temperature.calculateAvg();
        System.out.println("avg is : "+ avg);
        int days = temperature.noOfDaysAboveAvgTemp(avg);
        System.out.println(days + " day(s) above avg");

    }
}
