package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

/**
 *  Clase que genera tile de hierba
 */
public class FloorGrass extends StaticEntity {
	
	public FloorGrass(double x, double y) {
		super(new Image("/images/Cesped1.png"), x, y);
	}

	@Override
	public Shape getCollisionShape() {
		return null;
	}
	
}
