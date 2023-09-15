package ar.edu.unlu.poo.Punto1;

import java.util.Scanner;

public class Actividad {
    private String nombre;
    private String descripcion;
    private int idA;
    private String tipoSubscripcion;


    //Metodos
    public String getTipoSubscripcion(){
        return tipoSubscripcion;
    }
    public void cargarActividad(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombre del actividad: ");
        this.nombre = sc.nextLine();
        System.out.println("Ingrese descripcion de la actividad: ");
        this.descripcion = sc.nextLine();
        System.out.println("Ingrese ID que tendra la actividad: ");
        this.idA = sc.nextInt();
        sc.nextLine();
        System.out.println("Seleccione el tipo de subscripcion al que pertenecera la actividad\n\t1 - basica\n\t2 - intermedia\n\t3 - destacada\n");
        int opc = sc.nextInt();
        switch (opc) {
            case 1 -> this.tipoSubscripcion = "basica";
            case 2 -> this.tipoSubscripcion = "intermedia";
            case 3 -> this.tipoSubscripcion = "destacada";
        }

    }

    public String toSting(){
        String acum="";

        acum += "Id: "+idA+"\nNombre: "+nombre+"\nDescripcion: "+descripcion+"\nTipo de subscripcion requeridad para realizarse: "+tipoSubscripcion+ "\n------------------------------------\n";

        return acum;
    }
}
