import ar.edu.unlu.poo.punto9.Fecha;
import ar.edu.unlu.poo.punto9.Fecha;

import java.time.LocalDate;
import java.util.Scanner;

public class MainPunto9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fecha fech = new Fecha();

        //System.out.println("Ingresar primera fecha [dd-MM-yyyy]");
        //String f = sc.nextLine();
        LocalDate fecha1 = fech.transformadorFecha("02-08-2020");

        //System.out.println("Ingresar segunda fecha [dd-MM-yyyy]");
        //f = sc.nextLine();
        LocalDate fecha2 = fech.transformadorFecha("04-08-2020");

        //System.out.println("Ingresar tercera fecha [dd-MM-yyyy]");
        //f = sc.nextLine();
        LocalDate fecha3 = fech.transformadorFecha("03-08-2020");

        boolean entreFechas = fech.entreFechas(fecha1,fecha2,fecha3);
        System.out.println("la fecha 3 esta entre la 1 y la 2: "+entreFechas);

        boolean mayor = fech.fechaMayor(fecha1,fecha2);
        System.out.println("la fecha 1 es mayor que la fecha 2: "+mayor);

        boolean menor = fech.fechaMenor(fecha1,fecha2);
        System.out.println("la fecha 1 es menor que la fecah 2: "+menor);

    }

}
