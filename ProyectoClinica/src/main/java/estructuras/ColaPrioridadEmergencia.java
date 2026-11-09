package estructuras;

import modelo.Emergencia;

public class ColaPrioridadEmergencia {

    private NodoEmergencia frente;

    public ColaPrioridadEmergencia() {
        frente = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public NodoEmergencia getFrente() {
        return frente;
    }

    public void encolar(Emergencia emergencia) {
        NodoEmergencia nuevo = new NodoEmergencia(emergencia);

        if (estaVacia() || emergencia.getPrioridad() < frente.getEmergencia().getPrioridad()) {
            nuevo.setSiguiente(frente);
            frente = nuevo;
        } else {
            NodoEmergencia actual = frente;

            while (actual.getSiguiente() != null &&
                   actual.getSiguiente().getEmergencia().getPrioridad() <= emergencia.getPrioridad()) {
                actual = actual.getSiguiente();
            }

            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);
        }
    }

    public Emergencia desencolar() {
        if (estaVacia()) {
            return null;
        }

        Emergencia atendida = frente.getEmergencia();
        frente = frente.getSiguiente();

        return atendida;
    }

    public String mostrarCola() {
        if (estaVacia()) {
            return "No hay emergencias registradas.";
        }

        String texto = "";
        NodoEmergencia actual = frente;

        while (actual != null) {
            texto += actual.getEmergencia().toString() + "\n";
            actual = actual.getSiguiente();
        }

        return texto;
    }
}