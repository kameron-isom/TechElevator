package com.techelevator;

public class Television {
    // instance variables
    private boolean isOn;
    private int currentChannel =3;
    private int currentVolume =2;
    public static final int MAX_VOLUME= 10;
    public static final int MINIMUM_VOLUE =0;
    public static final int MAX_CHANNEL= 18;
    public static final int MINIMUM_CHANNEL= 3;

    // setters and getters


    public boolean isOn() {

        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }




    public int getCurrentVolume() {
        return currentVolume;
    }


    // set constructors



    public void turnOff() {


            this.isOn= false;




    }



    public void turnOn(){
            this.isOn =true;
            this.currentChannel = 3;
            this.currentVolume = 2;

    }
     public void changeChannel(int newChannel){
        if (isOn && newChannel>=3 && newChannel<=18 ){
            currentChannel = newChannel;
        }
        //if (!isOn){
        //currentChannel= currentChannel;
      //  }

    }
    public void channelUp(){
        if(isOn){
            currentChannel++;
        }
        if(isOn && currentChannel>MAX_CHANNEL){
            currentChannel = MINIMUM_CHANNEL;
        }

    }
    public void channelDown(){
        if (isOn){
            currentChannel--;
        }
        if (isOn && currentChannel<MINIMUM_CHANNEL){
            currentChannel =MAX_CHANNEL;
        }

    }
   public void raiseVolume(){
        if (isOn && currentVolume<MAX_VOLUME){
            currentVolume++;
        }

    }
  public void lowerVolume(){
        if (isOn && currentVolume> MINIMUM_VOLUE){
            currentVolume--;
        }

    }

}
