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
	
	
	public Animal(String owner2, String name2, int age2) {
		owner = owner2;
		name = name2;
		age = age2;
	}
	
	public abstract String getType();
	public abstract void setSubtype(String subtype);
	public abstract String getSubtype();
	public abstract String[] getSubtypeOptions();
	
	public void setVaccinations(ArrayList<String> vac){
		vaccinations = vac;
	}
	
	public void addAppointment(Appointment app) {
		currentAppointments.add(app);
	}
	
	public void setCurrentDiseases(ArrayList<String> dis) {
		currentDiseases = dis;
	}
	
	public void setPastDiseases(ArrayList<String> dis) {
		pastDiseases = dis;
	}
	
	public String getName() {
		return name;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public int getAge() {
		return age;
	}
	
	public ArrayList<String> getVaccinations(){
		return vaccinations;
	}
	
	public ArrayList<String> getPastDiseases(){
		return pastDiseases;
	}
	
	public ArrayList<String> getCurrentDiseases(){
		return currentDiseases;
	}
}
