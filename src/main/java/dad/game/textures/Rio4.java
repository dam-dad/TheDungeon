package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;


public class Rio4 extends StaticEntity {

    public Rio4(double x, double y) {
        super(new Image("/images/Rio4.png"), x, y);
    }

    // Comando para Checkear colisiones
    /*
     * Rectangle shape = getCollisionShape(); gc.setFill(Color.YELLOW);
     * gc.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
     */


}

