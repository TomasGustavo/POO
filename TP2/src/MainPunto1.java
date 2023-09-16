import ar.edu.unlu.poo.Punto1.Club;

import java.util.Scanner;

public class MainPunto1 {
    public static void main(String[] args) {


        Club nuevoClub = new Club("bariloche");

        for(int i =0 ;i<3;i++){
            nuevoClub.nuevaActividad();
        }
        for(int i =0 ;i<3;i++){
            nuevoClub.nuevoSocio();
        }

        System.out.println(nuevoClub.mostrarSocios());
        nuevoClub.mostrarSocioporSubscripcion();
        nuevoClub.mostrarActividadPorSubscripcion();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el mes del que quiera generar un imforme de los socios inscriptos: ");
        String mes = sc.nextLine();
        System.out.println(nuevoClub.informeMensualSocios(mes));
    }
}