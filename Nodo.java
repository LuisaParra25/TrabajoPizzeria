// Clase Nodo
class Nodo {
    Pizza pizza;
    Nodo siguiente;

    public Nodo(Pizza pizza) {
        this.pizza = pizza;
        this.siguiente = null;
    }
}

// Clase Pila
public class PilaManual {
    private Nodo tope;

    public PilaManual() {
        this.tope = null;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public void push(Pizza nuevaPizza) {
        Nodo nuevoNodo = new Nodo(nuevaPizza);
        nuevoNodo.siguiente = tope; // El nuevo apunta al antiguo tope
        tope = nuevoNodo;           // El nuevo nodo ahora es el tope
    }

    public Pizza pop() {
        if (isEmpty()) return null;
        Pizza pizzaRetorno = tope.pizza;
        tope = tope.siguiente; // El tope baja al siguiente nodo
        return pizzaRetorno;
    }

    public Pizza peek() {
        return isEmpty() ? null : tope.pizza;
    }
}
