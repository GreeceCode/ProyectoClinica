package archivos;

import java.io.*;
import modelo.DatosClinica;
import modelo.Medico;

public class ArchivoMedicos {

    public static void guardar(Medico medico) {

        try {

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("src/main/java/archivos/medicos.txt", true));

            bw.write(
                    medico.getCodigo() + "," +
                    medico.getNombre() + "," +
                    medico.getEspecialidad() + ","
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
                    new FileReader("src/main/java/archivos/medicos.txt"));

            String linea;

            while ((linea = br.readLine()) != null) {

                String datos[] = linea.split(",");

                Medico medico = new Medico(
                        Integer.parseInt(datos[0]),
                        datos[1],
                        datos[2]
                );

                DatosClinica.arbolMedicos.insertar(medico);

            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}