package dad.game.combate;

import dad.game.engine.DistanceCalculator;
import dad.game.engine.Entity;
import dad.game.engine.Player;
import dad.game.ui.Enemy;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;


/**
 * Clase Character que representa a un personaje en el juego. hereda de Entity
 */

public class Character extends Entity {

    private static final double ATTACK_RANGE = 10.0;
    private DistanceCalculator calculator = new DistanceCalculator(null);


    protected int health;
    protected int attackDamage;
    protected int defense;


    public Character(int health, int attackDamage, int defense) {
        this.health = health;
        this.attackDamage = attackDamage;
        this.defense = defense;
    }

    /**
     * Ataca a otro personaje.
     *
     * @param target El personaje objetivo del ataque.
     * @param damage
     */
    public void attack(Character target, int damage) {
        if (target != null) {
            target.takeDamage(this.attackDamage);
        }
    }

   /* public void attackWithSword(List<Enemy> allEnemies) {
        List<Enemy> enemiesInRange = getEnemiesInRange(allEnemies);
        for (Enemy enemy : enemiesInRange) {
            // Asumiendo que 'attackDamage' es el daño de ataque del jugador
            this.attack(enemy, this.attackDamage);
        }
    }*/


    protected List<Enemy> getEnemiesInRange(List<Enemy> allEnemies) {
        List<Enemy> enemiesInRange = new ArrayList<>();
        for (Enemy enemy : allEnemies) { // 'allEnemies' debería ser una lista de todos los enemigos en el juego
            if (isInRange(this, enemy)) {
                enemiesInRange.add(enemy);
            }
        }
        return enemiesInRange;
    }

    //todo Clase separada para sacar la distancia
    private boolean isInRange(Character attacker, Character target) {
        Point2D attackerPosition = new Point2D(attacker.getPosX(), attacker.getPosY());
        Point2D targetPosition = new Point2D(target.getPosX(), target.getPosY());

        double distance = calculator.calculateDistance(attackerPosition, targetPosition);

        return distance <= ATTACK_RANGE;
    }


    public void takeDamage(int damage) {
        int damageTaken = Math.max(damage - defense, 0);
        health -= damageTaken;
        if (health <= 0) {
            die();
        }
    }


    protected void die() {

    }


    @Override
    public void render(GraphicsContext gc) {

    }

    @Override
    public void update(long timeDifference) {

    }

    @Override
    public Shape getCollisionShape() {
        return null;
    }
}

