package cotizador;

public class Maquinaria {
    private final String descripcion;
    private final int precio;

    public Maquinaria(String descripcion, int precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }
}
