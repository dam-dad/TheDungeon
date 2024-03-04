package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class CespedClaro extends StaticEntity {

    public CespedClaro(double x, double y) {
        super(new Image("/images/Cesped.png"), x, y);
    }

    @Override
    public Shape getCollisionShape() {
        return null;
    }

}
