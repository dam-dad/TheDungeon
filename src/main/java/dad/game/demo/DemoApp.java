package dad.game.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DemoApp extends Application {
	
	public static Stage primaryStage;
	
	private GameController controller = new GameController();

	@Override
	public void start(Stage primaryStage) throws Exception {

		DemoApp.primaryStage = primaryStage;
		
		primaryStage.setTitle("Demo game");
		primaryStage.setScene(new Scene(controller.getView()));
		primaryStage.show();

	}

}
