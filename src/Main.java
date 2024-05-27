import java.util.Scanner;

import static java.lang.Math.random;

public class Main {
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("Pon tu nombre:");

        Domador domador = new Domador(leer.next(), digimonRanmdom());
        System.out.println(domador.getNombre()+" bienvenido a tu aventura digimon tu primer digimon ha sido "+domador.digimonsGet(0).getNombre());
        domador.getEquipo();
        while (batalla(domador, digimonRanmdom())){
            System.out.println("Tu equio actual es:");
            domador.getEquipo();
        }
    }

    public static Digimon digimonRanmdom() {
        int num = (int) (random() * 3) + 1;
        Digimon digimon = null;
        switch (num) {
            case 1:
                digimon = (new Digimon("Agumon", (int) (random() * 5) + 1));
                break;
            case 2:
                digimon = (new Digimon("Gabumon", (int) (random() * 5) + 1));
                break;
            case 3:
                digimon = (new Digimon("Patamon", (int) (random() * 5) + 1));
                break;
                /*
            case 4:
                this.digimons.add(new Digimon("Piyomon", (int) (random()*5)+1));
                break;
            case 5:
                this.digimons.add(new Digimon("Veedramon", (int) (random()*5)+1));
                break;*/
        }
        return digimon;
    }

    public static boolean batalla(Domador domador, Digimon digimon) {
        boolean gana = true, sigue = true;
        int vidaE = digimon.getVida();
        int vidaA = domador.digimonsGet(0).getVida();

        System.out.println(domador.getNombre() + " vs " + digimon.getNombre());
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
        while(sigue){
            Digimon digimonPropio = domador.digimonsGet(0);
            System.out.println(digimon.getNombre() +" Nivel " + digimon.getNivel() +"\nVida: " + digimon.getVida()+"/"+vidaE+"\n");
            System.out.println("                 "+digimonPropio.getNombre() +" Nivel " + digimonPropio.getNivel() +"\n                 Vida: " + digimonPropio.getVida()+"/"+vidaA+"\n");
            System.out.println( "┌───────────────────────────────────────────────────┐\n" +

                                "│1 Ataque normal ("+digimonPropio.getDp1()+"/10) 2 Ataque de especie ("+digimonPropio.getDp2()+"/10)│\n" +
                                "│3 Capturar              4 Cambiar digimon          │\n"+
                                "└───────────────────────────────────────────────────┘");
            int num = leer.nextInt();
            switch (num) {
                case 1:
                    digimon.recibirAtaque(digimonPropio.ataque1());
                    break;
                case 2:
                    digimon.recibirAtaque(digimonPropio.ataque2());
                    break;
                case 3:
                    System.out.println(domador.capturaDigimon(digimon));
                    break;
                case 4:
                    System.out.println("Cambiar digimon");
                    break;
            }
            if(digimon.getVida()>0){
                // Para hacer más jugable el ataque 1 es bastante más frecuente que el dos
                num = (int) (random()*3);
                if(num == 1){
                    digimonPropio.recibirAtaque(digimon.ataque2());
                }else{
                    digimonPropio.recibirAtaque(digimon.ataque1());
                }
                if(digimonPropio.getVida()<=0){
                    gana = false;
                    sigue = false;
                    System.out.println(domador.getNombre() + " ha sido derrotado");
                }

            }else {
                System.out.println(digimon.getNombre() + " ha sido derrotado");
                System.out.println(domador.getNombre() + " ha ganado");
                sigue = false;
            }
        }
        return gana;
    }
}