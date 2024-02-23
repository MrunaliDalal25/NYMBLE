package com.example.demo;

	
		public class StandardPassenger extends Passenger {
		    public StandardPassenger(String name, int passengerNumber, double balance) {
		        super(name, passengerNumber, balance);
		    }

		    @Override
		    public boolean deductBalance(double amount) {
		        if (getBalance() >= amount) {
		            setBalance(getBalance() - amount);
		            return true;
		        } else {
		            return false;
		        }
		    }
		    
		    // Getter and setter for balance
		    public double getBalance() {
		        return super.getBalance();
		    }

		    public void setBalance(double balance) {
		        super.setBalance(balance);
		    }
		}

