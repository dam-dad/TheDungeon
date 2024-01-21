package dad.game.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.game.engine.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;

/**
 * Controlador que gestiona el mapa del juego
 */
public class GameController implements Initializable {

	private Game game;

	@FXML
	private BorderPane view;

	@FXML
	private Canvas canvas;

	public GameController() {
		try { 
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GameView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		game = new Game(canvas);
		game.start();

	}

	public BorderPane getView() {
		return view;
	}

	public Game getGame() {
		return game;
	}

	public void startGame() {
		game = new Game(canvas);
		game.start();
	}
}
