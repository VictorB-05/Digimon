public class Digimon {

    private String nombre;
    private int nivel;
    private int vida;
    private int ataque;
    private int defensa;
    private int dp1;
    private int dp2;

    public Digimon(String nombre, int nivel){
        this.nombre = nombre;
        this.nivel = nivel;
        this.vida = (10*nivel);
        this.ataque = (5*nivel);
        this.defensa = (3*nivel);
        this.dp1 = 10;
        this.dp2 = 10;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    private void setVida(int vida) {
        this.vida = vida;
    }

    private void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDp1(int dp1) {
        this.dp1 = dp1;
    }

    public void setDp2(int dp2) {
        this.dp2 = dp2;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getVida() {
        return vida;
    }
    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getDp1() {
        return dp1;
    }

    public int getDp2() {
        return dp2;
    }



    public int ataque1(){
        int damage = this.ataque;
        dp1--;
        return damage;
    }

    public int ataque2(){
        int damage = this.ataque*2;
        dp2-=2;
        return damage;
    }

    public boolean captura(){
        if(this.vida <= 20){
            return true;
        }
        else{
            return false;
        }
    }

    public void recibirAtaque(int daño){
        // Si la defensa es demasiado alta
        if(daño*0.8<this.defensa){
            // El digimon recibe un 20% del daño como minimo
            this.vida -= daño*0.2;
        }else{
            // Sino recibe el daño menos la defensa
            this.vida -= daño-this.defensa;
        }
        this.vida -= daño;
        if (this.vida <= 0){
            this.vida = 0;
        }
    }

    @Override
    public String toString() {
        return  "Datos de " + nombre +
                ", nivel: " + nivel +
                ", vida: " + vida +
                ", ataque: " + ataque +
                ", Ataque normal:" + dp1 +
                ", Ataque de especie: " + dp2;
    }
}
