package operation;



// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /*
         *
         *
         *             4
         *          /     \
         *        1        6
         *      /  \        \
         *    0     2        9
         *                    \
         *                     13
         *
         */

        NodoEnterosArbol padre = new NodoEnterosArbol();  //1
        //System.out.println(padre.valor);
        padre.valor = 4;


        NodoEnterosArbol hijoIzquierdo = new NodoEnterosArbol(); //2
        hijoIzquierdo.valor = 1;
        NodoEnterosArbol hijoDerecho = new NodoEnterosArbol();  //3
        hijoDerecho.valor = 6;

        padre.hijoIzquierdo = hijoIzquierdo;

        padre.hijoDerecho = hijoDerecho;

        NodoEnterosArbol hijoIzquierdoDelHijoIzquierdo = new NodoEnterosArbol(); //4
        hijoIzquierdoDelHijoIzquierdo.valor = 0;

        NodoEnterosArbol hijoDerechoDelHijoIzquierdo = new NodoEnterosArbol(); //5
        hijoDerechoDelHijoIzquierdo.valor = 2;
        hijoIzquierdo.hijoDerecho = hijoDerechoDelHijoIzquierdo;

        hijoIzquierdo.hijoIzquierdo = hijoIzquierdoDelHijoIzquierdo;

        NodoEnterosArbol hijoDerechoDelHijoDerecho = new NodoEnterosArbol(); //6
        hijoDerechoDelHijoDerecho.valor = 9;
        hijoDerecho.hijoDerecho = hijoDerechoDelHijoDerecho;

        NodoEnterosArbol hijoDerechoDelHijoDerechoDelHijoDerecho = new NodoEnterosArbol(); //7
        hijoDerechoDelHijoDerechoDelHijoDerecho.valor = 13;
        hijoDerechoDelHijoDerecho.hijoDerecho = hijoDerechoDelHijoDerechoDelHijoDerecho;


        NodoEnterosArbol.Callback callback = nodo->nodo.valor;
        padre.recorrerInOrderNoRecursivo(callback);






        

        //System.out.println(padre.esHoja());  //Falso
        //System.out.println(hijoIzquierdo.esHoja()); //Falso
        //System.out.println(hijoDerecho.esHoja()); //Verdadero
        //System.out.println(hijoIzquierdoDelHijoIzquierdo.esHoja()); //Verdadero


        //int nodos = padre.contarNodos();
        //System.out.println(nodos);
        //padre.recorrerInOrder();
        //padre.recorrerPostOrder();

        //int niveles = padre.contarNiveles(0,0);
        //System.out.println(niveles);
        //int hojas = padre.contarHojas();
        //System.out.println(hojas);

    }

}