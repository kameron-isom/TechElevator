package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner input =  new Scanner(System.in);
		System.out.println("Enter a Number: ");
		String userInput = input.nextLine();

		int lastNum = Integer.parseInt(userInput);
		int prevNum = 1;
		System.out.println("0, 1");

		for (int i =1; i <= lastNum;) {
			System.out.print(", " + i);
			int tempNum = prevNum + i;
			prevNum = i;
			i = tempNum;
		}

	}

}
