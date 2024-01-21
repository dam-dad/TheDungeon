package dad.game.engine;

import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

/**
 *  Clase que genera tile de hierbaAlta
 */
public class LongGrass extends StaticEntity<Shape> {
	
	public LongGrass(double x, double y) {
		super(new Image("/images/tallGrassTile.png"), x, y);
	}

}
