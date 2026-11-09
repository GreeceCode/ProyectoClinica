package modelo;

public class Emergencia {

    private int codigo;
    private String paciente;
    private int prioridad;

    public Emergencia(int codigo, String paciente, int prioridad) {
        this.codigo = codigo;
        this.paciente = paciente;
        this.prioridad = prioridad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return codigo + " - " + paciente + " (Prioridad " + prioridad + ")";
    }

}