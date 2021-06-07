package AsociacionVecinos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Jenderson Quintero y Norangel Marín.
 */
public class Txt {

    private final File archivo = new File("test\\datosparcial.csv");
    private String texto = "";
    AsociacionVecinos aV = new AsociacionVecinos();
    
    /**
     * Procedimiento que lee el archivo texto y los ingresa al sistema.
     */
    public void cargarDatos() {
        // Proceso de extracion de datos
        try {
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String linea = "";
            while ((linea = leer.readLine()) != null) {
                texto += linea + "\n";
            }
        } catch (FileNotFoundException e) {

        } catch (IOException ex) {
            Logger.getLogger(Txt.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Proceso de almacenamiento
        String[] vecinos = texto.split("\n");
        for (String vecino : vecinos) {
            String[] datos = vecino.split(",");
            for (int j = 0; j < datos.length; j+=5) {
                if ("PH".equals(datos[4].toUpperCase())) {
                    int apto = 75;
                    aV.insertarListaAptos(aV.insertarListaVecinos(Long.parseLong(datos[0]), datos[1], Long.parseLong(datos[2]), datos[3], apto));
                } else {
                    aV.insertarListaAptos(aV.insertarListaVecinos(Long.parseLong(datos[0]), datos[1], Long.parseLong(datos[2]), datos[3], Integer.parseInt(datos[4])));
                }

            }
        }
    }
}
