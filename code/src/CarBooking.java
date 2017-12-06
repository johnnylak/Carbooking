import java.io.*;
import java.util.Scanner;

/****************************************************************************************
 * class CarBooking
 * Course name: Programmng 1 Assessment: Assignment 3 Release date: 28 April
 * 2014
 * 
 * Implemented by Craig Hamilton on 28/04/2014 Adapted by: John Lakkis s3018841
 * 
 ***************************************************************************************/

public class CarBooking {
	// instance variables - Ass 2 Stage A requirement (i)
	private String bookingID;
	private String registrationNumber;
	private String vehicleDescription;
	private boolean insuranceIncluded;

	// class constants - Ass 2 Stage A requirement (ii)
	private static final double BASIC_BOOKING_FEE = 150;
	private static final double INSURANCE_SURCHARGE = 50;

	// constructor - Ass 2 Stage A requirement (iii)
	public CarBooking(String bookingID, String registrationNumber,
			String vehicleDescription) {
		this.bookingID = bookingID;
		this.registrationNumber = registrationNumber;
		this.vehicleDescription = vehicleDescription;

		insuranceIncluded = false;
	}

	// accessors - Ass 2 Stage A requirement (iv)
	public String getBookingID() {
		return bookingID;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	// getBookingFee() - Ass 2 Stage A requirement (vi)
	public double getBookingFee() {
		double bookingFee = BASIC_BOOKING_FEE;

		if (insuranceIncluded == true) {
			bookingFee = bookingFee + INSURANCE_SURCHARGE;
		}

		return bookingFee;
	}
	//displays the booking ID, Vehicle description, rego and fee.
	public void printBookingSummary() {
		System.out.printf("\n\nBooking id:\t" + this.bookingID
				+ "\nRegistration:\t" + this.registrationNumber
				+ "\nDescription:\t" + this.vehicleDescription
				+ "\nBooking Fee:\t$%.2f", this.getBookingFee());
	}

}
