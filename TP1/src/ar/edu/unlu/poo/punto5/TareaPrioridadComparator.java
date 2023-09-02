package ar.edu.unlu.poo.punto5;

import ar.edu.unlu.poo.punto5.Tarea;

import java.util.Comparator;

public class TareaPrioridadComparator implements Comparator<Tarea> {
    @Override
    public int compare(Tarea tarea1, Tarea tarea2) {
        return tarea1.getPrioridad() - tarea2.getPrioridad();
    }
}