package org.example.View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.Model.Reminders;

public class popup extends Application {
    private Reminders remindersModel = new Reminders();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Set title for the stage
        primaryStage.setTitle("Desktop Pet");

        // Create main layout
        HBox mainLayout = new HBox(10); // 10 is the spacing between elements
        mainLayout.setPadding(new Insets(10));
        mainLayout.setStyle("-fx-background-color: white;");

        // Create the image view for the GIF
        Image gifImage = new Image(
                getClass().getResource("/dog-471_256.gif")
                        .toExternalForm()
        );
        ImageView imageView = new ImageView(gifImage);
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);

        // Create the right panel for question and buttons
        VBox questionPanel = new VBox(10);
        questionPanel.setAlignment(Pos.CENTER);

        // Get a random question from the Reminders model
        String randomQuestion = remindersModel.getRemindersArray();
        Label questionLabel = new Label(randomQuestion);
        questionLabel.setWrapText(true);
        questionLabel.setStyle("-fx-font-size: 14px;");

        // Create Yes/No buttons
        HBox buttonBox = new HBox(20);
        buttonBox.setAlignment(Pos.CENTER);

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        // Set button actions
        yesButton.setOnAction(event -> {
            // Handle "Yes" response
            primaryStage.hide();
        });

        noButton.setOnAction(event -> {
            // Handle "No" response
            questionLabel.setText("That's okay! Here's another question:\n" + remindersModel.getRemindersArray());
        });

        // Add buttons to the button box
        buttonBox.getChildren().addAll(yesButton, noButton);

        // Add question and buttons to the right panel
        questionPanel.getChildren().addAll(questionLabel, buttonBox);

        // Add the image and question panel to the main layout
        mainLayout.getChildren().addAll(imageView, questionPanel);

        // Create the scene
        Scene scene = new Scene(mainLayout, 500, 220);

        // Set the scene
        primaryStage.setScene(scene);

        // Position on bottom right of screen
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double x = bounds.getMinX() + (bounds.getWidth() - scene.getWidth());
        double y = bounds.getMinY() + (bounds.getHeight() - scene.getHeight());
        primaryStage.setX(x);
        primaryStage.setY(y);

        // Make window always on top
        primaryStage.setAlwaysOnTop(true);

        // Remove window decorations for a cleaner look (optional)
        // primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.show();
    }
}
