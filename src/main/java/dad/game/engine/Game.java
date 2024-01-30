package dad.game.engine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dad.game.combate.ListEnemys;
import dad.game.ui.Enemy;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Shape;


/**
 * Clase que crea un objeto gameloop que realiza acciones cada frame, entre ellas recibir el input, comprobar colisiones
 * y pintar el mapa del juego y las entidades
 */
public class Game extends AnimationTimer {

    private long time;
    private long timeDifference;

    private GraphicsContext graphicsContext;

    private Player player;
    ListEnemys listEnemys = new ListEnemys();
    private List<Entity> entities;

    private Set<KeyCode> input = new HashSet<>();
    private boolean nextMap1 = false;
    private boolean nextMap2 = false;
  //  private List<Entity> objects;

    public Game(Canvas canvas) {

        this.graphicsContext = canvas.getGraphicsContext2D();
        this.entities = Tile.loadTile(Tile.tileMap1);

        canvas.setOnKeyPressed(e -> this.input.add(e.getCode()));
        canvas.setOnKeyReleased(e -> this.input.remove(e.getCode()));
        canvas.setFocusTraversable(true);
        canvas.requestFocus();

        init();

    }

    public void init() {
        this.player = new Player(listEnemys,100,10,0,64, 64, 2);
       // this.entities.addAll(Tile.loadTile(Tile.tileMap1));
        this.entities = Tile.loadTile(Tile.tileMap1);


        // Crear un enemigo (Comentar esta linea para desactivar el enemigo)


        Image enemyImage = new Image("/images/idleDown.png");  // Reemplaza con la ruta correcta
        Enemy enemy = new Enemy(listEnemys,1000,25,0,200.0, 200.0, 30, player);
        listEnemys.addEnemy(enemy);
        this.entities.add(enemy);
        //Comentar hasta aquí

        listEnemys.removeEnemy(enemy);

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

        if (nextMap1) {
            System.out.println("Changing to Map 2...");
            this.entities = Tile.loadTile(Tile.tileMap2);
            player.posY = (Tile.tileMap2.length) * Tile.getTileLength()
                    - (Tile.getTileLength() / 2 + Tile.getTileLength());
            nextMap1 = false;
            System.out.println("Changed to Map 2");
        } else if (nextMap2) {
            System.out.println("Changing to Map 1...");
            this.entities = Tile.loadTile(Tile.tileMap1);
            player.posY = 0;
            nextMap2 = false;
            System.out.println("Changed to Map 1");
        }

        entities.forEach(entity -> {
            if (entity instanceof Enemy) {
                ((Enemy) entity).update(timeDifference);
            }
        });

        entities.removeIf(entity -> entity instanceof Enemy && ((Enemy) entity).isDefeated());
        listEnemys.getAllEnemies().removeIf(Enemy::isDefeated);
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
        if (input.contains(KeyCode.SPACE)) { // Suponiendo que SPACE es el botón de ataque
            player.attackWithSword();
            System.out.println("atacando al enemigo");
        }

    }

    // chequeamos colisions
    private void checkCollisions() {
        for (Entity entity : entities) {
            if (player.checkCollision(entity)) {
              //  System.out.println("Collision detected with: " + entity.getClass().getSimpleName());
                if (entity instanceof Map1Transition) {
                    nextMap1 = true;
                } else if (entity instanceof Map2Transition) {
                    nextMap2 = true;
                }
                player.move(null);
            }
            if (entity instanceof Enemy) {
                // Lógica para manejar la colisión con un enemigo
                // Por ejemplo, iniciar un combate o aplicar daño al jugador
                handleEnemyCollision((Enemy) entity);

            }
        }
    }

    private void handleEnemyCollision(Enemy enemy) {
        // Aplicar daño al jugador
        player.takeDamage(enemy.getAttackDamage());

        // Aplicar daño al enemigo (si el jugador tiene un ataque automático o defensivo)
        enemy.takeDamage(player.getAttackDamage());


        applyKnockback(player, enemy);

    }

    private void applyKnockback(Player player, Enemy enemy) {
        // Determinar la dirección del retroceso
        double dx = player.getPosX() - enemy.getPosX();
        double dy = player.getPosY() - enemy.getPosY();

        // Normalizar la dirección
        double length = Math.sqrt(dx * dx + dy * dy);
        if (length != 0) {
            dx /= length;
            dy /= length;
        }

        // Aplicar el retroceso
        double knockbackDistance = 0.2; // Ajusta este valor según sea necesario
        player.setPosX(player.getPosX() + dx * knockbackDistance);
        player.setPosY(player.getPosY() + dy * knockbackDistance);
    }

    // pinta todo
    private void render() {
        entities.forEach(entity -> entity.render(graphicsContext));
        player.render(graphicsContext);
    }




}