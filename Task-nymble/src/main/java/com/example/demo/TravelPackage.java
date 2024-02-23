package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    public void addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
        } else {
            System.out.println("Cannot add passenger, package is full.");
        }
    }

    public void bookActivityForPassenger(Passenger passenger, Activity activity) {
        if (!passengers.contains(passenger)) {
            System.out.println("Passenger is not enrolled in this travel package.");
            return;
        }
        
        if (!activity.hasSpace()) {
            System.out.println("Activity is full, cannot book for passenger.");
            return;
        }
        
        if (passenger instanceof StandardPassenger) {
            double cost = activity.getCost();
            if (!((StandardPassenger) passenger).deductBalance(cost)) {
                System.out.println("Insufficient balance, cannot book for passenger.");
                return;
            }
        } else if (passenger instanceof GoldPassenger) {
            double cost = activity.getCost() * 0.9; // 10% discount
            if (!((GoldPassenger) passenger).deductBalance(cost)) {
                System.out.println("Insufficient balance, cannot book for passenger.");
                return;
            }
        }
        
        passenger.bookActivity(activity);
        activity.bookPassenger(passenger);
    }
    
    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity: " + activity.getName());
                System.out.println("Description: " + activity.getDescription());
                System.out.println("Cost: " + activity.getCost());
                System.out.println("Capacity: " + activity.getCapacity());
            }
        }
    }

    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println("Name: " + passenger.getName());
            System.out.println("Passenger Number: " + passenger.getPassengerNumber());
        }
    }
    
    public void printPassengerDetails(Passenger passenger) {
        System.out.println("Passenger Name: " + passenger.getName());
        System.out.println("Passenger Number: " + passenger.getPassengerNumber());
        if (passenger instanceof StandardPassenger || passenger instanceof GoldPassenger) {
            System.out.println("Balance: " + ((StandardPassenger) passenger).getBalance());
        }
        System.out.println("Activities Booked:");
        List<Activity> bookedActivities = passenger.getBookedActivities();
        for (Activity activity : bookedActivities) {
            System.out.println("- Activity: " + activity.getName());
            System.out.println("  Destination: " + activity.getDestination().getName());
            System.out.println("  Price Paid: " + activity.getCost());
        }
    }
}
