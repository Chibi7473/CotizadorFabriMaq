
package cotizador;

public class ConIVA implements Precio {
    private final Precio base;

    public ConIVA(Precio base) {
        this.base = base;
    }

    @Override
    public int calcular() {
        return (int)(base.calcular() * 1.19);
    }
}
