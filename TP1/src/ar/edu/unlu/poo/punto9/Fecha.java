package ar.edu.unlu.poo.punto9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Fecha {
    // Atributps
    private static DateTimeFormatter formador1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static DateTimeFormatter formador2 = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    // Metodos
    public LocalDate transformadorFecha(String fecha){
        DateTimeFormatter formador = fecha.equals("dd-MM-yyyy") ? formador1 : formador2;
        return LocalDate.parse(fecha,formador);
    }

    public boolean entreFechas(LocalDate fechaMin,LocalDate fechaMax, LocalDate fecha){
        return (fecha.isAfter(fechaMin) && fecha.isBefore(fechaMax));
    }

    public boolean fechaMayor(LocalDate fecha1, LocalDate fecha2){
        return fecha1.isAfter(fecha2);
    }

    public boolean fechaMenor(LocalDate fecha1, LocalDate fecha2){
        return fecha1.isBefore(fecha2);
    }

}
