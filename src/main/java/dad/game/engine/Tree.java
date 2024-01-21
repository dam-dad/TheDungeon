package dad.game.engine;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Clase que genera una entidad de arbol
 */
public class Tree extends CollidableEntity {

	//TODO cambiar la textura sin que crashee el programa
	public Tree(double x, double y) {
		super(new Image("/images/Wall21.png"), x, y);
	}

	@Override
	public void render(GraphicsContext gc) {
		super.render(gc);
//		Rectangle shape = (Rectangle) getCollisionShape();
//		gc.setFill(Color.OLIVEDRAB);
//		gc.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
	}

}
