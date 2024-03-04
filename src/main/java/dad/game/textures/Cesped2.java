package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class Cesped2 extends StaticEntity {

    public Cesped2(double x, double y) {
        super(new Image("/images/Cesped2.png"), x, y);
    }

    @Override
    public Shape getCollisionShape() {
        return null;
    }

}
