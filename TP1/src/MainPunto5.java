import ar.edu.unlu.poo.punto5.ListaTareas;

import java.time.LocalDate;
import java.util.Scanner;

public class MainPunto5 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        ListaTareas listaDeTareas = new ListaTareas();

        listaDeTareas.agregarTarea("Ir al super mañana",2,false, LocalDate.now().plusDays(1));
        listaDeTareas.agregarTarea("Consultar repuesto del auto",1,false, (LocalDate.now().minusDays(1)));
        listaDeTareas.agregarTarea("Ir al cine a ver la nueva película de Marvel",1,true, (LocalDate.now().minusDays(1)));
        //listaDeTareas.agregarTareaPorTeclado();
        System.out.println(listaDeTareas);

        //ScreenUtilities.LimpiarPantalla();
        ScreenUtilities.pausa();

        System.out.println("vamos a modificar una tarea\n");
        System.out.println("------ Modificar la DESCRIPCION ------\n\n");
        System.out.println(listaDeTareas);
        System.out.print("Seleccione numero de tarea a modificar: ");


        int posicion = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese nueva descripcion: ");
        String nuevoDesc = sc.nextLine();

        ScreenUtilities.pausa();

        listaDeTareas.modificarDescripcion(nuevoDesc,posicion);
        System.out.println(listaDeTareas);

        ScreenUtilities.pausa();

        System.out.println("------ Modificar el ESTADO ------\n\n");
        System.out.println(listaDeTareas);
        System.out.print("Seleccione numero de tarea a modificar:");
        posicion = sc.nextInt();
        sc.nextLine();

        ScreenUtilities.pausa();

        listaDeTareas.modificarEstado(posicion);
        System.out.println(listaDeTareas);
        ScreenUtilities.pausa();

        System.out.println("------ Modificar la PRIORIDAD ------\n\n");
        System.out.println(listaDeTareas);
        System.out.print("Seleccione numero de tarea a modificar:");
        posicion = sc.nextInt();

        System.out.print("Indique nueva prioridad:");
        int priori = sc.nextInt();

        ScreenUtilities.pausa();

        listaDeTareas.modificarPrioridad(priori,posicion);
        System.out.println(listaDeTareas);
    }
}
