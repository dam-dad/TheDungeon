package dad.game.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

//TODO borrar antes de presentarlo
public class DemoApp extends Application {

    public static Stage primaryStage;

    private final GameController controller = new GameController();

    @Override
    public void start(Stage primaryStage) throws Exception {

        DemoApp.primaryStage = primaryStage;

        primaryStage.setTitle("Demo game");
        primaryStage.setScene(new Scene(controller.getView()));
        primaryStage.show();

    }

}
