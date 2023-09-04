package ar.edu.unlu.poo.Punto7;

public class Ecuacion {

    private final double a;
    private final double b;
    private final double c;


    public Ecuacion(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calcularDiscriminante(){
        return (b*b) - (4*a*c);
    }

    public double[] calcularRaices(){
        double discriminante = calcularDiscriminante();

        if(discriminante>0){
            double raizDiscriminante = Math.sqrt(discriminante);
            double r1 = ((-b + raizDiscriminante) / (2*a));
            double r2 = ((-b - raizDiscriminante) / (2*a));
            return new double[]{r1,r2};
        }else if(discriminante == 0){
            double x = -b/(2*a);
            return new double[]{x};
        }else{
            return new double[]{};
        }
    }

    public double calcularY(double x){
        return a*(x*x)+b*x+c;
    }

}
