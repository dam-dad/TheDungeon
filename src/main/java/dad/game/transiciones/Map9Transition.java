package dad.game.transiciones;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public class Map9Transition extends StaticEntity {

    public Map9Transition(double x, double y) {
        super(new Image("/images/CespedDesga.png"), x, y);
    }

    @Override
    public Shape getCollisionShape() {
        return new Rectangle(posX, posY, width, height);
    }
}