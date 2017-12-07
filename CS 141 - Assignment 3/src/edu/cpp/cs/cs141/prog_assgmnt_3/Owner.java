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
	
	public Owner(String strName, String strAddress, String strNumber) {
		name = strName;
		address = strAddress;
		phoneNumber = strNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
}
