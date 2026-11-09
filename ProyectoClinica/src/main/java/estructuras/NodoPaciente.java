package estructuras;

import modelo.Paciente;

public class NodoPaciente {

    private Paciente paciente;
    private NodoPaciente siguiente;
    private NodoPaciente anterior;

    public NodoPaciente(Paciente paciente) {
        this.paciente = paciente;
        this.siguiente = null;
        this.anterior = null;
    }

    // GETTERS

    public Paciente getPaciente() {
        return paciente;
    }

    public NodoPaciente getSiguiente() {
        return siguiente;
    }

    public NodoPaciente getAnterior() {
        return anterior;
    }

    // SETTERS

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setSiguiente(NodoPaciente siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(NodoPaciente anterior) {
        this.anterior = anterior;
    }

}