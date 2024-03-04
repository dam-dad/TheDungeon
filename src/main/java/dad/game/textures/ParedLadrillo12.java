package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ParedLadrillo12 extends StaticEntity {

    public ParedLadrillo12(double x, double y) {
        super(new Image("/images/ParedLadrillo12.png"), x, y);
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);


    }

}
