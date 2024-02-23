package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class ParedLadrillo extends StaticEntity {
	
	public ParedLadrillo(double x, double y) {
		super(new Image("/images/ParedLadrillo.png"), x, y);
	}

	@Override
	public Shape getCollisionShape() {
		return null;
	}
	
}