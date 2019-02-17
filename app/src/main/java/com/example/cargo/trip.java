package com.example.cargo;

import com.smartcar.sdk.*;
import com.smartcar.sdk.data.*;
import java.util.*;



import static com.example.cargo.Main.getCarAccess;

public class Trip {
    private int legs;
    private Vector passenger_active;
    private Vector passenger_names;
    private Vector passenger_fare;
    private double gas_price;
    private double ppg;
    private double kmpg;
    private double ppkm;
    private double odometer;

    public Trip() {
        legs = 1;
        passenger_active = new Vector(0);
        passenger_names = new Vector(0);
        passenger_fare = new Vector(0);
        gas_price = 2.51;
        ppg = 2.28;
        kmpg = 104 / 0.621371;
        ppkm = ppg / kmpg;
        odometer = getOdometer();
    }

    public Trip getTrip() {
        Trip trip = new Trip();
        return trip;
    }


    public double getOdometer() {
        String token = getCarAccess();
        SmartcarResponse<VehicleIds> response = authClient.getVehicleIds(token);
        int vid = (response.get('vehicles')).get(0);
        Vehicle vehicle = new Vehicle(vid, token);
        double odom = vehicle.odometer();
        return odom;

    }

    ;

    public void enterName(String name) {
        passenger_names.add(name);
        passenger_active.add(1);
        passenger_fare.add(0);
    }

    ;

    public double dropOff(String name) {
        int currIndex = 0;
        for (int i = 0; i < passenger_names.size(); i++) {
            if (passenger_names.get(i) == name) {
                passenger_active.set(i, 0);
                currIndex = i;
            }
        }
        newLeg();
        return (double) passenger_fare.get(currIndex);
    }

    ;

    public void pickUp(String name) {
        passenger_names.add(name);
        newLeg();
    }

    ;

    public void newLeg() {
        legs++;
        double old_odo = odometer;
        double new_odo = getOdometer();
        double kms = new_odo - old_odo;
        double active = 0.0;
        for (int i = 0; i < passenger_active.size(); i++) {
            active += (double) passenger_active.get(i);
        }
        active++;
        double leg_cost = (kms / active) * ppkm;
        for (int i = 0; i < passenger_active.size(); i++) {
            double a = (double) passenger_fare.get(i) + (leg_cost * (double) passenger_active.get(i));
            passenger_fare.set(i, a);
        }
        odometer = new_odo;
    }
}
