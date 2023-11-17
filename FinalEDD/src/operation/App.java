package operation;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Este programa permite trabajar con Árboles.");
        System.out.println("Digite el número de valores: ");
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int valores = -1;
        while (flag) {
            try {
                //int valores = scanner.nextInt();
                valores = scanner.nextInt();
                System.out.println("El valor ingresado es: " + valores);
                flag = false;
            } catch (InputMismatchException ex) {
                System.out.println("Usted ingresó un valor no numérico, por favor ingrese un valor numérico: ");
                scanner.nextLine();
            }
        }

        switch(valores){
            case -1: {
                NodoEnterosArbol padre = loopInfinito();
                //Menu menu = new Menu();
                //menu.padre = padre;
                //menu.mostrar_menu();
                System.out.println("el recorrido in order iterativo es:");
                NodoEnterosArbol.Callback callback = nodo->nodo.valor;
                padre.recorrerInOrderNoRecursivo(callback);
                break;
            }
            case 0: {
                System.out.println("Usted ingresó un arbol null");
                break;
            }
            default:
                NodoEnterosArbol padre =loopDefinido(valores);
                //padre.recorrerInOrder();
                //Menu menu = new Menu();
                //menu.padre = padre;
                //menu.mostrar_menu();
                System.out.println("el recorrido in order iterativo es:");
                NodoEnterosArbol.Callback callback = nodo->nodo.valor;
                padre.recorrerInOrderNoRecursivo(callback);
                break;
        }
    }


    private static NodoEnterosArbol construirArbol(NodoEnterosArbol padre, int valor){
        if(padre==null){
            padre = new NodoEnterosArbol();
            padre.valor = valor;
            return padre;
        }

        if (valor<padre.valor){
            padre.hijoIzquierdo = construirArbol(padre.hijoIzquierdo,valor);
        } else if (valor > padre.valor) {
            padre.hijoDerecho = construirArbol(padre.hijoDerecho, valor);
        }

        return padre;

    }

    private static NodoEnterosArbol loopInfinito() {
        Scanner sc = new Scanner(System.in);
        String valor = "";
        boolean flag = true;
        NodoEnterosArbol padre = null; // Initialize outside the loop
        while (flag) {
            System.out.println("Ingrese el valor del nodo: ");
            valor = sc.next();
            if (valor.equalsIgnoreCase("X")) {
                flag = false;
            } else {
                int valorInt = Integer.parseInt(valor);
                if (padre == null) {
                    padre = new NodoEnterosArbol();
                    padre.valor = valorInt;
                } else {
                    padre = construirArbol(padre, valorInt);
                }
            }
        }
        //sc.close(); // Close the scanner to release resources.
        return padre;
    }

    private static NodoEnterosArbol loopDefinido(int valores){
        Scanner sc2 = new Scanner(System.in);
        String valor = "";
        NodoEnterosArbol padre = new NodoEnterosArbol();
        for (int i=0; i<valores; i++){
            System.out.println("Ingrese el valor del nodo: ");
            valor = sc2.next();
            if (valor.equalsIgnoreCase("X")) {
                break;
            }
            else{
                int valorInt = Integer.parseInt(valor);
                if(i==0){
                    padre.valor= valorInt;
                }
                else{
                    padre = construirArbol(padre, valorInt);

                }
            }
        }
        //sc2.close();
        return padre;
    }


}

