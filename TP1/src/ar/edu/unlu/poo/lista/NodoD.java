package ar.edu.unlu.poo.lista;

public class NodoD {
    private Object dato;
    private NodoD proximo = null;
    private NodoD anterior = null;

    // metodos
    public void setDato(Object dato){
        this.dato = dato;
    }

    public Object getDato() {
        return dato;
    }

    public void setProximo(NodoD nodo){
        this.proximo = nodo;
    }
    public NodoD getProximo(){
        return proximo;
    }

    public void setAnterior(NodoD nodo){
        this.anterior = nodo;
    }
    public NodoD getAnterior(){
        return anterior;
    }
}
