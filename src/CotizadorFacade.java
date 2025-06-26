package cotizador;

public class CotizadorFacade {

    public Cotizacion cotizarMaquinaria(String cliente, Maquinaria maquinaria) {
        Precio precio = new ConIVA(new PrecioBase(maquinaria.getPrecio()));
        return new CotizacionBuilder()
                .setCliente(cliente)
                .setDescripcion(maquinaria.getDescripcion())
                .setPrecio(precio)
                .build();
    }

    public Cotizacion cotizarDescripcion(String cliente, String descripcion, int precioBase) {
        Precio precio = new ConIVA(new PrecioBase(precioBase));
        return new CotizacionBuilder()
                .setCliente(cliente)
                .setDescripcion(descripcion)
                .setPrecio(precio)
                .build();
    }
}