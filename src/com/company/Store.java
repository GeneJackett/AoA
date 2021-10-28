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


        public static int randPartition(int low, int high) {
            // pivot is chosen randomly
            Random rng = new Random();
            int pivotIndex = rng.nextInt(high-low+1)+ low;
            Store temp = Main.storeData.get(low);
            Main.storeData.set(low, Main.storeData.get(pivotIndex));
            Main.storeData.set(pivotIndex, temp);

            double pivotDistance = Main.storeData.get(low).distance;
            int i = low;
            for (int j = low + 1; j <= high; j++)
            {
                if (Main.storeData.get(j).distance <= pivotDistance)
                {
                    i++;

                    // swap arr[i] and arr[j]
                    temp = Main.storeData.get(j);
                    Main.storeData.set(j, Main.storeData.get(i)) ;
                    Main.storeData.set(i, temp);
                }
            }
            temp = Main.storeData.get(low);
            Main.storeData.set(low, Main.storeData.get(i));
            Main.storeData.set(i, temp);
            return i;
        }

        public static Store randSelect(int low, int high, int i) {
            if (low == high) {
                return Main.storeData.get(low);

            }
                int r = randPartition(low, high);//index of entire array
                int k = r - (low - 1);//rank with respect to our subproblem
            if(i == k) {
                return Main.storeData.get(r);
            }
            if(i < k) {
                return randSelect(low, r-1, i);
            }else{
               return randSelect(r+1, high,i-k);// continues to throw off order
            }
        }

}
