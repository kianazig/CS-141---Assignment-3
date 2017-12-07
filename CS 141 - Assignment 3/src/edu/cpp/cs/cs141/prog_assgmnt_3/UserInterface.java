/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment #3
 *
 * <Design the adminstrative program for a veterinary's office>
 *
 * Kiana Ziglari
 */

package edu.cpp.cs.cs141.prog_assgmnt_3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author kiana
 *
 */
public class UserInterface {
	
	Scanner keyboard;
	
	public UserInterface() {
		keyboard = new Scanner(System.in);
	}
	
	public void printWelcomeMessage() {
		System.out.println("Welcome!");
	}
	
	public int printMainMenu() {
		int choice;
		System.out.println("");
		System.out.println("What would you like to do?\n1: Search Appointments"
				+ "\n2: Search Medical Records\n3: Add A New Client"
				+ "\n4: Add A New Animal\n5: Quit");
		while (true) {
			try {
				choice = keyboard.nextInt();
				if (choice<1 || choice>5)
					System.out.println("Invalid Input. Please enter a number from 1-6.");
				else
					return choice;
			}
			catch(InputMismatchException ex) {
				System.out.println("Invalid Input. Please enter a number.");
				keyboard.nextLine();
			}
		}
	}
	
	//TESTED
	public boolean askAppointmentSearchType() {
		System.out.println("Would You Like To Search By:\n1: Owner\n2: Date");
		while (true) {
			try {
				int choice = keyboard.nextInt();
				if (choice == 1)
					return true;
				else if (choice == 2)
					return false;
				else 
					System.out.println("Invalid Input. Please enter either 1 or 2.");
			}
			catch(InputMismatchException ex) {
				System.out.println("Invalid Input. Please enter a number.");
				keyboard.nextLine();
			}
		}

	}
	
	//TESTED
	public int askMedicalRecordSearchType() {
		System.out.println("Would You Like To Search By:\n1: Animal Name"
				+ "\n2: Owner\n3: Animal Type");
		while (true) {
			int choice = keyboard.nextInt();
			try {
				if (choice==1)
					return 1;
				else if (choice==2)
					return 2;
				else if (choice==3)
					break;
				else
					System.out.println("Invalid Input. Please enter a number from 1-3.");
			}
			catch (InputMismatchException ex) {
				System.out.println("Invalid Input. Please enter a number.");
				keyboard.nextLine();
			}	
		}
		System.out.println("Would You Like To See The Medical Records For All"
				+ "\n1: Dogs\n2: Birds\n3: Fish");
		while (true) {
			int choice = keyboard.nextInt();
			try {
				if (choice==1)
					return 3;
				else if (choice==2)
					return 4;
				else if (choice==3)
					return 5;
				else
					System.out.println("Invalid Input. Please enter a number from 1-3.");
			}
			catch (InputMismatchException ex) {
				System.out.println("Invalid Input. Please enter a number.");
				keyboard.nextLine();
			}	
		}
	}
	
	//TESTED
	public void printAppointmentDetails(Appointment app) {
		System.out.println("\n--------------------------------------------------");
		String strStatus;
		String strMonth ="";
		if (app.getStatus())
			strStatus = "Outstanding";
		else
			strStatus = "Resolved";
		System.out.println("STATUS: "+strStatus+"\n");
		System.out.println("CLIENT: "+app.getOwner()+"\n");
		switch (app.getDate()[0]) {
		case 1:
			strMonth = "January";
			break;
		case 2:
			strMonth = "February";
			break;
		case 3:
			strMonth = "March";
			break;
		case 4:
			strMonth = "April";
			break;
		case 5:
			strMonth = "May";
			break;
		case 6:
			strMonth = "June";
			break;
		case 7:
			strMonth = "July";
			break;
		case 8:
			strMonth = "August";
			break;
		case 9:
			strMonth = "September";
			break;
		case 10:
			strMonth = "October";
			break;
		case 11:
			strMonth = "November";
			break;
		case 12:
			strMonth = "December";
			break;
		}
		System.out.println("DATE: "+strMonth+" "+app.getDate()[1]+", "+app.getDate()[2]);
		System.out.println("TIME: "+app.getTime());
		System.out.println("\nANIMAL NAME: "+app.getAnimal().getName());
		System.out.println("AGE: "+app.getAnimal().getAge());
		System.out.println("SPECIES: "+app.getAnimal().getType());
		System.out.println("SUBTYPE: "+app.getAnimal().getSubtype());
		System.out.println("--------------------------------------------------\n");
	}
	
	public void printNoAppointments() {
		System.out.println("\nThis animal has no outstanding appointments.");
	}
	
	public void printAppointmentAdded() {
		System.out.println("Your appointment was successfully added.");
	}
	
	public int appointmentOptions() {
		int choice;
		System.out.println("Would you like to:\n1: Edit this appointment\n"
				+ "2: Return to Main Menu");
		while (true) {
			try {
				choice = keyboard.nextInt();
				if (choice<1 || choice>2)
					System.out.println("Invalid Option. Please enter a number from 1-2.");
				else
					return choice;
			}
			catch(InputMismatchException ex) {
				System.out.println("Invalid Option. Please enter a number.");
				keyboard.nextLine();
			}
		}
	}
	
	//TESTED
	public int editAppointment() {
		int choice=0;
		boolean validInput = false;
		System.out.println("Would you like to:\n1: Change the Date\n2: Change the Time"
				+ "\n3: Change the Status to Resolved");
		while (!validInput) {
			validInput = true;
			try {
				choice = keyboard.nextInt();
				if (choice<1 || choice>3) {
					System.out.println("Invalid Option. Please enter a number from 1-3.");
					validInput = false;
				}
				else if (choice == 3) {
					System.out.println("Status Changed.");//TEST
				}
			}
			catch(InputMismatchException ex) {
				System.out.println("Invalid Option. Please enter a number.");
				validInput = false;
				keyboard.nextLine();
			}
		}
		return choice;
	}
	
	//TESTED
	public int printAppointmentEdited() {
		System.out.println("\nAppoitment succesfully edited. To return to the main menu enter 0."
				+ "\nTo return to the appointment details, enter 1.");
		while (true) {
			try {
				int input = keyboard.nextInt();
				if (input==0 || input==1)
					return input;
				else 
					System.out.println("Invalid Input. Please Enter 0 or 1.");
			}
			catch(InputMismatchException ex) {
				System.out.println("Invalid Option. Please enter a number.");
				keyboard.nextLine();
			}
		}

	}
	
	public void printAppointmentRemoved() {
		System.out.println("\nAppointment successfully removed. Returning to Main Menu.");
	}
	
	//TESTED
	public int[] askAppointmentDate() {
		int[] date = new int[3];
		date[0] = askMonth();
		date[1] = askDay(date[0]);
		date[2] = askYear();
		return date;
	}

	//TESTED
	private int askMonth() {
		String month;
		System.out.print("Month: ");
		keyboard.nextLine();
		while (true){
			month = keyboard.nextLine();
			if(month.equalsIgnoreCase("January") || month.equalsIgnoreCase("Jan")
					|| month.equalsIgnoreCase("Jan.") || month.equals("01") || month.equals("1"))
				return 1;
			else if(month.equalsIgnoreCase("February") || month.equalsIgnoreCase("Feb")
					|| month.equalsIgnoreCase("Feb.") || month.equals("02") || month.equals("2"))
				return 2;
			else if(month.equalsIgnoreCase("March") || month.equalsIgnoreCase("Mar")
					|| month.equalsIgnoreCase("Mar.") || month.equals("03") || month.equals("3")) 
				return 3;
			else if(month.equalsIgnoreCase("April") || month.equalsIgnoreCase("Apr")
					|| month.equalsIgnoreCase("Apr.") || month.equals("04") || month.equals("4"))
				return 4;
			else if(month.equalsIgnoreCase("May") || month.equals("05") || month.equals("5"))
				return 5;
			else if(month.equalsIgnoreCase("June") || month.equalsIgnoreCase("Jun")
					|| month.equalsIgnoreCase("Jun.") || month.equals("05") || month.equals("6"))
				return 6;
			else if(month.equalsIgnoreCase("July") || month.equalsIgnoreCase("Jul")
					|| month.equalsIgnoreCase("Jul.") || month.equals("07") || month.equals("7"))
				return 7;
			else if(month.equalsIgnoreCase("August") || month.equalsIgnoreCase("Aug")
					|| month.equalsIgnoreCase("Aug.") || month.equals("08") || month.equals("8"))
				return 8;
			else if(month.equalsIgnoreCase("September") || month.equalsIgnoreCase("Sept")
					|| month.equalsIgnoreCase("Sept.")|| month.equals("09") || month.equals("9"))
				return 9;
			else if(month.equalsIgnoreCase("October") || month.equalsIgnoreCase("Oct") 
					|| month.equalsIgnoreCase("Oct.") || month.equals("10"))
				return 10;
			else if(month.equalsIgnoreCase("November") || month.equalsIgnoreCase("Nov") 
					|| month.equalsIgnoreCase("Nov.") || month.equals("11"))
				return 11;
			else if (month.equalsIgnoreCase("December") || month.equalsIgnoreCase("Dec") 
					|| month.equalsIgnoreCase("Dec.") || month.equals("12"))
				return 12;
			else {
				System.out.println("Invalid Input, Please Try Again.\nYou can enter the month name, abbreviation, or number.");
			}
		}
	}

	//TESTED
	private int askDay(int month) {
		int day;
		while (true){
			System.out.print("Day: ");
			try {
				day = keyboard.nextInt();
				if(day>0 && day<32 && (month==1||month==3||month==5||month==7||month==8||month==10||month==12))
					return day;
				else if(day>0 && day<31 && (month==4||month==6||month==9||month==11))
					return day;
				else if (day>0 && day<30 && month==2)
					return day;
				else 
					System.out.println("This day doesn't exist in this month!");
			}
			catch (InputMismatchException ex) {
				System.out.println("Invalid Input. Please enter a valid number.");
				keyboard.nextLine();
			}	
		}
	}
	
	//TESTED
	private int askYear() {
		int year;
		while (true) {
			System.out.print("Year: ");
			try {
				year = keyboard.nextInt();
				if (year>=2017 && year<3000)
					return year;
				else
					System.out.println("Please enter a valid number.");
			}
			catch (InputMismatchException ex) {
				System.out.println("Invalid Input. Please enter a number.");
				keyboard.nextLine();
			}
		}
	}
	
	public String askAppointmentTime() {
		String time;
		System.out.print("Time: ");
		keyboard.nextLine();
		while (true) {
			boolean validNumber = true;
			time = keyboard.nextLine();
			int j=0;
			for (int i=0; i<time.length(); i++) {
				if (time.length()<4 || time.length()>5)
					validNumber = false;
				else if (!Character.isDigit(time.charAt(i))&&time.charAt(i)!=':') {
					validNumber = false;
				}
				else if (time.charAt(i)==':') {
					j++;
					if (i==1) {
						if (time.charAt(0)=='0' || time.charAt(2)=='6'|| time.charAt(2)=='7'
								|| time.charAt(2)=='8'|| time.charAt(2)=='9') 
							validNumber = false;
					}
					else if (i==2) {
						if (time.charAt(0)!='0' && time.charAt(0)!='1')
							validNumber = false;
						else if (time.charAt(1)!='0' && time.charAt(1)!='1' && time.charAt(1)!='2')
							validNumber = false;
						else if (time.charAt(3)=='6'|| time.charAt(3)=='7'|| time.charAt(3)=='8'
								|| time.charAt(3)=='9')
							validNumber = false;
					}
					else
						validNumber = false;
				}
			}
			if (j!=1)
				validNumber = false;
			if (validNumber)
				return time;
			else {
				System.out.println("Please enter a valid time.");
			}
		}
	}
	
	//TESTED
	public String askAnimalType() {
		String type;
		System.out.print("Type Of Animal: ");
		keyboard.nextLine();
		while (true) {
			type = keyboard.nextLine();
			if (type.equalsIgnoreCase("Dog"))
				return "Dog";
			else if (type.equalsIgnoreCase("Bird"))
				return "Bird";
			else if (type.equalsIgnoreCase("Fish"))
				return "Fish";
			else
				System.out.println("Invalid Type. Please Enter Dog/Bird/Fish.");
		}
	}
	
	//TESTED
	public String askAnimalSubtype(String type, String[] subtypeOption) {
		String subtype="";
		boolean validInput = false;
		System.out.println("What type of "+type.toLowerCase()+" is this?");
		for (int i=0; i<subtypeOption.length; i++) {
			if (i==(subtypeOption.length-1))
				System.out.print(subtypeOption[i]);
			else 
				System.out.print(subtypeOption[i]+"/");
		}
		System.out.print(": ");
		while (!validInput) {
			subtype = keyboard.nextLine();
			for (String sub : subtypeOption) {
				if (subtype.equalsIgnoreCase(sub)) {
					validInput = true;
					break;
				}
			}
			if (!validInput) {
				System.out.println("This is not a valid option. Please try again.");
			}
		}
		return subtype;
	}
	
	//TESTED
	public String askOwnerName(boolean clear) {
		System.out.print("Owner: ");
		if (clear)
			keyboard.nextLine();
		return keyboard.nextLine();
	}
	
	//TESTED
	public void printInvalidOwner() {
		System.out.println("This owner doesn't exist in the system. Please try again.");
	}
	
	//TESTED
	public String askAnimalName() {
		System.out.print("Name: ");
		return keyboard.nextLine();
	}
	
	//TESTED
	public int askAge() {
		int age;
		while (true) {
			System.out.print("Age: ");
			try {
				age = keyboard.nextInt();
				if (age<1)
					System.out.println("Invalid Age.");
				else
					return age;
			}
			catch(InputMismatchException ex) {
				System.out.println("Invalid Input. Please enter a number.");
				keyboard.nextLine();
			}
		}
	}
	
	//TESTED
	public String askClientName() {
		System.out.print("\nName: ");
		keyboard.nextLine();
		return keyboard.nextLine();
	}
	
	//TESTED
	public String askAddress() {
		String address;
		boolean validInput = false;
		System.out.println("\nAddress Information");
		System.out.print("Address Line 1: ");
		String strAddress = keyboard.nextLine();
		System.out.print("City: ");
		String city = keyboard.nextLine();
		System.out.print("State/Province/Region: ");
		String state = keyboard.nextLine();
		int zip=0;
		while (!validInput) {
			System.out.print("Zip Code: ");
			try {
				zip = keyboard.nextInt();
				if (Integer.toString(zip).length()!=5) {
					System.out.println("Please enter a 5 digit number.");
				}
				else 
					validInput = true;
			}
			catch (InputMismatchException ex) {
				System.out.println("Invalid Input. Please enter a number.");
				keyboard.nextLine();
			}
		}
		address = strAddress +"\n"+city +", "+state+" "+ Integer.toString(zip);
		return address;
	}
	
	//TESTED
	public String askPhoneNumber() {
		String phoneNumber="";
		boolean validInput = false;
		System.out.print("\nPhone Number: ");
		keyboard.nextLine();
		while(!validInput) {
			validInput = true;
			phoneNumber = keyboard.nextLine();
			if (phoneNumber.length()!=10) {
				System.out.println("Please enter a 10 digit number.");
				validInput = false;
			}
			else {
				for (int i=0; i<phoneNumber.length(); i++) {
					if (!Character.isDigit(phoneNumber.charAt(i))) {
						System.out.println("Invalid Input. Please enter a number without any"
								+ " special characters.");
						validInput = false;
						break;
					}
				}
			}
		}
		System.out.println("\nClient Sucessfully Added.\n");
		return phoneNumber;
	}
	
	//TESTED
	public void printAdd(boolean client) {
		String str;
		if (client)
			str = "client";
		else 
			str = "animal";
		System.out.println("\nTo add a new "+str+", please fill out the following information.");
	}
	
	//TESTED
	public boolean addHistory(String type) {
		System.out.println("Would you like to add a "+type+" history?");
		while(true) {
			String choice = keyboard.nextLine();
			if (choice.equalsIgnoreCase("Y")||choice.equalsIgnoreCase("Yes"))
				return true;
			else if (choice.equalsIgnoreCase("N")||choice.equalsIgnoreCase("No"))
				return false;
			else
				System.out.println("Invalid Input. Please enter Yes or No.");
		}
	}
	
	//TESTED
	public ArrayList<String> askVaccinationNames() {
		ArrayList<String> vaccinations = new ArrayList<String>();
		while (true) {
			System.out.print("Vaccination: ");
			String vaccination = keyboard.nextLine();
			vaccinations.add(vaccination);
			System.out.println("Would you like to enter another vaccination?");
			boolean validInput = false;
			while(!validInput) {
				String choice = keyboard.nextLine();
				if (choice.equalsIgnoreCase("Yes")||choice.equalsIgnoreCase("Y"))
					validInput = true;
				else if (choice.equalsIgnoreCase("No")||choice.equalsIgnoreCase("N")) {
					validInput = true;
					return vaccinations;
				}
				else 
					System.out.println("Invalid Input. Please Enter Yes or No.");
			}
		}
	}
	
	//TESTED
	public ArrayList<String> askMedicalHistory(boolean current) {
		String status;
		ArrayList<String> diseases = new ArrayList<String>();
		if (current)
			status = "current";
		else 
			status = "past";
		System.out.println("List all "+status.toUpperCase()+" diseases only.");
		while (true) {
			System.out.print("Disease: ");
			String disease = keyboard.nextLine();
			diseases.add(disease);
			System.out.println("Would you like to enter another "+status+" disease?");
			boolean validInput = false;
			while(!validInput) {
				String choice = keyboard.nextLine();
				if (choice.equalsIgnoreCase("Yes")||choice.equalsIgnoreCase("Y"))
					validInput = true;
				else if (choice.equalsIgnoreCase("No")||choice.equalsIgnoreCase("N")) {
					validInput = true;
					return diseases;
				}
				else 
					System.out.println("Invalid Input. Please Enter Yes or No.");
			}
		}
	}

	//TESTED
	public void printMedicalHistory(ArrayList<Animal> animals) {
		int i=1;
		System.out.printf("\n   %-20S%-15S%-20S\n", "Animal Name", "Type", "Owner");
		System.out.println("-------------------------------------------------------");
		for (Animal animal: animals) {
			System.out.printf(i+": %-20s%-15s%-20s\n", animal.getName(), animal.getType(), animal.getOwner());
			i++;
		}
		System.out.println("\n");
	}
	
	//TESTED
	public void printSpecificMedicalHistory(Animal animal) {
		System.out.println("\n-------------------------------------------------------");
		System.out.println("ANIMAL NAME: "+animal.getName()+"\nAGE: "+animal.getAge());
		System.out.println("\nSPECIES: "+animal.getType()+"\nTYPE: "+animal.getSubtype());
		System.out.println("\nOWNER: "+animal.getOwner());
		System.out.println("\nVACCINATION HISTORY");
		if (animal.getVaccinations()==null) {
			System.out.println("This animal has no vaccination history.");
		}
		else {
			for (String vac : animal.getVaccinations()) {
				System.out.println( "  - " + vac);
			}
		}
		System.out.println("\nCURRENT DISEASES");
		if (animal.getCurrentDiseases()==null){
			System.out.println("This animal has no current diseases.");
		}
		else {
			for (String dis : animal.getCurrentDiseases()) {
				System.out.println("  - " + dis);
			}
		}
		System.out.println("\nPAST DISEASES");
		if (animal.getPastDiseases()==null) {
			System.out.println("This animal has no past diseases.");
		}
		else {
			for (String dis : animal.getPastDiseases()) {
				System.out.println("  - " + dis);
			}
		}
		System.out.println("-------------------------------------------------------");
	}
	
	//TESTED
	public int askCheckOrAddApp() {
		System.out.println("Would you like to: ");
		System.out.println("\n0: Go Back To The Main Menu\n1: Check This Animal's Appointments\n2: Add An Appointment For This Animal");
		while (true) {
			try {
				int choice = keyboard.nextInt();
				if (choice<0 | choice >2)
					System.out.println("Invalid Input. Please enter a number from 0-2.");
				else
					return choice;
			}
			catch (InputMismatchException ex) {
				System.out.println("Invalid Input. Please enter a number.");
				keyboard.nextLine();
			}
		}
	}

	//TESTED I THINK
	public void printAppointments(ArrayList<Appointment> appointments) {
		int i=1;
		System.out.printf("\n   %-20S%-15S%-20S\n", "Owner", "Date", "Animal Name");
		System.out.println("----------------------------------------------------");
		for (Appointment app: appointments) {
			String date = app.getDate()[0]+"/"+app.getDate()[1]+"/"+app.getDate()[2];
			System.out.printf(i+": %-20s%-15s%-20s\n", app.getOwner(), date, app.getAnimal().getName());
			i++;
		}
	}

	//NEEDS TESTING
	public int viewSpecific(boolean appointment, int numberOfOptions) {
		System.out.println("\nTo go back to the Main Menu, Enter 0.");
		if (appointment) {
			System.out.println("To view the details of a specific appoinment, enter the"
					+ " \nnumber of the appoinment you would like to see.");
		}
		else {
			System.out.println("To view the details of a specific animal's medical history,"
					+ " \nenter the number of the history you would like to see.");
		}
		while(true) {
			try {
				int choice = keyboard.nextInt();
				if (choice<0 || choice>numberOfOptions) {
					System.out.println("Invalid Input. Please enter a number from 0 - "+
							numberOfOptions+".");
				}
				else
					return choice;
			}
			catch (InputMismatchException ex) {
				System.out.println("Invalid Input. Please enter a number.");
				keyboard.nextLine();
			}
		}
	}
}
