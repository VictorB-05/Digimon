import java.util.ArrayList;

import static java.lang.Math.random;

public class Domador {
    private String nombre;
    private ArrayList<Digimon> digimons = new ArrayList<Digimon>();

    public Domador(String nombre, int digimon) {
        this.nombre = nombre;
        switch (digimon){
            case 1:
                this.digimons.add(new Digimon("Agumon", (int) (random()*5)+1));
                break;
            case 2:
                this.digimons.add(new Digimon("Gabumon", (int) (random()*5)+1));
                break;
            case 3:
                this.digimons.add(new Digimon("Patamon", (int) (random()*5)+1));
                break;
                /*
            case 4:
                this.digimons.add(new Digimon("Piyomon", (int) (random()*5)+1));
                break;
            case 5:
                this.digimons.add(new Digimon("Veedramon", (int) (random()*5)+1));
                break;*/
        }
    }
    public boolean capturaDigimon(Digimon d) {
        boolean captura = d.captura();;
    if(captura) {
        digimons.add(d);
    }
    return captura;
    }
    public String getNombre() {
        return nombre;
    }
}
