package dad.game.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class GameEndController {

    @FXML
    private Label scoreLabel;

    public void setScore(int score) {
        scoreLabel.setText("Tu puntuación: " + score);
    }

    @FXML
    private void handleExit(ActionEvent event) {
        Stage stage = (Stage) scoreLabel.getScene().getWindow();
        stage.close();
    }
}
