package com.techelevator;

public class Example1 {

	public static void main(String[] args) {

		/*
		1. What is 5 divided by 2?
		Evaluates to 2 - what's happening is truncation, not rounding.
		In integer division, Java removes anything to the right of the
		decimal point.
		*/
		System.out.println("Question 1: ");
		System.out.println(5 / 2);

		/*
		2. What is 5.0 divided by 2? (Or 5 divided by 2.0?)
		When one value is a double and the other an integer, Java uses
		floating-point division.
		*/
		System.out.println("Question 2: ");
		System.out.println(5.0 / 2);

		/*
		3. What is 66.6 divided by 100?
		This demonstrates imprecision when doing math with doubles. Has
		to do with how they're stored under the hood; Java has trouble
		precisely storing decimal data in binary format.
		*/
		System.out.println("Question 3: ");
		System.out.println(66.6/100);

		/*
		4. If I divide 5 by 2, what's my remainder?
		Modulus operator gives you the remainder.
		*/
		System.out.println("Question 4: ");
		System.out.println(5 % 2);

		/*
		5. What is 1,000,000,000 * 3?
		Integer overflow occurs if you use ints instead of longs. To avoid
		this, we need a data type that holds more data.
		*/
		long billion = 1_000_000_000; //An int won't work.
		long threeBillion = billion * 3;
		System.out.println("Question 5: ");
		System.out.println(threeBillion);

		// Declaring a variable
		int numberOfPeople;             // declare an integer called numberOfPeople
		double gallonsOfGas;            // declare a double called gallonsOfGas
		boolean isRaining;              // declare a boolean called isRaining
		boolean isCloudy;               // declare a boolean called isCloudy
		char firstLetter;               // declare a char called firstLetter

		// Assigning a variable
		numberOfPeople = 16;            // assign the integer 16 to the numberOfPeople variable
		gallonsOfGas = 3.26;            // assign the double 3.26 to the gallonsOfGas variable
		isRaining = true;               // assign the boolean true to the isRaining variable
		firstLetter = 'a';              // assign the character 'a' to the firstLetter variable

		isCloudy = isRaining;           // copy the value from isRaining into the isCloudy variable
		
	}

}
