package dad.game.engine;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Map1Transition extends StaticEntity {

    /*
    Genera un objeto de transicion que visualmente es igual a un tile de suelo
     emplea el metodo getShape para comprobar colisiones con el player



     */

    public Map1Transition(double x, double y) {
        super(new Image("/images/CespedDesga.png"), x, y);
    }


    @Override
    public Shape getCollisionShape() {
        return new Rectangle(posX, posY - 48, width, height);
    }

}
