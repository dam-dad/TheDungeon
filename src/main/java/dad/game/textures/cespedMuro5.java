package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class cespedMuro5 extends StaticEntity {
	
	public cespedMuro5(double x, double y) {
		super(new Image("/images/cespedMuro5.png"), x, y);
	}

	@Override
	public void render(GraphicsContext gc) {
		super.render(gc);
	}
	
}