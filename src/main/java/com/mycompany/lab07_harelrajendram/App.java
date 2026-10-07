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
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
       move.setByY(-40);
       
       FadeTransition fade = new FadeTransition(Duration.seconds(2),ellipse);
       fade.setFromValue(1.0);
       fade.setToValue(0.30);
       
       ScaleTransition scale = new ScaleTransition(Duration.seconds(2),ellipse);
       scale.setToX(1.5);
       scale.setToY(1.5);
       
       RotateTransition rotate = new RotateTransition(Duration.seconds(2),ellipse);
       rotate.setFromAngle(0.0);
       rotate.setToAngle(45.0);
       
       SequentialTransition seq = new SequentialTransition(fade,scale,rotate,move);
       
       ParallelTransition paral = new ParallelTransition(pt,seq);
       
       Button start = new Button("start");
       start.setStyle("-fx-background-color:green");
       Button reset = new Button("reset");
       reset.setStyle("-fx-background-color:yellow");
       Button exit = new Button("exit");
       exit.setStyle("-fx-background-color:red");
       
       HBox buttonBox = new HBox();
       buttonBox.setAlignment(Pos.CENTER);
       buttonBox.getChildren().addAll(start,reset,exit);
       
       bPane.setBottom(buttonBox);
       
       start.setOnAction(e -> {
       paral.play();
       });
       
       reset.setOnAction(e -> {
       paral.stop();
       
       ellipse.setOpacity(1.0);
       ellipse.setScaleX(1.0);
       ellipse.setScaleY(1);
       ellipse.setRotate(0.0);
       ellipse.setTranslateY(0.0);       
       paral.jumpTo(Duration.ZERO);
       
       paral.playFromStart();
       });
       
       exit.setOnAction(e -> {
       Platform.exit();
               });
       
       paral.play();
       
       bPane.getChildren().addAll(myCircle,rect,M,N,P,Q,ellipse);

        var scene = new Scene(bPane, 740, 580);
        stage.setScene(scene);
        stage.setTitle(" Parralel Shape animations");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}