package dad.game.engine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Shape;


/**
 *  Clase que crea un objeto gameloop que realiza acciones cada frame, entre ellas recibir el input, comprobar colisiones 
 *  y pintar el mapa del juego y las entidades
 */
public class Game extends AnimationTimer {

	private long time;
	private long timeDifference;

	private GraphicsContext graphicsContext;

	private Player player;
	private List<Entity<? extends Shape>> entities = new ArrayList<>();

	private Set<KeyCode> input = new HashSet<>();

	public Game(Canvas canvas) {

		this.graphicsContext = canvas.getGraphicsContext2D();
		
		canvas.setOnKeyPressed(e -> this.input.add(e.getCode()));
		canvas.setOnKeyReleased(e -> this.input.remove(e.getCode()));
		canvas.setFocusTraversable(true);
		canvas.requestFocus();
		
		init();
		
	}
	
	public void init() {
		this.player = new Player(64, 64, 2);
		this.entities.addAll(Tile.loadTile(Tile.map));		
	}

	@Override
	public void start() {
		this.time = System.nanoTime();
		super.start();
	}

	// game loop
	public void handle(long currentNanoTime) {
		timeDifference = (currentNanoTime - time) / 1000;

		processInput();
		checkCollisions();
		update();
		render();

		time = currentNanoTime;
	}

	private void update() {
		
		player.update(timeDifference);
		
	}

	// procesamos las entradas
	private void processInput() {
		if (input.contains(KeyCode.W) || input.contains(KeyCode.UP)) {
			player.move(Direction.NORTH);
		}
		if (input.contains(KeyCode.S) || input.contains(KeyCode.DOWN)) {
			player.move(Direction.SOUTH);
		}
		if (input.contains(KeyCode.A) || input.contains(KeyCode.LEFT)) {
			player.move(Direction.EAST);
		}
		if (input.contains(KeyCode.D) || input.contains(KeyCode.RIGHT)) {
			player.move(Direction.WEST);
		}
	}

	// chequeamos colisions
	private void checkCollisions() {

		entities.stream()
			.filter(player::checkCollision)
			.findAny()
			.ifPresent(entity -> player.stop());

	}

	// pinta todo
	private void render() {
		entities.forEach(entity -> entity.render(graphicsContext));
		player.render(graphicsContext);
	}

}