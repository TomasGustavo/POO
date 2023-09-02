package ar.edu.unlu.poo.punto5;

import ar.edu.unlu.poo.lista.Nodo;
import ar.edu.unlu.poo.punto5.TareaPrioridadComparator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ListaTareas {

    // Atributos
    Tarea tarea = null;

    // Metodos
    public void agregarTarea(String desc, int prioridad,boolean estado, LocalDate fecha, LocalDate fechaR){
        Tarea nuevaTarea = new Tarea();
        nuevaTarea.setDescripcion(desc);
        nuevaTarea.setPrioridad(prioridad);
        nuevaTarea.setEstado(estado);
        nuevaTarea.setFecha_limite(fecha);
        nuevaTarea.setFecha_recordatorio(fechaR);
        if(tarea == null){
            tarea = nuevaTarea;
            tarea.setProximaTarea(null);
        }else{
            Tarea tareaAux = tarea;
            while(tareaAux.getProximaTarea() != null){
                tareaAux = tareaAux.getProximaTarea();
            }
            tareaAux.setProximaTarea(nuevaTarea);
        }

    }

    public void agregarTareaPorTeclado(){
        Scanner sc = new Scanner(System.in);
        String desc = "";
        int priori;
        int estado;
        String fechaIngresada = "";

        System.out.print("\ningrese descripcion de la tarea: ");
        desc = sc.nextLine();

        System.out.print("\ningrese numero de prioridad de la tarea: ");
        priori = sc.nextInt();
        sc.nextLine();

        System.out.print("\ningrese estado (1- completada | 2- imcompleta) de la tarea: ");
        estado = sc.nextInt();
        sc.nextLine();

        System.out.print("\ningrese fecha limite de la tarea[yyyy-MM-dd]: ");
        fechaIngresada = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaLimite = null;

        try {
            fechaLimite = LocalDate.parse(fechaIngresada, formatter);
            System.out.println("Fecha ingresada: " + fechaLimite);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha incorrecto. Asegúrate de usar yyyy-MM-dd.");
        }

        System.out.println("Desea agregar fecha recordatoria?[1- SI | 2- NO]: ");
        int fr = sc.nextInt();
        sc.nextLine();
        LocalDate fechaR = null;
        if(fr == 1){
            System.out.print("\ningrese fecha Recordatoria de la tarea[yyyy-MM-dd]: ");
            fechaIngresada = sc.nextLine();

            try {
                fechaR = LocalDate.parse(fechaIngresada, formatter);
                System.out.println("Fecha ingresada: " + fechaR);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Asegúrate de usar yyyy-MM-dd.");
            }
        }

        agregarTarea(desc, priori, estado == 1, fechaLimite, fechaR);
    }

    /*public Tarea recuperar(int posicion){
        int i = 0;
        Tarea tareaAux = new Tarea();
        tareaAux = tarea;
        while( i != (posicion-1)){
            tareaAux = tareaAux.getProximaTarea();
            i++;
        }
        return tareaAux;
    }

     */

    public void modificarDescripcion(String nuevaDescp, int posicion){
        int i = 0;
        Tarea tareaAux = tarea;
        while( i != (posicion-1)){
            tareaAux = tareaAux.getProximaTarea();
            i++;
        }
        tareaAux.setDescripcion(nuevaDescp);
    }
    public void modificarEstado(int posicion){
        int i = 0;
        Tarea tareaAux = tarea;
        while( i != (posicion-1)){
            tareaAux = tareaAux.getProximaTarea();
            i++;
        }
        if(!tareaAux.getEstado()){
            tareaAux.setEstado(true);
        }
    }
    public void modificarPrioridad(int priori, int posicion){
        int i = 0;
        Tarea tareaAux = tarea;
        while( i != (posicion-1)){
            tareaAux = tareaAux.getProximaTarea();
            i++;
        }
        tareaAux.setPrioridad(priori);
    }

    public void ordenarPorPrioridad() {
        if (tarea == null || tarea.getProximaTarea() == null) {
            // La lista está vacía o tiene solo un elemento, no es necesario ordenar
            return;
        }

        TareaPrioridadComparator comparator = new TareaPrioridadComparator();
        boolean huboCambio;

        do {
            huboCambio = false;
            Tarea tareaActual = tarea;
            Tarea tareaPrevia = null;

            while (tareaActual.getProximaTarea() != null) {
                Tarea tareaSiguiente = tareaActual.getProximaTarea();

                if (comparator.compare(tareaActual, tareaSiguiente) > 0) {
                    // Intercambia las tareas si la tareaActual tiene una prioridad mayor
                    if (tareaPrevia == null) {
                        tarea = tareaSiguiente;
                    } else {
                        tareaPrevia.setProximaTarea(tareaSiguiente);
                    }
                    tareaActual.setProximaTarea(tareaSiguiente.getProximaTarea());
                    tareaSiguiente.setProximaTarea(tareaActual);
                    huboCambio = true;
                }

                tareaPrevia = tareaActual;
                tareaActual = tareaSiguiente;
            }
        } while (huboCambio);
    }


    public String toString(){
        String acum = "";
        int i = 1;
        if(tarea == null){
            acum = "No hay ninguna tarea cargada!";
        }
        Tarea tareaAux = tarea;
        System.out.println("Descripcion \t||\tEstado \t||\tPrioridad \t||\tFecha limite\n");
        while(tareaAux != null){

            if(tareaAux.getFecha_limite().isBefore(LocalDate.now()) && (!tareaAux.getEstado())){
                acum += i +"|" +tareaAux.getDescripcion() + "\t||\t" + "Incompleta :(" + " (Vencida)" + "\t||\t" + tareaAux.getPrioridad() + "\t||\t"+ tareaAux.getFecha_limite() + "\n";
            }else if((tareaAux.getFecha_recordatorio().isAfter(LocalDate.now()) || tareaAux.getFecha_recordatorio().isEqual(LocalDate.now())) && (!tareaAux.getEstado())){
                if(tareaAux.getFecha_limite().isAfter(tareaAux.getFecha_recordatorio()) ||tareaAux.getFecha_limite().isEqual(tareaAux.getFecha_recordatorio()) ){
                    tareaAux.setPrioridad(1);
                }
                acum += i +"|" +tareaAux.getDescripcion() + "\t||\t" + "Incompleta :(" + " (Por vencer)" + "\t||\t" + tareaAux.getPrioridad() + "\t||\t"+ tareaAux.getFecha_limite() + "\n";
            }else{
                if(tareaAux.getEstado()){
                    acum += i +"|" + tareaAux.getDescripcion() + "\t||\t" + "Completada <3" + "\t||\t"  + tareaAux.getPrioridad() + "\t||\t" + tareaAux.getFecha_limite() + "\n";
                }else{
                    acum += i +"|" + tareaAux.getDescripcion() + "\t||\t" + "Incompleta :(" + "\t||\t" + tareaAux.getPrioridad() + "\t||\t" + tareaAux.getFecha_limite() + "\n";
                }
            }
            i++;
            tareaAux = tareaAux.getProximaTarea();
        }
        return acum;
    }
}
