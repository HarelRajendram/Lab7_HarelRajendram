package com.mycompany.lab07_harelrajendram;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
       BorderPane bPane = new BorderPane();
       
       Button start = new Button("start");
       Button reset = new Button("reset");
       Button exit = new Button("exit");
       
       Circle myCircle = new Circle(15,15,25);
       myCircle.setFill(Color.RED);
       
       Rectangle rect = new Rectangle(150,50,400,400);
       rect.setFill(null);
       rect.setStroke(Color.BLACK);
       
       Ellipse ellipse = new Ellipse(340,270,100,130);
       ellipse.setFill(Color.LIGHTBLUE);
      ellipse.setStroke(null);
       
       Text M = new Text(150,47,"M");
       Text N = new Text(550,47,"N");
       Text P = new Text(561,450,"P");
       Text Q = new Text(150,462,"Q");
       
       
       PathTransition pt = new PathTransition();
       
       pt.setDuration(Duration.millis(8000));
       pt.setNode(myCircle);
       pt.setPath(rect);
       pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
       
       TranslateTransition move = new TranslateTransition(Duration.seconds(2),ellipse);
       move.setToX(70);
       
       FadeTransition fade = new FadeTransition(Duration.seconds(2),ellipse);
       fade.setFromValue(1.0);
       fade.setToValue(0.30);
       
       ScaleTransition scale = new ScaleTransition(Duration.seconds(2),ellipse);
       scale.setToX(1.5);
       scale.setToY(1.5);
       
       RotateTransition rotate = new RotateTransition(Duration.seconds(2),ellipse);
       rotate.setFromAngle(0.0);
       rotate.setToAngle(45.0);
       
       bPane.getChildren().addAll(myCircle,rect,M,N,P,Q,ellipse);
       
       SequentialTransition seq = new SequentialTransition(fade,scale,rotate,move);
       
       ParallelTransition paral = new ParallelTransition(pt,seq);
       
       paral.play();
       
        var scene = new Scene(bPane, 740, 580);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}