package dad.game.ui;

import javafx.animation.FadeTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {


    Media media1;
    Media media2;
    MediaPlayer mediaPlayer;

    Image img1 = new Image("/images/music-on-icon.png");
    ImageView view1 = new ImageView(img1);

    Image img2 = new Image("/images/music-off-icon.png");
    ImageView view2 = new ImageView(img2);


    private BooleanProperty buttonPressed = new SimpleBooleanProperty();

    private BooleanProperty pdfButtonPressed = new SimpleBooleanProperty();
    private BooleanProperty controlMusicButtonPressed = new SimpleBooleanProperty();


    @FXML
    private Button controlMusicButton;

    @FXML
    private Label hechoPorLabel;

    @FXML
    private Button leaveButton;

    @FXML
    private Button pdfButton;

    @FXML
    private Button playButton;

    @FXML
    private BorderPane view;


    public MenuController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MenuView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonPressed.set(false);
        pdfButtonPressed.set(false);
        controlMusicButtonPressed.set(false);
        controlMusicButton.setGraphic(view1);
        view.sceneProperty().addListener((o, ov, nv) -> {
            startTransition();
        });
    }

    private void startTransition() {
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.seconds(4));
        fade.setFromValue(0.0);
        fade.setToValue(1.0);
        fade.setNode(view);
        fade.play();
    }


    @FXML
    void onControlMusicButton(ActionEvent event) {
        Task<Void> actualizarEstadoMusica = new Task<Void>() {
            protected Void call() throws Exception {
                controlMusicButtonPressed.set(true);
                controlMusicButton.setOnAction(e -> {
                    if (controlMusicButton.getGraphic().equals(view1)) {
                        controlMusicButton.setGraphic(view2);
                        App.stopMusic();
                    } else {
                        controlMusicButton.setGraphic(view1);
                        App.playMusic("Menu_Song");
                    }
                });
                return null;
            }
        };
        new Thread(actualizarEstadoMusica).start();
    }

    public BorderPane getView() {
        return view;
    }

    @FXML
    void onLeaveButton(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void onPlayButton(ActionEvent event) {
        buttonPressed.set(true);

        System.out.println("funciona");


    }

    @FXML
    void onpdfButton(ActionEvent event) {

        pdfButtonPressed.set(true);

        System.out.println("funciona");

    }


    public final BooleanProperty buttonPressedProperty() {
        return this.buttonPressed;

    }

    public final BooleanProperty pdfButtonPressedProperty() {
        return this.pdfButtonPressed;
    }

    public final BooleanProperty controlMusicButtonPressedProperty() {
        return this.controlMusicButtonPressed;
    }

    public final boolean isButtonPressed() {
        return this.buttonPressedProperty().get();
    }

    public final void setButtonPressed(final boolean buttonPressed) {
        this.buttonPressedProperty().set(buttonPressed);
    }


    public final boolean isPdfButtonPressed() {
        return this.pdfButtonPressedProperty().get();
    }

    public final void setPdfButtonPressed(final boolean pdfButtonPressed) {
        this.pdfButtonPressedProperty().set(pdfButtonPressed);
    }


    public final boolean isControlMusicButtonPressed() {
        return this.controlMusicButtonPressedProperty().get();
    }

    public final void setControlMusicButtonPressed(final boolean controlMusicButtonPressed) {
        this.controlMusicButtonPressedProperty().set(controlMusicButtonPressed);
    }
}
