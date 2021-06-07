/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AsociacionVecinos;

import java.awt.HeadlessException;
import java.text.Normalizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Jenderson Quintero y Norangel Marín
 */
public class Funcionalidades {

    Txt t = new Txt();

    /**
     * Método que se encarga de buscar a un veecino por su número de cédula y
     * muestra su ubicación de memoria.
     */
    public void buscarVecinos() {
        try {
            long cedula = Long.parseLong(JOptionPane.showInputDialog(null, "Ingrese la cédula del vecino: ", "Buscar un vecino", 1));
            Vecino direccion = t.aV.buscarVecino(cedula);
            if (direccion != null) {
                JOptionPane.showMessageDialog(null, direccion, "Dirección de memoria del Vecino", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Este vecino no se encuentra en la base de datos.", "Vecino NO encontrado", 0);
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados", "ERROR, Datos invalidos", 0);
        }
    }

    /**
     * Método que se encarga de buscar los habitantes de un apartamento por el
     * nombre del edifico y el número de apto. Muestra en pantalla la dirección
     * de memoria y los habitantes del apto.
     */
    public void buscarHabitantes() {
        try {
            String edificio = JOptionPane.showInputDialog(null, "Ingrese el edificio del vecino", "Buscar un vecino", 1);
            String apartamento = JOptionPane.showInputDialog(null, "Ingrese el apartamento del vecino: ", "Buscar un vecino", 1).toUpperCase();
            int apto;
            if ("PH".equals(apartamento)) {
                apto = 75;
            } else {
                apto = Integer.parseInt(apartamento);
            }
            Habitante direccion = t.aV.buscarHabitantes(edificio, apto);
            if (direccion != null) {
                JOptionPane.showMessageDialog(null, direccion, "Direción de memoria del apto.", 1);

                String info = "LISTA DE HABITANTES: " + "\n";
                info += "\n";

                while (direccion != null) {
                    info += "NOMBRE: " + direccion.habitante.nombre + "\n";
                    info += "CÉDULA: " + direccion.habitante.cedula + "\n";
                    info += "TELEFONO: " + direccion.habitante.telefono + "\n";
                    info += "EDIFICIO: " + direccion.habitante.edificio + "\n";
                    info += "APARTAMENTO: " + apartamento + "\n";
                    info += "\n";
                    direccion = direccion.siguiente;
                }

                JOptionPane.showMessageDialog(null, info, "Habitantes del Apartamento", 1);

            } else {
                JOptionPane.showMessageDialog(null, "Este apartamento no se encuentra en la base de datos.", "El apartamento no exite", 0);
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados", "ERROR, Datos invalidos", 0);
        }
    }
    
    /**
     * Función que limpia los acentos de cualquier texto que se le ingrese
     * @param texto
     * @return Un String sin ningún tipo de acento
     */
    public static String limpiarTexto(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }
}
