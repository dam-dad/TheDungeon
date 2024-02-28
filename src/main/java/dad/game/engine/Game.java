package dad.game.engine;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dad.game.combate.Weapon;
import dad.game.ui.Enemy;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;


/**
 * Clase que crea un objeto gameloop que realiza acciones cada frame, entre ellas recibir el input, comprobar colisiones
 * y pintar el mapa del juego y las entidades
 */
public class Game extends AnimationTimer {

    private long time;
    private long timeDifference;

    private GraphicsContext graphicsContext;

    private Player player;
    private List<Entity> entities;

    private Set<KeyCode> input = new HashSet<>();
    private boolean nextMap1 = false;
    private boolean nextMap2 = false;
    private boolean nextMap3 = false;
    private boolean nextMap4 = false;
    private boolean nextMap5 = false;


    Weapon sword = new Weapon("Espada", 10, 40, 40);


    //  private List<Entity> objects;

    // Nuevo flag para controlar el estado del knockback
    private boolean playerInKnockback = false;


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


        this.player = new Player(100,25,0,64, 64, 2);
       // this.entities.addAll(Tile.loadTile(Tile.tileMap1));
        this.entities = Tile.loadTile(Tile.tileMap1);


        // Crear un enemigo (Comentar esta linea para desactivar el enemigo)


        //Image enemyImage = new Image("/images/idleDown.png");  // Reemplaza con la ruta correcta
        Enemy enemy = new Enemy(100,25,0,200.0, 200.0, 30, player);
        this.entities.add(enemy);
        //Comentar hasta aquí


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
        }else if (nextMap3) {
            System.out.println("Changing to Map 2...");
            this.entities = Tile.loadTile(Tile.tileMap3);
            player.posY = 0;
            nextMap3 = false;
            System.out.println("Changed to Map 3");
        }else if (nextMap4) {
            System.out.println("Changing to Map 3...");
            this.entities = Tile.loadTile(Tile.tileMap4);
            player.posY = 0;
            nextMap4 = false;
            System.out.println("Changed to Map 4");
        }
        else if (nextMap5) {
            System.out.println("Changing to Map 4...");
            this.entities = Tile.loadTile(Tile.tileMap5);
            player.posY = 0;
            nextMap5 = false;
            System.out.println("Changed to Map 5");
        }

        entities.forEach(entity -> {
            if (entity instanceof Enemy) {
                ((Enemy) entity).update(timeDifference);
            }
        });

        entities.removeIf(entity -> entity instanceof Enemy && ((Enemy) entity).isDefeated());
       // listEnemys.getAllEnemies().removeIf(Enemy::isDefeated);
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
            useSword();
            player.attackWithSword(sword);
            System.out.println("atacando al enemigo");
        }

    }

    private void useSword() {
        // Crear una instancia de la espada
        Weapon sword = new Weapon("Espada", 10, 40, 40); // Utiliza los valores adecuados para width y height

        // Realizar el ataque con la espada
        for (Entity entity : entities) {
            if (entity instanceof Enemy && player.checkCollision(entity)) {
                Enemy enemy = (Enemy) entity; // Declaramos la variable enemy aquí
                enemy.takeDamage(sword.getDamage()); // Aplica el daño de la espada al enemigo
            }
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
            if (entity instanceof Enemy && !playerInKnockback) {
                handleEnemyCollision((Enemy) entity);

            }
        }
        // Restablecer el estado de knockback si no hay colisión con enemigos
        if (entities.stream().noneMatch(e -> e instanceof Enemy && player.checkCollision(e))) {
            playerInKnockback = false;
        }
    }

    private void handleEnemyCollision(Enemy enemy) {
        // Aplicar daño al jugador
        player.takeDamage(enemy.getAttackDamage());
        applyKnockback(player, enemy);
        playerInKnockback = true; // Marcar que el jugador está en estado de knockback

        // Aplicar daño al enemigo (si el jugador tiene un ataque automático o defensivo)

        // enemy.takeDamage(player.getAttackDamage());


    }

    //TODO Arreglar nuevo retroceso cuando enemy colisiona con el jugador rebotar a Pos contraria
    private void applyKnockback(Player player, Enemy enemy) {
        // Convertir las posiciones del jugador y del enemigo en Point2D
        Point2D playerPosition = new Point2D(player.getPosX(), player.getPosY());
        Point2D enemyPosition = new Point2D(enemy.getPosX(), enemy.getPosY());

        // Calcular la dirección del retroceso como un vector normalizado
        // Aquí es donde necesitamos ajustar la dirección del vector
        Point2D directionVector = playerPosition.subtract(enemyPosition).normalize(); // Cambio aquí

        // Determinar la magnitud del retroceso
        double knockbackDistance = 0.04; // Ajustado a 1 como mencionaste

        // Aplicar el retroceso
        Point2D newPlayerPosition = playerPosition.add(directionVector.multiply(knockbackDistance));
        player.setPosX(newPlayerPosition.getX());
        player.setPosY(newPlayerPosition.getY());
    }



    // pinta t-odo
    private void render() {
        entities.forEach(entity -> entity.render(graphicsContext));
        player.render(graphicsContext);

        double offsetX = 20; // Ajusta este valor según sea necesario
        double offsetY = 10; // Ajusta este valor según sea necesario

        double swordX = player.getPosX() + offsetX; // Calcula la posición X de la espada basada en la posición del jugador
        double swordY = player.getPosY() + offsetY; // Calcula la posición Y de la espada basada en la posición del jugador

        sword.render(graphicsContext, swordX, swordY);
    }




}