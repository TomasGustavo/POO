package ar.edu.unlu.poo.Punto3;

import java.util.ArrayList;
import java.util.Scanner;

public class Comision {
    private int id;
    private String dia;
    private String horario;
    private Disciplina disciplina;
    private String nivelDisciplina;
    private Profesor profesor;
    private int salon;
    private ArrayList<Alumno> alumnos;

    /*
    private Comision (String dia,String horario,Disciplina disciplina,int nivel,Profesor profe,int salon, int id){
        this.dia = dia;
        this.horario = horario;
        this.disciplina = disciplina;
        this.nivelDisciplina = this.disciplina.getNivel(nivel);
        this.profesor = profe;
        this.salon = salon;
        this.id = id;
    }

     */

    public void nuevaComision(Disciplina disciplina){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese dia/s que se dara la clase: ");
        this.dia = sc.nextLine();
        System.out.println("Ingrese horario que se dara la clase: ");
        this.horario = sc.nextLine();
        System.out.println("Ingrese la disciplina: ");
        this.disciplina = disciplina;
        System.out.println("ingrese nivel de dificultad:\n1-basica\n2-intermedia\n3-avanzada\n");
        this.nivelDisciplina = disciplina.getNivel(sc.nextInt());
        sc.nextLine();
        System.out.println("Ingrese los datos del profesor que dara la clase:");
        System.out.println("DNI: ");
        String dni = sc.nextLine();
        System.out.println("Nombre y apellido: ");
        this.profesor = new Profesor(dni,sc.nextLine());
        System.out.println("Ingrese el numero del salon en que se desarrollara: ");
        this.salon = sc.nextInt();
        sc.nextLine();
    }

    public Profesor getProfesor(){
        return profesor;
    }

    public void agregarAlumnos(Alumno alum){
        alumnos.add(alum);
        disciplina.agregarAlumno();
    }

    public int getId(){
        return id;
    }

    public int cantidadAlumnos(){
        return alumnos.size();
    }

    public Disciplina getDisciplina(){
        return disciplina;
    }

    public String toSting(){
        String acum = "";
        acum += "id Comision: "+ id +"\ndisciplina: "+disciplina+"\nnivel: "+nivelDisciplina+"\nprofesor: "+profesor+"\nsalon: "+salon+"\n----------------------------------------------\n";
        return acum;
    }

}
