package org.example.View;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Popup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class popup extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // set title for the stage
        primaryStage.setTitle("Desktop Pet");

        // create a button
        Button button = new Button("button");

        // create a tile pane
        TilePane tilepane = new TilePane();

        // create a label
        Label label = new Label("This is a Popup");

        // create a popup
        Popup popup = new Popup();

        // set background
        label.setStyle(" -fx-background-color: white;");

        // add the label
        popup.getContent().add(label);

        // set size of label
        label.setMinWidth(200);
        label.setMinHeight(50);

        // action event
        EventHandler<ActionEvent> event =
                new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent e)
                    {
                        if (!popup.isShowing())
                            popup.show(primaryStage);
                        else
                            popup.hide();
                    }
                };

        // when button is pressed
        button.setOnAction(event);

        // add button
        tilepane.getChildren().add(button);

        //gif
        Image gifImage = new Image(
                getClass().getResource("/dog-471_256.gif")
                        .toExternalForm()
        );
        ImageView imageView = new ImageView(gifImage);
        Group root = new Group(imageView);
        Scene scene = new Scene(root, 400, 200);

        // set the scene
        primaryStage.setScene(scene);

        // show on bottom right of screen
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double x = bounds.getMinX() + (bounds.getWidth() - scene.getWidth());
        double y = bounds.getMinY() + (bounds.getHeight() - scene.getHeight());
        primaryStage.setX(x);
        primaryStage.setY(y);

        primaryStage.show();
    }
}
