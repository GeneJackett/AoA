package com.company;
import java.util.*;
import java.io.*;


public class Main {
    public static List<Store> storeData = new ArrayList<>();
    public static List<Queries> storeQueries = new ArrayList<>();
    public static double []distanceArr;


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

        String line2  = "";
        try {

            // Create an object of file reader
            // class with CSV file as a parameter.
            boolean firstLine2 = true;
            BufferedReader br2 = new BufferedReader(new FileReader("Queries.csv"));
            while((line2 = br2.readLine()) != null) {
                if (firstLine2 == true) {
                    firstLine2 = false;
                    continue;
                }
                String[] attributes2 = line2.split(",");
                if (attributes2[1].indexOf('"') == 0) {
                    int k = 1;
                    do {
                        k++;
                        attributes2[1] += ("," + attributes2[k]);
                    } while (attributes2[k].indexOf('\"') == -1);
                    attributes2[1].replace("\"", "");
                    attributes2[2] = attributes2[k + 1];
                    attributes2[3] = attributes2[k + 2];

                }
                Queries theQueries = new Queries(Double.parseDouble(attributes2[0]), Double.parseDouble(attributes2[1]), Integer.parseInt(attributes2[2]));
                storeQueries.add(theQueries);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        distanceArr = new double[storeData.size()];

        //how to print variables form object
        for (int k = 0; k < storeQueries.size(); k++){
            for(int i = 0; i < storeData.size(); i++) {
                storeData.get(i).computeDistance(storeQueries.get(k).latQ, storeQueries.get(k).longQ);
                distanceArr[i] = storeData.get(i).getDistance();
                //System.out.println(storeData.get(i).distance+" "+i+"\n"); TEST PRINT
            }
            Store.sort(distanceArr, 0, distanceArr.length - 1);
            for (int r=0; r < storeQueries.get(k).numStores; r++ ){
                System.out.println(distanceArr[r]);
            }
            System.out.println("");
        }
        //Queries are being stored properly and are ready for calculations.
        /*for (int g = 0; g < storeQueries.size(); g++){
            System.out.println(storeQueries.get(g).latQ+", "+storeQueries.get(g).longQ+"\n");
        }

         */
    }
}
