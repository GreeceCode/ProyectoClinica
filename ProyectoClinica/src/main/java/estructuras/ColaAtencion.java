package estructuras;

import modelo.Paciente;

public class ColaAtencion {

    private NodoCola frente;
    private NodoCola fin;

    public ColaAtencion() {
        frente = null;
        fin = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public NodoCola getFrente() {
        return frente;
    }

    public NodoCola getFin() {
        return fin;
    }

    public void encolar(Paciente paciente) {
        NodoCola nuevo = new NodoCola(paciente);

        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    public Paciente desencolar() {
        if (estaVacia()) {
            return null;
        }

        Paciente atendido = frente.getPaciente();
        frente = frente.getSiguiente();

        if (frente == null) {
            fin = null;
        }

        return atendido;
    }

    public String mostrarCola() {
        if (estaVacia()) {
            return "No hay pacientes en cola.";
        }

        String texto = "";
        NodoCola actual = frente;

        while (actual != null) {
            texto += actual.getPaciente().toString() + "\n";
            actual = actual.getSiguiente();
        }

        return texto;
    }
}