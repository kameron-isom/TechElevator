package com.techelevator;

public class HomeworkAssignment {
    // add instance variables
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;


    // add getters and setters for each variable


    public int getEarnedMarks() {
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }



    public String getSubmitterName() {
        return submitterName;
    }



    public String getLetterGrade() {
        String letterGrade = "";
        double totalGrade = (double) earnedMarks/ possibleMarks *100 ;
        System.out.println( totalGrade);
        if(totalGrade >= 90){
            letterGrade="A";
        } else if(totalGrade >= 80) {
            letterGrade="B";
        } else if(totalGrade >= 70) {
            letterGrade= "C";
        } else if(totalGrade >= 60) {
            letterGrade ="D";
        } else if(totalGrade < 60) {
            letterGrade= "F";
        }
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {

        this.letterGrade = letterGrade;
    }

    public HomeworkAssignment(int possibleMarks, String submitterName){
        this.possibleMarks= possibleMarks;
        this.submitterName = submitterName;
    }

    public HomeworkAssignment(){

    }

}
