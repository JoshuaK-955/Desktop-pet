package org.example.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Window with MenuBar");

        // Create the MenuBar
        MenuBar menuBar = new MenuBar();

        Image gifImage = new Image("");
        ImageView gifView = new ImageView(gifImage);

        gifView.setFitWidth(200);
        gifView.setPreserveRatio(true);

        // Create Menus
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");

        Menu reminders = new Menu("Reminders");
        Menu insight = new Menu("Insight");

        // Add MenuItems to File menu
        MenuItem newItem = new MenuItem("New");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> primaryStage.close());

        fileMenu.getItems().addAll(newItem, new SeparatorMenuItem(), exitItem);

        // Add Menus to MenuBar
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, insight, reminders);

        // Main content
        Label label = new Label("Hello, JavaFX with MenuBar!");
        Button button = new Button("Click Me");
        button.setOnAction(e -> label.setText("Button Clicked!"));

        VBox content = new VBox(10, gifView, button);
        content.setStyle("-fx-padding: 10;");

        // Use BorderPane to put MenuBar at the top
        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(content);

        Scene scene = new Scene(root, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
