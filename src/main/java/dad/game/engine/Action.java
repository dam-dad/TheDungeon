package dad.game.engine;

/**
 * Clase que permite realizar el movimiento de una dirección, necesaria para comprobar las colisiones y permitir el action según 
 * colision o no
 */
public class Action {
	
	private Direction direction;
	
	public Action(Direction direction){
		this.direction = direction;
	}
	
	public Direction getDirection() {
		return direction;
	}
}
