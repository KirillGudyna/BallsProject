package com.gudyna.balls.generator;

import com.gudyna.balls.entity.Ball;
import com.gudyna.balls.entity.Basket;
import com.gudyna.balls.entity.Color;
import com.gudyna.balls.exception.ProgramException;
import com.gudyna.balls.service.BasketService;
import com.gudyna.balls.validator.BasketValidator;

import java.util.ArrayList;
import java.util.List;

public class BasketGenerator {
    public Basket createBasket(double carrying, int size, List<Ball> balls) throws ProgramException {
        BasketValidator basketValidator = new BasketValidator();
        if (!basketValidator.checkCarrying(carrying) || !basketValidator.checkSize(size)) {
            throw new ProgramException("incorrect parameters");
        }
        if (balls == null) {
            throw new ProgramException("basket does not exist");
        }
        return new Basket(carrying, balls, size);
    }

    public Basket createTestBasket() {
        BallGenerator ballCreator = new BallGenerator();
        BasketService basketService = new BasketService();
        Basket basket = null;
        try {
            Ball ball1 = ballCreator.generateBall(Color.BLUE, 11.5);
            Ball ball2 = ballCreator.generateBall(Color.BLACK, 8.5);
            Ball ball3 = ballCreator.generateBall(Color.GREY, 11.0);
            Ball ball4 = ballCreator.generateBall(Color.PURPLE, 3.0);
            Ball ball5 = ballCreator.generateBall(Color.BLUE, 12.0);
            basket = createBasket(100.0, 15, new ArrayList<>());
            basketService.putBall(ball1, basket);
            basketService.putBall(ball2, basket);
            basketService.putBall(ball3, basket);
            basketService.putBall(ball4, basket);
            basketService.putBall(ball5, basket);
        } catch (ProgramException e) {
            e.getMessage();
        }
        return basket;
    }
}
