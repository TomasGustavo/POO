import ar.edu.unlu.poo.Punto6.Biblioteca;

import java.util.Scanner;

public class MainPunto6 {

    public static void menu(){
        System.out.println("1 - Ingresar Nuevo libro");
        System.out.println("2 - Agregar ejemplares de un libro");
        System.out.println("3 - Realizar prestamo de libro");
        System.out.println("4 - Mostrar libros disponibles");
        System.out.println(AnsiColor.RED+"\n\n\t0 - SALIR"+ AnsiColor.RESET);
    }

    public static void main_ingresar(Biblioteca biblio){
        Scanner sc = new Scanner(System.in);
        String nombre,autor;
        int paginas,ejemplares;

        System.out.println("Ingrese nombre del libro: ");
        nombre = sc.nextLine();

        System.out.println("Ingrese autor del libro: ");
        autor = sc.nextLine();

        System.out.println("Ingrese Cantidad de paginas del libro: ");
        paginas = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese Cantidad de ejemplares del libro que quiere agregar: ");
        ejemplares = sc.nextInt();
        sc.nextLine();

        biblio.agregarLibro(nombre,autor,paginas,ejemplares,0);

        ScreenUtilities.pausa();
        ScreenUtilities.LimpiarPantalla();
    }

    public static void main_agregar(Biblioteca biblio){
        Scanner sc = new Scanner(System.in);
        String nombre;
        int cantidad;

        System.out.println("Ingrese nombre o autor del libro del que quiera agregar ejemplares: ");
        nombre = sc.nextLine();

        System.out.println("Ingrese cantidad de ejemplares a agregar: ");
        cantidad = sc.nextInt();
        sc.nextLine();

        biblio.agregarEjemplares(nombre,cantidad);

        ScreenUtilities.pausa();
        ScreenUtilities.LimpiarPantalla();
    }

    public static void main_comparar(){

    }

    public static void main_prestamo(Biblioteca biblio){
        Scanner sc = new Scanner(System.in);
        String nombre;
        int cantidad;

        System.out.println("Ingrese nombre o autor del libro del que quiera realizar un prestamo: ");
        nombre = sc.nextLine();

        System.out.println("Ingrese cantidad de ejemplares a prestar: ");
        cantidad = sc.nextInt();
        sc.nextLine();

        biblio.realizarPrestamo(nombre,cantidad);

        System.out.println("Con este nuevo prestamo la biblioteca realizo"+biblio.getPrestamosTotales()+"prestamos totales");

        ScreenUtilities.pausa();
        ScreenUtilities.LimpiarPantalla();
    }


    public static void main(String[] args) {

        Biblioteca biblio = new Biblioteca();

        /*
        biblio.agregarLibro("Corazon delator", "Edgar Alan Poe",250,10,0);
        biblio.agregarLibro("Viaje al centro de la tierra", "Julio Verne",250,2,0);
        System.out.println(biblio);
        biblio.mayorNroPaginas(0,1);

        ScreenUtilities.pausa();
        ScreenUtilities.LimpiarPantalla();

        System.out.println(AnsiColor.MAGENTA + "Seleecione el NOMBRE o AUTOR del libro que quiere hacer el prestamo: " + AnsiColor.RESET);
        Scanner sc = new Scanner(System.in);
        String opc = sc.nextLine();

        System.out.println("\n");

        biblio.realizarPrestamo(opc,1);
        biblio.realizarPrestamo(opc,1);
        System.out.println("\n");
        System.out.println(AnsiColor.MAGENTA+ "prestamos totales: " + AnsiColor.RESET +biblio.getPrestamosTotales());

        ScreenUtilities.pausa();
        ScreenUtilities.LimpiarPantalla();

        System.out.println(AnsiColor.MAGENTA + "seleecione el NOMBRE o AUTOR del libro que quiere hacer el prestamo: " + AnsiColor.RESET);
        sc = new Scanner(System.in);
        opc = sc.nextLine();

        System.out.println("\n");

        biblio.realizarPrestamo(opc,5);

        System.out.println(AnsiColor.MAGENTA+ "prestamos totales: " + AnsiColor.RESET +biblio.getPrestamosTotales());

        System.out.println(biblio);

        ScreenUtilities.pausa();
        ScreenUtilities.LimpiarPantalla();

        System.out.println(AnsiColor.MAGENTA+ "vamos a agregar ejemplares de algun libro ya existente en la biblioteca, ingresa el nombre o autor del que desees");
        opc = sc.nextLine();
        System.out.println("\nIngresa la cantidad que quieras agregar"+ AnsiColor.RESET);
        int cant = sc.nextInt();
        sc.nextLine();
        biblio.agregarEjemplares(opc,cant);

        System.out.println(biblio);
        */
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        while(!salir){
            ScreenUtilities.LimpiarPantalla();
            menu();
            int op = sc.nextInt();
            switch (op) {
                case 1 -> main_ingresar(biblio);
                case 2 -> main_agregar(biblio);
                case 3 -> main_prestamo(biblio);
                case 4 -> {
                    System.out.println(biblio);
                    ScreenUtilities.pausa();
                }
                case 0 -> {
                    salir = true;
                    break;
                }
            }

        }


    }
}
