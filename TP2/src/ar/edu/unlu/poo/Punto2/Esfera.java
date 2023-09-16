package ar.edu.unlu.poo.Punto2;

public class Esfera extends Forma3D {
    private String nombre = "Esfera";
    private double radio;

    public Esfera(double radio) {
        this.radio = radio;
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * radio * radio;
    }

    public double getVolumen() {
        return (4.0 / 3.0) * Math.PI * radio * radio * radio;
    }

    public String getNombre() {
        return nombre;
    }
}
