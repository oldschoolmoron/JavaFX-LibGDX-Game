package com.spacegame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;

import java.util.HashSet;
import java.util.Set;

public class Game {

    // Core Game Objects
    private GraphicsContext gc;   // Used for drawing on the Canvas
    private Scene scene;          // Used for keyboard input
    private Set<KeyCode> activeKeys; // Tracks pressed keys

    private Player player;        // Player object (must exist before game loop)

    //Constructor
    public Game(GraphicsContext gc, Scene scene) {
        this.gc = gc;
        this.scene = scene;
        this.activeKeys = new HashSet<>();

        setupInput();     // Prepare keyboard input
        startGameLoop();  // Start update + render loop
    }

    // Handle Keyboard Input
    private void setupInput() {
        scene.setOnKeyPressed(event -> activeKeys.add(event.getCode()));
        scene.setOnKeyReleased(event -> activeKeys.remove(event.getCode()));
    }

    //Start Animation Timer Loop
    private void startGameLoop() {

        // Initialize player (center bottom)
        player = new Player(380, 500);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();   // Game logic
                render();   // Drawing
            }
        };

        timer.start();
    }

    // Game Logic
    private void update() {

        // Move player left / right
        if (activeKeys.contains(KeyCode.LEFT)) {
            player.moveLeft();
        }
        if (activeKeys.contains(KeyCode.RIGHT)) {
            player.moveRight();
        }

        // Keep player inside screen bounds
        if (player.getX() < 0) {
            player.moveRight(); // Push back into bounds
        }
        if (player.getX() > 760) {  // 800 - playerWidth(40)
            player.moveLeft();      // Push back into bounds
        }

        // OPTIONAL BETTER VERSION (future)
        // player.setX(Math.max(0, Math.min(player.getX(), 760)));
    }

    //Draw Everything
    private void render() {

        // Paint background
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 800, 600);

        // Draw player
        player.draw(gc);

        // On-screen help text
        gc.setFill(Color.WHITE);
        gc.fillText("Use arrow keys to move", 330, 40);
    }
}
