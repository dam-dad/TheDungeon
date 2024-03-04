package dad.game.music;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URISyntaxException;
import java.net.URL;

public class MusicThread extends Thread {

    private final String file;
    private MediaPlayer player;

    public MusicThread(String file) {
        this.file = file;
    }

    /**
     * Método para iniciar musica
     */
    public void play() {
        URL path = getClass().getResource("/music/" + file + ".mp3");
        if (path == null) {
            System.err.println("No se encontró el archivo de música: " + file);
        } else {
            System.out.println("Ruta del archivo de música encontrada: " + path);
        }

        try {
            Media media = new Media(path.toURI().toString());
            player = new MediaPlayer(media);
            player.setVolume(0.03);
            player.setCycleCount(MediaPlayer.INDEFINITE);
            player.play();
        } catch (URISyntaxException e) {
            System.err.println("Error al cargar el archivo de música: " + file);
            e.printStackTrace();
        }
    }

    /**
     * Método para pausar la música
     */
    public void pause() {
        if (player != null) {
            try {
                player.stop();
            } catch (Exception e) {
                System.err.println("Error al pausar la música.");
                e.printStackTrace();
            }
        }
    }
}