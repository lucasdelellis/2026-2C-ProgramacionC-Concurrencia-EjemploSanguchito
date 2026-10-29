package modelos;

import java.util.Random;

/**
 * Consumidor. También es un Runnable.
 */
public class Invitado implements Runnable {
    private final Bandeja bandeja;
    private final int cantidadAComer;
    private final Random random = new Random();

    public Invitado(Bandeja bandeja, int cantidadAComer) {
        this.bandeja = bandeja;
        this.cantidadAComer = cantidadAComer;
    }

    @Override
    public void run() {
        String nombre = Thread.currentThread().getName();
        try {
            for (int i = 0; i < cantidadAComer; i++) {
                bandeja.sacar();
                Thread.sleep(random.nextInt(800)); // se lo está comiendo
            }
            System.out.println(nombre + " no puede comer más");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
