package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class ParedLadrillo4 extends StaticEntity {
	
	public ParedLadrillo4(double x, double y) {
		super(new Image("/images/ParedLadrillo4.png"), x, y);
	}

	@Override
	public Shape getCollisionShape() {
		return null;
	}
	
}
