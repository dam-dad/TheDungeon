package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class Cespedflor extends StaticEntity {

    public Cespedflor(double x, double y) {
        super(new Image("/images/Cespedflor.png"), x, y);
    }

    @Override
    public Shape getCollisionShape() {
        return null;
    }

}