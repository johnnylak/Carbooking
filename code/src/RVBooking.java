import java.io.PrintWriter;
import java.util.Scanner;

/****************************************************************************************
 * class RVBooking extends CarBooking Course name: Programmng 1 Assessment:
 * Assignment 3 Release date: 28 April 2014
 * 
 * Implemented by Craig Hamilton on 25/08/2012 Adapted by: John Lakkis s3018841
 * 
 * You need to follow the specification and complete the implementation of this
 * RVBooking subclass
 ***************************************************************************************/

class RVBooking extends CarBooking {
	// instance variable
	private int RVWeight;

	// constructor
	public RVBooking(String bookingID, String registrationNumber,
			String vehicleDescription, int RVWeight) {
		super(bookingID, registrationNumber, vehicleDescription);
		this.RVWeight = RVWeight;
	}

	// accessor
	public int getRVWeight() {
		return this.RVWeight;
	}

	// if the vehicle is above 2000(kgs) adds .10 to each kilogram thereafter
	// otherwise uses getBookingFee method from the superclass
	public double getBookingFee() {
		if (this.RVWeight > 2000) {
			return super.getBookingFee() + ((this.getRVWeight() - 2000) * 0.10);
		} else {
			return super.getBookingFee();
		}
	}

	// prints the weight of the RV when called by displayVehicleManifest()
	public void printBookingSummary() {
		super.printBookingSummary();
		System.out.printf("\nVehicle Weight:\t" + this.getRVWeight());

	}

}
