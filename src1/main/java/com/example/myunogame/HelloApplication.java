package com.example.myunogame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class  HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // Assurez-vous que le chemin du fichier FXML est correct
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/myunogame/hello-view.fxml"));



        //Passing FileInputStream object as a parameter
        FileInputStream inputstream = new FileInputStream("C:/MY-UNO-GAME/src/main/resources/images/uno_background.gif");
        Image image = new Image(inputstream);
        //Setting the image view
        ImageView imageView = new ImageView(image);

        //Setting the position of the image
        imageView.setX(50);
        imageView.setY(25);

        //setting the fit height and width of the image view
        imageView.setFitHeight(500);
        imageView.setFitWidth(900);


        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        //Creating a Group object
        Group root = new Group(imageView, fxmlLoader.load());

        Scene scene = new Scene(root); // Réduction de la taille de la fenêtre à 400x400
        String css = this.getClass().getResource("/com/example/myunogame/styles.css").toExternalForm();
        scene.getStylesheets().add(css);


//Loading image from URL
//Image image = new Image(new FileInputStream("url for the image));

        stage.setTitle("UNO GAME");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}