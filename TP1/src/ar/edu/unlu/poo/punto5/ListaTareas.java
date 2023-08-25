package ar.edu.unlu.poo.punto5;

import ar.edu.unlu.poo.lista.Nodo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ListaTareas {

    // Atributos
    Tarea tarea = null;

    // Metodos
    public void agregarTarea(String desc, int prioridad,boolean estado, LocalDate fecha){
        Tarea nuevaTarea = new Tarea();
        nuevaTarea.setDescripcion(desc);
        nuevaTarea.setPrioridad(prioridad);
        nuevaTarea.setEstado(estado);
        nuevaTarea.setFecha_limite(fecha);
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

        sc.close();

        agregarTarea(desc, priori, estado == 1, fechaLimite);
    }

    public void modificarDescripcion(String nuevaDescp){
        tarea.setDescripcion(nuevaDescp);
    }
    public void modificarEstado(int i){
        if(i == 1){
            tarea.setEstado(true);
        } else if (i ==2){
            tarea.setEstado(false);
        }
    }
    public void modificarPrioridad(int i){
        tarea.setPrioridad(i);
    }

    public String toString(){
        String acum = "";
        int i = 1;
        if(tarea == null){
            acum = "No hay ninguna tarea cargada!";
        }
        Tarea tareaAux = tarea;
        System.out.println("Descripcion \t||\tEstado \t||\tFecha limite\n");
        while(tareaAux != null){
            if(tareaAux.getFecha_limite().isBefore(LocalDate.now()) && (!tareaAux.getEstado())){
                acum += i +"|" +tareaAux.getDescripcion() + "\t||\t" + "Incompleta :(" + " (Vencida)" + "\t||\t" + tareaAux.getFecha_limite() + "\n";
            }else{
                if(tareaAux.getEstado()){
                    acum += i +"|" + tareaAux.getDescripcion() + "\t||\t" + "Completada <3" + "\t||\t" + tareaAux.getFecha_limite() + "\n";
                }else{
                    acum += i +"|" + tareaAux.getDescripcion() + "\t||\t" + "Incompleta :(" + "\t||\t" + tareaAux.getFecha_limite() + "\n";
                }
            }
            i++;
            tareaAux = tareaAux.getProximaTarea();
        }
        return acum;
    }
}
