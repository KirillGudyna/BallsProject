package com.gudyna.balls.validator;

import com.gudyna.balls.entity.Ball;
import com.gudyna.balls.entity.Basket;
import com.gudyna.balls.service.BasketService;

public class BasketValidator {
    private static final int MAX_SIZE = 15;
    private static final int MAX_CARRYING = 122;

    public boolean checkCarrying(double carrying) {
        return carrying > 0 && carrying <= MAX_CARRYING;
    }
    public boolean checkSize(int size){
        return size > 0 && size <= MAX_SIZE;
    }
    public boolean isFit(Basket basket, Ball ball) {
        BasketService basketService = new BasketService();
        double weightBalls = basketService.calculateTotalWeight(basket);
        int numberBalls = basket.getBalls().size();
        int maxNumbers = basket.getSize();
        return basket.getCarrying() - weightBalls - ball.getWeight() >= 0 && numberBalls+1 <= maxNumbers;
    }
}
