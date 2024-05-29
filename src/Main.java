import java.util.Scanner;

import static java.lang.Math.random;

/**
 * Clase principal donde se ejecuta la batalla digital y el domador <p>
 * Se tiene un metodo donde se sacan los digimons randoms <p>
 *
 * @author Victor
 */
public class Main {
    static Scanner leer = new Scanner(System.in);

    /**
     * Metodo principal donde se ejecuta la batalla digital
     *
     * @param args
     */
    public static void main(String[] args) {


        System.out.println("Pon tu nombre:");

        Domador domador = new Domador(leer.next(), digimonRanmdom());
        System.out.println(domador.getNombre() + " bienvenido a tu aventura digimon tu primer digimon ha sido " + domador.digimonsGet(0).getNombre());
        domador.getEquipo();
        BatallaDigital batallaDigital;
        try {
            do {
                batallaDigital = new BatallaDigital(domador, digimonRanmdom());

                batallaDigital.iniciarPela();

                if (batallaDigital.isGana()) {
                    System.out.println("Tu equio actual es:");
                    domador.getEquipo();
                }
            } while (batallaDigital.isGana() && !batallaDigital.ganador());
            if (batallaDigital.ganador()) {
                System.out.println(domador.getNombre() + " ha ganado");
            }
        } catch (hasPerdido e) {
            System.out.println(e.getMessage());
            System.out.println("Vuelve a intentarlo");
        }
    }

    /**
     * <p>Metodo que saca un digimon random atraves de un math random y un switch</p>
     * <p>Se ha cambiado el nivel alatorio del 1 al 5 a de 5 al 10</p>
     *
     * @return da un digimon random entre Agumon, Gabumon y Patamon que esta entre nivel 5 al 10
     */
    public static Digimon digimonRanmdom() {
        int num = (int) (random() * 3) + 1;
        Digimon digimon = null;
        //Se ha cambiado el nivel alatorio del 1 al 5 a de 5 al 10
        switch (num) {
            case 1:
                digimon = (new Digimon("Agumon", (int) (random() * 5) + 6));
                break;
            case 2:
                digimon = (new Digimon("Gabumon", (int) (random() * 5) + 6));
                break;
            case 3:
                digimon = (new Digimon("Patamon", (int) (random() * 5) + 6));
                break;
        }
        return digimon;
    }

}