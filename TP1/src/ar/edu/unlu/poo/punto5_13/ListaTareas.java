package ar.edu.unlu.poo.punto5_13;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
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

        Scanner sc = new Scanner(System.in);
        int i = 0;
        Tarea tareaAux = tarea;
        while( i != (posicion-1)){
            tareaAux = tareaAux.getProximaTarea();
            i++;
        }
        if(!tareaAux.getEstado()){
            tareaAux.setEstado(true);
        }
        System.out.println("Ingrese nombre del colaborar que finalizo la tarea: ");
        Colaborador colab = new Colaborador(sc.nextLine());
        tareaAux.setColaborador(colab);
        colab.realizarTarea(tareaAux);
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

    private boolean recordar(Tarea tareaAux){
        boolean rta;
        if(tareaAux.getFecha_recordatorio() == null){
            rta = false;
        }else{
            rta = tareaAux.getFecha_recordatorio().isAfter(LocalDate.now()) || tareaAux.getFecha_recordatorio().isEqual(LocalDate.now());
        }

        return rta;
    }


    public String toString(){
        String acum = "";
        int i = 1;
        if(tarea == null){
            acum = "No hay ninguna tarea cargada!";
        }
        Tarea tareaAux = tarea;
        //System.out.println("Descripcion \t||\tEstado \t||\tPrioridad \t||\tFecha limite\n");
        while(tareaAux != null){

            if(tareaAux.getFecha_limite().isBefore(LocalDate.now()) && (!tareaAux.getEstado())){
                acum += i +""+ AnsiColor.BLUE + "| Descripcion:" +AnsiColor.BLUE +""+ tareaAux.getDescripcion() + AnsiColor.BLUE +"\nEstado:"+AnsiColor.YELLOW +" Incompleta :( (Vencida)" + AnsiColor.BLUE +"\nPrioridad:" + AnsiColor.YELLOW +tareaAux.getPrioridad() +AnsiColor.BLUE+ "\nFecha limite:" +AnsiColor.YELLOW+ tareaAux.getFecha_limite() + "\n\n";
            }else if (recordar(tareaAux)) {
                if (!tareaAux.getEstado()) {
                    if (tareaAux.getFecha_limite().isAfter(tareaAux.getFecha_recordatorio()) || tareaAux.getFecha_limite().isEqual(tareaAux.getFecha_recordatorio())) {
                        tareaAux.setPrioridad(1);
                    }
                    acum += i +""+ AnsiColor.BLUE + "| Descripcion: " +AnsiColor.YELLOW + tareaAux.getDescripcion() + AnsiColor.BLUE +"\nEstado:"+AnsiColor.YELLOW +" Incompleta :( (Por vencer)" + AnsiColor.BLUE +"\nPrioridad:" + AnsiColor.YELLOW +tareaAux.getPrioridad() +AnsiColor.BLUE+ "\nFecha limite:" +AnsiColor.YELLOW+ tareaAux.getFecha_limite() + "\n\n";
                } else {
                    if (tareaAux.getEstado()) {
                        acum += i +""+ AnsiColor.BLUE + "| Descripcion: " +AnsiColor.YELLOW+ tareaAux.getDescripcion() + AnsiColor.BLUE +"\nEstado:"+AnsiColor.YELLOW +" Completada <3" + AnsiColor.BLUE +"\nPrioridad:" + AnsiColor.YELLOW +tareaAux.getPrioridad() +AnsiColor.BLUE+ "\nFecha limite:" +AnsiColor.YELLOW+ tareaAux.getFecha_limite() + "\n\n";
                    } else {
                        acum += i +""+ AnsiColor.BLUE + "| Descripcion: " +AnsiColor.YELLOW + tareaAux.getDescripcion() + AnsiColor.BLUE +"\nEstado:"+AnsiColor.YELLOW +" Incompleta :( " + AnsiColor.BLUE +"\nPrioridad:" + AnsiColor.YELLOW +tareaAux.getPrioridad() +AnsiColor.BLUE+ "\nFecha limite:" +AnsiColor.YELLOW+ tareaAux.getFecha_limite() + "\n\n";
                    }
                }
            } else {
                if (tareaAux.getEstado()) {
                    acum += i +""+ AnsiColor.BLUE + "| Descripcion: " +AnsiColor.YELLOW + tareaAux.getDescripcion() + AnsiColor.BLUE +"\nEstado:"+AnsiColor.YELLOW +" Completada <3" + AnsiColor.BLUE +"\nPrioridad:" + AnsiColor.YELLOW +tareaAux.getPrioridad() +AnsiColor.BLUE+ "\nFecha limite:" +AnsiColor.YELLOW+ tareaAux.getFecha_limite() + "\n\n";
                } else {
                    acum += i +""+ AnsiColor.BLUE + "| Descripcion: " +AnsiColor.YELLOW + tareaAux.getDescripcion() + AnsiColor.BLUE +"\nEstado:"+AnsiColor.YELLOW +" Incompleta :( " + AnsiColor.BLUE +"\nPrioridad:" + AnsiColor.YELLOW +tareaAux.getPrioridad() +AnsiColor.BLUE+ "\nFecha limite:" +AnsiColor.YELLOW+ tareaAux.getFecha_limite() + "\n\n"+ AnsiColor.RESET;
                }
            }
            i++;
            tareaAux = tareaAux.getProximaTarea();
        }
        return acum;
    }



    public List<Tarea> obtenerTareasRealizadasPorColaborador(Colaborador colaborador) {
        List<Tarea> tareasRealizadasPorColaborador = new ArrayList<>();
        Tarea tareaActual = tarea;

        while (tareaActual != null) {
            if (tareaActual.getColaborador() != null && tareaActual.getColaborador().equals(colaborador)) {
                tareasRealizadasPorColaborador.add(tareaActual);
            }
            tareaActual = tareaActual.getProximaTarea();
        }

        return tareasRealizadasPorColaborador;
    }

}
