package ar.edu.unlu.poo.punto5_13;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Colaborador {
    private String nombre;
    private List<Tarea> tareasRealizadas;

    public Colaborador(String nombre){
        this.nombre = nombre;
        this.tareasRealizadas = new ArrayList<>();
    }

    public String getNombre(){
        return nombre;
    }

    public List<Tarea> getTareasRealizadas(){
        return tareasRealizadas;
    }

    public void realizarTarea(Tarea tarea){
        tarea.setEstado(true);
        tarea.setFechaFinalizacion(LocalDate.now());
        tareasRealizadas.add(tarea);
    }
}
