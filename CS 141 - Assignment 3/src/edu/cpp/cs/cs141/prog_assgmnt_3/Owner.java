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
public class Owner implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7435676668760852013L;
	private String name;
	private String address;
	private String phoneNumber;
	
	/**
	 * Constructor for an Owner. Initializes name, address, and phone number.
	 * @param strName owner's name
	 * @param strAddress owner's address
	 * @param strNumber owner's phone number
	 */
	public Owner(String strName, String strAddress, String strNumber) {
		name = strName;
		address = strAddress;
		phoneNumber = strNumber;
	}
	
	/**
	 * Returns the owner's name
	 * @return owner's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the owner's address
	 * @return owner's address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Returns the owner's phone number
	 * @return owner's phone number (as a String)
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
}
