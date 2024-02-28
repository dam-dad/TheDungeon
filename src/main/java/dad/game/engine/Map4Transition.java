package dad.game.engine;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Map4Transition extends StaticEntity {

    public Map4Transition(double x, double y) {
        super(new Image("Ruta imagen de la textura"), x, y);
    }


    @Override
    public Shape getCollisionShape() {
        return new Rectangle(posX, posY + 48, width, height);
    }


}