package estructuras;

import modelo.Medico;

public class NodoMedico {

    private Medico medico;
    private NodoMedico izquierdo;
    private NodoMedico derecho;

    public NodoMedico(Medico medico) {
        this.medico = medico;
        this.izquierdo = null;
        this.derecho = null;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public NodoMedico getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoMedico izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoMedico getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoMedico derecho) {
        this.derecho = derecho;
    }
}