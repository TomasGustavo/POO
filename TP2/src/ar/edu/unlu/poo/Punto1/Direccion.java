package ar.edu.unlu.poo.Punto1;

import java.util.Scanner;

public class Direccion {
    private String calle;
    private int numero;
    private int depto;
    private int piso;

    // Metodos

    public void cargarDireccion(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese Calle donde vive el socio: ");
        this.calle = sc.nextLine();
        System.out.println("Ingrese el numero de la calle donde vive el socio: ");
        this.numero = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el piso [opcional: -1 para dejarlo vacio]: ");
        this.piso = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el departamento [opcional: -1 para dejarlo vacio]: ");
        this.depto = sc.nextInt();
        sc.nextLine();

    }
}
