package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class EsquinaCesped1 extends StaticEntity {

    public EsquinaCesped1(double x, double y) {
        super(new Image("/images/EsquinaCesped1.png"), x, y);
    }

    @Override
    public Shape getCollisionShape() {
        return null;
    }

}
