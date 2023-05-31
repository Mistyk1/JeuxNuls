import java.util.Random;
import java.util.Scanner;

public class Knucklebones{

    public static final String ANSI_RESET = "\u001B[0m";
    private static final Scanner sc = new Scanner(System.in);

    public static void regles(){
        System.out.println("--- Règles ---");
        System.out.println("Chaque joueurs possède un tableau en 3x3. à chaque tour, un joueur lance un dé et peut le placer sur une de ses colonne.");
        System.out.println("Il faut que la colonne ne soit pas remplie pour pouvoir l'utiliser.");
        System.out.println("Chaque dé x placé rapporte x de points sur la colonne. Si plusieurs dé x sont sur une colonne, les points gagnés suivent cette formule: x * (nombre d'occurence ^ 2).");
        System.out.println("Si un dé x est placé sur une colonne, alors tout les dés x sur cette même colonne de l'adversaire seront détruits.");
        System.out.println("Pour gagner il faut avoir le plus de points.");
        System.out.println("--------------");
        System.out.println("(Entrez une touche pour continuer)");
        sc.next();
    }

    public static int lancerDe(){
        Random de = new Random();
        return (de.nextInt(6) + 1);
    }

    public static void afficherPlateaux(Joueur j1, Joueur j2){
        System.out.println("----------");
        for (int i = 0; i < 3; i += 1){
            System.out.print(j1.colonnes[i] + " ");
        }
        System.out.println("\n");
        for (int k = 0; k < 2; k += 1){
            for (int i = 0; i < 3; i += 1){
                for (int j = 0; j < 3; j += 1){
                    if (k == 0){
                        System.out.print(("\u001B[3" + (7-j1.tab[i][j]) + "m") + j1.tab[i][j] + " " + ANSI_RESET);
                    } else if (k == 1){
                        System.out.print(("\u001B[3" + (7-j2.tab[i][j]) + "m") + j2.tab[i][j] + " " + ANSI_RESET);
                    }
                }
                if (k == 0 && i == 0){
                    System.out.println(" " + j1.nom + " (" + j1.score + ")");
                } else if (k == 1 && i == 2){
                    System.out.println(" " + j2.nom + " (" + j2.score + ")");
                } else {
                    System.out.println();
                }
            }
            System.out.println();
        }
        for (int i = 0; i < 3; i += 1){
            System.out.print(j2.colonnes[i] + " ");
        }
        System.out.println("\n");
    }

    public static boolean colonnePleine(boolean joueur, Joueur j1, Joueur j2, int col){
        boolean verif = true;
        if (joueur){
            for (int i = 0; i < 3; i += 1){
                if (j1.tab[i][col] == 0){
                    verif = false;
                }
            }
        } else {
            for (int i = 0; i < 3; i += 1){
                if (j2.tab[i][col] == 0){
                    verif = false;
                }
            }
        }
        return verif;
    }

    public static boolean colonnePleine(Joueur j, int col){
        boolean verif = true;
        for (int i = 0; i < 3; i += 1){
            if (j.tab[i][col] == 0){
                verif = false;
            }
        }
        return verif;
    }

    public static boolean finPartie(Joueur j1, Joueur j2){
        int cpt1 = 0;
        int cpt2 = 0;
        for (int i = 0; i < 3; i += 1){
            if (colonnePleine(j1, i)){
                cpt1 += 1;
            }
            if (colonnePleine(j2, i)){
                cpt2 += 1;
            }
        }
        return cpt1 == 3 || cpt2 == 3;
    }

    public static void placerDe(boolean joueur, Joueur j1, Joueur j2, int de){
        int col = 0;
        boolean verif = true;
        //Sélection de la colonne
        System.out.print("Choisissez une colonne ");
        while (verif){
            System.out.print("> ");
            col = sc.nextInt() - 1;
            if ((col >= 0 && col <= 2) && (!colonnePleine(joueur, j1, j2, col))){
                verif = false;
            }
        }
        int cpt;
        if (!joueur){
            //Joueur 2 place son dé
            cpt = 0;
            while (!verif){
                if (j2.tab[cpt][col] != 0){
                    cpt += 1;
                } else {
                    verif = true;
                }
            }
            j2.tab[cpt][col] = de;
            scoreColonne(j2, col);
        } else {
            //Joueur 1 place son dé
            cpt = 2;
            while (!verif){
                if (j1.tab[cpt][col] != 0){
                    cpt -= 1;
                } else {
                    verif = true;
                }
            }
            j1.tab[cpt][col] = de;
            scoreColonne(j1, col);
        }
        casserDe(joueur, j1, j2, de, col);
    }

    public static void casserDe(boolean joueur, Joueur j1, Joueur j2, int de, int col){
        if (!joueur){
            //Joueur 2 casse un dé à Joueur 1
            for (int i = 0; i < 3; i += 1){
                if (j1.tab[i][col] == de){
                    j1.tab[i][col] = 0;
                }
            }
            for (int i = 0; i < 2; i += 1){
                for (int j = 0; j < 2; j += 1){
                    if (j1.tab[j+1][col] == 0){
                        j1.tab[j+1][col] = j1.tab[j][col];
                        j1.tab[j][col] = 0;
                    }
                }
            }
            scoreColonne(j1, col);
        } else {
            //Joueur 1 casse un dé à Joueur 2
	        for (int i = 0; i < 3; i += 1){
                if (j2.tab[i][col] == de){
                    j2.tab[i][col] = 0;
                }
            }
            for (int i = 0; i < 2; i += 1){
                for (int j = 2; j > 0; j -= 1){
                    if (j2.tab[j-1][col] == 0){
                        j2.tab[j-1][col] = j2.tab[j][col];
                        j2.tab[j][col] = 0;
                    }
                }
            }
            scoreColonne(j2, col);
        }
    }

    public static void scoreColonne(Joueur j, int col){
        int[] nb = new int[]{0, 0, 0, 0, 0, 0};
        j.colonnes[col] = 0;
        for (int i = 0; i < 3; i += 1){
            if (j.tab[i][col] != 0){
                nb[j.tab[i][col]-1] += 1;
            }
        }
        for (int i = 0; i < nb.length; i += 1){
            if (nb[i] >= 1 && nb[i] <= 3){
                j.colonnes[col] += (i+1) * nb[i] * nb[i];
            }
        }
    }

    public static void calculerScore(Joueur j1, Joueur j2){
        j1.score = j1.colonnes[0] + j1.colonnes[1] + j1.colonnes[2];
        j2.score = j2.colonnes[0] + j2.colonnes[1] + j2.colonnes[2];
    }

    public static void gagnant(Joueur j1, Joueur j2){
        if (j1.score > j2.score){
            System.out.println(j1.nom + " a gagné");
        } else if (j1.score < j2.score){
            System.out.println(j2.nom + " a gagné");
        } else {
            System.out.println("Égalité");
        }
    }
    public static void main(String[] args) {
        System.out.print("Bienvenue au Knucklebones!\nSouhaitez-vous connaitre les règles? (y/n) > ");
        char rep = sc.next().charAt(0);
        if (rep == 'y' || rep == 'Y'){
            regles();
        }
        //--- Données joueurs ---
        System.out.print("Comment s'appelle le joueur 1? > ");
        Joueur j1 = new Joueur(sc.next());
        System.out.print("Comment s'appelle le joueur 2? > ");
        Joueur j2 = new Joueur(sc.next());
        //------
        boolean fin = false;
        boolean joueur = true;
        int de;
        while (!fin){
            afficherPlateaux(j1, j2);
            de = lancerDe();
            if (joueur){
                System.out.println(j1.nom + " a fait un " + ("\u001B[3" + (7-de) + "m") + de + ANSI_RESET);
                placerDe(joueur, j1, j2, de);
                calculerScore(j1, j2);
                joueur = false;
            } else {
                System.out.println(j2.nom + " a fait un " + ("\u001B[3" + (7-de) + "m") + de + ANSI_RESET);
                placerDe(joueur, j1, j2, de);
                calculerScore(j1, j2);
                joueur = true;
            }
            fin = finPartie(j1, j2);
        }
        afficherPlateaux(j1, j2);
        gagnant(j1, j2);
    }
}
