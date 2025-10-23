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

    private Set<KeyCode> activeKeys; // stores which keys are being pressed

    private boolean isRunning = true; // keeps the game loop going

}

