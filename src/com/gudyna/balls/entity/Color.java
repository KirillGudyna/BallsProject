package com.gudyna.balls.entity;

public enum Color {
    BLACK ("black"),
    WHITE ("white"),
    BLUE ("blue"),
    GREY("grey"),
    GREEN("green"),
    YELLOW ("yellow"),
    PURPLE ("purple");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
