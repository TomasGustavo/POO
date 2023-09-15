import ar.edu.unlu.poo.Punto1.Club;

public class MainPunto1 {
    public static void main(String[] args) {


        Club nuevoClub = new Club("bariloche");

        for(int i =0 ;i<3;i++){
            nuevoClub.nuevaActividad();
        }
        for(int i =0 ;i<3;i++){
            nuevoClub.nuevoSocio();
        }

        System.out.println(nuevoClub.mostrarSocios());
        nuevoClub.mostrarSocioporSubscripcion();
        nuevoClub.mostrarActividadPorSubscripcion();
    }
}