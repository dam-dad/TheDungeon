package dad.game.combate;

import dad.game.engine.Entity;
import dad.game.ui.Enemy;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class Character extends Entity {
    private static final double ATTACK_RANGE = 100.0;
    protected int health;
        protected int attackDamage;
        protected int defense;
        ListEnemys listEnemys = new ListEnemys();
        private List<Enemy> allEnemies = listEnemys.getAllEnemies();


        public Character(int health, int attackDamage, int defense) {
            this.health = health;
            this.attackDamage = attackDamage;
            this.defense = defense;
        }

        /**
         * Ataca a otro personaje.
         * @param target El personaje objetivo del ataque.
         */
        public void attack(Character target, int damage) {
            if (target != null) {
                target.takeDamage(damage);
            }
        }

    public void attackWithSword() {
        List<Enemy> enemiesInRange = getEnemiesInRange();
        for (Enemy enemy : enemiesInRange) {
            // Asumiendo que 'attackDamage' es el daño de ataque del jugador
            this.attack(enemy, this.attackDamage);
        }
    }


    private List<Enemy> getEnemiesInRange() {
        List<Enemy> enemiesInRange = new ArrayList<>();
        for (Enemy enemy : allEnemies) { // 'allEnemies' debería ser una lista de todos los enemigos en el juego
            if (isInRange(this, enemy)) {
                enemiesInRange.add(enemy);
            }
        }
        return enemiesInRange;
    }

    private boolean isInRange(Character attacker, Character target) {
        double distance = Math.sqrt(Math.pow(attacker.getPosX() - target.getPosX(), 2) + Math.pow(attacker.getPosY() - target.getPosY(), 2));
        return distance <= ATTACK_RANGE; // 'ATTACK_RANGE' es una constante que define el rango de ataque
    }




        public void takeDamage(int damage) {
            int damageTaken = Math.max(damage - defense, 0);
            health -= damageTaken;
            if (health <= 0) {
                die();
            }
        }

        protected void die() {
            // Lógica para manejar la muerte del personaje
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

