import ar.edu.unlu.poo.lista.ListaEnlazada;

public class Main {
    public static void main(String[] args) {

        ListaEnlazada lista = new ListaEnlazada();

        lista.agregar("Hola ");
        lista.agregar("mundo!");
        System.out.println(lista);
    }
}