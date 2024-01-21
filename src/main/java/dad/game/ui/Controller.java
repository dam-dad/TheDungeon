package dad.game.ui;

import dad.game.demo.GameController;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;


public class Controller implements Initializable {

    private MenuController menuController;
    private GameController gameController;


    Media media;
    MediaPlayer mediaPlayer;


    @FXML
    private BorderPane view;


    public Controller() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Controller.fxml"));
        loader.setController(this);
        loader.load();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            menuController = new MenuController();
            gameController = new GameController();
            view.setCenter(menuController.getView());
        } catch (Exception e) {
            e.printStackTrace();
        }

        menuController.buttonPressedProperty().addListener((o, ov, nv) -> sepulsoboton());
        menuController.pdfButtonPressedProperty().addListener((o, ov, nv) -> sepulsobotonPDF(o, ov, nv));
        menuController.controlMusicButtonPressedProperty().addListener((o, ov, nv) -> sepulsobotonControlMusica(o, ov, nv));

        App.playMusic("music");
    }

    private void sepulsobotonControlMusica(ObservableValue<? extends Boolean> o, Boolean ov, Boolean nv) {
        App.stopMusic();
        App.playMusic("music");
    }

    private void sepulsobotonPDF(ObservableValue<? extends Boolean> o, Boolean ov, Boolean nv) {
    }

    private void sepulsoboton() {
        Platform.runLater(() -> {
            try {
                view.setCenter(gameController.getView());
                gameController.startGame();
            } catch (Exception e) {
                e.printStackTrace();
                // Agrega aquí el manejo de excepciones según tus necesidades
            }
        });
    }

    public BorderPane getView() {
        return view;
    }


}
