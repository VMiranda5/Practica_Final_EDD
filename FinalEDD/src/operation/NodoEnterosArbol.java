package operation;

public class NodoEnterosArbol {

    int valor;
    NodoEnterosArbol padre;
    NodoEnterosArbol hijoIzquierdo;
    NodoEnterosArbol hijoDerecho;

    boolean esHoja() {
        return hijoIzquierdo == null && hijoDerecho == null;
    }
    interface Callback{
        int obtener_valor(NodoEnterosArbol nodo);
    }
    void recorrerInOrderNoRecursivo(Callback callback){

        NodoEnterosArbol currentNode= this;
        StackInteger nodos_arbol = new StackInteger();

        while (currentNode != null || !nodos_arbol.isEmpty()){

            while (currentNode !=null){
                nodos_arbol.push(currentNode);
                currentNode=currentNode.hijoIzquierdo;

            }
            currentNode=nodos_arbol.pop();
            int valor_nodo= callback.obtener_valor(currentNode);
            System.out.println(valor_nodo);

            currentNode=currentNode.hijoDerecho;
        }
    }

    void recorrerInOrder() {
        if (hijoIzquierdo != null) {
            hijoIzquierdo.recorrerInOrder();
        }
        System.out.println(valor);
        if (hijoDerecho != null) {
            hijoDerecho.recorrerInOrder();
        }
    }
    void recorrerPreOrder() {
        System.out.println(valor);
        if (hijoIzquierdo != null) {
            hijoIzquierdo.recorrerPreOrder();
        }
        if (hijoDerecho != null) {
            hijoDerecho.recorrerPreOrder();
        }
    }

    void recorrerPostOrder() {
        if (hijoIzquierdo != null) {
            hijoIzquierdo.recorrerPostOrder();
        }
        if (hijoDerecho != null) {
            hijoDerecho.recorrerPostOrder();
        }
        System.out.println(valor);
    }

    int contarNodos() {
        int nodos = 1; // Initialize the count to 1 for the current node

        if (hijoIzquierdo != null) {
            nodos += hijoIzquierdo.contarNodos();
        }

        if (hijoDerecho != null) {
            nodos += hijoDerecho.contarNodos();
        }

        return nodos;
    }


    int contarHojas() {
        if(this.esHoja()){
            return 1;
        }
        else {
            if (hijoIzquierdo!=null && hijoDerecho!=null) {
                return hijoIzquierdo.contarHojas() + hijoDerecho.contarHojas();
            }
            if (hijoIzquierdo!=null){
                return hijoIzquierdo.contarHojas();
            }
            if (hijoDerecho!=null){
                return hijoDerecho.contarHojas();
            }
            else{
                return 0;
            }
        }
    }


    int contarNiveles(int niveles_izquierdos, int niveles_derechos) {
        if (this.esHoja()){
            return 0;
        }
        if (hijoIzquierdo!=null) {
            niveles_izquierdos = hijoIzquierdo.contarNiveles(niveles_izquierdos, niveles_derechos);
        }
        if (hijoDerecho!=null) {
            niveles_derechos = hijoDerecho.contarNiveles(niveles_izquierdos, niveles_derechos);
        }

        return Math.max(niveles_izquierdos,niveles_derechos)+1;
    }

    int calcularAncho(){
        return 0;
    }

}

