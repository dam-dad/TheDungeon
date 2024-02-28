package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class ParedLadrillo5 extends StaticEntity {
	
	public ParedLadrillo5(double x, double y) {
		super(new Image("/images/ParedLadrillo5.png"), x, y);
	}

	@Override
	public Shape getCollisionShape() {
		return null;
	}
	
}