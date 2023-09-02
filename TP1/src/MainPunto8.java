import ar.edu.unlu.poo.Punto8.Contrasenia;
import ar.edu.unlu.poo.Punto8.Generador;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPunto8 {
    public static void main(String[] args) {
        Generador nuevoGenerador = new Generador();

        ArrayList<Contrasenia> listaContra = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de contraseñas a generar: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese la cantidad de caracteres que tendran las contraseñas: ");
        int caract = sc.nextInt();
        sc.nextLine();
        for(int i =0 ; i<cantidad;i++){
            listaContra.add(nuevoGenerador.generar(caract));
        }

        for(Contrasenia contra : listaContra){
            if(contra.getFuerte()){
                System.out.println("<"+contra.getContra()+">" + " -FUERTE");
            }else{
                System.out.println("<"+contra.getContra()+">" + " -DEBIL");
            }
        }

        System.out.println("Quiere regenerar las contraseñas debiles? [1 - SI || 2 - NO]: ");
        int opc = sc.nextInt();
        sc.nextLine();
        if(opc == 1){
            int i = 0;
            for (Contrasenia contra : listaContra){
                while(!contra.getFuerte()){
                    contra = nuevoGenerador.generar(caract);
                    listaContra.set(i,contra);
                }
                i++;
            }

            for(Contrasenia contra : listaContra){
                if(contra.getFuerte()){
                    System.out.println("<"+contra.getContra()+">" + " -FUERTE");
                }else{
                    System.out.println("<"+contra.getContra()+">" + " -DEBIL");
                }
            }
        }



    }



}
