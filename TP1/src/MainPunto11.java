import ar.edu.unlu.poo.Punto11.Juego;
import ar.edu.unlu.poo.Punto11.Jugador;

import java.util.Scanner;

public class MainPunto11 {

    public static void menu(){
        System.out.println("1| agregar palabras al diccionario");
        System.out.println("2| Jugar");
        System.out.println("\n\n\t0| SALIR");
    }

    public static void menu_jugar(Juego juego){

        Scanner sc = new Scanner(System.in);
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        System.out.println("Ingrese el nombre del jugador 1:");
        jugador1.setNombre(sc.nextLine());
        System.out.println("Ingrese el nombre del jugador 2:");
        jugador2.setNombre(sc.nextLine());

        juego.agregarJugadores(jugador1,jugador2);


    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean salir= false;
        while(!salir){
            Juego nuevoJuego = new Juego();
            menu();
            int opc = sc.nextInt();
            sc.nextLine();
            switch (opc){
                case 1 -> nuevoJuego.agregar();
                case 2 -> menu_jugar(nuevoJuego);
                case 0 -> salir=true;
            }

        }
    }
}
