package dad.game.engine;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Clase que genera una entidad de arbol
 */
public class Rio4 extends StaticEntity {

	// TODO cambiar la textura sin que crashee el programa
	public Rio4(double x, double y) {
		super(new Image("/images/Rio4.png"), x, y);
	}

	// Comando para Checkear colisiones
	/*
	 * Rectangle shape = getCollisionShape(); gc.setFill(Color.YELLOW);
	 * gc.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
	 */

//		Rectangle shape = (Rectangle) getCollisionShape();
//		gc.setFill(Color.OLIVEDRAB);
//		gc.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
}

