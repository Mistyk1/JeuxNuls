package Jeux;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class DZQH {
    private static final Scanner sc = new Scanner(System.in);
    private static final Random r = new Random();

    DZQH(){
        DZQH.main(null);
    }

    public static void regles(){
        System.out.println("--- Règles ---");
        System.out.println("[Insérer règles]");
        System.out.println("--------------");
        System.out.println("(Entrez une touche pour continuer)");
        sc.next();
    }

    public static boolean estPlein(int[][] tab){
        boolean plein = true;
        for (int i = 0; i < tab.length; i += 1){
            for (int j = 0; j < tab[0].length; j += 1){
                if (tab[i][j] != 0 || !plein){
                    plein = false;
                }
            }
        }
        return plein;
    }

    public static void placerNb(int[][] tab){
        if (!estPlein(tab)){
            ArrayList<int[]> libres = new ArrayList<>();
            for (int i = 0; i < tab.length; i += 1){
                for (int j = 0; j < tab[0].length; j += 1){
                    if (tab[i][j] == 0){
                        libres.add(new int[]{i, j});
                    }
                }
            }
            int[] coo = libres.get(r.nextInt(libres.size()));
            tab[coo[0]][coo[1]] = (r.nextInt(1) + 1) * 2;
        }
    }

    public static void main(String[] args) {
        System.out.print("Bienvenue au 2048!\nSouhaitez-vous connaitre les règles? (y/n) > ");
        char rep = sc.next().charAt(0);
        if (rep == 'y' || rep == 'Y'){
            regles();
        }
        int[][] tab = new int[][]{{0, 0, 0, 0},
                                  {0, 0, 0, 0},
                                  {0, 0, 0, 0},
                                  {0, 0, 0, 0}
        };
        placerNb(tab);
        placerNb(tab);
        placerNb(tab);
    }
}
