package com.gudyna.balls.validator;

public class BallValidator {
    private static final double MAX_WEIGHT = 20.0;

    public boolean checkWeight(double weight) {
        return weight > 0 && weight <= MAX_WEIGHT;
    }
}
