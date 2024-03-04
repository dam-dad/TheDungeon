package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Agua14 extends StaticEntity {

    public Agua14(double x, double y) {
        super(new Image("/images/Agua14.png"), x, y);
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }

}
