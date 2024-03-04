package dad.game.combate;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Clase Weapon que crea las armas del juego
 *
 * @author Javier Pérez
 */
public class Weapon {

    private int damage;
    private String name;
    private final Rectangle hitbox;
    private final Image weaponImage;


    public Weapon(String name, int damage, int width, int height, String imagePath) {
        this.name = name;
        this.damage = damage;
        this.hitbox = new Rectangle(width, height);
        this.weaponImage = new Image(imagePath); // Cargar la imagen del asset

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void attack(Enemy enemy) {
        if (hitbox.getBoundsInParent().intersects(Enemy.getHitbox().getBoundsInParent())) {
            enemy.takeDamage(damage);
        }
    }

    public void render(GraphicsContext gc, double x, double y) {
        if (weaponImage != null) {
            gc.drawImage(weaponImage, x, y);
        } else {
            // Dibuja la hitbox si no hay imagen
            gc.setStroke(Color.RED);
            gc.strokeRect(x, y, hitbox.getWidth(), hitbox.getHeight());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Constructor, getters y setters...
}




