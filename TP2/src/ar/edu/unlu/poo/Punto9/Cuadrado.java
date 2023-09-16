package ar.edu.unlu.poo.Punto9;

public class Cuadrado extends Forma2D {
    private String nombre = "Cuadrado";
    private double lado;

    public Cuadrado (double lado) {
        this.lado = lado;
    }

    @Override
    public double getArea() {
        return lado*lado;
    }
    public String getNombre(){
        return nombre;
    }
}
