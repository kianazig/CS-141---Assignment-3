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
public class Dog extends Animal{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static enum Type{TOY, WORKING, SPORTING, HERDING, OTHER};
	private Type type;
	
	public Dog(String owner, String name, int age) {
		super(owner, name, age);

	}
	
	@Override
	public void setSubtype(String subtype) {
		if (subtype.equalsIgnoreCase("Toy")) {
			type = Type.TOY;
		}
		else if (subtype.equalsIgnoreCase("Working")) {
			type = Type.WORKING;
		}
		else if (subtype.equalsIgnoreCase("Sporting")) {
			type = Type.SPORTING;
		}
		else if (subtype.equalsIgnoreCase("Herding")) {
			type = Type.HERDING;
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
		subtypeOptions[0] = "Toy";
		subtypeOptions[1] = "Working";
		subtypeOptions[2] = "Sporting";
		subtypeOptions[3] = "Herding";
		subtypeOptions[4] = "Other";
		return subtypeOptions;
	}
	
	public String getType() {
		return "Dog";
	}
}
