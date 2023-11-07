package jeux;

import java.util.Random;
import java.util.Scanner;

import java.util.ArrayList;

public class DZQH {
    private static final Scanner sc = new Scanner(System.in);
    private static final Random r = new Random();

    public DZQH(){
        main(null);
    }





    //---- Classe Plateau ----
    private static class Plateau{
        private int[][] plateau;

        Plateau(){
            this.plateau = new int[][]{{0, 0, 0, 0},
                                       {0, 0, 0, 0},
                                       {0, 0, 0, 0},
                                       {0, 0, 0, 0}
            };
        }

        public boolean estPlein(){
            boolean plein = true;
            for (int i = 0; i < plateau.length; i += 1){
                for (int j = 0; j < plateau[0].length; j += 1){
                    if (plateau[i][j] != 0 || !plein){
                        plein = false;
                    }
                }
            }
            return plein;
        }

        public void placerNb(){
            if (!estPlein()){
                ArrayList<int[]> libres = new ArrayList<>();
                for (int i = 0; i < plateau.length; i += 1){
                    for (int j = 0; j < plateau[0].length; j += 1){
                        if (plateau[i][j] == 0){
                            libres.add(new int[]{i, j});
                        }
                    }
                }
                int[] coo = libres.get(r.nextInt(libres.size()));
                plateau[coo[0]][coo[1]] = (r.nextInt(1) + 1) * 2;
            }
        }

        public String afficherPlateauString(){
            String str = "";
            for (int[] x : plateau){
                for (int y : x){
                    str += y;
                }
                str += "\n";
            }
            return str;
        }
    }
    //------------------------




    
    public static void regles(){
        System.out.println("--- Règles ---");
        System.out.println("[Insérer règles]");
        System.out.println("--------------");
        System.out.println("(Entrez une touche pour continuer)");
        sc.next();
    }

    public static void main(String[] args) {
        System.out.print("Bienvenue au 2048!\nSouhaitez-vous connaitre les règles? (y/n) > ");
        char rep = sc.next().charAt(0);
        if (rep == 'y' || rep == 'Y'){
            regles();
        }
        Plateau p = new Plateau();
        p.placerNb();
        p.placerNb();
        p.placerNb();
        System.out.println(p.afficherPlateauString());
    }
}
