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
public class AppointmentYearComparator implements Comparator<Appointment>{

	@Override
	public int compare(Appointment o1, Appointment o2) {
		// TODO Auto-generated method stub
		return o1.getDate()[2]-o2.getDate()[2];
	}

}
