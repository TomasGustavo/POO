package ar.edu.unlu.poo.punto5;
import java.time.LocalDate;

public class Tarea {
    // Atributos
    private String descripcion = "";
    private int prioridad;
    private boolean estado;
    LocalDate fecha_limite;
    Tarea proximaTarea = null;


    // Metodos
    public void setDescripcion(String desc){
        this.descripcion = desc;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setPrioridad(int prioridad){
        this.prioridad = prioridad;
    }
    public int getPrioridad(){
        return prioridad;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public boolean getEstado(){
        return estado;
    }
    public void setFecha_limite(LocalDate fecha){
        this.fecha_limite = fecha;
    }
    public LocalDate getFecha_limite(){
        return fecha_limite;
    }

    public void setProximaTarea(Tarea proximaTarea) {
        this.proximaTarea = proximaTarea;
    }

    public Tarea getProximaTarea() {
        return proximaTarea;
    }
}
