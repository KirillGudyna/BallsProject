package test.gudyna.servicetest;

import com.gudyna.balls.entity.Ball;
import com.gudyna.balls.entity.Basket;
import com.gudyna.balls.entity.Color;
import com.gudyna.balls.exception.ProgramException;
import com.gudyna.balls.generator.BasketGenerator;
import com.gudyna.balls.service.BasketService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class BasketServiceTest {
    BasketService basketService;
    Basket basket;

    @BeforeMethod
    public void setUp() {
        basketService = new BasketService();
        BasketGenerator basketCreator = new BasketGenerator();
        basket = basketCreator.createTestBasket();
    }

    @Test
    public void numberOfBallsByColorTest() {
        int expected = 2;
        int actual = basketService.calculateNumberBallsByColor(Color.BLUE, basket);
        assertEquals(actual, expected);
    }

    @Test
    public void weightOfBallsTest() {
        double expected = 46.0;
        double actual = basketService.calculateTotalWeight(basket);
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void putBallTestException() {
        Ball ball = new Ball(15, Color.BLUE);
        Basket basket = new Basket(12.5, new ArrayList<>(), 15);
        try {
            basketService.putBall(ball, basket);
        } catch (ProgramException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void putBallTest() {
        Ball ball = new Ball(5.0, Color.BLACK);
        Basket basket = new Basket(50.0, new ArrayList<>(), 15);
        try {
            boolean condition = basketService.putBall(ball, basket);
            assertTrue(condition);
        } catch (ProgramException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void removeBallTest() {
        Ball expected = new Ball(11.5, Color.BLUE);
        try {
            Ball actual = basketService.removeBall(0, basket);
            assertEquals(expected, actual);
        } catch (ProgramException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void removeBallTestException() {
        Ball expected = new Ball(11.5, Color.BLUE);
        try {
            Ball actual = basketService.removeBall(-1, basket);
            assertEquals(expected, actual);
        } catch (ProgramException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void setBallTest() {
        Ball expected = new Ball(11.5, Color.BLUE);
        Ball ball = new Ball(4, Color.GREY);
        try {
            Ball actual = basketService.setBall(0, ball, basket);
            assertEquals(expected, actual);
        } catch (ProgramException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void setBallTestException() {
        Ball expected = new Ball(11.5, Color.BLUE);
        Ball ball = new Ball(4, Color.GREY);
        try {
            Ball actual = basketService.setBall(-1, ball, basket);
            assertEquals(expected, actual);
        } catch (ProgramException e) {
            fail(e.getMessage());
        }
    }
}
