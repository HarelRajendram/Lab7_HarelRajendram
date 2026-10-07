package com.mycompany.lab07_harelrajendram;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
       Pane pane = new Pane();
       Circle myCircle = new Circle(15,15,25);
       
       Rectangle rect = new Rectangle(150,50,400,400);
       rect.setFill(null);
       rect.setStroke(Color.BLACK);
       
       Ellipse ellipse = new Ellipse();
       
       PathTransition pt = new PathTransition();
       
       pt.setDuration(Duration.millis(10000));
       pt.setNode(myCircle);
       pt.setPath(rect);
       pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
       pt.setCycleCount(4);
       
       pane.getChildren().addAll(myCircle,rect);
       pt.play();
       
        var scene = new Scene(pane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}