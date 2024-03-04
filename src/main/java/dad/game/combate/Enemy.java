package dad.game.combate;

import dad.game.engine.Animation;
import dad.game.engine.Direction;
import dad.game.engine.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase enemy que genera nuestro primer enemigo
 *
 * @author Javier Pérez
 */
public class Enemy extends Character {

    private final double speed;
    private final Player player;
    private final Map<Direction, Animation> animations;

    private Direction actions;

    //todo eliminar listEnemys
    public Enemy(int health, int attackDamage, int defense, double initialPosX, double initialPosY, double speed, Player player) {
        super(health, attackDamage, defense);


        this.posX = initialPosX;
        this.posY = initialPosY;
        this.width = (int) (100 * SCALE);
        this.height = (int) (150 * SCALE);
        this.speed = speed;
        this.player = player;
        this.animations = createAnimations();
    }

    public static Rectangle getHitbox() {
        return new Rectangle(0, 0, 100, 150);
    }

    private Map<Direction, Animation> createAnimations() {
        Map<Direction, Animation> enemyAnimations = new HashMap<>();
        // Define las animaciones para cada dirección del enemigo
        enemyAnimations.put(Direction.NORTH, new Animation("/images/idleUp.png"));
        enemyAnimations.put(Direction.SOUTH, new Animation("/images/idleDown.png"));
        enemyAnimations.put(Direction.EAST, new Animation("/images/idleRight.png"));
        enemyAnimations.put(Direction.WEST, new Animation("/images/idleLeft.png"));
        return enemyAnimations;
    }

    @Override
    public void render(GraphicsContext gc) {
        Animation currentAnimation = animations.get(getDirection());
        if (currentAnimation != null) {
            gc.drawImage(currentAnimation.getCurrentFrame(), posX, posY, width, height);
        } else {
            // Manejar el caso en que la animación es null (puedes mostrar una imagen predeterminada o realizar alguna acción apropiada)
            System.err.println("La animación es null para la dirección: " + getDirection());
        }


    }


    @Override
    public void update(long timeDifference) {
        animations.values().forEach(animation -> animation.update(timeDifference));

        // Calcular la dirección hacia la posición del jugador
        double directionX = player.getPosX() - posX;
        double directionY = player.getPosY() - posY;

        // Normalizar para mantener la misma velocidad en todas las direcciones
        double length = Math.sqrt(directionX * directionX + directionY * directionY);
        if (length != 0) {
            directionX /= length;
            directionY /= length;
        }

        // Mover hacia la posición del jugador
        double distance = speed * timeDifference / 1e6; // Convertir nanosegundos a milisegundos
        posX += directionX * distance;
        posY += directionY * distance;

        // Actualizar la animación según la dirección
        updateAnimation(directionX, directionY);

        if (this.isDefeated()) {
            die();
        }
    }


    private void updateAnimation(double directionX, double directionY) {
        if (Math.abs(directionX) > Math.abs(directionY)) {
            // Movimiento horizontal
            if (directionX > 0) {
                setDirection(Direction.EAST);
            } else {
                setDirection(Direction.WEST);
            }
        } else {
            // Movimiento vertical
            if (directionY > 0) {
                setDirection(Direction.SOUTH);
            } else {
                setDirection(Direction.NORTH);
            }
        }
    }


    public boolean isDefeated() {
        return this.health <= 0;
    }

    protected void die() {
        System.out.println("Enemigo muerto");
        // Aquí puedes agregar lógica adicional, como eliminar al enemigo del juego
    }

    public void removeEnemy(List<Enemy> allEnemies) {
        allEnemies.remove(this);
    }


    @Override
    public Shape getCollisionShape() {
        double shapeX = posX;
        double shapeY = posY + height / 2;

        // Verifica si la dirección es null antes de realizar el cálculo
        if (actions != null) {
            switch (actions) {
                case SOUTH:
                    shapeY += speed;
                    break;
                case NORTH:
                    shapeY -= speed;
                    break;
                case EAST:
                    shapeX -= speed;
                    break;
                case WEST:
                    shapeX += speed;
                    break;
            }
        }
        return new Rectangle(shapeX, shapeY, width, height / 2);
    }

    public int getAttackDamage() {
        return attackDamage;
    }
}