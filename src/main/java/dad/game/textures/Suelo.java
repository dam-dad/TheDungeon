package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class Suelo extends StaticEntity {
	
	public Suelo(double x, double y) {
		super(new Image("/images/Suelo.png"), x, y);
	}

	@Override
	public Shape getCollisionShape() {
		return null;
	}
	
}
