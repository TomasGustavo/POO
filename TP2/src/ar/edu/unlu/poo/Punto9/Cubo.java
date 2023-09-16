package ar.edu.unlu.poo.Punto9;

public class Cubo extends Forma3D{
    private String nombre = "Cubo";
    private double arista;

    public Cubo(double arista){
        this.arista = arista;
    }

    @Override
    public double getArea() {
        return 6*arista*arista;
    }

    public double getVolumen(){
        return arista*arista*arista;
    }
    public String getNombre(){
        return nombre;
    }
}
