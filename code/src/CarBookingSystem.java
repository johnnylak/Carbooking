import java.io.*;
import java.util.Scanner;

/****************************************************************************************
 * class CarBookingSystem
 * Course name: Programmng 1 Assessment: Assignment 3 Release date: 28 April
 * 2014
 * 
 * Implemented by Craig Hamilton on 28/04/2014 Adapted by: John Lakkis s3018841
 * 
 * You should use this class as a starting point for your assignment 3 program.
 ***************************************************************************************/

public class CarBookingSystem {
	// array that stores both carBooking and RVBooing objects
	private static CarBooking[] cars = new CarBooking[10];
	static int counter = 0;

	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String response;
		char selection = '\0';

		do {
			// display menu options

			System.out.println("*** Ferry Ticketing system Menu ***");
			System.out.println();
			System.out.println("A   -   Add Car Bookings");
			System.out.println();
			System.out.println("B   -   Display Vehicle Registration Details");
			System.out.println();
			System.out.println("C   -   Display Booking Fee");
			System.out.println();
			System.out.println("D   -   Display RVBooking Weight");
			System.out.println();
			System.out.println("E   -   Display Vehicle Manifest");
			System.out.println();
			System.out.println("X   -   Exit");
			System.out.println();
			System.out.print("Enter your selection: ");

			// get user's response
			response = sc.nextLine().toUpperCase();

			System.out.println();

			// response is invalid if it is not 1 character in length
			if (response.length() != 1) {
				System.out
						.println("Error - you did not enter a valid menu option!");
			} else {
				selection = response.charAt(0);

				// process the user's selection
				switch (selection) {
				case 'A':
					addCarBookings();
					break;

				case 'B':
					displayRegistrationDetails();
					break;

				case 'C':
					displayBookingFee();
					break;

				case 'D':
					displayRVBookingWeight();
					break;

				case 'E':
					displayVehicleManifest();
					break;
				case 'X':
					System.out.println("Programing terminating - goodbye!");
					break;

				default:
					System.out
							.println("Error - you did not enter a valid menu option!");

				}
			}

			System.out.println();

		} while (selection != 'X');
	}

	// Prompts the user to enter a set of booking details and
	// creates the corresponding set of CarBooking and RVbooking objects
	// based on the user's input and stores them in the array.
	// asks user after each loop if they would like to proceed

	public static void addCarBookings() {

		char response = 'Y';

		do {

			System.out.println("\n VEHICLE BOOKING SYSTEM: \n");

			System.out
					.println("Booking type: [RV Booking or Car Booking? RV or C]");
			String bookingType = sc.nextLine().toUpperCase();

			System.out.println("Please enter the booking ID:");
			String bookingID = sc.nextLine();

			System.out.println("Please enter vehicle description:");
			String vehicleDescription = sc.nextLine();

			System.out.println("Please enter vehicle registration:");
			String registrationNumber = sc.nextLine();
			// if the vehicle is an RV asks for the weight
			if (bookingType.equals("RV")) {
				System.out.println("Please enter the weight of the vehicle:");
				int RVWwight = sc.nextInt();

				cars[counter] = new RVBooking(bookingID, vehicleDescription,
						registrationNumber, RVWwight);
				sc.nextLine();

			} else {
				cars[counter] = new CarBooking(bookingID, vehicleDescription,
						registrationNumber);

			}
			System.out.println("Would you like to add another vehicle? [Y/N]");
			response = sc.nextLine().toUpperCase().charAt(0);
			counter++;

		} while (response != 'N' && counter < 10);

	}

	// Displays the booking id and registration number for all
	// bookings in the system.
	public static void displayRegistrationDetails() {
		System.out.println("List of booking ID's and Registration Numbers: \n");

		for (int i = 0; i < counter; i++) {

			System.out.println("Booking Number: " + cars[i].getBookingID()
					+ ", Vehicle: " + cars[i].getRegistrationNumber());
		}
	}

	// Locates a Booking specified by the user and displays
	// the applicable booking fee to the screen.
	// prompts the user if the would like to perform another search
	public static void displayBookingFee() {
		Scanner scan = new Scanner(System.in);
		CarBooking temp = null;
		char response = 'Y';

		do {
			// ask user to enter a booking number to search
			System.out.println("\nBooking Fee Retrieval: \n");
			System.out.println("Enter booking ID:");
			String id = scan.next();
			// goes through the array to search for booking
			for (int i = 0; i < counter; i++) {
				// if the car is found in get stored in temp
				if (cars[i].getBookingID().compareToIgnoreCase(id) == 0) {
					temp = cars[i];
				}
			}
			// if no booking is found an error message will appear
			if (temp == null) {
				System.out.println("Error! Booking ID not found!");
				System.out
						.println("Would you like to perform another search? [Y/N]");
				response = scan.next().toUpperCase().charAt(0);
			}
			// if the booking is found is will be displayed
			else {
				System.out.println("Fee for booking " + temp.getBookingID()
						+ " is " + temp.getBookingFee());
				System.out
						.println("Would you like to perform another search? [Y/N]");
				response = scan.next().toUpperCase().charAt(0);
			}
		} while (response != 'N');

	}

	// Locates an RVbooking specified by the user and
	// displays the recorded weight of the recreational vehicle.
	public static void displayRVBookingWeight() {
		System.out.println("Printing weights of RV Bookings:\n");
		for (int i = 0; i < counter; i++) {
			if (cars[i] instanceof RVBooking) {
				System.out.printf("Booking ID: " + cars[i].getBookingID()
						+ "\tWeight:%d\n", ((RVBooking) cars[i]).getRVWeight());
			}

		}
	}

	// Displays a summary of all CarBooking and RVBooking details
	// currently stored in the system.
	public static void displayVehicleManifest() {

		System.out.println("Printing details of all bookings:\n");
		for (int i = 0; i < counter; i++) {
			cars[i].printBookingSummary();
		}
		// end of method
	}
}
