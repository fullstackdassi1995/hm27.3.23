package org.example;

import java.util.Random;

import static org.example.Main.*;


public class OlympicRunner extends Thread{
    protected String city;
    protected Integer meter = 0;
    Random random = new Random();


    public OlympicRunner(String city) {
        this.city = city;
    }
    public void run(){
        while (!gameOver.get()){
            for (int i = 0; i < random.nextInt(20000)+500; i++) {
                if (meter == 45000){
                    gameOver.set(true);

                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("the winner is " + this.city + " " + this.meter);
                    gameOver();
                    break;
                }

                else meter++;

            }

            if (gameOver.get()){
                break;
            }


            try {
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.city + " " + this.meter);
            boom();
            meet.set(meter);
        }

    }

public void boom(){
        if (meet.get() == meter & meter > 100){
            meter = 0;
        }
}

public void gameOver(){
    if (gameOver.get()){
        OlympicRunner.currentThread().stop();
    }
}
}
