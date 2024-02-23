package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class LadoCesped4 extends StaticEntity {
	
	public LadoCesped4(double x, double y) {
		super(new Image("/images/LadoCesped4.png"), x, y);
	}

	@Override
	public Shape getCollisionShape() {
		return null;
	}
	
}
