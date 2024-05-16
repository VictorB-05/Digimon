public class Digimon {

    private String nombre;
    private int nivel;
    private int vida;
    private int ataque;
    private int dp1;
    private int dp2;

    public Digimon(String nombre, int nivel){
        this.nombre = nombre;
        this.nivel = nivel;
        this.vida = (10*nivel);
        this.ataque = (5*nivel);
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

    public int getDp1() {
        return dp1;
    }

    public int getDp2() {
        return dp2;
    }

    public int ataqueC(){
        int daño = this.ataque;

        return daño;
    }

    public int ataqueP(){
        int daño = this.ataque;

        return daño;
    }
}
