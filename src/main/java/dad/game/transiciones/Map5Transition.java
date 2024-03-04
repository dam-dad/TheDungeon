package dad.game.transiciones;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * Clase que genera un objeto de transicion que visualmente es igual a un tile de suelo
 */
public class Map5Transition extends StaticEntity {

    public Map5Transition(double x, double y) {
        super(new Image("/images/Puente.png"), x, y);
    }


    @Override
    public Shape getCollisionShape() {
        return new Rectangle(posX, posY - 48, width, height);

    }

}