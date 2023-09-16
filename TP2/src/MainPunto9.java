import ar.edu.unlu.poo.Punto9.*;

import java.util.ArrayList;

public class MainPunto9 {
    public static void main(String[] args) {

        ArrayList<Forma> formas = new ArrayList<>();

        // agrego formas 2D
        formas.add(new Circulo(5.0));
        formas.add(new Cuadrado(4.0));
        formas.add(new Rectangulo(5.0,3.0));
        formas.add(new Triangulo(5.0,2.0));

        // agrego formas 3D

        formas.add(new Esfera(3.0));
        formas.add(new Cubo(5.0));
        formas.add(new Paralelepipedo(2.0,3.0,4.0));
        formas.add(new Tetraedro(5.0));

        // calculo y muestro areas y volumenes

        for(Forma forma:formas){
            System.out.println("Area: " + forma.getArea());
            if(forma instanceof Forma3D){
                Forma3D forma3D = (Forma3D) forma;
                System.out.println("Volumen: "+ forma3D.getVolumen());
            }
        }

    }


}
