package com.company;
import java.util.*;
import java.io.*;

public class Main {
    public static double calculateDistance(){
        double distance = 0.0;
        return distance;
    }
    public static void printAnswer(){
//public hey new comment
    }

    public static void main(String[] args) {
	// read in csv files first then create a query for local data.
        ArrayList<Double> data = new ArrayList<>();
        try {
            // Create an object of file reader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(file);

            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();

            // print Data
            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    System.out.println("Print outputs.\n");
    }
}
