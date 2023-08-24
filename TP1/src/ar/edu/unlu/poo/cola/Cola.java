package ar.edu.unlu.poo.cola;
import ar.edu.unlu.poo.lista.Nodo;
public class Cola {
    // Atributos
    private Nodo frente = null;
    private Nodo finall = null;

    // Metodos

    public void c_encolar(Object dato){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDato(dato);
        if(c_vacia()){
            frente = nuevoNodo;
        } else{
            finall.setProximo(nuevoNodo);
        }
        finall = nuevoNodo;
    }

    public Object c_desencolar(){
        if(c_vacia()){
            return null;
        }
        Nodo nodoAux = frente;
        frente = nodoAux.getProximo();
        return nodoAux.getDato();
    }

    public int c_longitud(){
        int i = 0;
        Nodo nodoAux = frente;
        while(nodoAux != null){
            i++;
            nodoAux = nodoAux.getProximo();
        }
        return i;
    }

    public boolean c_vacia(){
        return (frente == null);
    }

    public void mostrarFrente(){
        System.out.println("Frente: " + frente.getDato());
    }

    public void mostrarFinal(){
        System.out.println("Final: " + finall.getDato());
    }
    public String toString(){
        String acum = "";
        int i = 1;
        Nodo nodoAux = frente;
        if(c_vacia()){
            acum += "La cola esta vacia!!";
        } else{
            System.out.println("Contenido de la cola: ");
            Object x;
            Cola colaAux = new Cola();
            while(!c_vacia()){
                x = c_desencolar();
                acum += x + "\n";
                colaAux.c_encolar(x);
            }
            while(!colaAux.c_vacia()){
                x = colaAux.c_desencolar();
                c_encolar(x);
            }
        }
        return acum;
    }

}

