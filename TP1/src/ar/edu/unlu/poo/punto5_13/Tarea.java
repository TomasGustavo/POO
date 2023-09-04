package ar.edu.unlu.poo.punto5_13;
import java.time.LocalDate;

public class Tarea {
    // Atributos
    private String descripcion = "";
    private int prioridad;
    private boolean estado;
    LocalDate fecha_limite;
    LocalDate fecha_recordatorio;
    private Colaborador colaborador;
    private LocalDate fechaFinalizacion;
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

    public void setFecha_recordatorio(LocalDate fecha){
        this.fecha_recordatorio = fecha;
    }
    public LocalDate getFecha_recordatorio(){
        return fecha_recordatorio;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public LocalDate getFechaFinalizacion() {
        return fechaFinalizacion;
    }
}
