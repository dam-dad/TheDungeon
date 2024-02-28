package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class ParedLadrillo15 extends StaticEntity {
	
	public ParedLadrillo15(double x, double y) {
		super(new Image("/images/ParedLadrillo15.png"), x, y);
	}

	@Override
	public Shape getCollisionShape() {
		return null;
	}
	
}
