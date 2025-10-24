package com.spacegame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.animation.AnimationTimer;

import java.util.HashSet;
import java.util.Set;

public class Game {

    private GraphicsContext gc; // This lets us draw on the screen
    private Scene scene;        // This lets us handle keyboard input

    private Set<KeyCode> activeKeys; // This stores which keys are being pressed

    private boolean isRunning = true; // Keeps the game loop going

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
        // Game logic goes here (movement, collisions, etc.)
        if (activeKeys.contains(KeyCode.LEFT)) {
            System.out.println("Moving left");
        }
        if (activeKeys.contains(KeyCode.RIGHT)) {
            System.out.println("Moving right");
        }
    }

    private void render() {
        gc.clearRect(0, 0, 800, 600);
        gc.fillText("Game Running...", 350, 300);
    }
}
