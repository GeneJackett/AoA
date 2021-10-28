package com.company;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Store {

    public String id;
    public String address;
    public String city;
    public String state;
    public String zipCode;
    public double latitude;
    public double longitude;
    public double distance;
    public List<Store> storeList = new ArrayList<>();

    public List<Store> getStoreList() {
        return storeList;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Store (String theID, String theAddress, String theCity, String theState, String theZip, double theLat, double theLon ){
            id = theID;
            address = theAddress;
            city = theCity;
            state = theState;
            zipCode = theZip;
            latitude = theLat;
            longitude = theLon;
            distance = 0;
        }
        //computer distance first for all stores using the queries lat and long

        public void computeDistance(double otherLat, double otherLong) {
            //Haversine Formula
            double radiusOfEarthInMiles = 3958.8;
            //First we convert the latitudes and longitudes to radians.
            double lat1 = Math.toRadians(latitude);
            double lat2 = Math.toRadians(otherLat);
            double long1 = Math.toRadians(longitude);
            double long2 = Math.toRadians(otherLong);
            //Then we apply the Haversine Formula to get the distance in miles.
            double a = Math.pow(Math.sin((lat2 - lat1) / 2), 2) + Math.cos(lat1) * Math.cos(lat2) *
                    Math.pow(Math.sin((long2 - long1) / 2), 2);
            double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            distance = radiusOfEarthInMiles * c;
        }

        // This Function helps in calculating
        // random numbers between low(inclusive)
        // and high(inclusive)
        public static void random(double arr[],int low, int high)
        {

            Random rand= new Random();
            int pivot = rand.nextInt(high-low)+low;

            Store temp1= storeData.get(low);
            arr[pivot]=arr[high];
            arr[high]=temp1;
        }

        /* This function takes last element as pivot,
        places the pivot element at its correct
        position in sorted array, and places all
        smaller (smaller than pivot) to left of
        pivot and all greater elements to right
        of pivot */
        public static int partition(int low, int high)
        {
            // pivot is chosen randomly
            random(arr,low,high);
            double pivot = arr[high];


            int i = (low-1); // index of smaller element
            for (int j = low; j < high; j++)
            {
                // If current element is smaller than or
                // equal to pivot
                if (arr[j] < pivot)
                {
                    i++;

                    // swap arr[i] and arr[j]
                    double temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            // swap arr[i+1] and arr[high] (or pivot)
            double temp = arr[i+1];
            arr[i+1] = arr[high];
            arr[high] = temp;

            return i+1;
        }


        /* The main function that implements QuickSort()
        arr[] --> Array to be sorted,
        low --> Starting index,
        high --> Ending index */
        public static void sort(int low, int high)
        {
            if (low < high)
            {
            /* pi is partitioning index, arr[pi] is
            now at right place */
                int pi = partition(low, high);
                // Recursively sort elements before
                // partition and after partition
                sort(low, pi-1);
                sort(pi+1, high);
            }
        }

}
