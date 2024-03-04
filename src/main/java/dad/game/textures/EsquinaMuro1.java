package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class EsquinaMuro1 extends StaticEntity {

    public EsquinaMuro1(double x, double y) {
        super(new Image("/images/EsquinaMuro1.png"), x, y);
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);


    }

}
