package ar.edu.unlu.poo.Punto9;

public class Circulo extends Forma2D{
    private String nombre = "Circulo";
    private double radio;

    public Circulo(double radio){
        this.radio = radio;
    }

    public double getArea(){
        return Math.PI * radio * radio;
    }

    public String getNombre(){
        return nombre;
    }
}
