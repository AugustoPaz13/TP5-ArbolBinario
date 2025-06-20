package arbolBinario;

public class ArbolBinario {
    protected Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public Nodo raizArbol() {
        return raiz;
    }

    boolean esVacio() {
        return raiz == null;
    }

    public void insertar(int valor) throws Exception {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo nodo, int valor) throws Exception {
        if (nodo == null) {
            return new Nodo(valor);
        }
        if (valor < nodo.dato) {
            nodo.izdo = insertarRec(nodo.izdo, valor);
        } else if (valor > nodo.dato) {
            nodo.dcho = insertarRec(nodo.dcho, valor);
        } else {
            throw new Exception("Nodo duplicado: " + valor);
        }
        return nodo;
    }

    public Nodo buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private Nodo buscarRec(Nodo nodo, int valor) {
        if (nodo == null || nodo.dato == valor) {
            return nodo;
        }
        if (valor < nodo.dato) {
            return buscarRec(nodo.izdo, valor);
        } else {
            return buscarRec(nodo.dcho, valor);
        }
    }

    public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private Nodo eliminarRec(Nodo nodo, int valor) {
        if (nodo == null) return null;

        if (valor < nodo.dato) {
            nodo.izdo = eliminarRec(nodo.izdo, valor);
        } else if (valor > nodo.dato) {
            nodo.dcho = eliminarRec(nodo.dcho, valor);
        } else {
            // nodo encontrado
            if (nodo.izdo == null) return nodo.dcho;
            else if (nodo.dcho == null) return nodo.izdo;

            Nodo sucesor = minimo(nodo.dcho);
            nodo.dato = sucesor.dato;
            nodo.dcho = eliminarRec(nodo.dcho, sucesor.dato);
        }
        return nodo;
    }

    private Nodo minimo(Nodo nodo) {
        while (nodo.izdo != null) {
            nodo = nodo.izdo;
        }
        return nodo;
    }

    // Recorrido en preorden
    public static void preorden(Nodo r) {
        if (r != null) {
            r.visitar();
            preorden(r.izdo);
            preorden(r.dcho);
        }
    }

    // Recorrido en inorden
    public static void inorden(Nodo r) {
        if (r != null) {
            inorden(r.izdo);
            r.visitar();
            inorden(r.dcho);
        }
    }

    // Recorrido en postorden
    public static void postorden(Nodo r) {
        if (r != null) {
            postorden(r.izdo);
            postorden(r.dcho);
            r.visitar();
        }
    }
}
