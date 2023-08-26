import ar.edu.unlu.poo.Punto6.Biblioteca;

import java.util.Scanner;

public class MainPunto6 {
    public static void main(String[] args) {

        Biblioteca biblio = new Biblioteca();

        biblio.agregarLibro("padre rico padre pobre", "hideo kojima",250,10,0);
        biblio.agregarLibro("jejeje", "konami",250,2,0);
        System.out.println(biblio);
        biblio.mayorNroPaginas(0,1);

        System.out.println("seleecione el NOMBRE o AUTOR del libre que quiere hacer el prestamo: ");
        Scanner sc = new Scanner(System.in);
        String opc = sc.nextLine();

        System.out.println("\n");

        biblio.realizarPrestamo(opc,1);
        biblio.realizarPrestamo(opc,1);
        System.out.println("\n");
        System.out.println("prestamos totales: "+biblio.getPrestamosTotales());

        System.out.println("seleecione el NOMBRE o AUTOR del libre que quiere hacer el prestamo: ");
        sc = new Scanner(System.in);
        opc = sc.nextLine();

        System.out.println("\n");

        biblio.realizarPrestamo(opc,5);

        System.out.println("prestamos totales: "+biblio.getPrestamosTotales());

    }
}
