package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class LadoCesped3 extends StaticEntity {

    public LadoCesped3(double x, double y) {
        super(new Image("/images/LadoCesped3.png"), x, y);
    }

    @Override
    public Shape getCollisionShape() {
        return null;
    }

}
