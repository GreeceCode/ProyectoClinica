package estructuras;

public class MatrizHabitaciones {
    private String[][] habitaciones;

    public MatrizHabitaciones(int pisos, int cantidadHabitaciones) {
        habitaciones = new String[pisos][cantidadHabitaciones];

        for (int i = 0; i < pisos; i++) {
            for (int j = 0; j < cantidadHabitaciones; j++) {
                habitaciones[i][j] = "Libre";
            }
        }
    }

    public void ocuparHabitacion(int piso, int habitacion) {
        habitaciones[piso][habitacion] = "Ocupado";
    }

    public void liberarHabitacion(int piso, int habitacion) {
        habitaciones[piso][habitacion] = "Libre";
    }

    public String consultarHabitacion(int piso, int habitacion) {
        return habitaciones[piso][habitacion];
    }

    public String mostrarHabitaciones() {

    String texto = "";

    texto += "          Habitación\n\n";
    texto += "          1        2        3\n\n";

    for (int i = 0; i < habitaciones.length; i++) {

        texto += "Piso " + (i + 1) + "   ";

        for (int j = 0; j < habitaciones[i].length; j++) {

            if (habitaciones[i][j].equals("Libre")) {
                texto += "Libre    ";
            } else {
                texto += "Ocup.    ";
            }
        }

        texto += "\n\n";
    }

    return texto;
}

    public int contarLibres() {
        int contador = 0;

        for (int i = 0; i < habitaciones.length; i++) {
            for (int j = 0; j < habitaciones[i].length; j++) {
                if (habitaciones[i][j].equals("Libre")) {
                    contador++;
                }
            }
        }

        return contador;
    }
}