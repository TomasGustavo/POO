package ar.edu.unlu.poo.Punto3;

import java.util.Scanner;

public class Alumno {
    private String dni;
    private String nombreApellido;
    private int telefono;
    private int credencial;

    public int getCredencial(){
        return credencial;
    }

    public void cargarAlumno(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese dni del alumno: ");
        this.dni = sc.nextLine();
        System.out.println("Ingrese nombre y apellido del alumno: ");
        this.nombreApellido = sc.nextLine();
        System.out.println("Ingrese numero de telefono del alumno: ");
        this.telefono = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese numero de credencial con el que se indentificara al alumno: ");
        this.credencial = sc.nextInt();
        sc.nextLine();
    }
}
