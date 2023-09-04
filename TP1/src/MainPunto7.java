import ar.edu.unlu.poo.Punto7.Ecuacion;

import java.util.Scanner;

public class MainPunto7 {

    public static void imprimirRaices(double[] raices){
        if(raices.length == 2){
            System.out.println("Raices: x1 = "+raices[0]+", x2 = "+raices[1]);
        }else if(raices.length == 1){
            System.out.println("Raiz unica: x = "+raices[0]);
        }else{
            System.out.println("No hay raices reales!");
        }
    }
    public static void main(String[] args) {

        Ecuacion ecuacion1 = new Ecuacion(1,-3,2); // Dos raices distintas
        Ecuacion ecuacion2 = new Ecuacion(1,2,1); // Raiz unica
        Ecuacion ecuacion3 = new Ecuacion(1,1,1); // Dos raices distintas

        // pruba de calculo de discriminante y raices
        System.out.println("Ecuacion 1: ");
        System.out.println("Discriminante: "+ ecuacion1.calcularDiscriminante());
        double[] raices1 = ecuacion1.calcularRaices();
        imprimirRaices(raices1);

        System.out.println("Ecuacion 2: ");
        System.out.println("Discriminante: "+ ecuacion2.calcularDiscriminante());
        double[] raices2 = ecuacion2.calcularRaices();
        imprimirRaices(raices2);

        System.out.println("Ecuacion 3: ");
        System.out.println("Discriminante: "+ ecuacion3.calcularDiscriminante());
        double[] raices3 = ecuacion3.calcularRaices();
        imprimirRaices(raices3);


        // calculo de Y

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor de X: ");
        double x = sc.nextDouble();

        System.out.println("\nEcucacion 1: el resultado de Y(x) = "+ ecuacion1.calcularY(x));
        System.out.println("\nEcucacion 2: el resultado de Y(x) = "+ ecuacion2.calcularY(x));
        System.out.println("\nEcucacion 3: el resultado de Y(x) = "+ ecuacion3.calcularY(x));
    }
}
