package com.gudyna.balls.entity;

import java.util.Collections;
import java.util.List;

public class Basket {
    private double carrying;
    private int size;
    List<Ball> balls;

    public Basket(double carrying, List<Ball> balls, int size) {
        this.carrying = carrying;
        this.size = size;
        this.balls = balls;
    }

    public double getCarrying() {
        return carrying;
    }

    public void setCarrying(double carrying) {
        this.carrying = carrying;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public boolean add(Ball ball) {
        if (ball == null) {
            return false;
        }
        return balls.add(ball);
    }

    public Ball set(int index, Ball ball) {
        if (index < 0 || index >= balls.size() || ball == null) {
            return null;
        }
        return balls.set(index, ball);
    }

    public Ball remove(int index) {
        if (index<0 || index >= balls.size()) {
            return null;
        }
        return balls.remove(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Basket)) return false;
        Basket basket = (Basket) o;
        return Double.compare(basket.getCarrying(), getCarrying()) == 0 &&
                basket.getSize() == getSize() &&
                balls.equals(basket.balls);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(carrying);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (balls != null ? balls.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Basket{carrying=");
        sb.append(carrying);
        sb.append(", balls=");
        sb.append(balls);
        sb.append(", size=");
        sb.append(size);
        sb.append("}");
        return sb.toString();
    }
}
