/**
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
     *
     * @param nombre
     * @param nivel
     * @author Victor
     */
    public Digimon(String nombre, int nivel){
        this.nombre = nombre;
        this.nivel = nivel;
        this.vidaMax = (10*nivel);
        this.vida = (10*nivel);
        this.ataque = (5*nivel);
        this.defensa = (2*nivel);
        this.dp1 = 10;
        this.dp2 = 10;
    }

    /**
     *
     * @param nombre
     * @author Victor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @param nivel
     * @author Victor
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     *
     * @param vida
     * @author Victor
     */
    private void setVida(int vida) {
        this.vida = vida;
    }

    /**
     *
     * @param ataque
     * @author Victor
     */
    private void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDp1(int dp1) {
        this.dp1 = dp1;
    }

    /**
     *
     * @param dp2
     * @author Victor
     */
    public void setDp2(int dp2) {
        this.dp2 = dp2;
    }

    /**
     *
     * @param defensa
     * @author Victor
     */
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    /**
     *
     * @param vidaMax
     * @author Victor
     */
    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
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
     * @return
     * @author Victor
     */
    public int getNivel() {
        return nivel;
    }

    /**
     *
     * @return
     * @author Victor
     */
    public int getVida() {
        return vida;
    }

    /**
     *
     * @return
     * @author Victor
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     *
     * @return
     * @author Victor
     */
    public int getDefensa() {
        return defensa;
    }

    /**
     *
     * @return
     * @author Victor
     */
    public int getDp1() {
        return dp1;
    }

    /**
     *
     * @return
     * @author Victor
     */
    public int getDp2() {
        return dp2;
    }

    /**
     *
     * @return
     * @author Victor
     */
    public int getVidaMax() {
        return vidaMax;
    }

    /**
     *
     * @return
     * @author Victor
     */
    public boolean isDebilitado() {
        return debilitado;
    }

    /**
     *
     * @return
     * @author Victor
     */
    public int ataque1(){
        if(debilitado){
           return 0;
        }
        int damage = this.ataque;
        dp1--;
        return damage;
    }

    /**
     *
     * @return
     * @author Victor
     */
    public int ataque2(){
        // se ha puesto el daño del ataque estpecial en 1,5 para que se más jugable
        if(debilitado){
            return 0;
        }
        int damage = (int) (this.ataque*1.5);
        dp2-=2;
        return damage;
    }

    /**
     *
     * @return
     * @author Victor
     */
    public boolean captura(){
        if(this.vida <= 20){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     *
     * @param damage
     * @author Victor
     */
    public void recibirAtaque(int damage){
        // Si la defensa es demasiado alta
        if(damage*0.8<this.defensa){
            // El digimon recibe un 20% del daño como minimo
            this.vida -= (int) (damage*0.2);
        }else{
            // Sino recibe el daño menos la defensa
            this.vida -= (damage-this.defensa);
        }
        if (this.vida <= 0){
            debilitado = true;
            this.vida = 0;
        }
    }

    /**
     *
     * @return
     * @author Victor
     */
    @Override
    public String toString() {
        return  "Datos de " + nombre +
                ", nivel: " + nivel +
                ", vida: " + vida +
                ", ataque: " + ataque +
                ", Ataque normal:" + dp1 +
                ", Ataque de especie: " + dp2;
    }

    /**
     * @author Victor
     */
    public void curar(){
        this.vida += (int) (this.vidaMax/2);
    }
}
