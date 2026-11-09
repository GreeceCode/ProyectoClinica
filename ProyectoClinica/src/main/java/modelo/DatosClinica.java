package modelo;

import estructuras.ArbolMedicos;
import estructuras.ColaAtencion;
import estructuras.ColaPrioridadEmergencia;
import estructuras.ListaDoblePacientes;
import estructuras.MatrizHabitaciones;
import estructuras.PilaHistorial;

import java.util.ArrayList;

public class DatosClinica {

    public static ListaDoblePacientes listaPacientes = new ListaDoblePacientes();
    public static ColaAtencion colaAtencion = new ColaAtencion();
    public static ColaPrioridadEmergencia colaEmergencia = new ColaPrioridadEmergencia();
    public static PilaHistorial pilaHistorial = new PilaHistorial();
    public static ArbolMedicos arbolMedicos = new ArbolMedicos();
    public static MatrizHabitaciones matrizHabitaciones = new MatrizHabitaciones(2, 3);

    // Para evitar cargar los TXT más de una vez
    public static boolean datosCargados = false;

    // Pacientes que ya fueron atendidos
    public static ArrayList<Paciente> pacientesAtendidos = new ArrayList<>();

}