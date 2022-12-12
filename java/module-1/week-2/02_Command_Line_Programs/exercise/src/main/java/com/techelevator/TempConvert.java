package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter Temperature");
		String value = input.nextLine();
		String nonValue = "not applicable";
		double temperatureInput = Double.parseDouble(value);


		System.out.println("Enter F or C for Celcius or Farheniet");
		String charInput = input.nextLine();
		if (charInput.equals("F")) {
			double tempInF = temperatureInput * 1.8 + 32;


		}
		if (charInput.equals("C")) {
			double tempInC = (temperatureInput - 32) / 1.8;

		}


		System.out.println("Temparutre is" + temperatureInput);
	}
}






