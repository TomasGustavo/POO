package ar.edu.unlu.poo.lista;


public class ListaEnlazada {
    // Atributos
    private Nodo inicio = null;
    private int cantidad = 0;

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
        cantidad++;
    }

    public void eliminar(Object dato){
        Nodo nodoAux = inicio;
        if(nodoAux.getDato() == dato) {
            inicio = nodoAux.getProximo();
        } else {
            while (nodoAux.getProximo().getDato() != dato){
                nodoAux = nodoAux.getProximo();
            }
            nodoAux.setProximo(nodoAux.getProximo().getProximo());
        }
        cantidad--;
    }

    public Object recuperar(int posicion){
        Object rta;
        int posiAux = 0;
        if(vacia()){
            rta = "La lista esta vacia";
            return rta;
        } else if((posicion < 0) || posicion >= cantidad){
            rta = "posicion fuera de rango!!!!!";
            return rta;
        }
        Nodo actual = inicio;
        while(posiAux != posicion){
            actual = actual.getProximo();
            posiAux++;
        }
        rta = actual.getDato();
        return rta;
    }

    public boolean insertarPosicion(int posicion, Object dato){
        boolean rta;
        if ((posicion > cantidad) || (posicion < 0) || (vacia())){
            rta = false;
        } else {
            Nodo nuevoNodo = new Nodo();
            nuevoNodo.setDato(dato);
            Nodo nodoAux = inicio;
            if(posicion == 0){
                inicio = nuevoNodo;
                nuevoNodo.setProximo(nodoAux);
            } else{
                int i = 0;
                while ((i+1) != posicion){
                    nodoAux = nodoAux.getProximo();
                    i++;
                }
                nuevoNodo.setProximo(nodoAux.getProximo());
                nodoAux.setProximo(nuevoNodo);
            }
            rta = true;
        }
        cantidad++;
        return rta;
    }

    public boolean vacia(){
        return (cantidad == 0);
    }
    public int longitud(){
        return cantidad;
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
