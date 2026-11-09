package estructuras;

import modelo.Consulta;

public class NodoHistorial {

    private Consulta consulta;
    private NodoHistorial siguiente;

    public NodoHistorial(Consulta consulta) {
        this.consulta = consulta;
        this.siguiente = null;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public NodoHistorial getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoHistorial siguiente) {
        this.siguiente = siguiente;
    }
}