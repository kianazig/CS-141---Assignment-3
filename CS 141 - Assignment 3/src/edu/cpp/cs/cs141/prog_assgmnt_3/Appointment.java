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
	
	public Appointment(Owner cli, Animal an) {
		client = cli;
		animal = an;
		status = true;
	}
	
	public void setDate(int[] d) {
		date = d;
	}
	
	public void setTime(String t) {
		time = t;
	}
	
	public int[] getDate() {
		return date;
	}

	public Owner getOwner() {
		return client;
	}
	
	public Animal getAnimal() {
		return animal;
	}
	
	public String getTime() {
		return time;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void changeStatus() {
		status=!status;
	}
}
