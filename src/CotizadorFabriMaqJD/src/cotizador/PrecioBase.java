
package cotizador;

public class PrecioBase implements Precio {
    private final int base;

    public PrecioBase(int base) {
        this.base = base;
    }

    @Override
    public int calcular() {
        return base;
    }
}
