package dad.game.engine;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Map3TransitionBack extends StaticEntity {

    public Map3TransitionBack(double x, double y) {
        super(new Image("/images/CespedDesga.png"), x, y);
    }


    @Override
    public Shape getCollisionShape(){
        return new Rectangle(posX, posY + 48, width, height);
    }

}
