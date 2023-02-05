package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public void run() {
        /* Your code goes here */

        System.out.println("What is the search word");
        String originalWord = userInput.nextLine();


        System.out.println("What is the replacement word");
        String replacementWord= userInput.nextLine();

        System.out.print("What is the source file: ");
        String sourcefilepath = userInput.nextLine();

        System.out.println("What is the destination file");
        String destinationFilePath= userInput.nextLine();

        File sourceFile= new File(sourcefilepath);
        File copyFile= new File(destinationFilePath);



        try(Scanner fileInput= new Scanner(sourceFile);
            PrintWriter writer =new PrintWriter(sourceFile)){

            while (fileInput.hasNextLine()){
                String lineOfText = fileInput.nextLine();



                writer.println(lineOfText.replace(originalWord,replacementWord));


            }

        } catch (FileNotFoundException e){
            System.out.println("File not Found");
        }




    }

}
