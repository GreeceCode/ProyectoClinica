package modelo;

public class Consulta {

    private int codigo;
    private String paciente;
    private String medico;
    private String consulta;

    public Consulta(int codigo, String paciente, String medico, String consulta) {
        this.codigo = codigo;
        this.paciente = paciente;
        this.medico = medico;
        this.consulta = consulta;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getPaciente() {
        return paciente;
    }

    public String getMedico() {
        return medico;
    }

    public String getConsulta() {
        return consulta;
    }

    @Override
    public String toString() {
        return "Consulta " + codigo + ": " + consulta + " | Medico: " + medico;
    }
}