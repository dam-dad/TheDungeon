package dad.game.ui;

import dad.game.demo.GameController;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Clase que controla el menu
 *
 * @author Javier Pérez
 */

public class Controller implements Initializable {

    Media media;
    MediaPlayer mediaPlayer;
    private MenuController menuController;
    private GameController gameController;
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
        if (nv) { // Si el nuevo valor es true, significa que el botón fue presionado
            try {
                // Asegúrate de que esta ruta corresponde a donde se guarda tu archivo PDF
                File pdfFile = new File("Score.pdf");
                if (pdfFile.exists()) {
                    // Abre el archivo PDF con la aplicación predeterminada
                    if (Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().open(pdfFile);
                    } else {
                        // Manejo en caso de que el escritorio no sea compatible
                        System.out.println("El escritorio no es compatible. No se puede abrir el archivo.");
                    }
                } else {
                    // El archivo no existe, puedes optar por generar el PDF aquí o mostrar un mensaje de error
                    System.out.println("El archivo PDF no existe.");
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Ocurrió un error al intentar abrir el archivo PDF.");
            }
        }

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
