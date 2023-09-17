package ar.edu.unlu.poo.Punto3;

import java.util.ArrayList;

public class Disciplina {
    private String nombre;
    private String descripcion;
    private ArrayList<String> nivel = new ArrayList<>();

    private int cantidadDeAlumnosEnTotal=0;

    public Disciplina (String nombre,String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre(){
        return nombre;
    }

    public  String getDescripcion(){
        return descripcion;
    }
    public void agregarAlumno(){
        this.cantidadDeAlumnosEnTotal ++;
    }

    public int getCantidadDeAlumnosEnTotal(){
        return cantidadDeAlumnosEnTotal;
    }

    private void setNivel(){
        nivel.add("inicial");
        nivel.add("intermedio");
        nivel.add("avanzado");
    }
    public String getNivel(int i){
        return nivel.get(i);
    }

    public String toString(){
        String acum = "";
        acum += "\nNombre: "+ nombre+"\nDescipcion: "+ descripcion+"\n------------------------------\n";
        return acum;
    }
}