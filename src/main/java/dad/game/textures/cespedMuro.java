package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class cespedMuro extends StaticEntity {

    public cespedMuro(double x, double y) {
        super(new Image("/images/cespedMuro.png"), x, y);
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }

}
