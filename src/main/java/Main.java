import modelos.Bandeja;
import modelos.Invitado;
import modelos.Mozo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bandeja bandeja = new Bandeja(); // UNA sola bandeja compartida por todos

        List<Thread> hilos = new ArrayList<>();
        hilos.add(new Thread(new Mozo(bandeja, 12), "Mozo Carlos"));
//        hilos.add(new Thread(new Mozo(bandeja, 6), "Mozo Lucía"));
        hilos.add(new Thread(new Invitado(bandeja, 4), "Invitada Ana"));
        hilos.add(new Thread(new Invitado(bandeja, 4), "Invitado Bruno"));
        hilos.add(new Thread(new Invitado(bandeja, 4), "Invitada Sofía"));

        for (Thread hilo : hilos) {
            hilo.start(); // start() crea el hilo nuevo; run() directo NO lo haría
        }
        for (Thread hilo : hilos) {
            hilo.join(); // el main espera a que todos terminen
        }
        System.out.println("Se terminó la fiesta");
    }
}
