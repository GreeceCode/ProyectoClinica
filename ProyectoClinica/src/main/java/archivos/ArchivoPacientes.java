package archivos;

import java.io.*;
import modelo.DatosClinica;
import modelo.Paciente;

public class ArchivoPacientes {

    public static void guardar(Paciente paciente) {

        try {

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("src/main/java/archivos/pacientes.txt", true));

            bw.write(
                    paciente.getCodigo() + "," +
                    paciente.getNombre() + "," +
                    paciente.getEdad() + "," +
                    paciente.getSexo() + "," +
                    paciente.getTelefono() + "," +
                    paciente.getSeguro()
            );

            bw.newLine();

            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void cargar() {

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("src/main/java/archivos/pacientes.txt"));

            String linea;

            while ((linea = br.readLine()) != null) {

                String datos[] = linea.split(",");

                Paciente paciente = new Paciente(
                        Integer.parseInt(datos[0]),
                        datos[1],
                        Integer.parseInt(datos[2]),
                        datos[3],
                        datos[4],
                        datos[5]
                );

                DatosClinica.listaPacientes.insertar(paciente);

            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}