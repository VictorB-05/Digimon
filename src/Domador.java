import java.util.ArrayList;

import static java.lang.Math.random;

/**
 * Clase donde se el domadores basicamenete el perfil del usaurio aquí en un arraylist se tiene el equipo de digimons
 *
 * @author Victor
 */
public class Domador {
    private String nombre;
    private ArrayList<Digimon> digimons = new ArrayList<Digimon>();

    /**
     * Constructor que inicializa el nombre del domador y le mete un digimon al equpio
     *
     * @param nombre
     * @param digimon
     */
    public Domador(String nombre, Digimon digimon) {
        this.nombre = nombre;
        this.digimons.add(digimon);
    }

    /**
     * Metodo que se le pasa un digimon y atraves de el metodo captura del digimon se captura o no el digimon y se mete al equipo de digimons luego se captura el digimon
     *
     * @param digimon el digimon que se va a capturar o no
     * @return debuelve: <br>
     * <b>true</b> si se ha capturado o no <br>
     * <b>false</b> en caso de que no se haya capturado
     */
    public Boolean capturaDigimon(Digimon digimon) {
        boolean captura = false;
        if (digimon.captura()) {
            digimons.add(digimon);
            captura = true;
        }
        return captura;
    }

    /**
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Muestra el digimon del equipo que este en la posicion que se pase por parametro
     *
     * @param numero El numero del digimon que queremos ver
     * @return El digimon escogido
     */
    public Digimon digimonsGet(int numero) {
        return digimons.get(numero);
    }

    /**
     * Metodo que muestra todos los digimons del equipo por consola
     */
    public void getEquipo() {
        for (int i = 0; i < digimons.size(); i++) {
            System.out.println("Digimon " + (i + 1) + ": " + digimons.get(i).toString());
        }
    }

    /**
     * metodo que devuelve el arraylist de digimons paraa acceder más facilmente a funciones desde la batalla digital
     *
     * @return el arraylist de digimons
     */
    public ArrayList<Digimon> getDigimons() {
        return digimons;
    }

    /**
     * Metodo que devuelve el numero de digimons del equipo para poder contavilizar el numero de digimons
     *
     * @return el numero de digimons del equipo
     */
    public int numeroDigimons() {
        return digimons.size();
    }

    /**
     * Metodo que cambia un digimon a primera posicion y pone el que estaba en primera posicion en la posicion del digimon que se a cambiado
     *
     * @param num el numero del digimon que queremos cambiar a primera posicion
     * @return el digimon que se ha cambiado a primera posicion
     */
    public Digimon cambiarDigimon(int num) {
        Digimon aux = digimons.get(num);
        digimons.set(num, digimons.get(0));
        digimons.set(0, aux);
        return aux;
    }

    /**
     * Metodo creado para curar el equpio desde la batalla digital para hacer más jugable el juego
     */
    public void curarEquipo() {
        for (int i = 0; i < digimons.size(); i++) {
            digimons.get(i).curar();
        }
    }
}
