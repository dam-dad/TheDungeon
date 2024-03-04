package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ParedLadrillo5 extends StaticEntity {

    public ParedLadrillo5(double x, double y) {
        super(new Image("/images/ParedLadrillo5.png"), x, y);
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);


    }
}
