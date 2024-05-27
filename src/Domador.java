import java.util.ArrayList;

import static java.lang.Math.random;

public class Domador {
    private String nombre;
    private ArrayList<Digimon> digimons = new ArrayList<Digimon>();

    public Domador(String nombre, Digimon digimon) {
        this.nombre = nombre;
        this.digimons.add(digimon);
    }

    public String capturaDigimon(Digimon d) {
        String captura = "";
        if (d.captura()) {
            digimons.add(d);
            captura = d.getNombre() + " capturado";
        } else {
            captura = d.getNombre() + " no capturado";
        }
        return captura;
    }

    public String getNombre() {
        return nombre;
    }

    public Digimon digimonsGet(int i) {
        return digimons.get(i);
    }

    public void getEquipo() {
        for (int i = 0; i < digimons.size(); i++) {
            System.out.println(digimons.get(i).toString());
        }
    }
}
