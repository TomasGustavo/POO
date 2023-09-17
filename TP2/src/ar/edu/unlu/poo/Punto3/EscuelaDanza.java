package ar.edu.unlu.poo.Punto3;

import java.util.ArrayList;
import java.util.Scanner;

public class EscuelaDanza {
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Comision> comisiones;
    private ArrayList<Alumno> alumnos;


    public void agregarDisciplina(String nombre, String desc){
        Disciplina disciplina = new Disciplina(nombre,desc);
        disciplinas.add(disciplina);
    }
    public void agregarComision(){
        for(Disciplina dis : disciplinas){
            System.out.println(dis);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("seleccion la disciplina [escriba el nombre de la disciplina]: ");
        String nombre = sc.nextLine();
        Disciplina nd = null;
        for(Disciplina dis : disciplinas){
            if(dis.getNombre().equals(nombre)){
                nd = dis;
            }
        }
        Comision nuevaComision = new Comision();
        assert nd != null;
        nuevaComision.nuevaComision(nd);
        comisiones.add(nuevaComision);
    }
    public void registrarAsistencia(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese nro credencial del alumno: ");
        int idAlumno = sc.nextInt();
        sc.nextInt();
        Comision comisionActual = mostrarComisiones();
        for(Alumno alum : alumnos){
            if(alum.getCredencial() == idAlumno){
                comisionActual.agregarAlumnos(alum);
            }
        }
    }

    public void nuevoAlumno(){
        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno.cargarAlumno();
        alumnos.add(nuevoAlumno);
    }

    private Comision mostrarComisiones(){
        Scanner sc = new Scanner(System.in);
        for(Comision comision : comisiones){
            System.out.println(comision);
        }
        System.out.println("ingrese id de la comision:");
        int idComision = sc.nextInt();
        sc.nextLine();
        for(Comision comision : comisiones){
            if (idComision == comision.getId()){
                return comision;

            }
        }
        return null;
    }

    public void reporteDisciplimaMasRedituable(){
        Disciplina disciplinaConMasEstudiantes = null;
        int cantAlum;
        int mayorCantAlum =0;
        for(Disciplina disciplina : disciplinas){
            cantAlum = disciplina.getCantidadDeAlumnosEnTotal();
            if(cantAlum > mayorCantAlum){
                mayorCantAlum = cantAlum;
                disciplinaConMasEstudiantes = disciplina;
            }
        }
        assert disciplinaConMasEstudiantes != null;
        System.out.println("La disciplina con mayor cantidad de estudiantes asistidos es: "+ disciplinaConMasEstudiantes + " con una cantidad de: "+ disciplinaConMasEstudiantes.getCantidadDeAlumnosEnTotal()+"\n");
    }
}
