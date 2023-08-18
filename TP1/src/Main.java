import ar.edu.unlu.poo.lista.ListaEnlazada;

public class Main {
    public static void main(String[] args) {

        ListaEnlazada lista = new ListaEnlazada();

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

    }
}