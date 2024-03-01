package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

/**
 *  Clase que genera tile de flor
 */
public class Flower extends StaticEntity {
	
	public Flower(double x, double y) {
		super(new Image("/images/flowerTile.png"), x, y);
	}

	@Override
	public Shape getCollisionShape() {
		return null;
	}

}
