package dad.game.engine;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

/**
 *   Genera un objeto de transicion que visualmente es igual a un tile de suelo
 *   emplea el metodo getShape para comprobar colisiones con el player
 */
public class CollidableEntity extends StaticEntity<Rectangle> {
	
	public CollidableEntity(Image image, double x, double y) {
		super(image, x, y);
	}

	@Override
	public Rectangle getCollisionShape() {
		return new Rectangle(posX, posY, width, height);
	}

}
