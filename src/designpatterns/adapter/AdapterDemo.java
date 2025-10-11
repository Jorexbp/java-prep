package designpatterns.adapter;

/*
   Adapter (Estructural)
   ► Permite que dos interfaces incompatibles colaboren, actuando como “traductor”.
   ► Problema: reutilizar una clase existente cuya interfaz no coincide con lo que espera el cliente.
*/
public class AdapterDemo {

    // Target: lo que el cliente espera usar
    interface MediaPlayer {
        void play(String filename);
    }

    // Adaptee: clase existente con una interfaz diferente
    static class AdvancedPlayer {
        public void playMp4(String file) {
            System.out.println("Reproduciendo MP4: " + file);
        }
    }

    // Adapter: traduce de MediaPlayer a AdvancedPlayer
    static class Mp4Adapter implements MediaPlayer {
        private final AdvancedPlayer advanced = new AdvancedPlayer();

        public void play(String filename) {
            advanced.playMp4(filename);
        }
    }

    public static void main(String[] args) {
        MediaPlayer player = new Mp4Adapter(); // el cliente habla MediaPlayer
        player.play("video.mp4");              // por debajo usa AdvancedPlayer
    }
}
