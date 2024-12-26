package com.example.myunogame;

import javafx.animation.ScaleTransition;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class CarteVue extends StackPane {

    private static final double CARD_WIDTH = 90;
    private static final double CARD_HEIGHT = 130;
    private static final double RADIUS = 15;
    private static final double CIRCLE_RADIUS = 20;

    private Rectangle fond;
    private Circle centreCircle;
    private Text centreText;
    private Image CarteImage;

    public CarteVue(String couleur, String valeur) throws IOException {
        // Create card background with rounded corners and a gradient effect
        fond = new Rectangle(CARD_WIDTH, CARD_HEIGHT);
        fond.setArcWidth(RADIUS);
        fond.setArcHeight(RADIUS);
        fond.setFill(getColorFromCarte(couleur));
        fond.setStroke(Color.BLACK);
        fond.setStrokeWidth(2);
        if (couleur=="Rouge"){
            FileInputStream inputstream = new FileInputStream("C:/MY-UNO-GAME/src/main/resources/images/Red 1.png");
            Image image = new Image(inputstream);
            ImageView imageView = new ImageView(image);

            //Setting the position of the image
            imageView.setX(100);
            imageView.setY(100);

            //setting the fit height and width of the image view
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            //Creating a Group object
            Group root = new Group(imageView);

            Scene scene = new Scene(root); // Réduction de la taille de la fenêtre à 400x400
        }

        // Create a shadow effect for 3D appearance
        //fond.setEffect(new javafx.scene.effect.DropShadow(10, 0, 5, Color.GRAY));

        // Create the circle in the center
       // centreCircle = new Circle(CIRCLE_RADIUS);
        //centreCircle.setFill(Color.WHITE);
       // centreCircle.setStroke(Color.BLACK);
       // centreCircle.setStrokeWidth(2);

        // Create text inside the circle
        //centreText = new Text(valeur);
       // centreText.setFill(Color.BLACK);
       // centreText.setFont(Font.font("Arial", 20));
       // centreText.setStyle("-fx-font-weight: bold;");

        // Create a StackPane to center the circle and text
        //StackPane centrePane = new StackPane(centreCircle, centreText);
       // StackPane.setAlignment(centrePane, Pos.CENTER);

        // Create the value text in the middle of the card
       // Text valueText = new Text(valeur);
        //valueText.setFill(Color.WHITE);
       // valueText.setFont(Font.font("Arial", 50));
       // valueText.setStyle("-fx-font-weight: bold;");

        // Add everything to the main StackPane
       // getChildren().addAll(fond, valueText, centrePane);
       // setAlignment(Pos.CENTER);

        // Apply hover effect for scaling and shadow
       // setOnMouseEntered(e -> applyHoverEffect());
        //setOnMouseExited(e -> removeHoverEffect());
    }

    // Helper method to get the solid color fill based on the card's color
    private Color getColorFromCarte(String couleur) {
        switch (couleur) {
            case "Rouge":
                return Color.rgb(255, 59, 48);  // Bright red
            case "Jaune":
                return Color.rgb(255, 204, 0);  // Bright yellow
            case "Vert":
                return Color.rgb(52, 199, 89);  // Bright green
            case "Bleu":
                return Color.rgb(0, 122, 255);  // Bright blue
            case "Noir":
                return Color.rgb(0, 0, 0);  // Black for special cards (e.g., Wild, +4)
            default:
                return Color.GRAY;  // Default to gray if the color is unrecognized
        }
    }

    // Apply hover effect (scaling the card up and adding a shadow)
    private void applyHoverEffect() {
        // Scale the card up slightly
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), this);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.play();

        // Add a more pronounced shadow effect on hover
        fond.setEffect(new javafx.scene.effect.DropShadow(15, 0, 10, Color.BLACK));
    }

    // Remove hover effect (restore original size and shadow)
    private void removeHoverEffect() {
        // Restore original size
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), this);
        scaleTransition.setToX(1.0);
        scaleTransition.setToY(1.0);
        scaleTransition.play();

        // Remove the hover shadow effect
        fond.setEffect(new javafx.scene.effect.DropShadow(10, 0, 5, Color.GRAY));
    }
}
