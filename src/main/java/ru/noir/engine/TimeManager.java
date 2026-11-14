package ru.noir.engine;

//Полное управление временем
//Полное управление временем
public class TimeManager {
    private int currentHour = 9;
    private int currentMinute = 0;
    private int currentDay = 1;
    private double timeLeft = 48.0;

    public double getTimeLeft() {
        return timeLeft;
    }

    private void switchDay(){
        this.currentDay += 1;
    }

    public boolean isTimeOut(){
        return this.timeLeft <= 0;
    }

    private void hourSwitch(){
        if(this.currentHour == 23){
            this.currentHour = 0;
            this.switchDay();
        } else this.currentHour += 1;
    }

    public void addMinutes(int minutes){
        if(minutes < 60){
            this.currentMinute = minutes;
        }

        else{
            minutes -= 60;
            this.hourSwitch();
            addMinutes(minutes);
        }
    }


    public void setTimeLeft(int minutes){
        this.timeLeft = (this.timeLeft * 60 - minutes)/60;
    }

    @Override
    public String toString() {
        int hoursLeft = (int)this.timeLeft;
        double minutesLeft = (this.timeLeft - hoursLeft) * 60;
        return "День: " + this.currentDay + " " + String.format("%02d:%02d",this.currentHour, this.currentMinute)
                + " Осталось времени: " + String.format("%02d:%02.0f",hoursLeft, minutesLeft);
    }
}
