package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class CespedDesga extends StaticEntity {

    public CespedDesga(double x, double y) {
        super(new Image("/images/CespedDesga.png"), x, y);
    }

    @Override
    public Shape getCollisionShape() {
        return null;
    }

}
