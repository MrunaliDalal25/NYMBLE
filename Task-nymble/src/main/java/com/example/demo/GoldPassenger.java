package com.example.demo;


	public class GoldPassenger extends Passenger {
	    public GoldPassenger(String name, int passengerNumber, double balance) {
	        super(name, passengerNumber, balance);
	    }

	   
		@Override
	    public boolean deductBalance(double amount) {
	        // Apply 10% discount for Gold passengers
	        double discountedAmount = amount * 0.9;
	        if (getBalance() >= discountedAmount) {
	            deductBalance(getBalance() - discountedAmount);
	            return true;
	        } else {
	            return false;
	        }
	    }
		private double getBalance() {
			// TODO Auto-generated method stub
			return 0;
		}
}
