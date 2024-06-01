package com.example.tugas5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        Label loginLabel = new Label("Halaman Login Siswa");

        Label userLabel = new Label("Username:");
        TextField userField = new TextField();

        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();

        Button loginButton = new Button("Login");

        loginButton.setOnAction(e -> {
            String username = userField.getText();
            String password = passField.getText();

            if (username.equals("NIXL") && password.equals("kerennn")) {
                showWelcomePage(primaryStage, username);
            } else {
                showAlert("Username / Password salah");
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(userLabel, 0, 0);
        gridPane.add(userField, 1, 0);
        gridPane.add(passLabel, 0, 1);
        gridPane.add(passField, 1, 1);
        gridPane.add(loginButton, 1, 2);

        VBox vbox = new VBox(10, loginLabel, gridPane);
        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showWelcomePage(Stage primaryStage, String username) {
        Stage welcomeStage = new Stage();
        welcomeStage.setTitle("Welcome");

        Label welcomeLabel = new Label("Halo " + username);
        Button backButton = new Button("Back");

        backButton.setOnAction(e -> {
            welcomeStage.close(); // Close the welcome stage
            primaryStage.show();  // Show the login stage again
        });

        VBox vbox = new VBox(10, welcomeLabel, backButton);
        Scene scene = new Scene(vbox, 300, 200);

        welcomeStage.setScene(scene);
        welcomeStage.show();

        primaryStage.hide(); // Hide the login stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}
