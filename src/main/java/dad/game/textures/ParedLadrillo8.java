package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class ParedLadrillo8 extends StaticEntity {
	
	public ParedLadrillo8(double x, double y) {
		super(new Image("/images/ParedLadrillo8.png"), x, y);
	}

	@Override
	public Shape getCollisionShape() {
		return null;
	}
	
}