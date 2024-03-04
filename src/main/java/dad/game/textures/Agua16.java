package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class Agua16 extends StaticEntity {
	
	public Agua16(double x, double y) {
		super(new Image("/images/Agua16.png"), x, y);
	}

	@Override
	public void render(GraphicsContext gc) {
		super.render(gc);
	}
	
}