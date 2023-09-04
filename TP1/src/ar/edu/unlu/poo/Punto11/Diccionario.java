package ar.edu.unlu.poo.Punto11;

import java.util.ArrayList;
import java.util.Scanner;

public class Diccionario {
    // Atributos
    private ArrayList<Palabra> palabras;


    //Metodos

    public void agregarPalabra(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese palabra a agregar al diccionario del juego: ");
        Palabra nuevaPalabra = new Palabra();
        nuevaPalabra.setStats(sc.nextLine());

        palabras.add(nuevaPalabra);
    }


    public int contiene(Palabra palabra){
        for (Palabra palabraEnArray : palabras){
            if(palabraEnArray.getPalabra() == palabra.getPalabra()){
                return palabraEnArray.getValor();
            }
        }
        return -1;
    }


}
