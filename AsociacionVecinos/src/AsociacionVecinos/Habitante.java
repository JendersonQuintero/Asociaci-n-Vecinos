package AsociacionVecinos;

/**
 *
 * @author Jenderson Quintero y Norangel Marín.
 */
public class Habitante {
    Vecino habitante;
    Habitante siguiente;
    
    /**
     * Constructor del Nodo Habitante
     * @param habitante 
     */
    public Habitante(Vecino habitante){
        this.habitante=habitante;
        this.siguiente=null;
    }
}
