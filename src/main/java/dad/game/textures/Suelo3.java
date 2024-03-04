package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class Suelo3 extends StaticEntity {

    public Suelo3(double x, double y) {
        super(new Image("/images/Suelo3.png"), x, y);
    }

    @Override
    public Shape getCollisionShape() {
        return null;
    }

}

