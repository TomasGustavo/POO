package ar.edu.unlu.poo.Punto9;

public class Rectangulo extends Forma2D{
    private String nombre = "Rectangulo";
    public double base;
    public double altura;

    public Rectangulo(double base, double altura){
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
