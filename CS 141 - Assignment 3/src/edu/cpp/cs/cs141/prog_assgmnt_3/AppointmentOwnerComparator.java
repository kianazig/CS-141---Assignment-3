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

import java.util.Comparator;

/**
 * @author kiana
 *
 */
public class AppointmentOwnerComparator implements Comparator<Appointment>{

	@Override
	public int compare(Appointment o1, Appointment o2) {
		String owner1 = o1.getOwner().getName().toUpperCase();
		String owner2 = o2.getOwner().getName().toUpperCase();
		return owner1.compareTo(owner2);
	}

}
