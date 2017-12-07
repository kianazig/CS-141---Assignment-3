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
public class Fish extends Animal{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8593757994194103326L;

	public static enum Type{GOLDFISH, BETTA, FRESHWATER, SALTWATER, OTHER};
	private Type type;
	
	public Fish(String owner, String name, int age) {
		super(owner, name, age);

	}
	
	@Override
	public void setSubtype(String subtype) {
		if (subtype.equalsIgnoreCase("Goldfish")) {
			type = Type.GOLDFISH;
		}
		else if (subtype.equalsIgnoreCase("Betta")) {
			type = Type.BETTA;
		}
		else if (subtype.equalsIgnoreCase("Freshwater")) {
			type = Type.FRESHWATER;
		}
		else if (subtype.equalsIgnoreCase("Saltwater")) {
			type = Type.SALTWATER;
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
		subtypeOptions[0] = "Goldfish";
		subtypeOptions[1] = "Betta";
		subtypeOptions[2] = "Freshwater";
		subtypeOptions[3] = "Saltwater";
		subtypeOptions[4] = "Other";
		return subtypeOptions;
	}
	
	public String getType() {
		return "Fish";
	}
}
