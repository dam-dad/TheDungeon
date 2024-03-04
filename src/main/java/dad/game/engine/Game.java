package dad.game.engine;

import dad.game.combate.Enemy;
import dad.game.combate.Weapon;
import dad.game.transiciones.*;
import dad.game.ui.GameEndController;
import dad.game.ui.Puntuacion;
import dad.game.ui.ReportService;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Clase que crea un objeto gameloop que realiza acciones cada frame, entre ellas recibir el input, comprobar colisiones
 * y pintar el mapa del juego y las entidades
 */
public class Game extends AnimationTimer {

    // Tiempo
    private long time;
    private long timeDifference;

    // Context
    private GraphicsContext graphicsContext;
    private Player player;
    private List<Entity> entities;

    private int enemigosDerrotados = 0;
    String nombreusuario = "Usuario 1";


    // Input
    private Set<KeyCode> input = new HashSet<>();

    // Flags para controlar el cambio de mapas
    private boolean nextMap1 = false;
    private boolean nextMap2 = false;
    private boolean nextMap3 = false;
    private boolean nextMap3_2 = false;
    private boolean nextMap4 = false;
    private boolean nextMap4_back = false;
    private boolean nextMap5 = false;
    private boolean nextMap5_back = false;
    private boolean nextMap6 = false;
    private boolean nextMap6_back = false;
    private boolean nextMap7 = false;
    private boolean nextMap7_back = false;
    private boolean nextMap8 = false;
    private boolean nextMap8_back = false;


    //Creacion de la espada
    Weapon sword = new Weapon("Espada", 10, 40, 40, "/images/espada.png");


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


        this.player = new Player(100, 25, 0, 64, 64, 2);
        // this.entities.addAll(Tile.loadTile(Tile.tileMap1));
        this.entities = Tile.loadTile(Tile.tileMap1);


        // Crear un enemigo (Comentar esta linea para desactivar el enemigo)


        //Image enemyImage = new Image("/images/idleDown.png");  // Reemplaza con la ruta correcta
        Enemy enemy = new Enemy(100, 25, 0, 200.0, 200.0, 30, player);
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

    /**
     * Actualiza las entidades del juego
     */
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
        } else if (nextMap3) {
            System.out.println("Changing to Map 3...");
            this.entities = Tile.loadTile(Tile.tileMap3);
            player.posX = 13 * Tile.getTileWidth(); // Columna 14 (índice 13), cada tile tiene 48px de ancho
            player.posY = 4 * Tile.getTileLength(); // Fila 5 (índice 4), cada tile tiene 48px de alto
            spawnEnemy(100.0, 100.0); // Ejemplo de posición. Ajusta según la lógica del mapa

            nextMap3 = false;
            System.out.println("Changed to Map 3");
        } else if (nextMap3_2) {
            System.out.println("Changing to Map 2...");
            this.entities = Tile.loadTile(Tile.tileMap2);
            player.posX = 1 * Tile.getTileWidth(); // La columna 2
            player.posY = 4 * Tile.getTileLength(); // La fila 5
            spawnEnemy(100.0, 100.0); // Ejemplo de posición. Ajusta según la lógica del mapa
            nextMap3_2 = false;
            System.out.println("Changed to Map 2");
        } else if (nextMap4) {
            System.out.println("Changing to Map 4...");
            this.entities = Tile.loadTile(Tile.tileMap4);
            player.posX = 6 * Tile.getTileWidth(); // Para el número 36
            player.posY = 1 * Tile.getTileLength(); // Segunda fila
            nextMap4 = false;
            System.out.println("Changed to Map 4");
        } else if (nextMap4_back) {
            System.out.println("Changing to Map 3...");
            this.entities = Tile.loadTile(Tile.tileMap3);
            player.posX = 6 * Tile.getTileWidth(); // Para el primer número 49 encima del 84
            player.posY = 8 * Tile.getTileLength(); // Novena fila
            nextMap4_back = false;
            System.out.println("Changed to Map 3");
        } else if (nextMap5) {
            System.out.println("Changing to Map 5...");
            this.entities = Tile.loadTile(Tile.tileMap5);
            player.posX = 10 * Tile.getTileWidth(); // Para el número 43
            player.posY = 8 * Tile.getTileLength(); // Primera fila
            nextMap5 = false;
            System.out.println("Changed to Map 5");
        } else if (nextMap5_back) {
            System.out.println("Changing to Map 2...");
            this.entities = Tile.loadTile(Tile.tileMap2);
            player.posX = 9 * Tile.getTileWidth(); // Para el número 90
            player.posY = 0 * Tile.getTileLength(); // Cuarta fila
            nextMap5_back = false;
            System.out.println("Changed to Map 2");
        } else if (nextMap6) {
            System.out.println("Changing to Map 6...");
            this.entities = Tile.loadTile(Tile.tileMap6);
            player.posX = 10 * Tile.getTileWidth(); // Quinta columna desde la izquierda
            player.posY = 7 * Tile.getTileLength(); // Octava fila (segunda por debajo)
            nextMap6 = false;
            System.out.println("Changed to Map 6");
        } else if (nextMap6_back) {
            System.out.println("Changing to Map 5...");
            this.entities = Tile.loadTile(Tile.tileMap5);
            player.posX = 9 * Tile.getTileWidth(); // Para el número "91"
            player.posY = 1 * Tile.getTileLength(); // Primera fila
            nextMap6_back = false;
            System.out.println("Changed to Map 5");
        } else if (nextMap7) {
            System.out.println("Changing to Map 7...");
            this.entities = Tile.loadTile(Tile.tileMap7);
            player.posX = 5 * Tile.getTileWidth(); // Quinta columna desde la izquierda
            player.posY = 8 * Tile.getTileLength(); // Primera fila
            nextMap7 = false;
            System.out.println("Changed to Map 7");
        } else if (nextMap7_back) {
            System.out.println("Changing to Map 6...");
            this.entities = Tile.loadTile(Tile.tileMap6);
            player.posX = 5 * Tile.getTileWidth(); // Cuarta columna desde la izquierda
            player.posY = 1 * Tile.getTileLength(); // Última fila
            nextMap7_back = false;
            System.out.println("Changed to Map 6");
        } else if (nextMap8) {
            System.out.println("Changing to Map 8...");
            this.entities = Tile.loadTile(Tile.tileMap8);
            player.posX = 5 * Tile.getTileWidth(); // Quinta columna desde la izquierda
            player.posY = 8 * Tile.getTileLength(); // Primera fila
            nextMap8 = false;
            System.out.println("Changed to Map 8");
        } else if (nextMap8_back) {
            System.out.println("Changing to Map 7...");
            this.entities = Tile.loadTile(Tile.tileMap7);
            player.posX = 5 * Tile.getTileWidth(); // Cuarta columna desde la izquierda
            player.posY = 1 * Tile.getTileLength(); // Última fila
            nextMap8_back = false;
            System.out.println("Changed to Map 7");
        }


        // Actualización de los enemigos y posible eliminación si están derrotados
        List<Entity> toRemove = new ArrayList<>();
        entities.forEach(entity -> {
            if (entity instanceof Enemy) {
                Enemy enemy = (Enemy) entity;
                enemy.update(timeDifference);
                if (enemy.isDefeated()) {
                    toRemove.add(enemy);
                    enemigosDerrotados++; // Incrementa el contador por cada enemigo derrotado
                    System.out.println("Enemigo derrotado. Total ahora: " + enemigosDerrotados);
                }
            }
        });

        entities.removeAll(toRemove);

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
        Weapon sword = new Weapon("Espada", 10, 40, 40, "images/espada.png"); // Utiliza los valores adecuados para width y height

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
                } else if (entity instanceof Map3Transition) {
                    nextMap3 = true;
                } else if (entity instanceof Map3TransitionBack) {
                    nextMap3_2 = true;
                } else if (entity instanceof Map4Transition) {
                    nextMap4 = true;
                } else if (entity instanceof Map4TransitionBack) {
                    nextMap4_back = true;
                } else if (entity instanceof Map5Transition) {
                    nextMap5 = true;
                } else if (entity instanceof Map5TransitionBack) {
                    nextMap5_back = true;
                } else if (entity instanceof Map6Transition) {
                    nextMap6 = true;
                } else if (entity instanceof Map6TransitionBack) {
                    nextMap6_back = true;
                } else if (entity instanceof Map7Transition) {
                    nextMap7 = true;
                } else if (entity instanceof Map7TransitionBack) {
                    nextMap7_back = true;
                } else if (entity instanceof Map8Transition) {
                    nextMap8 = true;
                } else if (entity instanceof Map8TransitionBack) {
                    nextMap8_back = true;
                } else if (entity instanceof Map9Transition) {
                    onGameEnd();

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

    private void spawnEnemy(double posX, double posY) {
        Enemy enemy = new Enemy(100, 25, 0, posX, posY, 30, player);
        this.entities.add(enemy);
    }

    @Override
    public void stop() {
        super.stop(); 

    }

    public void onGameEnd() {
        stop();
        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GameEndView.fxml"));
                Parent root = loader.load();

                GameEndController controller = loader.getController();
                controller.setScore(enemigosDerrotados); // Configura la puntuación final en la pantalla de "Juego Terminado"

                // Obtiene la ventana (Stage) actual a través del GraphicsContext del Canvas
                Stage currentStage = (Stage) graphicsContext.getCanvas().getScene().getWindow();

                // Cambia la escena actual por la nueva escena de "Juego Terminado"
                currentStage.setScene(new Scene(root));
                currentStage.setTitle("Juego Terminado");
                currentStage.show();

                List<Puntuacion> puntuaciones = new ArrayList<>();
                puntuaciones.add(new Puntuacion("Jugador Nuevo", enemigosDerrotados));
                try {
                    ReportService.generarPdf(puntuaciones);
                } catch (JRException | IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


}

