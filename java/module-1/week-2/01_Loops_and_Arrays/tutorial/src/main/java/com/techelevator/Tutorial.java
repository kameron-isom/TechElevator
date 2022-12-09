package com.techelevator;

public class Tutorial {

    public static void main(String[] args) {

        // write your code here

int i;
for (i=0; i<= 5; i++){
    System.out.println(i);
}

for (i= 10; i >=0; i--){
    System.out.println(i);
}
int [] forecastTemperatures= new int[15];
forecastTemperatures[0]= 72;
forecastTemperatures[1]=78;
forecastTemperatures [2]= 58;
forecastTemperatures [3]=79;
forecastTemperatures[4]= 74;
forecastTemperatures [2]= forecastTemperatures[2]+ 10;
for (i=0; i<forecastTemperatures.length; i++){
    System.out.println(forecastTemperatures[i]);
}
int highestTempatureValue = forecastTemperatures [0];
int highestTemperatureIndex = 0;
for (int j= 1; j < forecastTemperatures.length; j++) {
if (forecastTemperatures [j] > highestTempatureValue){
    highestTempatureValue = forecastTemperatures [j];
    highestTemperatureIndex= j;
    System.out.println("The highest temperature is" + highestTempatureValue);
    System.out.println( "The highestntemperature is in" + (highestTemperatureIndex + 1) + " days");
}
}
    }
}
