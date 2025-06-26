
package cotizador;

public class Cotizacion {
    private String cliente;
    private String descripcion;
    private Precio precio;

    public void setCliente(String cliente) { this.cliente = cliente; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrecio(Precio precio) { this.precio = precio; }

    public String getDescripcion() { return descripcion; }
    public int getTotal() { return precio.calcular(); }

    public void mostrar() {
        System.out.println("\n--- COTIZACIoN ---");
        System.out.println("Cliente: " + cliente);
        System.out.println("Producto: " + descripcion);
        System.out.println("Precio total con IVA: $" + getTotal());
        System.out.println("---------------------------\n");
    }
}
