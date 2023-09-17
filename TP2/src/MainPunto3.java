import ar.edu.unlu.poo.Punto3.EscuelaDanza;

import java.util.Scanner;

public class MainPunto3 {
    public static void main(String[] args) {

        EscuelaDanza escuela = new EscuelaDanza();
        Scanner sc = new Scanner(System.in);
        String nombre;
        for(int i =0 ; i<4; i++){
            System.out.println("Ingres nombre de la nueva disciplina: ");
            nombre = sc.nextLine();
            System.out.println("Ingrese la descripcion de esta disciplina: ");
            escuela.agregarDisciplina(nombre,sc.nextLine());
        }

        for(int i =0 ; i<4; i++){
            escuela.agregarComision();
        }

        for(int i =0 ; i<5; i++){
            escuela.nuevoAlumno();
        }

        escuela.registrarAsistencia();
        escuela.registrarAsistencia();
        escuela.registrarAsistencia();
        escuela.registrarAsistencia();

        escuela.reporteDisciplimaMasRedituable();


    }
}
