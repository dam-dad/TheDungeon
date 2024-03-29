package dad.game.engine;

import dad.game.combate.Character;
import dad.game.combate.Enemy;
import dad.game.combate.Weapon;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase del Personaje principal del juego
 */
public class Player extends Character {

    private static final long ANIMATION_SPEED = 125000;
    @SuppressWarnings("serial")
    private final Map<Direction, Animation> idle = new HashMap<>() {{
        put(Direction.NORTH, new Animation("/images/SpriteUp.png"));
        put(Direction.SOUTH, new Animation("/images/SpriteDown.png"));
        put(Direction.EAST, new Animation("/images/SpriteLeft.png"));
        put(Direction.WEST, new Animation("/images/SpriteRight.png"));
    }};
    @SuppressWarnings("serial")
    private final Map<Direction, Animation> walk = new HashMap<>() {{
        put(Direction.NORTH, new Animation(ANIMATION_SPEED, "/images/SpriteWalkUp1.png", "/images/SpriteUp.png", "/images/SpriteWalkUp2.png", "/images/SpriteUp.png"));
        put(Direction.SOUTH, new Animation(ANIMATION_SPEED, "/images/SpriteWalkDown1.png", "/images/SpriteDown.png", "/images/SpriteWalkDown2.png", "/images/SpriteDown.png"));
        put(Direction.EAST, new Animation(ANIMATION_SPEED, "/images/SpriteWalkLeft1.png", "/images/SpriteLeft.png", "/images/SpriteWalkLeft1.png", "/images/SpriteLeft.png"));
        put(Direction.WEST, new Animation(ANIMATION_SPEED, "/images/SpriteWalkRight1.png", "/images/SpriteRight.png", "/images/SpriteWalkRight1.png", "/images/SpriteRight.png"));
    }};
    public double xSpeed;
    public double ySpeed;
    List<Enemy> allEnemies = new ArrayList<>();
    private Weapon equippedWeapon;
    private boolean isWalking = false;
    private Direction direction;
    private Animation animation;
    private Direction actions;

    public Player(int health, int attackDamage, int defense, double posX, double posY, double speed) {
        super(health, attackDamage, defense);


        // variables of movement speed
        this.xSpeed = speed;
        this.ySpeed = speed;

        // variables of starting position
        this.posX = posX;
        this.posY = posY;

        // default direction when starting
        this.direction = Direction.SOUTH;

        // variables of character size
        this.width = (int) (100 * SCALE);
        this.height = (int) (150 * SCALE);
    }

    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }


    private void idle() {
        isWalking = false;
    }

    public void move(Direction action) {
        this.actions = action;
    }

    public void render(GraphicsContext gc) {
        if (animation != null) {
            gc.drawImage(animation.getCurrentFrame(), posX, posY, width, height);
        } else {
            // Manejar el caso en que la animación es null (puedes mostrar una imagen predeterminada o realizar alguna acción apropiada)
            System.err.println("La animación es null para la dirección: " + direction);
        }

        Rectangle shape = (Rectangle) getCollisionShape();
       /* gc.setFill(Color.OLIVEDRAB);
        gc.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());*/
    }


/*
    private void apply(Action action) {
        if (actions != null && action.getDirection() != null) {
            switch (action.getDirection()) {
                case SOUTH:
                    moveDown();
                    break;
                case NORTH:
                    moveUp();
                    break;
                case EAST:
                    moveLeft();
                    break;
                case WEST:
                    moveRight();
                    break;
            }
        } else {
            System.err.println("La dirección de la acción es null.");
        }
    }*/

    public void update(long timeDifference) {
        if (actions != null) {
            direction = actions; // Establecer la dirección para el jugador
            isWalking = true;

            switch (actions) {
                case SOUTH:
                    posY += ySpeed;
                    break;
                case NORTH:
                    posY -= ySpeed;
                    break;
                case EAST:
                    posX -= xSpeed;
                    break;
                case WEST:
                    posX += xSpeed;
                    break;
            }

            actions = null;
        } else {
            idle();
        }

        if (!isWalking) {
            animation = idle.get(direction);
        } else {
            animation = walk.get(direction);
        }
        animation.update(timeDifference);
    }

	/*private Rectangle getCollisionShape(Action action) {
		double shapeX = posX;
		double shapeY = posY + height / 2;
		if (action != null) {
			switch (action.getDirection()) {
			case SOUTH: shapeY += ySpeed; break;
			case NORTH: shapeY -= ySpeed; break;
			case EAST: shapeX -= xSpeed; break;
			case WEST: shapeX += xSpeed; break;
			}
		}
		return new Rectangle(shapeX, shapeY, width, height / 2);
	}*/


    @Override
    public Shape getCollisionShape() {
        double shapeX = posX;
        double shapeY = posY + height / 2;

        // Verifica si la dirección es null antes de realizar el cálculo
        if (actions != null) {
            switch (actions) {
                case SOUTH:
                    shapeY += ySpeed;
                    break;
                case NORTH:
                    shapeY -= ySpeed;
                    break;
                case EAST:
                    shapeX -= xSpeed;
                    break;
                case WEST:
                    shapeX += xSpeed;
                    break;
            }
        }
        return new Rectangle(shapeX, shapeY, width, height / 2);
    }

   /* public List<Enemy> getEnemiesInRange() {
        List<Enemy> enemiesInRange = new ArrayList<>();
        for (Enemy enemy : allEnemies)  {
            if (isInRange(this, enemy)) {
                enemiesInRange.add(enemy);
            }
        }
        return enemiesInRange;
    }*/


    public void attackWithSword(Weapon sword) {
        if (sword != null) {
            List<Enemy> enemiesInRange = getEnemiesInRange(allEnemies);
            for (Enemy enemy : enemiesInRange) {
                this.attack(enemy, sword.getDamage());
            }
        } else {
            System.out.println("No weapon equipped.");
        }
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

}