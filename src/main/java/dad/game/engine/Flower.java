package dad.game.engine;

import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

/**
 *  Clase que genera tile de flor
 */
public class Flower extends StaticEntity<Shape> {
	
	public Flower(double x, double y) {
		super(new Image("/images/flowerTile.png"), x, y);
	}

}
