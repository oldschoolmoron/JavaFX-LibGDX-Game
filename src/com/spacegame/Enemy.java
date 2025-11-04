package com.spacegame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Enemy {

    private double x;
    private double y;
    private double width;
    private double height;
    private double speed;

    // constructor gives each enemy a position and speed
    public Enemy(double x, double y) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 20;
        this.speed = 2; // moves down slowly
    }

    // update position (moves enemy down the screen)
    public void update() {
        y += speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    // Draw the enemy
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillRect(x, y, width, height);
    }

    // Getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    // check if enemy goes off the screen
    public boolean isOffScreen() {
        return y > 600; // screen height from your Game.java
    }
}
