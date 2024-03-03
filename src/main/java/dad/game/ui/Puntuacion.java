package dad.game.ui;

public class Puntuacion {
    private String nombre;
    private int enemigosDerrotados;

    public Puntuacion(String nombre, int enemigosDerrotados) {
        this.nombre = nombre;
        this.enemigosDerrotados = enemigosDerrotados;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEnemigosDerrotados() {
        return enemigosDerrotados;
    }
}
