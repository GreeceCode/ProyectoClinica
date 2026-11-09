package archivos;

import java.io.*;
import modelo.Consulta;
import modelo.DatosClinica;

public class ArchivoHistorial {

    public static void guardar(Consulta consulta) {

        try {

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("src/main/java/archivos/historial.txt", true));

            bw.write(
                    consulta.getCodigo() + "," +
                    consulta.getPaciente() + "," +
                    consulta.getMedico() + "," +
                    consulta.getConsulta()
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
                    new FileReader("src/main/java/archivos/historial.txt"));

            String linea;

            while ((linea = br.readLine()) != null) {

                String datos[] = linea.split(",");

                Consulta consulta = new Consulta(
                        Integer.parseInt(datos[0]),
                        datos[1],
                        datos[2],
                        datos[3]
                );

                DatosClinica.pilaHistorial.agregarConsulta(consulta);
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}