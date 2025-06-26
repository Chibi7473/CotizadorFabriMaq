# Cotizador – FabriMaq JD

**Alumno:** Jose Diaz  
**Asignatura:** Patrones de Diseño  
**Profesor:** Giovanni Cáceres  
**Evaluación Unidad 3 – Parte 1**

---

## Descripción del sistema

Este sistema permite a los clientes de FabriMaq JD realizar cotizaciones desde consola para distintos tipos de maquinaria agrícola. Se consideran configuraciones de productos, precios variables, IVA y múltiples cotizaciones en una misma sesión.

Al finalizar, se genera automáticamente un archivo `resumen_cotizaciones.txt` con el total acumulado y los productos cotizados.

---

## Patrones de Diseño Aplicados (GoF)

| Patrón         | Tipo           | Implementación técnica |
|----------------|----------------|-------------------------|
| **Facade**     | Estructural    | `CotizadorFacade` centraliza la lógica del sistema. |
| **Strategy**   | Comportamiento | Permite variar el cálculo de precios mediante una interfaz (`Precio`). |
| **Builder**    | Creacional     | `CotizacionBuilder` construye objetos `Cotizacion` paso a paso. |
| **Decorator**  | Estructural    | `ConIVA` añade comportamiento dinámico a `PrecioBase`. |

---

## Instrucciones de uso

1. Abrir el proyecto en **NetBeans** u otro IDE compatible con Java.
2. Asegurarse de tener los archivos `.java` en el paquete `cotizador`.
3. Ejecutar la clase `Main`.

---

## Funcionalidad del sistema

- Cotización de 4 tipos de maquinaria: Clipper, Desbarbador, Columna de Aire, Prelimpiadora.
- Prelimpiadora configurable: tamaño (pequeña/grande), cantidad de harneros y harneros extra.
- Cálculo automático del IVA usando patrón **Decorator**.
- Generación automática del archivo `resumen_cotizaciones.txt` con el total acumulado.
- Flujo continuo de cotizaciones hasta que el usuario decide salir.

---

## Justificación técnica de los patrones

### Facade – `CotizadorFacade`
**Tipo:** Estructural  
Centraliza la lógica de impresión, cálculo y entrada, manteniendo limpio el `Main`.  
Facilita la escalabilidad y mantiene la separación de responsabilidades.

---

### Strategy (implementado como `Precio`)
**Tipo:** Comportamiento  
Define una interfaz `Precio` que permite cambiar la forma de calcular el precio.  
El programa puede soportar precios con descuento, promociones, etc.

---

### Builder – `CotizacionBuilder`
**Tipo:** Creacional  
Permite construir objetos `Cotizacion` de forma clara, sin constructores largos.  
Agrega flexibilidad y claridad al código.

---

### Decorator – `ConIVA`
**Tipo:** Estructural  
Agrega el cálculo de IVA sin modificar el comportamiento original de `PrecioBase`.  
Aplica el principio abierto/cerrado del diseño orientado a objetos.

---
