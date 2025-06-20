package arbolBinario;

public class Main {
    public static void main(String[] args) {
        System.out.println("Árbol binario de búsqueda de números enteros\n");

        ArbolBinario arbolBinario = new ArbolBinario();

        try {
            arbolBinario.insertar(10);
            arbolBinario.insertar(15);
            arbolBinario.insertar(7);
            arbolBinario.insertar(3);
            arbolBinario.insertar(9);
            arbolBinario.insertar(1);

            System.out.println("\nBuscando 15...");
            Nodo resultado = arbolBinario.buscar(15);
            System.out.println((resultado != null) ? "Nodo 15 encontrado." : "Nodo 15 no encontrado.");

            System.out.println("\nEliminando 15...");
            arbolBinario.eliminar(15);

            System.out.println("\nRecorrido preorden:");
            ArbolBinario.preorden(arbolBinario.raizArbol());
            System.out.println("\nRecorrido inorden:");
            ArbolBinario.inorden(arbolBinario.raizArbol());
            System.out.println("\nRecorrido postorden:");
            ArbolBinario.postorden(arbolBinario.raizArbol());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
