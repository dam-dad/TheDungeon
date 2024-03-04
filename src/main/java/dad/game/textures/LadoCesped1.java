package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class LadoCesped1 extends StaticEntity {

    public LadoCesped1(double x, double y) {
        super(new Image("/images/LadoCesped1.png"), x, y);
    }

    @Override
    public Shape getCollisionShape() {
        return null;
    }

}
