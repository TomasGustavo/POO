package ar.edu.unlu.poo.Punto1;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class Club {
    // Atributos
    private String nombre;
    private ArrayList<Socio> socios = new ArrayList<Socio>();
    private ArrayList<Actividad> actividades = new ArrayList<Actividad>();

    // Metodos

    public Club (String nombre){
        this.nombre = nombre;
    }

    public void nuevoSocio(){

        Socio nuevoSocio = new Socio();
        nuevoSocio.cargarSocio();
        socios.add(nuevoSocio);
    }

    public void nuevaActividad(){
        Actividad nuevaActividad = new Actividad();
        nuevaActividad.cargarActividad();
        actividades.add(nuevaActividad);
    }

    public String mostrarSocios(){
        String acum = "";
        for(Socio socio: socios){
            acum += socio.toSting();
        }
        return acum;
    }
    private String mostrarSocios(ArrayList<Socio> socios){
        String acum = "";
        for(Socio socio: socios){
            acum += socio.toSting();
        }
        return acum;
    }

    public String mostrarActividades(ArrayList<Actividad> act){
        String acum = "";
        for(Actividad actividad: act){
            acum += actividad.toSting();
        }
        return acum;
    }

    public void mostrarSocioporSubscripcion(){
        ArrayList<Socio> sociosBasicos = new ArrayList<>();
        ArrayList<Socio> sociosIntermedios = new ArrayList<>();
        ArrayList<Socio> sociosDestacados = new ArrayList<>();
        for(Socio socio: socios){
            if(socio.getTipoSubscripcion().equals("basica")){
                sociosBasicos.add(socio);
            } else if (socio.getTipoSubscripcion().equals("intermedia")) {
                sociosIntermedios.add(socio);
            } else{
                sociosDestacados.add(socio);
            }
        }
        System.out.println("\n\nLista de socios con subscripcion basica\n");
        System.out.println(mostrarSocios(sociosBasicos));
        System.out.println("\n\nLista de socios con subscripcion intermedia\n");
        System.out.println(mostrarSocios(sociosIntermedios));
        System.out.println("\n\nLista de socios con subscripcion destacada\n");
        System.out.println(mostrarSocios(sociosDestacados));
    }

    public void mostrarActividadPorSubscripcion(){
        ArrayList<Actividad> actividadesBasicas = new ArrayList<>();
        ArrayList<Actividad> actividadesIntermedios = new ArrayList<>();
        ArrayList<Actividad> actividadesDestacados = new ArrayList<>();
        for(Actividad act: actividades){
            if(act.getTipoSubscripcion().equals("basica")){
                actividadesBasicas.add(act);
            } else if (act.getTipoSubscripcion().equals("intermedia")) {
                actividadesIntermedios.add(act);
            } else{
                actividadesDestacados.add(act);
            }
        }
        System.out.println("\n\nLista de Actividades de subscripcion basica\n");
        System.out.println(mostrarActividades(actividadesBasicas));
        System.out.println("\n\nLista de Actividades de subscripcion intermedia\n");
        System.out.println(mostrarActividades(actividadesIntermedios));
        System.out.println("\n\nLista de Actividades de subscripcion destacada\n");
        System.out.println(mostrarActividades(actividadesDestacados));
    }

    public String informeMensualSocios(){
        LocalDate fechaActual = LocalDate.now();
        Month mesActual = fechaActual.getMonth();
        int anioActual =fechaActual.getYear();
        String acum ="\t\tInforme mensual de nuevos socios en"+mesActual+" "+anioActual+"\n\n\n";
        for(Socio socio : socios){
            if(socio.getFechaDeRegistro().getMonth() == mesActual && socio.getFechaDeRegistro().getYear() == anioActual){
                acum+= "Nombre del socio: "+ socio.getNombreYapellido()+"\nId: "+socio.getIdSocio()+"\nFecha de registro: "+socio.getFechaDeRegistro()+"\n\n";
            }
        }
        return acum;
    }
    @Override
    public String toString(){
        return nombre;
    }
}
