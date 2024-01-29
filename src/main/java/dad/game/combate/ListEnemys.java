package dad.game.combate;

import dad.game.ui.Enemy;

import java.util.ArrayList;
import java.util.List;

public class ListEnemys {
    private List<Enemy> allEnemies = new ArrayList<>();

    public void addEnemy(Enemy enemy) {
        allEnemies.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        allEnemies.remove(enemy);
    }

    public List<Enemy> getAllEnemies() {
        return allEnemies;
    }



    // Otros métodos y atributos del juego...


}
