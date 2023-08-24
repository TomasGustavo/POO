import ar.edu.unlu.poo.cola.Cola;
import ar.edu.unlu.poo.lista.ListaEnlazada;
import ar.edu.unlu.poo.lista.ListaEnlazadaDoble;
import ar.edu.unlu.poo.pila.Pila;

public class Main {
    public static void main(String[] args) {

        // ------------------ PUNTO 1 ------------------

        /**/ListaEnlazada lista = new ListaEnlazada();

        // metodo de agregar
        System.out.println("vacia?: " + lista.vacia());
        System.out.println(lista.longitud());
        for(int i = 0; i<8;i++){
            lista.agregar(i);
        }
        System.out.print(lista);
        System.out.println("------------------");

        // metodo eliminar (por dato)
        lista.eliminar(4);
        lista.eliminar(6);
        System.out.println(lista.longitud());
        System.out.println("------------------");

        // metodo recuperar (por por posicion logica)
        System.out.print("Dato recuperado: - ");
        System.out.println(lista.recuperar(0));
        System.out.println("------------------");

        // metodo insertar por posicion (logica)
        boolean rta = lista.insertarPosicion(5,10);
        System.out.println(rta);
        System.out.print(lista);
        System.out.println(lista.longitud());
        System.out.println("------------------");


        // ------------------ PUNTO 2 ------------------

        /**/
        ListaEnlazadaDoble listaD = new ListaEnlazadaDoble();

        // metodo de agregar
        System.out.println("--------- AGREGAR ---------");
        System.out.println("vacia?: " + listaD.vacia());
        System.out.println(listaD.longitud());
        for(int i = 0; i<8;i++){
            listaD.agregar(i);
        }
        System.out.print(listaD);
        System.out.println("------------------");

        // metodo eliminar (por dato)
        System.out.println("--------- ELIMINAR ---------");
        listaD.eliminar(4);
        listaD.eliminar(6);
        System.out.print(listaD);
        System.out.println(listaD.longitud());
        System.out.println("------------------");

        // metodo recuperar (por por posicion logica)
        System.out.println("--------- RECUPERAR ---------");
        System.out.print("Dato recuperado: - ");
        System.out.println(listaD.recuperar(5));
        System.out.println("------------------");

        // metodo insertar por posicion (logica)
        System.out.println("--------- INSERTAR ---------");
        boolean rta = listaD.insertarPosicion(1,10);
        System.out.println(rta);
        System.out.print(listaD);
        System.out.println(listaD.longitud());
        System.out.println("------------------");



        // ------------------ PUNTO 3 ------------------
        /**/
        Pila pila = new Pila();

        // metodo de apilar
        System.out.println("--------- APILAR ---------");
        System.out.println("---------- ANTES DE APILAR -------");
        System.out.println("vacia?: " + pila.p_vacia());
        System.out.println("cantidad de elementos de la pila: " + pila.p_longitud());
        for(int i = 0; i<8;i++){
            pila.p_apilar(i);
        }
        System.out.println("---------- DESPUES DE APILAR -------");
        System.out.print(pila);
        System.out.println("cantidad de elementos de la pila: " + pila.p_longitud());
        System.out.println("Tope: " + pila.p_tope());
        System.out.println("------------------");

        // metodo de desapilar
        System.out.println("--------- DESAPILAR ---------");
        Object x = pila.p_desapilar();
        System.out.print(pila);
        System.out.println("elemento recuperado: " + x);
        System.out.println("cantidad de elementos de la pila: " + pila.p_longitud());
        System.out.println("Tope: " + pila.p_tope());
        System.out.println("------------------");



        // ------------------ PUNTO 4 ------------------
        /**/
        Cola cola = new Cola();

        // metodo de encolar
        System.out.println("--------- ENCOLAR ---------");
        System.out.println("---------- ANTES DE ENCOLAR -------");
        System.out.println("vacia?: " + cola.c_vacia());
        System.out.println("cantidad de elementos de la cola: " + cola.c_longitud());
        for(int i = 0; i<8;i++){
            cola.c_encolar(i);
        }
        System.out.println("---------- DESPUES DE ENCOLAR -------");
        System.out.print(cola);
        System.out.println("cantidad de elementos de la cola: " + cola.c_longitud());
        cola.mostrarFrente();
        cola.mostrarFinal();
        System.out.println("------------------");

        // metodo de desencolar
        System.out.println("--------- DESENCOLAR ---------");
        Object y = cola.c_desencolar();
        System.out.print(cola);
        System.out.println("elemento recuperado: " + y);
        System.out.println("cantidad de elementos de la cola: " + cola.c_longitud());
        cola.mostrarFrente();
        cola.mostrarFinal();
        System.out.println("------------------");


    }
}