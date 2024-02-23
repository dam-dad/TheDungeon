package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class florMuro extends StaticEntity {
	
	public florMuro(double x, double y) {
		super(new Image("/images/florMuro.png"), x, y);
	}

	@Override
	public void render(GraphicsContext gc) {
		super.render(gc);
	}
	
}

