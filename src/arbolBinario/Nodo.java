package arbolBinario;

public class Nodo {
    protected int dato;
    protected Nodo izdo;
    protected Nodo dcho;

    public Nodo(int valor) {
        dato = valor;
        izdo = null;
        dcho = null;
    }

    public Nodo(Nodo ramaIzdo, int valor, Nodo ramaDcho) {
        this.dato = valor;
        izdo = ramaIzdo;
        dcho = ramaDcho;
    }

    void visitar() {
        System.out.print(dato + " ");
    }
}
