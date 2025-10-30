package com.spacegame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;

import java.util.HashSet;
import java.util.Set;

public class Game {

    private GraphicsContext gc; // This lets us draw on the screen
    private Scene scene;        // this lets us handle keyboard input
    private Set<KeyCode> activeKeys; //stores which keys are being pressed

    private Player player; //inside the class

    public Game(GraphicsContext gc, Scene scene) {
        this.gc = gc;
        this.scene = scene;
        this.activeKeys = new HashSet<>();

        setupInput(); // handle key presses
        startGameLoop(); // start updating and drawing
    }

    private void setupInput() {
        scene.setOnKeyPressed(event -> activeKeys.add(event.getCode()));
        scene.setOnKeyReleased(event -> activeKeys.remove(event.getCode()));
    }

    private void startGameLoop() {
        player = new Player(380, 500); // roughly center bottom of the screen
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                render();
            }
        };
        timer.start();
    }
    private void update() {
        if (activeKeys.contains(KeyCode.LEFT)) {
            player.moveLeft();
        }
        if (activeKeys.contains(KeyCode.RIGHT)) {
            player.moveRight();
        }
        if (player.getX() < 0) {
            player.moveRight(); // push back inside
        }
        if (player.getX() > 760) { // 800 - 40 (player width)
            player.moveLeft(); // push back inside
        }
    }


    private void render() {
        // Clear the screen
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 800, 600);

        // Draw player
        player.draw(gc);

        // Text info.
        gc.setFill(Color.WHITE);
        gc.fillText("Use arrow keys to move", 330, 40);
    }
}

// TODO: Add enemies and bullets