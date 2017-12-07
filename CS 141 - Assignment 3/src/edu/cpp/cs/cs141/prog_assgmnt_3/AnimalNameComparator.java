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
public class AnimalNameComparator implements Comparator<Animal>{

	@Override
	public int compare(Animal o1, Animal o2) {
		String name1 = o1.getName().toUpperCase();
		String name2 = o2.getName().toUpperCase();
		return name1.compareTo(name2);
	}

}
