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
import java.io.Serializable;

/**
 * @author kiana
 *
 */
public abstract class Animal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4030284787888364693L;
	private String owner;//should be Owner????
	private String name;
	private int age;
	private ArrayList<String> vaccinations;
	private ArrayList<Appointment> currentAppointments;
	private ArrayList<String> currentDiseases;
	private ArrayList<String> pastDiseases;
	
	/**
	 * Constructor for an Animal. Initializes owner, name, and age.
	 * @param owner2 owner's name
	 * @param name2 animal's name
	 * @param age2 animal's age
	 */
	public Animal(String owner2, String name2, int age2) {
		owner = owner2;
		name = name2;
		age = age2;
		currentAppointments = new ArrayList<Appointment>();
	}
	
	/**
	 * Returns the species of the animal 
	 * @return A String representing the species of the animal (Dog/Bird/Fish)
	 */
	public abstract String getType();
	
	/**
	 * Sets the specific variety of the species 
	 * @param subtype the subtype of the animal based on their species
	 */
	public abstract void setSubtype(String subtype);
	
	/**
	 * Returns the specific variety of the species
	 * @return the subtype of the animal based on their species
	 */
	public abstract String getSubtype();
	
	/**
	 * Returns the subtype options for the animal, which is specific to their species
	 * @return the subtype options for the animal, which is specific to their species
	 */
	public abstract String[] getSubtypeOptions();
	
	/**
	 * Sets the animal's vaccinations
	 * @param vac ArrayList<String> Representing the animals vaccinations
	 */
	public void setVaccinations(ArrayList<String> vac){
		vaccinations = vac;
	}
	
	/**
	 * Adds an appointment for the animal
	 * @param app the appointment that is added
	 */
	public void addAppointment(Appointment app) {
		currentAppointments.add(app);
	}
	
	/**
	 * Removes an appointment for the animal
	 * @param app the appointment that is removed
	 */
	public void removeAppointment(Appointment app) {
		currentAppointments.remove(app);
	}
	
	public ArrayList<Appointment> getAppointments() {
		return currentAppointments;
	}
	
	/**
	 * Sets the current diseases for the animal
	 * @param dis list of current diseases
	 */
	public void setCurrentDiseases(ArrayList<String> dis) {
		currentDiseases = dis;
	}
	
	/**
	 * Sets the past diseases for the animal
	 * @param dis list of past diseases
	 */
	public void setPastDiseases(ArrayList<String> dis) {
		pastDiseases = dis;
	}
	
	/**
	 * Adds diseases to the list of current diseases
	 * @param disease the diseases that are added to the list
	 */
	public void addCurrentDisease(ArrayList<String> disease) {
		for (String dis : disease) {
			currentDiseases.add(dis);
		}
	}
	
	/**
	 * Removes a disease from the list of current diseases and adds it to past
	 * diseases
	 * @param disease the disease that is being changed
	 */
	public void changeDiseaseToPast(String disease) {
		currentDiseases.remove(disease);
		pastDiseases.add(disease);
	}
	
	/**
	 * Changes the animal's age
	 * @param a the new age
	 */
	public void changeAge(int a) {
		age = a;
	}
	
	/**
	 * Adds vaccinations to the list of animal's vaccinations
	 * @param vac the vaccinations that are added
	 */
	public void addVaccinations(ArrayList<String> vac) {
		for (String v : vac) {
			vaccinations.add(v);
		}
	}
	
	/**
	 * Returns the animal's name
	 * @return the animal's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the owner's name
	 * @return the owner's name
	 */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * Returns the animal's age
	 * @return the animal's age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Returns a list of the animal's vaccinations
	 * @return a list of the animal's vaccinations
	 */
	public ArrayList<String> getVaccinations(){
		return vaccinations;
	}
	
	/**
	 * Returns a list of the animal's past diseases
	 * @return a list of the animal's past diseases
	 */
	public ArrayList<String> getPastDiseases(){
		return pastDiseases;
	}
	
	/**
	 * Returns a list of the animal's current diseases
	 * @return a list of the animal's current diseases
	 */
	public ArrayList<String> getCurrentDiseases(){
		return currentDiseases;
	}
}
