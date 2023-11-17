package operation;

public class StackInteger {
    NodoInteger top;

    public StackInteger() {
        top = null;
    }

    public void push(NodoEnterosArbol value) {
        NodoInteger nodo = new NodoInteger();
        nodo.value = value;
        nodo.next = top;
        top = nodo;
    }

    public NodoEnterosArbol pop() {
        NodoEnterosArbol value = top.value;
        top = top.next;
        return value;
    }

    public boolean isEmpty() {
        return top == null;
    }
}