package ar.edu.unlu.poo.Punto2;

public class Triangulo extends Forma2D{
    private String nombre = "Triangulo";
    private double base;
    private double altura;

    public Triangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    public double getArea(){
        return base*altura;
    }
    public String getNombre(){
        return nombre;
    }
}
