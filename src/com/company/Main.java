package com.company;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


public class Main {
    public static List<Store> storeData = new ArrayList<>();

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
            boolean firstLine = true;
            BufferedReader br = new BufferedReader(new FileReader("WhataburgerData.csv"));
            while((line = br.readLine()) != null) {
                if(firstLine == true){
                    firstLine = false;
                    continue;
                }
                String[] attributes = line.split(",");
                if(attributes[1].indexOf('"')==0){
                    int j = 1;
                    do{
                        j++;
                        attributes[1] += ("," + attributes[j]);
                    }while(attributes[j].indexOf('\"') == -1);
                    attributes[1].replace("\"","");
                    attributes[2]=attributes[j+1];
                    attributes[3]=attributes[j+2];
                    attributes[4]=attributes[j+3];
                    attributes[5]=attributes[j+4];
                    attributes[6]=attributes[j+5];
                }
                Store thisStore = new Store(attributes[0],attributes[1],attributes[2],attributes[3],attributes[4],Double.parseDouble(attributes[5]),Double.parseDouble(attributes[6]));

                storeData.add(thisStore); // create multipel Store objects.
                //System.out.print((attributes[0])+"\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //how to print variables form object
        for(int i = 0; i < storeData.size(); i++) {
            System.out.println(storeData.get(i).longitude+" "+i+"\n");
        }
    }
}
