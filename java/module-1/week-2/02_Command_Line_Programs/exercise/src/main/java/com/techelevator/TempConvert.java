package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		System.out.print("Enter Tempature in Celsius or Fahrenheit.");


		int temperatureCelsius = (temperatureFarenheit - 32) / 1.8;
		int temperatureFarenheit = temperatureCelsius * 1.8 + 3;
		System.out.println(temperatureCelsius);

	}

}
