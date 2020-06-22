package com.gudyna.balls.generator;

import com.gudyna.balls.entity.Ball;
import com.gudyna.balls.entity.Color;
import com.gudyna.balls.exception.ProgramException;
import com.gudyna.balls.validator.BallValidator;

public class BallGenerator {
    public Ball generateBall(Color color, double weight) throws ProgramException {
        BallValidator ballValidator = new BallValidator();
        if (!ballValidator.checkWeight(weight)) {
            throw new ProgramException("incorrect parameters");
        }
        if (color == null) {
            throw new ProgramException("color does not exist");
        }
        return new Ball(weight, color);
    }
}
