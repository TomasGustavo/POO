package ar.edu.unlu.poo.lista;

import javax.print.attribute.standard.JobKOctets;

public class ListaEnlazada {
    // Atributos
    private Nodo inicio = null;

    // Metodos
    public void agregar(Object dato){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDato(dato);
        if(inicio == null){
            inicio = nuevoNodo;
        } else{
            Nodo nodoAux = inicio;
            while(nodoAux.getProximo() != null){
                nodoAux = nodoAux.getProximo();
            }
            nodoAux.setProximo(nuevoNodo);
        }
    }

    public String toString(){
        String acum = "";
        int i = 1;
        Nodo nodoAux = inicio;
        if(inicio == null){
            acum = "Lista vacia!";
        }
        while(nodoAux != null){
            acum += "NODO: " + i + " " + nodoAux.getDato() + "\n";
            i++;
            nodoAux = nodoAux.getProximo();
        }
        return acum;
    }
}
