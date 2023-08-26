package ar.edu.unlu.poo.Punto6;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    // Atributos
    private List<Libro> biblioteca ;
    private int librosTotalesDisponibles = 0;
    private int prestamosTotales = 0;

    public Biblioteca(){
        biblioteca = new ArrayList<>();
    }

    // Metodos
    public void agregarLibro(String nombre, String autor, int hojas,int stock,int prestados){
        Libro nuevoLibro = new Libro();
        nuevoLibro.setAutor(autor);
        nuevoLibro.setNombre(nombre);
        nuevoLibro.setHojas(hojas);
        nuevoLibro.setStockEnBiblioteca(stock);
        nuevoLibro.setCantidadPrestados(prestados);
        biblioteca.add(nuevoLibro);
        librosTotalesDisponibles += nuevoLibro.getStockEnBiblioteca();
        prestamosTotales += nuevoLibro.getCantidadPrestados();
    }

    public void realizarPrestamo(String idLibro,int cantidad){
        for(Libro libro : biblioteca){
            if(libro.getNombre().equalsIgnoreCase(idLibro) || libro.getAutor().equalsIgnoreCase(idLibro) ){
                if(libro.getStockEnBiblioteca() <= 1){
                    System.out.println("No es posible realizar el prestamo porque solo queda 1 libro disponible en el lugar");
                }else{
                    libro.setStockEnBiblioteca(libro.getStockEnBiblioteca()-cantidad);
                    libro.setCantidadPrestados(libro.getCantidadPrestados()+cantidad);
                    prestamosTotales+= cantidad;
                    librosTotalesDisponibles-= cantidad;

                    System.out.println("Stock restante en biblioteca: "+libro.getStockEnBiblioteca());
                    System.out.println("Cantidad de libros prestados: "+libro.getCantidadPrestados());

                    break;
                }

            }
        }
    }

    public void mayorNroPaginas(int indice1,int indice2){
        Libro libro1 = biblioteca.get(indice1);
        Libro libro2 = biblioteca.get(indice2);
        if(libro1.getHojas() > libro2.getHojas()){
            System.out.println("El libro " +"<"+libro1.getNombre()+">"+" tiene mas hojas que el libro "+"<"+ libro2.getNombre()+">" );
        }else if(libro1.getHojas() < libro2.getHojas()){
            System.out.println("El libro " +"<"+libro2.getNombre()+">"+" tiene mas hojas que el libro "+"<"+ libro1.getNombre()+">" );
        }else{
            System.out.println("Ambos libros tiene la misma cantidad de hojas" );
        }
    }

    public int getLibrosTotalesDisponibles(){
        return librosTotalesDisponibles;
    }
    public int getPrestamosTotales(){
        return prestamosTotales;
    }
    public String toString(){
        String acum = "";
        for (Libro libro : biblioteca) {
            acum += "El libro " + "<"+libro.getNombre()+">" + " creado por el autor " +"<"+ libro.getAutor()+">" + " tiene " + libro.getHojas() + "  páginas, quedan " + libro.getStockEnBiblioteca() + " disponibles y se prestaron " + libro.getCantidadPrestados() + "\n\n";
        }

        return acum;
    }
}
