import java.util.ArrayList;

import static java.lang.Math.random;

/**
 * @author Victor
 */
public class Domador {
    private String nombre;
    private ArrayList<Digimon> digimons = new ArrayList<Digimon>();

    /**
     *
     * @param nombre
     * @param digimon
     * @author Victor
     */
    public Domador(String nombre, Digimon digimon) {
        this.nombre = nombre;
        this.digimons.add(digimon);
    }

    /**
     *
     * @param d
     * @return
     * @author Victor
     */
    public Boolean capturaDigimon(Digimon d) {
        boolean captura = false;
        if (d.captura()) {
            digimons.add(d);
            captura = true;
        }
        return captura;
    }

    /**
     *
     * @return
     * @author Victor
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param i
     * @return
     * @author Victor
     */
    public Digimon digimonsGet(int i) {
        return digimons.get(i);
    }

    /**
     * @author Victor
     */
    public void getEquipo() {
        for (int i = 0; i < digimons.size(); i++) {
            System.out.println("Digimon " + (i + 1) + ": " +digimons.get(i).toString());
        }
    }

    /**
     *
     * @return
     * @author Victor
     */
    public ArrayList<Digimon> getDigimons() {
        return digimons;
    }

    /**
     *
     * @return
     * @author Victor
     */
    public int numeroDigimons() {
        return digimons.size();
    }

    /**
     *
     * @param num
     * @return
     * @author Victor
     */
    public Digimon cambiarDigimon(int num) {
        Digimon aux = digimons.get(num);
        digimons.set(num, digimons.get(0));
        digimons.set(0, aux);
        return aux;
    }

    /**
     * @author Victor
     */
    public void debilitado(){
        digimons.remove(0);
    }

    /**
     * @author Victor
     */
    public void curarEquipo() {
        for(int i = 0; i < digimons.size(); i++){
            digimons.get(i).curar();
        }
    }
}
