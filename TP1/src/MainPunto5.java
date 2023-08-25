import ar.edu.unlu.poo.punto5.ScreenUtilities;
import ar.edu.unlu.poo.punto5.ListaTareas;

import java.time.LocalDate;

public class MainPunto5 {
    public static void main(String[] args) {

        ListaTareas listaDeTareas = new ListaTareas();

        listaDeTareas.agregarTarea("Ir al super mañana",2,false, LocalDate.now().plusDays(1));
        listaDeTareas.agregarTarea("Consultar repuesto del auto",1,false, (LocalDate.now().minusDays(1)));
        listaDeTareas.agregarTarea("Ir al cine a ver la nueva película de Marvel",1,true, (LocalDate.now().minusDays(1)));
        //listaDeTareas.agregarTareaPorTeclado();
        System.out.println(listaDeTareas);

        ScreenUtilities.LimpiarPantalla();


        System.out.println("vamos a modificar una tarea");


    }
}
