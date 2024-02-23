package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class Flor extends StaticEntity {
	
	public Flor(double x, double y) {
		super(new Image("/images/Flor.png"), x, y);
	}

	@Override
	public Shape getCollisionShape() {
		return null;
	}
	
}