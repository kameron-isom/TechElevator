package com.lendingcatalog.util;

import com.lendingcatalog.util.exception.FileStorageException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileStorageService {

    // Requirement: File I/O
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileStorageException {

        try (FileOutputStream file = new FileOutputStream( filename, appendFile);
             PrintWriter writer = new PrintWriter(file)) {
            writer.println(contents);
        } catch (FileNotFoundException e){
           throw new FileStorageException("File "+ filename + "not found");
        } catch (Exception e){
           System.err.println("Error, unable to to identify error");
        }

    }

    public static List<String> readContentsOfFile(String filename) throws FileStorageException {
      List<String> content= new ArrayList<>();
        File file = new File(filename);
       try(Scanner readContents = new Scanner(file)){

           while (readContents.hasNextLine()){
               String lineOfText= readContents.nextLine();
               content.add(lineOfText);
           }

           } catch (Exception e){
           throw new FileStorageException("Error, unable to to identify error");
       }
        return content;
    }
}
