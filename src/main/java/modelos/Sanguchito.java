package modelos;

public class Sanguchito {
    private final String sabor;
    private final String preparadoPor;

    public Sanguchito(String sabor, String preparadoPor) {
        this.sabor = sabor;
        this.preparadoPor = preparadoPor;
    }

    @Override
    public String toString() {
        return "sanguchito de " + sabor + " (de " + preparadoPor + ")";
    }
}
