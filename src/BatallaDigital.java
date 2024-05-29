import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Math.random;

/**
 * Clase donde se ejecuta la batalla digital
 *
 * @author Victor
 */
public class BatallaDigital {

    static Scanner leer = new Scanner(System.in);
    private boolean gana = true;
    private Domador domador;
    private Digimon digimon;
    private Digimon digimonPropio;
    private boolean captura = false;
    private boolean batalla = true;

    /**
     * Constructor de la battala digital
     *
     * @param domador domador que ha creado el usuario
     * @param digimon digimon al que el domador se enfrenta
     */
    public BatallaDigital(Domador domador, Digimon digimon) {
        this.domador = domador;
        this.digimon = digimon;
        this.digimonPropio = domador.digimonsGet(0);
    }

    /**
     * Metodo que ve si el usuario ha ganado
     *
     * @return si el usuario ha gando
     */
    public boolean isGana() {
        return gana;
    }

    /**
     * <p>Metodo que inicia la batalla muestra el digimon enemigo y el usuario
     * y inicia los metodos de las distintas fases de la batalla</p>
     * <p>Si atraves del metodo hasPerdido el usuario ha perdido se termina la batalla y da un throw de hasPerdido</p>
     *
     * @throws hasPerdido si el usuario ha perdido
     */
    public void iniciarPela() throws hasPerdido {
        System.out.println(domador.getNombre() + " vs " + digimon.getNombre());
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
        int num;
        while (batalla) {
            turnoAliado();
            if (!captura && !digimon.isDebilitado()) {
                ataqueEnemigo();
                if (digimonPropio.isDebilitado()) {
                    if (hasPerdido()) {
                        gana = false;
                        throw new hasPerdido("Has perido");
                    }
                }
            } else {
                if (digimon.getVida() == 0) System.out.println(digimon.getNombre() + " ha sido derrotado");
                System.out.println(domador.getNombre() + " ha ganado");
                batalla = false;
            }
        }
    }

    /**
     * Que segun el numero de la accion que elija el usuario hace un ataque, una captura o cambia de digimon
     */
    private void turnoAliado() {
        int num = 0;
        boolean incorrecto = false;
        mostarAcciones();
        do {
            try {
                num = leer.nextInt();
                if ((num == 4 && domador.getDigimons().size() == 1) || (num < 1 || num > 4)) {
                    incorrecto = true;
                    System.out.println("Opcion no valida");
                } else {
                    incorrecto = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Formato no valida");
                incorrecto = true;
            }
        } while (incorrecto);
        switch (num) {
            case 1:
                digimon.recibirAtaque(digimonPropio.ataque1());
                break;
            case 2:
                digimon.recibirAtaque(digimonPropio.ataque2());
                break;
            case 3:
                captura = domador.capturaDigimon(digimon);
                if (captura) {
                    System.out.println(digimon.getNombre() + " capturado");
                    System.out.println("Se procede a curar a tu equipo");
                    domador.curarEquipo();
                    batalla = false;
                } else {
                    System.out.println(digimon.getNombre() + " no capturado");
                }
                break;
            case 4:
                while (!cambairaDigimon()) ;
                break;
        }
    }

    /**
     * Muestra las acciones que puede realizar el usuario
     */
    private void mostarAcciones() {
        String linea1 = String.format("│1 Ataque normal (%-2s/10) 2 Ataque de especie (%-2s/10)│", digimonPropio.getDp1(), digimonPropio.getDp2());
        mostrarDatos();
        System.out.println("┌───────────────────────────────────────────────────┐\n" +
                linea1 + "\n" +
                "│3 Capturar              4 Cambiar digimon          │\n" +
                "└───────────────────────────────────────────────────┘");
    }

    /**
     * <p>Metodo que hace que el enemigo digimon ataque al usurio.</p>
     * <p>Se usa un math random que da un numero del 1 al 4 y es paar que le ataque especial se más raro que ele ataque normal</p>
     * <p>Cunado se decide que ataque hacer se llama al al metodo correspondiente y se le pasa el daño a tu digimon atraves de el metodo receibirAtaque</p>
     */
    public void ataqueEnemigo() {
        int num;
        mostrarDatos();
        // Para hacer más jugable el ataque 1 es bastante más frecuente que el dos
        num = (int) Math.round(random() * 3) + 1;
        if (num == 1) {
            System.out.println("El " + digimon.getNombre() + " enemigo ha hecho un ataque de especie");
            digimonPropio.recibirAtaque(digimon.ataque2());
        } else {
            System.out.println("El " + digimon.getNombre() + " enemigo ha hecho un ataque común");
            digimonPropio.recibirAtaque(digimon.ataque1());
        }
    }

    /**
     * <p>Metodo que comprueba si el usuario a perdido</p>
     * <p>Si no a pedido el digimon se cambia</p>
     *
     * @return si el usuario ha perdido
     */
    public boolean hasPerdido() {
        System.out.println(digimonPropio.getNombre() + " ha sido derrotado");
        for (int i = 0; i < domador.numeroDigimons(); i++) {
            if (!domador.digimonsGet(i).isDebilitado()) {
                while (!cambairaDigimon()) {
                    System.out.println("");
                }
                return false;
            }
        }
        return true;
    }

    /**
     * <p>Metodo que hace que el <b>usuario cambie de digimon</b> y se le notifique si lo ha cambiado o no </p>
     * <p>Si el digimon esta <b>debilitado</b> no lo puede cambiar y se le notifica de que no se puede cambiar a ese digimon </p>
     * <p>Si el digimon ya se esta <b>luchando</b> no se puede cambiar </p>
     *
     * @return si el usuario ha cambiado de digimon
     */
    public boolean cambairaDigimon() {
        System.out.println("Cambia digimon");
        domador.getEquipo();
        try {
            int num = leer.nextInt() - 1;
            if (domador.digimonsGet(num).isDebilitado()) {
                System.out.println("El digimon esta debilitado");
                return false;
            } else if (num == 0) {
                System.out.println("El digimon esta ya luchando");
                return false;
            } else if (num <= domador.numeroDigimons() - 1 && num >= 0) {
                System.out.println("Cambiaste a " + domador.getDigimons().get(num).getNombre());
                domador.cambiarDigimon(num);
                digimonPropio = domador.digimonsGet(0);
                return true;
            }
        } catch (InputMismatchException e) {
            System.out.println("Solo numeros");
        }
        return false;
    }

    /**
     * Muestra los datos del digimon del usuario y del enemigo
     */
    public void mostrarDatos() {
        System.out.println(digimon.getNombre() + " Nivel " + digimon.getNivel() + "\nVida: " + digimon.getVida() + "/" + digimon.getVidaMax() + "\n");
        System.out.println("                 " + digimonPropio.getNombre() + " Nivel " + digimonPropio.getNivel() + "\n" +
                "                 Vida: " + digimonPropio.getVida() + "/" + digimonPropio.getVidaMax() + "\n");
    }

    /**
     * Metodo que comprueba si si el usuario ha ganado mirando si el usuario tiene a los digimons Agumon, Gabumon y Patamon
     *
     * @return si el usuario ha ganado
     */
    public boolean ganador() {
        boolean tieneAgumon = false;
        boolean tieneGabumon = false;
        boolean tienePatamon = false;

        for (int i = 0; i < domador.getDigimons().size(); i++) {
            String nombre = domador.digimonsGet(i).getNombre();
            if (nombre.equals("Agumon")) {
                tieneAgumon = true;
            } else if (nombre.equals("Gabumon")) {
                tieneGabumon = true;
            } else if (nombre.equals("Patamon")) {
                tienePatamon = true;
            }
        }

        return tieneAgumon && tieneGabumon && tienePatamon;
    }

}
