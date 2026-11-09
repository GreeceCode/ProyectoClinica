package estructuras;

import modelo.Paciente;

public class ListaDoblePacientes {

    private NodoPaciente inicio;
    private NodoPaciente fin;

    public ListaDoblePacientes() {
        inicio = null;
        fin = null;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public NodoPaciente getInicio() {
        return inicio;
    }

    public NodoPaciente getFin() {
        return fin;
    }

    public void insertar(Paciente paciente) {
        NodoPaciente nuevo = new NodoPaciente(paciente);

        if (estaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
        }
    }

    public Paciente buscar(int codigo) {
        NodoPaciente actual = inicio;

        while (actual != null) {
            if (actual.getPaciente().getCodigo() == codigo) {
                return actual.getPaciente();
            }

            actual = actual.getSiguiente();
        }

        return null;
    }
    public int generarCodigo() {

    if (estaVacia()) {
        return 101;
    }

    NodoPaciente actual = inicio;

    while (actual.getSiguiente() != null) {
        actual = actual.getSiguiente();
    }

    return actual.getPaciente().getCodigo() + 1;
}

    public boolean modificar(int codigo, Paciente nuevoPaciente) {
        NodoPaciente actual = inicio;

        while (actual != null) {
            if (actual.getPaciente().getCodigo() == codigo) {
                actual.setPaciente(nuevoPaciente);
                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }

    public boolean eliminar(int codigo) {
        NodoPaciente actual = inicio;

        while (actual != null) {
            if (actual.getPaciente().getCodigo() == codigo) {

                if (actual == inicio && actual == fin) {
                    inicio = null;
                    fin = null;

                } else if (actual == inicio) {
                    inicio = inicio.getSiguiente();
                    inicio.setAnterior(null);

                } else if (actual == fin) {
                    fin = fin.getAnterior();
                    fin.setSiguiente(null);

                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }

                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }

    public int cantidadPacientes() {
        int contador = 0;
        NodoPaciente actual = inicio;

        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }

        return contador;
    }

    public String mostrarAdelante() {
        if (estaVacia()) {
            return "No hay pacientes registrados.";
        }

        String texto = "";
        NodoPaciente actual = inicio;

        while (actual != null) {
            texto += actual.getPaciente().toString() + "\n";
            actual = actual.getSiguiente();
        }

        return texto;
    }

    public String mostrarAtras() {
        if (estaVacia()) {
            return "No hay pacientes registrados.";
        }

        String texto = "";
        NodoPaciente actual = fin;

        while (actual != null) {
            texto += actual.getPaciente().toString() + "\n";
            actual = actual.getAnterior();
        }

        return texto;
    }
}