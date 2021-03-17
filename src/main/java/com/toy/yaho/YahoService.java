package com.toy.yaho;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class YahoService {

    @Value("${who.am.i}")
    private String who;

    @HystrixCommand(fallbackMethod = "fallBackString")
    public String getWho() {
        randomlyRunLong();
        return who;
    }

    private void randomlyRunLong(){
        Random rand = new Random();

        int randomNum = rand.nextInt((3 - 1) + 1) + 1;

        if (randomNum==3)
            sleep();
    }

    private void sleep(){
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String fallBackString() {
        return "실패했지만 값을 주겠다.";
    }

}
