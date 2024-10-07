import java.util.Iterator;
import java.util.NoSuchElementException;

public class SecuenciaEnteros implements Iterable<Integer> {
    private Nodo cabeza;
    private int tamaño;

    public SecuenciaEnteros() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    public void añadir(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
        tamaño++;
    }

    public int obtenerPorIndice(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Nodo actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual.valor;
    }

    public int obtenerPorPosicion(int posicion) {
        return obtenerPorIndice(posicion);  
    }

    public void modificarPorIndice(int indice, int nuevoValor) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Nodo actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        actual.valor = nuevoValor;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IteradorSecuencia();
    }

    private class IteradorSecuencia implements Iterator<Integer> {
        private Nodo actual = cabeza;

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int valor = actual.valor;
            actual = actual.siguiente;
            return valor;
        }
    }

    public void imprimirSecuencia() {
        for (int valor : this) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }

    public int tamaño() {
        return tamaño;
    }
}