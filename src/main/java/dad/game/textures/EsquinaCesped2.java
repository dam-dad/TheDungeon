package dad.game.textures;

import dad.game.engine.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class EsquinaCesped2 extends StaticEntity {
	
	public EsquinaCesped2(double x, double y) {
		super(new Image("/images/EsquinaCesped2.png"), x, y);
	}

	@Override
	public Shape getCollisionShape() {
		return null;
	}
	
}
