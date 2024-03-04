package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ParedLadrillo8 extends StaticEntity {

    public ParedLadrillo8(double x, double y) {
        super(new Image("/images/ParedLadrillo8.png"), x, y);
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);


    }

}