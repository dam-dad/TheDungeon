package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class EsquinaMuro3 extends StaticEntity {

    public EsquinaMuro3(double x, double y) {
        super(new Image("/images/EsquinaMuro3.png"), x, y);
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);


    }

}