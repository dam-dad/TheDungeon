package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ParedLadrillo4 extends StaticEntity {

    public ParedLadrillo4(double x, double y) {
        super(new Image("/images/ParedLadrillo4.png"), x, y);
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);


    }

}

