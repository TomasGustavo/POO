package ar.edu.unlu.poo.Punto6;

public class Libro {
    // Atributos
    private String nombre = "";
    private String autor = "";
    private int hojas;
    private int stockEnBiblioteca;
    private int cantidadPrestados;

    // Metodos

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public String getAutor(){
        return autor;
    }
    public void setHojas(int hojas){
        this.hojas = hojas;
    }
    public int getHojas(){
        return hojas;
    }
    public void setStockEnBiblioteca(int stock){
        this.stockEnBiblioteca = stock;
    }
    public int getStockEnBiblioteca(){
        return stockEnBiblioteca;
    }
    public void setCantidadPrestados(int cantidadPrestados){
        this.cantidadPrestados = cantidadPrestados;
    }
    public int getCantidadPrestados(){
        return cantidadPrestados;
    }

    public void agregarEjemplares(int cantidad){
        this.stockEnBiblioteca += cantidad;
    }

}
