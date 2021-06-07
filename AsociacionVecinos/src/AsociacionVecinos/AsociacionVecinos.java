package AsociacionVecinos;

/**
 *
 * @author Jenderson Quintero y Norangel Marín.
 */
public class AsociacionVecinos {
    Vecino[] tablaVecinos;
    Habitante[] tablaApartamentos;

    
    /**
     * Constructor de las Tablas Hash.
     */
    public AsociacionVecinos(){
        this.tablaVecinos = new Vecino[269];
        this.tablaApartamentos = new Habitante[169];
        for (int i = 0; i < 269; i++) {
            tablaVecinos[i] = null;
        } 
        
        for (int i = 0; i < 169; i++) {
            tablaApartamentos[i] = null;
        }
    }
    
    /**
     * Función que devuelve la posición en la que se insertará un elemento de acuerdo a la cedula y el tamaño del arreglo.
     * @param clave
     * @return int
     */
    public int funcionHashTV(long clave){
        int tamañoTV = 269;
        int key = (int) (clave  % tamañoTV);
        return key;  
    }
    
    /**
     * Función que devuelve la posición en la que se insertará un elemento de acuerdo al edificio, apartamento y el tamaño del arreglo.
     * @param edificio
     * @param apartamento
     * @return int
     */
    public int funcionHashTA(String edificio, int apartamento){
            int tamañoTA = 169;
            int key = (apartamento % tamañoTA);

            for (int i = 0; i < tamañoTA ; i++) {
                if(tablaApartamentos[key] == null || tablaApartamentos[key].habitante.apartamento==apartamento && tablaApartamentos[key].habitante.edificio.equals(Funcionalidades.limpiarTexto(edificio))){
                    return key;
                }
                else{
                    key++;
                }
            }
        return key;       
    }
  
    /**
     * Procedimiento de inserción de un vecino en la tabla vecinos.
     * @param cedula
     * @param nombre
     * @param telefono
     * @param edificio
     * @param apto
     * @return Vecino
     */
    public Vecino insertarListaVecinos(long cedula, String nombre, long telefono, String edificio, int apto){
        int posicion;
        Vecino nuevo;
        
        posicion = funcionHashTV(cedula);
        nuevo = new Vecino(cedula, nombre.toUpperCase(), telefono, edificio.toUpperCase(), apto);
        nuevo.siguiente = this.tablaVecinos[posicion];
        this.tablaVecinos[posicion] = nuevo;
        return nuevo;
    }
    
    /**
     * Busca la dirección de memoria de un vecino de la tabla pasandole como parametro la cedula del mismo.
     * @param clave
     * @return Vecino
     */
    public Vecino buscarVecino(long clave){
        Vecino aux = null;
        int posicion = funcionHashTV(clave);
        
        if(this.tablaVecinos[posicion] != null){
            aux = this.tablaVecinos[posicion];
            while((aux.siguiente != null) && (aux.cedula != clave)){
                aux = aux.siguiente;
            }
            if(aux.cedula != clave){
                aux = null;
            } 
        }
        return aux;
    }
    
    /**
     * Procedimiento de inserción de un habitante en la tabla apartamentos.
     * @param vecino 
     */
    public void insertarListaAptos(Vecino vecino){      
        int posicion;
        Habitante habitante;
        
        habitante = new Habitante(vecino);
        posicion = funcionHashTA(vecino.edificio, vecino.apartamento);
        habitante.siguiente = this.tablaApartamentos[posicion];
        this.tablaApartamentos[posicion] = habitante;
    }
    
    /**
     * Busca la dirección de memoria de la lista habitantes de un apartamento pasandole como parametro el edificio y el apartamento en cuestion.
     * @param edificio
     * @param apto
     * @return Habitante
     */
    public Habitante buscarHabitantes(String edificio, int apto){
        Habitante aux = null;
        int posicion = funcionHashTA(edificio.toUpperCase(),apto);
        
        if(this.tablaApartamentos[posicion] != null){
            aux = tablaApartamentos[posicion];
            return aux;
        }
        return aux;
    }   
}
