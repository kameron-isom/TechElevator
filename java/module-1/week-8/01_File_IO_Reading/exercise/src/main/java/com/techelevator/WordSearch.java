package com.techelevator;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class WordSearch {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);
	//Prompt for file path

	public static void main(String[] args) {
		WordSearch wordSearch = new WordSearch();
		wordSearch.run();
	}

	public void run() {
		/* Your code goes here */
		System.out.println("What is the fully qualified name of the file that should be searched?");
		String filename = userInput.nextLine();


		File wordSearches = new File(filename);

		int lineNumber = 1;

		try (Scanner fileInput = new Scanner(wordSearches)) {

			System.out.println("What is the search word you are looking for?");
			String word = userInput.nextLine();

			System.out.println("Should the search be case sensitive? (Y\\N)");
			String casesSensitive = userInput.nextLine();
			boolean isCaseSensitive = casesSensitive.equalsIgnoreCase("Y");

			while (fileInput.hasNextLine()) {
				String currentLineOfText = fileInput.nextLine();
				if (isCaseSensitive) {
					if (currentLineOfText.contains(word)) {
						System.out.println(String.format("%d: %s", lineNumber, currentLineOfText));
					}
				} else {


					if (currentLineOfText.toLowerCase().contains(word.toLowerCase())) {
						System.out.println(String.format("%d: %s", lineNumber, currentLineOfText));

					}
				}
				lineNumber++;

			}

		} catch (Exception e) {
			System.out.println("The file was not found: ");

		}

	}
}


