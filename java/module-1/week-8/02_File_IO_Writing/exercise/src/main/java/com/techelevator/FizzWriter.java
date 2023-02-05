package com.techelevator;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		FizzWriter fizzWriter = new FizzWriter();
		fizzWriter.run();

	}

	public void run() {
		/* Your code goes here */
		System.out.print("What is the destination file:  ");
		String sourcefilepath = userInput.nextLine();

		File sourceFile= new File(sourcefilepath);

		int lineCount = 0;
		try(PrintWriter writer = new PrintWriter(sourceFile)) {

			for (int i=0;i<300;i++){
				lineCount++;
				if(lineCount%15==0){
					writer.println("FizzBuzz");
				} else if (lineCount%5==0){
					writer.println("Buzz");
				} else if(lineCount%3==0){
					writer.println("Fizz");
				} else{
					writer.println(lineCount);
				}
			}
			

		} catch (Exception e){
			System.out.println("File not found");

		}



				}
			}









