package com.gudyna.balls.service;

import com.gudyna.balls.entity.Ball;
import com.gudyna.balls.entity.Basket;
import com.gudyna.balls.entity.Color;
import com.gudyna.balls.exception.ProgramException;
import com.gudyna.balls.validator.BasketValidator;

import java.util.List;

public class BasketService {
    public int calculateNumberBallsByColor(Color color, Basket basket) {
        int count = 0;
        List<Ball> balls = basket.getBalls();
        for (Ball item : balls) {
            if (item.getColor().equals(color)) {
                count++;
            }
        }
        return count;
    }

    public double calculateTotalWeight(Basket basket) {
        double totalWeight = 0;
        List<Ball> balls = basket.getBalls();
        for (Ball item : balls) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public boolean putBall(Ball ball, Basket basket) throws ProgramException {
        BasketValidator basketValidator = new BasketValidator();
        if (!basketValidator.isFit(basket, ball)) {
            throw new ProgramException("the ball cannot be placed in the basket");
        }
        return basket.add(ball);
    }

    public Ball setBall(int index, Ball ball, Basket basket) throws ProgramException {
        Ball oldValue = basket.set(index, ball);
        if (oldValue == null) {
            throw new ProgramException("there is not such ball in the basket");
        }
        return oldValue;
    }

    public Ball removeBall(int index, Basket basket) throws ProgramException {
        Ball removedBall = basket.remove(index);
        if (removedBall == null) {
            throw new ProgramException("there is not such ball in the basket");
        }
        return removedBall;
    }
}
