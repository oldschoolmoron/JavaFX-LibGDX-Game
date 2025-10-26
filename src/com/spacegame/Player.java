package com.spacegame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player {
    private double x;
    private double y;
    private double speed = 5; // how fast player moves

    public Player(double x, double y) {
        this.x = x;
        this.y = y;
    }
    // draws the player as a small circle (for now)
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.CYAN);
        gc.fillOval(x, y, 40, 40); // x, y, width, height
    }

    // Simple move methods, connect these later
    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    // Getter methods (optional now)
    public double getX() { return x; }
    public double getY() { return y; }
}
