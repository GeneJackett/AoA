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
        //1.read in store locations and store them in an array
        //2.for each line in the queries file: x , y , and i
        //3.compute the distance from the query location to each store location
        //and store the results in a new distance array.
        //4.Run the selection algorithm to find the Nth closest store to the query
        //5.Now that we know the ith closest store, make one final pass through
        //the distance array to find all i stores that are at least this close.
        //6.Sort the i stores and output in order from closest to furthest.
            String line  = "";
        try {
            // Create an object of file reader
            // class with CSV file as a parameter.
            BufferedReader br = new BufferedReader(new FileReader("WhataburgerData.csv"));
            while((line = br.readLine()) != null) {
                String[] attributes = line.split(",");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Print outputs.\n");
    }
}
