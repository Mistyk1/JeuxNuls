import java.util.Random;
import java.util.Scanner;

public class Demineur{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private static final Scanner sc = new Scanner(System.in);

    public static void regles(){
        System.out.println("--- Règles ---");
        System.out.println("Vous disposez d'un plateau contenant des mines cachées");
        System.out.println("A chaque tour, vous pouvez révéler le contenu d'une case en entrant ses coordonnées");
        System.out.println("Si vous révélez une case vide, toute les cases vides connectées seront révélés");
        System.out.println("Les cases indiquent le nombre de mine(s) à proximité");
        System.out.println("Révéler une mine vous fait perdre, révéler toute les cases vide vous fait gagner");
        System.out.println("--------------");
        System.out.println("(Entrez une touche pour continuer)");
        sc.next();
    }

    public static PlateauDem newPlateau(int largeur, int longueur, int proba){
        PlateauDem p = new PlateauDem(largeur, longueur);
        placerMines(p, largeur, longueur, proba);
        calculerProxi(p, largeur, longueur);
        return p;
    }

    public static void placerMines(PlateauDem p, int largeur, int longueur, int proba){
        Random rand = new Random();
        for (int i = 0; i < largeur; i += 1){
            for (int j = 0; j < longueur; j += 1){
                if (rand.nextInt(100) <= proba){
                    p.mines[i][j] = -1;
                }
                p.trouve[i][j] = false;
            }
        }
    }

    public static void calculerProxi(PlateauDem p, int largeur, int longueur){
        for (int i = 0; i < largeur; i += 1){
            for (int j = 0; j < longueur; j += 1){
                if (p.mines[i][j] != -1){
                    for (int k = -1; k < 2; k += 1){
                        for (int l = -1; l < 2; l += 1){
                            if ((i+k >= 0 && i+k <= largeur-1 && j+l >= 0 && j+l <= longueur-1) && (p.mines[i+k][j+l] == -1)){
                                p.mines[i][j] += 1;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void printTab(PlateauDem p){
        System.out.print("   ");
        for (int i = 0; i < p.mines[0].length; i += 1){
            if (i < 9){
                System.out.print(i + 1 + " ");
            } else {
                System.out.print(i + 1 + "");
            }
        }
        System.out.println("\n");
        for (int i = 0; i < p.mines.length; i += 1){
            if (i < 9){
                System.out.print(i + 1 + "  ");
            } else {
                System.out.print(i + 1 + " ");
            }
            for (int j = 0; j < p.mines[0].length; j += 1){
                if (p.trouve[i][j]){
                    if (p.mines[i][j] > 0){
                        System.out.print(ANSI_GREEN + p.mines[i][j] + " " + ANSI_RESET);
                    } else if (p.mines[i][j] == 0){
                        System.out.print(ANSI_WHITE + p.mines[i][j] + " " + ANSI_RESET);
                    } else {
                        System.out.print(ANSI_RED + "@ " + ANSI_RESET);
                    }
                } else {
                    System.out.print(ANSI_CYAN + "# " + ANSI_RESET);
                }
            }
            System.out.println();
        }
    }

    public static boolean estBombe(PlateauDem p, int largeur, int longueur){
        return (p.mines[largeur][longueur] == -1);
    }

    public static void devoilerMines(PlateauDem p, int largeur, int longueur){
        for (int i = 0; i < largeur; i += 1){
            for (int j = 0; j < longueur; j += 1){
                if (p.mines[i][j] == -1){
                    p.trouve[i][j] = true;
                }
            }
        }
    }

    public static void voisinVide(PlateauDem p, int largeur, int longueur, int[] coo, int fonct){
        if (p.mines[coo[0]][coo[1]] == 0 && p.trouve[coo[0]][coo[1]] != true){
            p.trouve[coo[0]][coo[1]] = true;
            if (fonct != 1){
                if (coo[0] < largeur-1){
                    voisinVide(p, largeur, longueur, new int[]{coo[0]+1, coo[1]}, -1);
                }
            }
            if (fonct != -1){
                if (coo[0] > 0){
                    voisinVide(p, largeur, longueur, new int[]{coo[0]-1, coo[1]}, 1);
                }
            }
            if (fonct != 2){
                if (coo[1] < longueur-1){
                    voisinVide(p, largeur, longueur, new int[]{coo[0], coo[1]+1}, -2);
                }
            }
            if (fonct != -2){
                if (coo[1] > 0){
                    voisinVide(p, largeur, longueur, new int[]{coo[0], coo[1]-1}, 2);
                }
            }
        } else if (p.mines[coo[0]][coo[1]] > 0 && p.trouve[coo[0]][coo[1]] != true){
            p.trouve[coo[0]][coo[1]] = true;
        }
    }

    public static boolean finPartie(PlateauDem p, int largeur, int longueur){
        int verif = 0;
        for (int i = 0; i < largeur; i += 1){
            for (int j = 0; j < longueur; j += 1){
                if ((p.mines[i][j] != -1 && p.trouve[i][j] == true) || (p.mines[i][j] == -1 && p.trouve[i][j] == false)){
                    verif += 1;
                }
            }
        }
        return (verif+1 == largeur * longueur);
    }

    public static void main(String[] args){
        System.out.print("Bienvenue au Démineur!\nSouhaitez-vous connaitre les règles? (y/n) > ");
        char rep = sc.next().charAt(0);
        if (rep == 'y' || rep == 'Y'){
            regles();
        }
        int largeur = 0;
        int longueur = 0;
        int proba = 0;
        System.out.print("Saisissez la largeur du plateau (Entre 5 et 50) ");
        while (!(largeur >= 5 && largeur <= 50)){
            System.out.print("> ");
            largeur = sc.nextInt();
        }
        System.out.print("Saisissez la longueur du plateau (Entre 5 et 50) ");
        while (!(longueur >= 5 && longueur <= 50)){
            System.out.print("> ");
            longueur = sc.nextInt();
        }
        System.out.print("Saisissez la probabilité d'une mine sur une case (Entre 10 et 50) ");
        while (!(proba >= 10 && proba <= 50)){
            System.out.print("> ");
            proba = sc.nextInt();
        }
        PlateauDem p = newPlateau(largeur, longueur, proba);
        boolean fin = false;
        boolean bombe = false;
        boolean verif = false;
        boolean verifAlt = false;
        int[] coo = new int[2];
        while (!fin && !bombe){
            printTab(p);
            while (!verifAlt){
                System.out.print("Choisissez une ligne ");
                while (!verif){
                    System.out.print("> ");
                    coo[0] = sc.nextInt()-1;
                    verif = ((coo[0] >= 0 && coo[0] < largeur));
                    if (!verif){
                        System.out.print(ANSI_RED + "Hors limite " + ANSI_RESET);
                    }
                }
                verif = false;
                System.out.print("Choisissez une colonne ");
                while (!verif){
                    System.out.print("> ");
                    coo[1] = sc.nextInt()-1;
                    verif = ((coo[1] >= 0 && coo[1] < longueur));
                    if (!verif){
                        System.out.print(ANSI_RED + "Hors limite " + ANSI_RESET);
                    }
                }
                verif = false;
                verifAlt = !p.trouve[coo[0]][coo[1]];
                if (!verifAlt){
                    System.out.println(ANSI_RED + "Case déjà vérifiée" + ANSI_RESET);
                }
            }
            verifAlt = false;
            bombe = estBombe(p, coo[0], coo[1]);
            fin = finPartie(p, largeur, longueur);
            if (!bombe){
                voisinVide(p, largeur, longueur, coo, 0);
            } else {
                p.trouve[coo[0]][coo[1]] = true;
            }
        }
        printTab(p);
        if (bombe){
            System.out.println(ANSI_RED + "BOOM!" + ANSI_RESET);
            System.out.print("Souhaitez vous voir l'emplacement de toute les mines? (y/n) > ");
            rep = sc.next().charAt(0);
            if (rep == 'y' || rep == 'Y'){
                devoilerMines(p, largeur, longueur);
                printTab(p);
            }
        } else if (fin){
            System.out.println(ANSI_GREEN + "Félicitation!" + ANSI_RESET);
        }
    }
}
