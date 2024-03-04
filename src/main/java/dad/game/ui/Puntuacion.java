package dad.game.ui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Puntuacion {
    private final StringProperty nombre = new SimpleStringProperty();
    private final StringProperty enemigosDerrotados = new SimpleStringProperty();

    // Constructor
    public Puntuacion(String nombre, int enemigosDerrotados) {
        this.nombre.set(nombre);
        this.enemigosDerrotados.set(String.valueOf(enemigosDerrotados));
    }

    // Métodos getter y setter para nombre
    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    // Métodos getter y setter para enemigosDerrotados
    public String getEnemigosDerrotados() {
        return enemigosDerrotados.get();
    }

    public void setEnemigosDerrotados(String enemigosDerrotados) {
        this.enemigosDerrotados.set(enemigosDerrotados);
    }

    public StringProperty enemigosDerrotadosProperty() {
        return enemigosDerrotados;
    }
}
