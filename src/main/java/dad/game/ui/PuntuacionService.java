package dad.game.ui;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PuntuacionService {

    private static final String ARCHIVO_PUNTUACIONES = "puntuaciones.csv";

    public static void guardarPuntuacion(Puntuacion puntuacion) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_PUNTUACIONES, true))) {
            bw.write(puntuacion.getNombre() + "," + puntuacion.getEnemigosDerrotados() + "\n");
        }
    }

    public static List<Puntuacion> leerPuntuaciones() throws IOException {
        List<Puntuacion> puntuaciones = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_PUNTUACIONES))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    puntuaciones.add(new Puntuacion(parts[0], Integer.parseInt(parts[1])));
                }
            }
        }
        return puntuaciones;
    }
}