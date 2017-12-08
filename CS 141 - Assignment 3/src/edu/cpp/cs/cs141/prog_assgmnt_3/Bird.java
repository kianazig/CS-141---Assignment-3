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

/**
 * @author kiana
 *
 */
public class Bird extends Animal{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static enum Type{PARAKEET, COCKATIEL, CONURE, PARROT, OTHER};
	private Type type;
	
	/**
	 * Creates a Bird, calling the superclass constructor
	 * @param owner the owner's name
	 * @param name the bird's name
	 * @param age the bird's age
	 */
	public Bird(String owner, String name, int age) {
		super(owner, name, age);
	}
	
	@Override
	public void setSubtype(String subtype) {
		if (subtype.equalsIgnoreCase("Parakeet")) {
			type = Type.PARAKEET;
		}
		else if (subtype.equalsIgnoreCase("Cockatiel")) {
			type = Type.COCKATIEL;
		}
		else if (subtype.equalsIgnoreCase("Conure")) {
			type = Type.CONURE;
		}
		else if (subtype.equalsIgnoreCase("Parrot")) {
			type = Type.PARROT;
		}
		else if (subtype.equalsIgnoreCase("Other")) {
			type = Type.OTHER;
		}
	}

	@Override
	public String getSubtype() {
		return type.toString().substring(0, 1).toUpperCase()+type.toString().substring(1).toLowerCase();
	}
	
	@Override
	public String[] getSubtypeOptions() {
		String[] subtypeOptions = new String[5];
		subtypeOptions[0] = "Parakeet";
		subtypeOptions[1] = "Cockatiel";
		subtypeOptions[2] = "Conure";
		subtypeOptions[3] = "Parrot";
		subtypeOptions[4] = "Other";
		return subtypeOptions;
	}
	
	public String getType() {
		return "Bird";
	}
}
