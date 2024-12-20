package com.example.myunogame;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HelloController {

    @FXML
    private VBox welcomePage;

    @FXML
    private VBox choosePlayersPage;

    @FXML
    private VBox gamePage;

    @FXML
    private HBox navigationBar;

    @FXML
    private ImageView backgroundImage;

    private int currentPage = 0;

    @FXML
    public void initialize() {
        // Charger le GIF global d'arrière-plan
        Image gif = new Image(getClass().getResourceAsStream("/images/uno_background.gif"));
        backgroundImage.setImage(gif);
    }

    @FXML
    protected void onStartButtonClick() {
        currentPage = 1;
        updatePage();
    }

    @FXML
    protected void onChooseTwoPlayers() {
        startGame();
    }

    @FXML
    protected void onChooseThreePlayers() {
        startGame();
    }

    @FXML
    protected void onChooseFourPlayers() {
        startGame();
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

    private void startGame() {
        currentPage = 2;
        updatePage();
    }

    private void updatePage() {
        welcomePage.setVisible(false);
        choosePlayersPage.setVisible(false);
        gamePage.setVisible(false);
        navigationBar.setVisible(true);

        switch (currentPage) {
            case 0:
                welcomePage.setVisible(true);
                navigationBar.setVisible(false);
                break;
            case 1:
                choosePlayersPage.setVisible(true);
                break;
            case 2:
                gamePage.setVisible(true);
                break;
            default:
                break;
        }
    }
}
