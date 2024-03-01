package dad.game.combate;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Clase Weapon que crea las armas del juego
 * @author Javier Pérez
 */
public class Weapon {

    private int damage;
    private String name;
    private Rectangle hitbox;



    public int getDamage() {
        return damage;
    }

    public Weapon(String name, int damage, int width, int height) {
        this.name = name;
        this.damage = damage;
        this.hitbox = new Rectangle(width, height);
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void attack(Enemy enemy) {
        if (hitbox.getBoundsInParent().intersects(enemy.getHitbox().getBoundsInParent())) {
            enemy.takeDamage(damage);
        }
    }

    public void render(GraphicsContext gc, double x, double y) {
        gc.setStroke(Color.RED);
        gc.strokeRect(x, y, hitbox.getWidth(), hitbox.getHeight());
    }


    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Constructor, getters y setters...
}




