package estructuras;

import modelo.Medico;

public class ArbolMedicos {

    private NodoMedico raiz;

    public ArbolMedicos() {
        raiz = null;
    }

    public void insertar(Medico medico) {
        raiz = insertarRecursivo(raiz, medico);
    }

    private NodoMedico insertarRecursivo(NodoMedico actual, Medico medico) {
        if (actual == null) {
            return new NodoMedico(medico);
        }

        if (medico.getCodigo() < actual.getMedico().getCodigo()) {
            actual.setIzquierdo(insertarRecursivo(actual.getIzquierdo(), medico));
        } else if (medico.getCodigo() > actual.getMedico().getCodigo()) {
            actual.setDerecho(insertarRecursivo(actual.getDerecho(), medico));
        }

        return actual;
    }

    public Medico buscar(int codigo) {
        return buscarRecursivo(raiz, codigo);
    }

    private Medico buscarRecursivo(NodoMedico actual, int codigo) {
        if (actual == null) {
            return null;
        }

        if (codigo == actual.getMedico().getCodigo()) {
            return actual.getMedico();
        }

        if (codigo < actual.getMedico().getCodigo()) {
            return buscarRecursivo(actual.getIzquierdo(), codigo);
        } else {
            return buscarRecursivo(actual.getDerecho(), codigo);
        }
    }

    public String mostrarInOrden() {
        if (raiz == null) {
            return "No hay médicos registrados.";
        }

        return mostrarInOrdenRecursivo(raiz);
    }

    private String mostrarInOrdenRecursivo(NodoMedico actual) {
        if (actual == null) {
            return "";
        }

        return mostrarInOrdenRecursivo(actual.getIzquierdo())
                + actual.getMedico().toString() + "\n"
                + mostrarInOrdenRecursivo(actual.getDerecho());
    }
    public int generarCodigo() {
    return generarCodigoRecursivo(raiz, 200) + 1;
}

private int generarCodigoRecursivo(NodoMedico actual, int mayor) {
    if (actual == null) {
        return mayor;
    }

    if (actual.getMedico().getCodigo() > mayor) {
        mayor = actual.getMedico().getCodigo();
    }

    mayor = generarCodigoRecursivo(actual.getIzquierdo(), mayor);
    mayor = generarCodigoRecursivo(actual.getDerecho(), mayor);

    return mayor;
}
}