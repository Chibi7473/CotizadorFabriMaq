package cotizador;

import java.util.Scanner;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static boolean continuarCotizando = true;
    public static int resumenTotal = 0;
    public static List<String> productosCotizados = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CotizadorFacade facade = new CotizadorFacade();

        while (continuarCotizando) {
            System.out.println("=== FabriMaq JD - Cotizador ===");
            System.out.print("Ingrese su nombre: ");
            String cliente = scanner.nextLine();

            System.out.println("Seleccione tipo de maquinaria:");
            System.out.println("1. Clipper");
            System.out.println("2. Desbarbador");
            System.out.println("3. Columna de aire");
            System.out.println("4. Pre-limpiadora");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 4) {
                System.out.print("Tamaño (1: Pequeña, 2: Grande): ");
                int tam = scanner.nextInt();
                scanner.nextLine();

                String tamaño = (tam == 2) ? "Grande" : "Pequeña";
                int base = (tam == 2) ? 3400000 : 2400000;

                System.out.print("Cantidad de harneros: ");
                int cant = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Cotizar tambien 16 harneros? (s/n): ");
                String extra = scanner.nextLine();

                Cotizacion cot = facade.cotizarDescripcion(cliente, "Pre-limpiadora " + tamaño + " con " + cant + " harneros", base + cant * 20000);
                cot.mostrar();
                resumenTotal += cot.getTotal();
                productosCotizados.add(cot.getDescripcion());

                if (extra.equalsIgnoreCase("s")) {
                    Cotizacion extraCot = facade.cotizarDescripcion(cliente, "Juego adicional de 16 harneros", 320000);
                    extraCot.mostrar();
                    resumenTotal += extraCot.getTotal();
                    productosCotizados.add(extraCot.getDescripcion());
                }
            } else {
                Maquinaria maquinaria = switch (opcion) {
                    case 1 -> new Maquinaria("Clipper", 6950000);
                    case 2 -> new Maquinaria("Desbarbador", 3554900);
                    case 3 -> new Maquinaria("Columna de aire", 1400000);
                    default -> null;
                };

                if (maquinaria != null) {
                    Cotizacion cot = facade.cotizarMaquinaria(cliente, maquinaria);
                    cot.mostrar();
                    resumenTotal += cot.getTotal();
                    productosCotizados.add(cot.getDescripcion());
                } else {
                    System.out.println("Opcion invalida");
                }
            }

            System.out.print("Desea realizar otra cotizacion? (s/n): ");
            String repetir = scanner.nextLine();
            if (!repetir.equalsIgnoreCase("s")) {
                continuarCotizando = false;
                System.out.println("Gracias por usar el sistema de cotizacion FabriMaq JD.");
                System.out.println("Total acumulado de todas las cotizaciones: $" + resumenTotal);
                try (FileWriter writer = new FileWriter("resumen_cotizaciones.txt")) {
                    writer.write("Resumen de cotizaciones FabriMaq JD\n");
                    for (String p : productosCotizados) {
                        writer.write("- " + p + "\n");
                    }
                    writer.write("Total acumulado: $" + resumenTotal);
                    System.out.println("Resumen guardado en archivo resumen_cotizaciones.txt");
                } catch (Exception e) {
                    System.out.println("Error al guardar el resumen: " + e.getMessage());
                }
            }
        }
    }
}