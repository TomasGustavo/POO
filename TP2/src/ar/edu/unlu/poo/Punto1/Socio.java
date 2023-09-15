package ar.edu.unlu.poo.Punto1;

import java.time.LocalDate;
import java.util.Scanner;

public class Socio {
    private String nombreYapellido;
    private int numeroTelefono;
    private String mail;
    private Direccion direccion = new Direccion();
    private int idSocio;
    private String tipoSubscripcion;
    private LocalDate fechaDeRegistro;

    // Metodos

    public String getTipoSubscripcion(){
        return tipoSubscripcion;
    }
    public LocalDate getFechaDeRegistro(){
        return fechaDeRegistro;
    }
    public String getNombreYapellido(){
        return  nombreYapellido;
    }
    public int getIdSocio(){
        return idSocio;
    }
    public void cargarSocio(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombre y apellido del socio: ");
        this.nombreYapellido = sc.nextLine();
        System.out.println("Ingrese E-Mail del socio: ");
        this.mail = sc.nextLine();
        System.out.println("Ingrese numero de telefono del socio: ");
        this.numeroTelefono = sc.nextInt();
        sc.nextLine();
        this.direccion.cargarDireccion();
        System.out.println("Ingrese ID que tendra el socio: ");
        this.idSocio = sc.nextInt();
        sc.nextLine();
        System.out.println("Seleccione el tipo de subscripcion\n\t1 - basica\n\t2 - intermedia\n\t3 - destacada\n");
        int opc = sc.nextInt();
        switch (opc){
            case 1 -> this.tipoSubscripcion = "basica";
            case 2 -> this.tipoSubscripcion = "intermedia";
            case 3 -> this.tipoSubscripcion = "destacada";
        }
        fechaDeRegistro = LocalDate.now();

    }

    public String toSting(){
        String acum="";

        acum += "Id: "+idSocio+"\nNombre: "+nombreYapellido+"\nTipo de subscripcion: "+tipoSubscripcion+ "\n------------------------------------\n";

        return acum;
    }
}
