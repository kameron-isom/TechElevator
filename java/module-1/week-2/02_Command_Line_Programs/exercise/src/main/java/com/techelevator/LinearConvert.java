package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Length");
		String value = input.nextLine();
		String nonValue = "not applicable";
		double lengthInput = Double.parseDouble(value);

		System.out.println("Enter if value is M for Meter and F for Feet");
		String valueOfChar = input.nextLine();

		if (valueOfChar.equals("M")) {
			double finalValue = lengthInput * 3.2808399;
			System.out.print("Length in Feet: " + finalValue);

		} else if (valueOfChar.equals("F")) {
			double finalValueF = lengthInput * 0.3048;
			System.out.println("Length in Meters: " + finalValueF);
		}

	}
}
