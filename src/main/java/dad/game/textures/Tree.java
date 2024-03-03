package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Clase que genera una entidad de arbol
 */
public class Tree extends StaticEntity {

	public Tree(double x, double y) {
		super(new Image("/images/Wall21.png"), x, y);
	}

	@Override
	public void render(GraphicsContext gc) {
		super.render(gc);



		//Comando para Checkear colisiones
		/*Rectangle shape = getCollisionShape();
		gc.setFill(Color.YELLOW);
		gc.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
*/



//		Rectangle shape = (Rectangle) getCollisionShape();
//		gc.setFill(Color.OLIVEDRAB);
//		gc.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
	}

}
