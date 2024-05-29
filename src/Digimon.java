/**
 * Clase donde se crean los digimons, se controlan sus estadisticas y sus aciones
 *
 * @author Victor
 */
public class Digimon {

    private String nombre;
    private int nivel;
    private int vidaMax;
    private int vida;
    private int ataque;
    private int defensa;
    private int dp1;
    private int dp2;
    private boolean debilitado = false;

    /**
     * Constructor de digimon que crea un digimon con sus estadisticas vida 10 veces el nivel
     * ataque 5 veces el nivel y defensa 2 veces el nivel y inica el los ataques a 10 cada uno
     *
     * @param nombre el nombre del digimon que puede ser entre Agumon, Gabumon o Patamon
     * @param nivel  y su nivel entre 1 y 10
     */
    public Digimon(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.vidaMax = (10 * nivel);
        this.vida = (10 * nivel);
        this.ataque = (5 * nivel);
        this.defensa = (2 * nivel);
        this.dp1 = 10;
        this.dp2 = 10;
    }

    /**
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * @return
     */
    public int getVida() {
        return vida;
    }

    /**
     * @return
     */
    public int getDp1() {
        return dp1;
    }

    /**
     * @return
     */
    public int getDp2() {
        return dp2;
    }

    /**
     * @return
     */
    public int getVidaMax() {
        return vidaMax;
    }

    /**
     * @return
     */
    public boolean isDebilitado() {
        return debilitado;
    }

    /**
     * Metodo que hace que el digimon haga un ataque normal
     *
     * @return daño del ataque normal
     */
    public int ataque1() {
        if (debilitado) {
            return 0;
        }
        int damage = this.ataque;
        dp1--;
        return damage;
    }

    /**
     * Metodo que hace que el digimon haga un ataque de especie se ha puesto el daño del ataque estpecial en 1,5 para que se más jugable
     *
     * @return daño del ataque de especie
     */
    public int ataque2() {
        if (debilitado) {
            return 0;
        }
        int damage = (int) (this.ataque * 1.5);
        dp2 -= 2;
        return damage;
    }

    /**
     * Metodo que comprueba si el digimon se puede capturar mirando si tine menos de 20 de vida
     *
     * @return si el digimon se puede capturar
     */
    public boolean captura() {
        if (this.vida <= 20) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * <p> Metodo que hace que el digimon reciba un ataque y se debilita si la vida llega a cero </p>
     * <p> Se ha implemenetado la variable defensa para que el digimon no se deblite tan facilmente
     * la defensa funciona de tal manera que si es demasiado alta (mayor que el 80% dela ataque)
     * recive el digimon un 20% del daño como minimo</p>
     * <p>Si no hay esa diferencia el daño que recibe es el daño menos la defensa</p>
     *
     * @param damage daño del ataque que va a recibir
     */
    public void recibirAtaque(int damage) {
        // Si la defensa es demasiado alta
        if (damage * 0.8 < this.defensa) {
            // El digimon recibe un 20% del daño como minimo
            this.vida -= (int) (damage * 0.2);
        } else {
            // Sino recibe el daño menos la defensa
            this.vida -= (damage - this.defensa);
        }
        if (this.vida <= 0) {
            debilitado = true;
            this.vida = 0;
        }
    }

    /**
     * Metodo que hace que el digimon se cure la mitad de su vida maxima y si estaba debilitado se lo revierte
     */
    public void curar() {
        this.vida += (int) (this.vidaMax / 2);
        if (debilitado) {
            debilitado = false;
        }
    }

    /**
     * Metodo que muestra los datos del digimon
     *
     * @return Los datos del digimon
     */
    @Override
    public String toString() {
        return "Datos de " + nombre +
                ", nivel: " + nivel +
                ", vida: " + vida +
                ", ataque: " + ataque +
                ", defensa: " + defensa +
                ", Ataque normal:" + dp1 +
                ", Ataque de especie: " + dp2;
    }

}
