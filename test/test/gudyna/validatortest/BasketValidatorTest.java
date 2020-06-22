package test.gudyna.validatortest;

import com.gudyna.balls.entity.Ball;
import com.gudyna.balls.entity.Basket;
import com.gudyna.balls.entity.Color;
import com.gudyna.balls.generator.BasketGenerator;
import com.gudyna.balls.validator.BasketValidator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BasketValidatorTest {
    BasketValidator basketValidator;
    Basket basket;

    @BeforeMethod
    public void setUp() {
        basketValidator = new BasketValidator();
        BasketGenerator basketGenerator = new BasketGenerator();
        basket = basketGenerator.createTestBasket();
    }

    @Test
    public void checkCarryingTestPositive() {
        double carrying = 75.0;
        boolean condition = basketValidator.checkCarrying(carrying);
        assertTrue(condition);
    }

    @Test
    public void checkCarryingTestNegative() {
        double carrying = 125.0;
        boolean condition = basketValidator.checkCarrying(carrying);
        assertFalse(condition);
    }

    @Test
    public void isFitTestPositive() {
        Ball ball = new Ball(10.0, Color.BLUE);
        boolean condition = basketValidator.isFit(basket, ball);
        assertTrue(condition);
    }

    @Test
    public void isFitTestNegative() {
        Ball ball = new Ball(101.0, Color.BLUE);
        boolean condition = basketValidator.isFit(basket, ball);
        assertFalse(condition);
    }
}

