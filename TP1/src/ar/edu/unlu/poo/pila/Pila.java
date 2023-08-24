package ar.edu.unlu.poo.pila;

import ar.edu.unlu.poo.lista.Nodo;

public class Pila {
    // Atributos
    private Nodo tope = null;

    // Metodos
    public void p_apilar(Object dato){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDato(dato);
        nuevoNodo.setProximo(tope);
        tope = nuevoNodo;
    }

    public Object p_desapilar(){
        Object rta;
        Nodo topeActual = tope;
        rta = topeActual.getDato();
        tope = topeActual.getProximo();
        return rta;
    }

    public Object p_tope(){
        Object rta;
        Nodo aux = tope;
        rta = aux.getDato();
        return rta;
    }

    public boolean p_vacia(){
        return tope == null;
    }

    public int p_longitud(){
        int n = 0;
        Object x;
        Pila pilaAux = new Pila();
        while(!p_vacia()){
            x = p_desapilar();
            pilaAux.p_apilar(x);
            n++;
        }
        while(!pilaAux.p_vacia()){
            x = pilaAux.p_desapilar();
            p_apilar(x);
        }
        return n;
    }

    public String toString(){
        String acum = "\n";
        int i = 1;
        Nodo nodoAux = tope;
        if(p_vacia()){
            acum = "Pila vacia";
        }else{
            System.out.print("Contenido de la pila: ");
            Object x;
            Pila pilaAux = new Pila();
            while(!p_vacia()){
                x = p_desapilar();
                acum += x + "\n";
                pilaAux.p_apilar(x);
            }
            while(!pilaAux.p_vacia()){
                x = pilaAux.p_desapilar();
                p_apilar(x);
            }
        }
        return acum;
    }

}
