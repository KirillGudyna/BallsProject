package test.gudyna.entitytest;

import com.gudyna.balls.entity.Ball;
import com.gudyna.balls.entity.Basket;
import com.gudyna.balls.entity.Color;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;


public class TestBasket {
    private Basket basket;

    @BeforeTest
    public void setBasket() {
        basket = new Basket(11, new ArrayList<>(), 11);
    }

    @Test
    public void addTest() {
        Ball ball = new Ball(1, Color.BLACK);
        boolean condition = basket.add(ball);
        assertTrue(condition);
    }

    @Test
    public void addNullTest() {
        Ball ball = null;
        boolean condition = basket.add(ball);
        assertFalse(condition);
    }

    @Test
    public void removeTest() {
        Ball ball = new Ball(1, Color.BLACK);
        basket.add(ball);
        Ball actual = basket.remove(1);
        assertEquals(ball, actual);
    }

    @Test
    public void removeNullTest() {
        Ball ball = new Ball(1, Color.BLACK);
        basket.add(ball);
        Ball actual = basket.remove(1);
        assertNull(actual);
    }

    @Test
    public void setTest() {
        Ball expected = new Ball(1, Color.BLACK);
        basket.add(expected);
        Ball ball1 = new Ball(2, Color.BLUE);
        Ball actual = basket.set(0, ball1);
        assertEquals(expected, actual);
    }
    @Test
    public void setNullTest() {
        Ball expected = new Ball(1, Color.BLACK);
        basket.add(expected);
        Ball actual = basket.set(0, null);
        assertNull(actual);
    }
}