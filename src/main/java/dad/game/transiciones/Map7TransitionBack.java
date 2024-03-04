package dad.game.transiciones;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Map7TransitionBack extends StaticEntity {

    public Map7TransitionBack(double x, double y) {
        super(new Image("/images/Puente.png"), x, y);
    }


    @Override
    public Shape getCollisionShape() {
        return new Rectangle(posX, posY + 48, width, height);
    }


}
