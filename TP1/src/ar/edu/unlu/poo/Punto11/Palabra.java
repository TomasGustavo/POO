package ar.edu.unlu.poo.Punto11;

public class Palabra {
    private String palabra;
    private int valor;

    // Metodos

    private int puntosPorPalabra(String palabra){
        int rta =0;
        rta = palabra.length();

        if(palabra.contains(String.valueOf("k")) || palabra.contains(String.valueOf("z"))||palabra.contains(String.valueOf("x"))||palabra.contains(String.valueOf("y"))||palabra.contains(String.valueOf("w"))||palabra.contains(String.valueOf("q")) ){
            rta++;
        }

        return rta;
    }


    public void setStats(String palabra){
        String palabraMinus = palabra.toLowerCase();
        this.palabra = palabraMinus;
        this.valor = puntosPorPalabra(palabraMinus);
    }

    public String getPalabra(){
        return palabra;
    }
    public int getValor(){
        return valor;
    }

}
