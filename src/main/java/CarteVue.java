package com.example.myunogame;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class CarteVue extends StackPane {
    public CarteVue(String couleur, String valeur) {
        Rectangle fond = new Rectangle(60, 90);
        fond.setArcWidth(15);
        fond.setArcHeight(15);
        fond.setFill(Color.web(getColorFromCarte(couleur)));

        fond.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.25), 4, 0, 2, 2);");

        Text texteValeur = new Text(valeur);
        texteValeur.setFill(Color.WHITE);
        texteValeur.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        getChildren().addAll(fond, texteValeur);
        setAlignment(Pos.CENTER);
        setStyle("-fx-border-color: black; -fx-border-width: 1px;");
    }

    private String getColorFromCarte(String couleur) {
        switch (couleur) {
            case "Rouge": return "#FF3B30";
            case "Jaune": return "#FFCC00";
            case "Vert": return "#34C759";
            case "Bleu": return "#007AFF";
            case "Noir": return "#8E8E93";
            default: return "#FFFFFF";
        }
    }
}