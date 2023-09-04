import ar.edu.unlu.poo.punto5_13.ListaTareas;

import java.util.Scanner;

public class MainPunto5_13 {

    public static void menu(){
        System.out.println("1| Agregar Tarea a la lista");
        System.out.println("2| Modificar Tarea");
        System.out.println("3| Mostrar lista de Tareas");
        System.out.println(AnsiColor.RED+"\n\n\t0| Salir"+AnsiColor.RESET);
    }

    public static void menu_modificar(){
        System.out.println("1| Modificar descripcion");
        System.out.println("2| Modificar Prioridad");
        System.out.println("3| Marcar como Terminda");
        System.out.println(AnsiColor.RED+"\n\n\t0| Salir"+AnsiColor.RESET);
    }

    public static void main_agregar(ListaTareas lista){

        lista.agregarTareaPorTeclado();
        lista.ordenarPorPrioridad();
        //ScreenUtilities.pausa();
        ScreenUtilities.LimpiarPantalla();
    }

    public static void main_modificar(ListaTareas lista){
        Scanner sc = new Scanner(System.in);

        boolean salir = false;
        while(!salir){
            ScreenUtilities.LimpiarPantalla();
            System.out.println(lista);
            System.out.println(AnsiColor.MAGENTA+"Seleccione que Tarea quiere modificar [indique el numero con el que figura] [0 para salir]");
            int tarea = sc.nextInt();
            sc.nextLine();
            if(tarea == 0){
                return;
            }
            menu_modificar();
            int opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1 -> {
                    System.out.println("Ingrese nueva descripcion: ");
                    String desc = sc.nextLine();
                    lista.modificarDescripcion(desc, tarea);
                }
                case 2 -> {
                    System.out.println("Ingrese nueva prioridad");
                    int priori = sc.nextInt();
                    sc.nextLine();
                    lista.modificarPrioridad(priori, tarea);
                }
                case 3 -> {
                    lista.modificarEstado(tarea);
                    ScreenUtilities.pausa();
                }
                case 0 -> salir = true;
            }
        }
        sc.nextLine();

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ListaTareas listaDeTareas = new ListaTareas();

        boolean salir = false;

        while(!salir){
            ScreenUtilities.LimpiarPantalla();
            menu();
            System.out.print("OPCION:");
            int opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1 -> main_agregar(listaDeTareas);
                case 2 -> main_modificar(listaDeTareas);
                case 3 -> {
                    System.out.println(listaDeTareas);
                    ScreenUtilities.pausa();
                }
                case 0 -> salir = true;
            }
        }
    }
}
