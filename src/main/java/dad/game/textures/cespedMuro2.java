package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class cespedMuro2 extends StaticEntity {
	
	public cespedMuro2(double x, double y) {
		super(new Image("/images/cespedMuro2.png"), x, y);
	}

	@Override
	public void render(GraphicsContext gc) {
		super.render(gc);
	}
	
}
