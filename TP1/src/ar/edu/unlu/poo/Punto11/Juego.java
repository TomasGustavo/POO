package ar.edu.unlu.poo.Punto11;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego {

    private ArrayList<Jugador> jugadores;
    private Diccionario diccionario = new Diccionario();


    public void agregarJugadores(Jugador j1,Jugador j2){
        jugadores.add(j1);
        jugadores.add(j2);
    }

    public void agregar(){
        diccionario.agregarPalabra();
    }


    public void jugar(){
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        System.out.println("Empecemos el juego");
        System.out.println("Cada jugador tendra secuencialmente la posibilidad de formar una palabra y ver si suma puntaje");
        while(!salir){
            for(Jugador jp : jugadores){
                System.out.println(jp.getNombre()+": ");
                Palabra palabraIngresada = new Palabra();
                if(diccionario.contiene(palabraIngresada) != -1) {
                    jp.setPuntaje(jp.getPuntaje()+ palabraIngresada.getValor());
                    System.out.println("yeeeei sumaste "+palabraIngresada.getValor()+" puntos <3");
                }else{
                    System.out.println("Lo siento la palabra que ingresaste no existe en el diccionario :(");
                }
            }
            System.out.println("Desea contunuar jugando? [1 - SI || 2 - NO]:");
            if(sc.nextInt()==2){
                salir = true;
            }

        }
        System.out.println("PUNTAJES FINALES");
        System.out.println(jugadores.get(0).getNombre()+": "+jugadores.get(0).getPuntaje());
        System.out.println(jugadores.get(1).getNombre()+": "+jugadores.get(1).getPuntaje());
    }
}
