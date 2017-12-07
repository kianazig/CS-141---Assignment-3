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
public class AnimalOwnerComparator implements Comparator<Animal>{

	@Override
	public int compare(Animal o1, Animal o2) {
		String owner1 = o1.getOwner().toUpperCase();
		String owner2 = o2.getOwner().toUpperCase();
		return owner1.compareTo(owner2);
	}

}
