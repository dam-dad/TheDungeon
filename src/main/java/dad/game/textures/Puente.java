package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class Puente extends StaticEntity {
	
	public Puente(double x, double y) {
		super(new Image("/images/Puente.png"), x, y);
	}

	@Override
	public Shape getCollisionShape() {
		return null;
	}
	
}