package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class Suelo4 extends StaticEntity {
	
	public Suelo4(double x, double y) {
		super(new Image("/images/Suelo4.png"), x, y);
	}

	@Override
	public Shape getCollisionShape() {
		return null;
	}
	
}