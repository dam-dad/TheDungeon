package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class cespedMuro3 extends StaticEntity {

    public cespedMuro3(double x, double y) {
        super(new Image("/images/cespedMuro3.png"), x, y);
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }

}
