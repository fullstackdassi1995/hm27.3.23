package org.example;

import java.util.Random;

import static org.example.Main.*;


public class OlympicRunner extends Thread{
    protected String city;
    protected Integer meter = 0;
    Random random = new Random();

    private boolean firstJump = true;


    public OlympicRunner(String city) {
        this.city = city;
    }
    public void run(){
        while (!gameOver.get()){
            int nextJump = random.nextInt(2000);
            int kodemMeter = this.meter;


                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if (meter >= 45000){
                    gameOver.set(true);
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    this.meter = 45000;
                    System.out.println("the winner is " + this.city + " " + this.meter);
                    gameOver();
                    break;
                }

                if (gameOver.get()){
                    break;
                }
                else

                meter+= nextJump;

            if (this.meter > 100){
                boom1(kodemMeter);}
            if (this.meter > 0){
            System.out.println(this.city + " " + this.meter);}
        }
    }


    public void  boom1(int kodemMeter){
       // pause.set(true);
        try {
            sleep(15);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (mapDistance.containsKey(meter)){
            if (!firstJump){
                mapDistance.remove(kodemMeter);
            }

            // pause.set(false);
            String kodemCity = mapDistance.get(meter).city;
            System.out.println(this.city + " and" + "==================== " + kodemCity + " met and reset");

            mapDistance.get(meter).meter = 0;
            mapDistance.remove(meter);
            this.meter = 0;
            mapDistance.put(meter, this);

        }
        else{
            if (!firstJump){
            mapDistance.remove(kodemMeter);}
            mapDistance.put(meter, this);
        }
        firstJump = false;
    }


public void gameOver(){
    if (gameOver.get()){
        OlympicRunner.currentThread().stop();
    }
}
}
