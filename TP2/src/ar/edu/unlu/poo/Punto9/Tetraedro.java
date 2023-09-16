package ar.edu.unlu.poo.Punto9;

public class Tetraedro extends Forma3D{
    private String nombre = "Tetraedro";
    private double arista;

    public Tetraedro(double arista){
        this.arista = arista;
    }

    public double getArea(){
        return arista*arista * Math.sqrt(3);
    }

    public double getVolumen(){
        return (arista * arista * arista * Math.sqrt(2)/12);
    }
    public String getNombre(){
        return nombre;
    }
}
