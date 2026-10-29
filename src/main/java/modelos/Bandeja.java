package modelos;

import java.util.ArrayList;

/**
 * Recurso compartido entre mozos (productores) e invitados (consumidores).
 * La bandeja tiene capacidad para UN solo sanguchito.
 */
public class Bandeja {

    // null significa que la bandeja está vacía
    private ArrayList<Sanguchito> sanguchitos = new ArrayList<>();
    private int maxSanguchitos = 3;

    /**
     * Lo llaman los mozos. Si la bandeja está ocupada, el mozo espera.
     */
    public synchronized void depositar(Sanguchito nuevo) throws InterruptedException {
        while (sanguchitos.size() == maxSanguchitos) {
            System.out.println(nombreHilo() + " espera: la bandeja está llena");
            wait();
        }

        sanguchitos.add(nuevo);
        System.out.println(nombreHilo() + " deposita " + nuevo);
        notifyAll();
    }

    /**
     * Lo llaman los invitados. Si la bandeja está vacía, el invitado espera.
     */
    public synchronized Sanguchito sacar() throws InterruptedException {
        while (sanguchitos.size() == 0) {
            System.out.println(nombreHilo() + " espera: la bandeja está vacía");
            wait();
        }

        Sanguchito sacado = sanguchitos.removeFirst();
        System.out.println(nombreHilo() + " saca " + sacado);
        notifyAll();
        return sacado;
    }

    private String nombreHilo() {
        return Thread.currentThread().getName();
    }
}
