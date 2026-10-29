package modelos;

import java.util.Random;

/**
 * Productor. Implementa Runnable: describe la TAREA a ejecutar,
 * pero no es un hilo en sí mismo. El hilo se crea en el Main.
 */
public class Mozo implements Runnable {
    private static final String[] SABORES = {"jamón y queso", "salame", "atún", "palmitos", "lechuga y tomate"};

    private final Bandeja bandeja;
    private final int cantidadADepositar;
    private final Random random = new Random();

    public Mozo(Bandeja bandeja, int cantidadADepositar) {
        this.bandeja = bandeja;
        this.cantidadADepositar = cantidadADepositar;
    }

    @Override
    public void run() {
        String nombre = Thread.currentThread().getName();
        try {
            for (int i = 0; i < cantidadADepositar; i++) {
                Thread.sleep(random.nextInt(500)); // tarda en ir a buscarlo a la cocina
                String sabor = SABORES[random.nextInt(SABORES.length)];
                bandeja.depositar(new Sanguchito(sabor, nombre));
            }
            System.out.println(nombre + " terminó su turno");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // restauramos la marca de interrupción
        }
    }
}
