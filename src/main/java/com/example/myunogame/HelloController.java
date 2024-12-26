package com.example.myunogame;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloController {

    @FXML
    private VBox welcomePage;

    @FXML
    private VBox choosePlayersPage;

    @FXML
    private VBox gamePage;

    @FXML
    private HBox carteContainer;

    @FXML
    private HBox navigationBar;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private Button exitButton; // Quitter button

    @FXML
    private Button rulesButton; // Règles de Jeu button

    private int currentPage = 0;

    @FXML
    public void initialize() {
        // Load the background image
        if (backgroundImage != null) {
            Image gif = new Image(getClass().getResourceAsStream("/images/uno_background.gif"));
            backgroundImage.setImage(gif);
        }
        updatePage();
    }

    @FXML
    protected void onStartButtonClick() {
        currentPage = 1;
        updatePage();
    }

    @FXML
    protected void onChooseTwoPlayers() throws IOException {
        startGame(2);
    }

    @FXML
    protected void onChooseThreePlayers() throws IOException {
        startGame(3);
    }

    @FXML
    protected void onChooseFourPlayers() throws IOException {
        startGame(4);
    }

    @FXML
    protected void onRetourButtonClick() {
        if (currentPage > 0) {
            currentPage--;
            updatePage();
        }
    }

    @FXML
    protected void onSuivantButtonClick() {
        currentPage++;
        updatePage();
    }

    @FXML
    protected void onExitButtonClick() {
        Platform.exit();
    }

    @FXML
    protected void onRulesButtonClick() {
        try {
            // Create a new stage for the rules window
            Stage rulesStage = new Stage();
            rulesStage.setTitle("Règles du Jeu");
            rulesStage.initModality(Modality.APPLICATION_MODAL); // Block interaction with main window

            // Create a layout for the rules
            StackPane rulesLayout = new StackPane();
            rulesLayout.setStyle("-fx-padding: 20; -fx-background-color: #FFFFFF;");

            // Add rules content
            Label rulesLabel = new Label(
                    "Règles de UNO:\n\n" +
                            "1. Chaque joueur commence avec 7 cartes.\n" +
                            "2. Faites correspondre une carte par couleur ou par valeur.\n" +
                            "3. Les cartes spéciales incluent +2, +4, inverser, passer, et joker.\n" +
                            "4. Le premier joueur à se débarrasser de toutes ses cartes gagne.\n" +
                            "5. N'oubliez pas de dire 'UNO' lorsque vous avez une seule carte!"
            );
            rulesLabel.setWrapText(true);
            rulesLabel.setStyle("-fx-font-size: 14px; -fx-text-alignment: center;");

            rulesLayout.getChildren().add(rulesLabel);

            // Set the scene and show the rules window
            Scene scene = new Scene(rulesLayout, 400, 300);
            rulesStage.setScene(scene);
            rulesStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startGame(int numPlayers)  throws IOException{
        currentPage = 2;
        updatePage();
        displayCards(numPlayers);
    }

    private void updatePage() {
        // Hide all pages
        welcomePage.setVisible(false);
        choosePlayersPage.setVisible(false);
        gamePage.setVisible(false);
        navigationBar.setVisible(true);

        // Switch case to manage page visibility
        switch (currentPage) {
            case 0:
                welcomePage.setVisible(true);
                // Show Quitter and Règles de Jeu buttons only on the first page
                exitButton.setVisible(true);
                rulesButton.setVisible(true);
                navigationBar.setVisible(false); // Hide navigation bar on the welcome page
                break;
            case 1:
                choosePlayersPage.setVisible(true);
                // Hide buttons
                exitButton.setVisible(false);
                rulesButton.setVisible(false);
                break;
            case 2:
                gamePage.setVisible(true);
                // Hide buttons
                exitButton.setVisible(false);
                rulesButton.setVisible(false);
                break;
            default:
                break;
        }
    }

    private void displayCards(int numPlayers) throws IOException {
        carteContainer.getChildren().clear();

        for (int i = 0; i < numPlayers; i++) {
            CarteVue card = new CarteVue("Rouge", String.valueOf(i + 1));
            carteContainer.getChildren().add(card);
        }
    }
}