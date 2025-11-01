package com.spacegame;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Canvas canvas = new Canvas(800, 600);
        root.getChildren().add(canvas);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("2D Space Game");
        stage.setResizable(false);
        stage.show();

        GraphicsContext gc = canvas.getGraphicsContext2D();
        new Game(gc, scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
