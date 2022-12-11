package com.techelevator;

import java.util.Locale;
import java.util.Scanner;

public class Tutorial {

    public static void main(String[] args) {

//         ***********  Step 1: Use the *new* operator to create Strings on the Heap  *************

        char [] helloChars = new char []{'h', 'e', 'l', 'l', 'o','!'};
        String greeting = new String(helloChars);
        System.out.println("Greeting: " + greeting);



        // ***********  Step 2: Try out some String methods  *************

        System.out.println( "Please type sentence ");
        Scanner scanner = new Scanner(System.in);
        String sentence  = scanner.nextLine();
        System.out.println("Hello " + sentence + " !");
//
//
//        String uppercaseSentence = sentence.toUpperCase();
//        System.out.println(uppercaseSentence);
//
//        int firstspace = sentence.indexOf(" ");
//        if ( firstspace == -1){
//            System.out.println("The first word is "+ firstspace + " characters long");
//        } else {
//            System.out.println("The first word is " + firstspace + " characters long");
//        }
//
//        System.out.println(sentence.replace("the", "the one and only"));
//
//        String [] words = sentence.split(" ");
//        System.out.println("The words in this sentence:");
//        for (int i= 0; i < words.length; i++){
//            System.out.println(words[i]);
//        }


        // ***********  Step 3: Compare Strings  *************

        String secretWord = "Secret!";
        System.out.print("Enter the secret word (hint: it's '" + secretWord + "') ");
        String userSecretWord = scanner.nextLine();

        boolean matchEqualityOperator = secretWord == userSecretWord;
        System.out.println("Using '==': " + matchEqualityOperator);


    }
}
