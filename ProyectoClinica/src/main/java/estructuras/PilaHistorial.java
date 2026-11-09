package estructuras;

import modelo.Consulta;

public class PilaHistorial {

    private NodoHistorial cima;

    public PilaHistorial() {
        cima = null;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public NodoHistorial getCima() {
        return cima;
    }

    public void agregarConsulta(Consulta consulta) {

        NodoHistorial nuevo = new NodoHistorial(consulta);

        nuevo.setSiguiente(cima);

        cima = nuevo;
    }

    public Consulta deshacerUltimaConsulta() {

        if (estaVacia()) {
            return null;
        }

        Consulta eliminada = cima.getConsulta();

        cima = cima.getSiguiente();

        return eliminada;
    }

    public Consulta verUltimaConsulta() {

        if (estaVacia()) {
            return null;
        }

        return cima.getConsulta();
    }

    public String mostrarHistorial() {

        if (estaVacia()) {
            return "No hay consultas registradas.";
        }

        String texto = "";

        NodoHistorial actual = cima;

        while (actual != null) {

            texto += actual.getConsulta().toString() + "\n";

            actual = actual.getSiguiente();

        }

        return texto;
    }
    public String mostrarHistorialPaciente(String paciente) {

        String texto = "";

        NodoHistorial actual = cima;

        while (actual != null) {

            Consulta c = actual.getConsulta();

            if (c.getPaciente().equals(paciente)) {
                texto += c.toString() + "\n";
            }

            actual = actual.getSiguiente();
        }

        if (texto.equals("")) {
            return "No hay consultas para este paciente.";
        }

        return texto;
    }

    public int cantidadConsultasPaciente(String paciente) {

        int contador = 0;

        NodoHistorial actual = cima;

        while (actual != null) {

            if (actual.getConsulta().getPaciente().equals(paciente)) {
                contador++;
            }

            actual = actual.getSiguiente();
        }

        return contador;
    }

    public Consulta deshacerUltimaConsultaPaciente(String paciente) {

        if (estaVacia()) {
            return null;
        }

        NodoHistorial actual = cima;
        NodoHistorial anterior = null;

        while (actual != null) {

            if (actual.getConsulta().getPaciente().equals(paciente)) {

                Consulta eliminada = actual.getConsulta();

                if (actual == cima) {
                    cima = cima.getSiguiente();
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }

                return eliminada;
            }

            anterior = actual;
            actual = actual.getSiguiente();
        }

        return null;
    }
}