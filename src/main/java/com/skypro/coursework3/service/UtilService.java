package com.skypro.coursework3.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class UtilService {
    private Random random;

    @Autowired
    public void setRandom(Random random) {
        this.random = random;
    }

    public int getRandomInt(int bound) {
        return random.nextInt(bound);
    }
}
