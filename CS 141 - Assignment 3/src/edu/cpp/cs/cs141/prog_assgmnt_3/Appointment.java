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

import java.io.Serializable;

/**
 * @author kiana
 *
 */
public class Appointment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[] date;
	private String time;
	private boolean status;
	private Animal animal;
	private Owner client;
	
	/**
	 * Creates an appointment, initializing the client and the animal.
	 * @param cli the client
	 * @param an the animal
	 */
	public Appointment(Owner cli, Animal an) {
		client = cli;
		animal = an;
		status = true;
	}
	
	/**
	 * Sets the date of the appointment
	 * @param d A 3 element integer array representing the date. The first element represents
	 * the month, the second represents the day, and the third represents the year
	 */
	public void setDate(int[] d) {
		date = d;
	}
	
	/**
	 * Sets the time of the appointment
	 * @param t the time of the appointment (as a String)
	 */
	public void setTime(String t) {
		time = t;
	}
	
	/**
	 * Returns the date of the appointment
	 * @return A 3 element integer array representing the date. The first element represents
	 * the month, the second represents the day, and the third represents the year
	 */
	public int[] getDate() {
		return date;
	}

	/**
	 * Returns the client the appointment is for
	 * @return the client the appointment is for
	 */
	public Owner getOwner() {
		return client;
	}
	
	/**
	 * Returns the animal the appointment is for
	 * @return the animal the appointment is for
	 */
	public Animal getAnimal() {
		return animal;
	}
	
	/**
	 * Returns the time the appointment is for
	 * @return the time the appointment is for (as a String)
	 */
	public String getTime() {
		return time;
	}
	
	/**
	 * Returns the status of the appointment (either Outstanding or Resolved)
	 * @return the status of the appointment (either Outstanding or Resolved)
	 */
	public boolean getStatus() {
		return status;
	}
	
	/**
	 * Changes the status of the appointment from outstanding to resolved or from 
	 * resolved to outstanding. 
	 */
	public void changeStatus() {
		status=!status;
	}
}
