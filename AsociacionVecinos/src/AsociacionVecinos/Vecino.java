package AsociacionVecinos;

/**
 *
 * @author Jenderson Quintero y Norangel Marín.
 */
public class Vecino {
    long cedula;
    String nombre;
    long telefono;
    String edificio;
    int apartamento;
    Vecino siguiente;
    
    /**
     * Constructor del Nodo Vecino.
     * @param cedula
     * @param nombre
     * @param telefono
     * @param edificio
     * @param apto 
     */
    public Vecino(long cedula, String nombre, long telefono, String edificio, int apto){
        this.cedula=cedula;
        this.nombre=nombre;
        this.telefono=telefono;
        this.edificio=Funcionalidades.limpiarTexto(edificio);
        this.apartamento=apto;
        this.siguiente = null;
    }
}
