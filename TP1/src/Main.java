import ar.edu.unlu.poo.lista.ListaEnlazada;
import ar.edu.unlu.poo.lista.ListaEnlazadaDoble;

public class Main {
    public static void main(String[] args) {

        /*ListaEnlazada lista = new ListaEnlazada();

        // metodo de agregar
        System.out.println(lista.vacia());
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
        */

        ListaEnlazadaDoble listaD = new ListaEnlazadaDoble();

        // metodo de agregar
        System.out.println("--------- AGREGAR ---------");
        System.out.println(listaD.vacia());
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
    }
}