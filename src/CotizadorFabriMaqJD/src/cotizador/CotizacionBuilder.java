
package cotizador;

public class CotizacionBuilder {
    private final Cotizacion cotizacion = new Cotizacion();

    public CotizacionBuilder setCliente(String c) {
        cotizacion.setCliente(c);
        return this;
    }

    public CotizacionBuilder setDescripcion(String d) {
        cotizacion.setDescripcion(d);
        return this;
    }

    public CotizacionBuilder setPrecio(Precio p) {
        cotizacion.setPrecio(p);
        return this;
    }

    public Cotizacion build() {
        return cotizacion;
    }
}
