package ar.edu.unlu.poo.Punto3;

import java.time.LocalDate;

public class Profesor {
    private String dni;
    private String nombreApellido;
    private double sueldo = 0;


    public Profesor(String dni,String nombreApellido){
        this.dni = dni;
        this.nombreApellido = nombreApellido;
    }
    public void sumarSueldo(int cant){
        sueldo += (cant*10);
    }

    private void principioDeMes(){
        LocalDate dia = LocalDate.now();
        if(dia.getDayOfMonth() == 1){
            sueldo = 0;
        }
    }
}
