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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author kiana
 *
 */
public class SystemManager {
	
	
	private UserInterface ui;
	private Comparator<Animal> animalNameComp;
	private Comparator<Animal> animalOwnerComp;
	private Comparator<Appointment> appointmentDateComp;
	private Comparator<Appointment> appointmentMonthComp;
	private Comparator<Appointment> appointmentYearComp;
	private Comparator<Appointment> appointmentOwnerComp;
	private FileOutputStream fos;
	private ObjectOutputStream oos;
	private FileInputStream fis;
	private ObjectInputStream  ois;
	private ArrayList<Owner> clients;
	private ArrayList<Animal> animals;
	private ArrayList<Appointment> appointments;
	
	public SystemManager() {
		ui = new UserInterface();
		animalNameComp = new AnimalNameComparator();
		animalOwnerComp = new AnimalOwnerComparator();
		appointmentDateComp = new AppointmentDateComparator();
		appointmentMonthComp = new AppointmentMonthComparator();
		appointmentYearComp = new AppointmentYearComparator();
		appointmentOwnerComp = new AppointmentOwnerComparator();
		clients = new ArrayList<Owner>();
		animals = new ArrayList<Animal>();
		appointments = new ArrayList<Appointment>();//NOT SURE IF NEEDED BECUASE CLIENTS HAVE AN APP OBJECT
	}
	
	/**
	 * Saves the size of the ArrayList followed by all of the objects inside it, for clients,
	 * animals, and appointments.
	 */
	public void saveData() {
		File save = new File("save.dat");
		try {
			fos = new FileOutputStream(save);
			oos = new ObjectOutputStream(fos);
			oos.writeInt(clients.size());
			for (Owner client : clients) {
				oos.writeObject(client);
			}
			oos.writeInt(animals.size());
			for (Animal animal : animals) {
				oos.writeObject(animal);
			}
			oos.writeInt(appointments.size());
			for (Appointment app : appointments) {
				oos.writeObject(app);
			}
			oos.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads off client, animal, and appointment objects, adding them to the appropriate ArrayLists
	 */
	public void loadData() {
		File save = new File("save.dat");
		try {
			fis = new FileInputStream(save);
			ois = new ObjectInputStream(fis);
			int numberOfClients = ois.readInt();
			for (int i=0; i<numberOfClients;i++) {
				clients.add((Owner) ois.readObject());
			}
			int numberOfAnimals = ois.readInt();
			for (int i=0; i<numberOfAnimals; i++) {
				animals.add((Animal) ois.readObject());
			}
			int numberOfAppointments = ois.readInt();
			for (int i=0; i<numberOfAppointments; i++) {
				appointments.add((Appointment) ois.readObject());
			}
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Main loop that runs the program, directing different methods to execute based on 
	 * what the user wants to do. 
	 */
	public void runProgram() {
		ui.printWelcomeMessage();
		loadData();
		while (true) {
			int choice = ui.printMainMenu();
			if(choice == 1) {
				searchAppointments();
				int input = ui.viewSpecific(true, appointments.size());
				if (input!=0) {
					editAppointment(input);
				}
			}
			else if (choice == 2) {
				Animal an = searchMedicalRecords();//TESTED
				if (an != null) {
					ui.printSpecificMedicalHistory(an);
					editOrViewAppointment(an);
				}
			}
			else if (choice == 3) {
				addClient();//TESTED
			}
			else if (choice == 4) {
				addAnimal();//TESTED 
			}
			else if (choice == 5) {
				saveData();
				System.exit(0);
			}
		}
	}
	
	/**
	 * Calls the UI to ask which aspects of the appointment the user wants to change, and then 
	 * changes them appropriately. 
	 * @param app the appointment that's being edited
	 */
	public void editAppointment(int app) {
		int choice = 1;
		while (choice == 1) {
			ui.printAppointmentDetails(appointments.get(app-1));
			int input2 = ui.appointmentOptions();
			if (input2 == 1) {
				int editChoice = ui.editAppointment();
				if (editChoice == 1) {
					appointments.get(app-1).setDate(ui.askAppointmentDate());
					choice = ui.printAppointmentEdited();
				}
				else if (editChoice == 2) {
					appointments.get(app-1).setTime(ui.askAppointmentTime());
					choice = ui.printAppointmentEdited();
				}
				else if (editChoice == 3) {
					appointments.remove(appointments.get(app-1));
					for (Animal an : animals) {
						for (Appointment appoint : an.getAppointments()) {
							if (appoint.equals(appointments.get(app-1))){
								an.removeAppointment(appoint);
							}
						}
					}
					ui.printAppointmentRemoved();
					choice = 0;
				}
			}
			else 
				break;
		}
	}


	/**
	 * Allows the user to either view existing appointments or add an appointment for a 
	 * particular animal
	 * @param animal the animal that appointments are being viewed/added for 
	 */
	private void editOrViewAppointment(Animal animal) {
		int choice = ui.askCheckOrAddApp();
		if (choice == 1) {
			if (!animal.getAppointments().isEmpty()) {
				for (Appointment app : animal.getAppointments()) {
					ui.printAppointmentDetails(app);
				}
			}
			else {
				ui.printNoAppointments();
			}
		}
		else if (choice == 2) {
			int i = 0;
			for (Owner cli : clients) {
				if (animal.getOwner().equalsIgnoreCase(cli.getName()))
					break;
				else 
					i++;
			}
			addAppointment(animal, clients.get(i));
		}
		else if (choice == 3) {
			editMedicalHistory(animal);
		}
	}
	
	public void editMedicalHistory(Animal animal) {
		int input = ui.editMedicalHistory();
		if (input == 1) {
			animal.changeAge(ui.askAge());
		}
		else if (input == 2) {
			animal.addVaccinations(ui.askVaccinationNames());
		}
		else if (input == 3) {
			animal.addCurrentDisease(ui.askMedicalHistory(true));
		}
		else if (input == 4) {
			for (String dis : animal.getCurrentDiseases()) {
				if (dis.equalsIgnoreCase(ui.printCurrentDiseases(animal))) {
					animal.changeDiseaseToPast(dis);
				}
			}
		}
	}

	/**
	 * Asks the UI for the user's desired appointment details and adds the appointment
	 * to the ArrayList
	 * @param animal the animal the appointment is being added for
	 * @param client the client the appointment is being added for
	 */
	private void addAppointment(Animal animal, Owner client) {
		Appointment app = new Appointment(client, animal);
		app.setDate(ui.askAppointmentDate());
		app.setTime(ui.askAppointmentTime());
		animal.addAppointment(app);//Just Added, Needs testing
		appointments.add(app);
	}

	/**
	 * Tells the UI to print all appointments either sorted by owner or by date based on 
	 * the user's input
	 */
	private void searchAppointments() {
		boolean searchByOwner = ui.askAppointmentSearchType();
		if (searchByOwner) {
			appointments.sort(appointmentOwnerComp);
		}
		else {//Search by date
			appointments.sort(appointmentDateComp);
			appointments.sort(appointmentMonthComp);
			appointments.sort(appointmentYearComp);
		}
		ui.printAppointments(appointments);
	}

	/**
	 * Calls the UI to print a list of medical records based on the user's chosen search criteria
	 * @return the animal that the user would like to see the specific details of 
	 */
	private Animal searchMedicalRecords() {
		int searchType = ui.askMedicalRecordSearchType();
		ArrayList<Animal> dogs = new ArrayList<Animal>();
		ArrayList<Animal> birds = new ArrayList<Animal>();
		ArrayList<Animal> fish = new ArrayList<Animal>();
		if (searchType==1) {
			animals.sort(animalNameComp);
			ui.printMedicalHistory(animals);
			int choice = ui.viewSpecific(false, animals.size());
			if (choice == 0)
				return null;
			else
				return animals.get(choice-1);
		}
		else if (searchType==2) {
			animals.sort(animalOwnerComp);
			ui.printMedicalHistory(animals);
			int choice = ui.viewSpecific(false, animals.size());
			if (choice == 0)
				return null;
			else
				return animals.get(choice-1);
		}
		else if (searchType==3) {
			for (Animal animal : animals) {
				if (animal.getType().equalsIgnoreCase("Dog"))
					dogs.add(animal);
			}
			ui.printMedicalHistory(dogs);
			int choice = ui.viewSpecific(false, dogs.size());
			if (choice == 0)
				return null;
			else
				return dogs.get(choice-1);
		}
		else if (searchType==4) {
			for (Animal animal : animals) {
				if (animal.getType().equalsIgnoreCase("Bird"))
					birds.add(animal);
			}
			ui.printMedicalHistory(birds);
			int choice = ui.viewSpecific(false, birds.size());
			if (choice == 0)
				return null;
			else
				return birds.get(choice-1);
		}
		else if (searchType == 5) {
			for (Animal animal : animals) {
				if (animal.getType().equalsIgnoreCase("Fish"))
					fish.add(animal);
			}
			ui.printMedicalHistory(fish);
			int choice = ui.viewSpecific(false, fish.size());
			if (choice == 0)
				return null;
			else
				return fish.get(choice-1);
		}
		return null;
	}

	/**
	 * Asks the UI for client information and adds a new Client to the ArrayList
	 */
	private void addClient() {
		ui.printAdd(true);
		String name = ui.askClientName();
		String address = ui.askAddress();
		String phoneNumber = ui.askPhoneNumber();
		Owner client = new Owner(name, address, phoneNumber);
		clients.add(client);
	}

	/**
	 * Asks the UI for animal information and adds a new Animal to the ArrayList
	 */
	private void addAnimal() {
		boolean validOwner = false;
		String owner="";
		ui.printAdd(false);
		boolean clear = true;
		while (!validOwner) {
			owner = ui.askOwnerName(clear);
			for (Owner tempOwner : clients) {
				if(owner.equalsIgnoreCase(tempOwner.getName().toString())) {
					validOwner = true;
					break;
				}
			}
			if(!validOwner)
				ui.printInvalidOwner();
			clear = false;
		}
		String name = ui.askAnimalName();
		int age = ui.askAge();
		String type = ui.askAnimalType();
		if (type.equalsIgnoreCase("Dog")) {
			animals.add(new Dog(owner, name, age));
		}
		else if (type.equalsIgnoreCase("Bird")) {
			animals.add(new Bird(owner, name, age));
		}
		else if (type.equalsIgnoreCase("Fish")) {
			animals.add(new Fish(owner, name, age));
		}
		int size = animals.size();
		String subtype = ui.askAnimalSubtype(type, animals.get(size-1).getSubtypeOptions());
		animals.get(size-1).setSubtype(subtype);
		ArrayList<String> vaccinations = new ArrayList<String>();
		ArrayList<String> currentDiseases = new ArrayList<String>();
		ArrayList<String> pastDiseases = new ArrayList<String>();
		if (ui.addHistory("vaccination")) {
			vaccinations = ui.askVaccinationNames();
			animals.get(size-1).setVaccinations(vaccinations);
		}
		if (ui.addHistory("medical")) {
			if (ui.addDiseases(true)) {
				currentDiseases = ui.askMedicalHistory(true);
				animals.get(size-1).setCurrentDiseases(currentDiseases);
			}
			if (ui.addDiseases(false)) {
				pastDiseases = ui.askMedicalHistory(false);
				animals.get(size-1).setPastDiseases(pastDiseases);
			}
		}
	}
}
