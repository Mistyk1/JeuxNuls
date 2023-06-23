package Puissance4;
import java.util.Scanner;

public class Puissance4{
    private static final Scanner sc = new Scanner(System.in);

    Puissance4(){
        Puissance4.main(null);
    }
    
    public static void regles(){
        System.out.println("--- Règles ---");
        System.out.println("[Insérer règles]");
        System.out.println("--------------");
        System.out.println("(Entrez une touche pour continuer)");
        sc.next();
    }

    public static void afficherPlateau(Plateau4 p){
        int caseP;
        for (int i = 0; i < 6; i += 1){
            for (int j = 0; j < 7; j += 1){
                caseP = p.cases[i][j];
                if (caseP == 0){
                    //print(" . ");
                    System.out.print(" " + caseP + " ");
                } else if (caseP == 1){
                    //print("\033[0;31m" + " O " + "\033[0m");
                    System.out.print("\033[0;31m" + " " + caseP + " " + "\033[0m");
                } else if (caseP == 2){
                    //print("\033[0;33m" + " O " + "\033[0m");
                    System.out.print("\033[0;33m" + " " + caseP + " " + "\033[0m");
                } else if (caseP == 3){
                    //print("\033[0;32m" + " O " + "\033[0m");
                    System.out.print("\033[0;32m" + " " + caseP + " " + "\033[0m");
                }
            }
            System.out.println();
        }
    }

    public static void afficherPlateau(Plateau4 p, String j1, String j2){
        System.out.println();
        System.out.print("Tour de ");
        if (p.tour){
            System.out.println(j1 + "\n");
        } else {
            System.out.println(j2 + "\n");
        }
        afficherPlateau(p);
    }

    public static void placerPion(Plateau4 p){
        boolean verif = false;
        int col = 0;
        System.out.print("Choisissez une colonne ");
        while (!verif){
            System.out.print("> ");
            col = sc.nextInt() - 1;
            verif = (col >= 0 && col <= 6 && !colonnePleine(p, col));
        }
        verif = false;
        int cpt = 5;
        while (!verif){
            if (p.cases[cpt][col] == 0){
                verif = true;
            } else {
                cpt -= 1;
            }
        }
        if (p.tour){
            p.cases[cpt][col] = 1;
        } else {
            p.cases[cpt][col] = 2;
        }
    }

    public static boolean colonnePleine(Plateau4 p, int col){
        int plein = 0;
        for (int i = 0; i < 6; i += 1){
            if (p.cases[i][col] != 0){
                plein += 1;
            }
        }
        return plein == 6;
    }

    public static boolean plateauPlein(Plateau4 p){
        int verif = 0;
        for (int i = 0; i < 7; i += 1){
            if (colonnePleine(p, i)){
                verif += 1;
            }
        }
        return verif == 7;
    }

    public static boolean puissance4(Plateau4 p){
        boolean verif = false;
        int cpti = 0;
        int cptj;
        while (!verif && cpti < 6){
            cptj = 0;
            while (!verif && cptj < 7){
                if (!verif && cpti < 3 && p.cases[cpti][cptj] != 0){ //Détection vers le bas
                    for (int i = 0; i < 3; i += 1){
                        verif = (p.cases[cpti+i][cptj] == p.cases[cpti+i+1][cptj]) && !verif;
                    }
                    if (verif){
                        p.gagnant = p.cases[cpti][cptj];
                        for (int i = 0; i < 4; i += 1){
                            p.cases[cpti+i][cptj] = 3;
                        }
                    }
                }
                if (!verif && cptj < 5 && p.cases[cpti][cptj] != 0){ //Détection vers la droite
                    for (int j = 0; j < 3; j += 1){
                        verif = (p.cases[cpti][cptj+j] == p.cases[cpti][cptj+j+1]) && !verif;
                    }
                    if (verif){
                        p.gagnant = p.cases[cpti][cptj];
                        for (int j = 0; j < 4; j += 1){
                            p.cases[cptj][cptj+j] = 3;
                        }
                    }
                }
                /*if (!verif && cpti < 4 && p.cases[cpti][cptj] != 0){ //Détection vers le bas-gauche
                    verif = ((p.cases[cpti][cptj] == p.cases[cpti+1][cptj]) == (p.cases[cpti+2][cptj] == p.cases[cpti+3][cptj]));
                    if (verif){
                        p.gagnant = p.cases[cpti][cptj];
                        p.cases[cpti][cptj] = 3;
                        p.cases[cpti+1][cptj] = 3;
                        p.cases[cpti+2][cptj] = 3;
                        p.cases[cpti+3][cptj] = 3;
                    }
                }
                if (!verif && cpti < 4 && p.cases[cpti][cptj] != 0){ //Détection vers le bas-droite
                    verif = ((p.cases[cpti][cptj] == p.cases[cpti+1][cptj]) == (p.cases[cpti+2][cptj] == p.cases[cpti+3][cptj]));
                    if (verif){
                        p.gagnant = p.cases[cpti][cptj];
                        p.cases[cpti][cptj] = 3;
                        p.cases[cpti+1][cptj] = 3;
                        p.cases[cpti+2][cptj] = 3;
                        p.cases[cpti+3][cptj] = 3;
                    }
                }*/
                cptj += 1;
            }
            cpti += 1;
        }
        return verif;
    }

    public static void main(String[] args) {
        System.out.print("Bienvenue au Puissance 4!\nSouhaitez-vous connaitre les règles? (y/n) > ");
        char rep = sc.next().charAt(0);
        if (rep == 'y' || rep == 'Y'){
            regles();
        }
        System.out.print("Comment s'appelle le joueur 1? > ");
        String j1 = sc.next();
        System.out.print("Comment s'appelle le joueur 2? > ");
        String j2 = sc.next();
        Plateau4 p = new Plateau4();
        boolean fin = false;
        while (!fin){
            afficherPlateau(p, j1, j2);
            placerPion(p);
            p.tour = !p.tour;
            fin = plateauPlein(p) || puissance4(p);
        }
        System.out.println();
        afficherPlateau(p);
        System.out.println();
        if (p.gagnant == 0){
            System.out.println("Égalité!");
        } else if (p.gagnant == 1){
            System.out.println(j1 + " a fait un puissance 4!");
        } else if (p.gagnant == 2){
            System.out.println(j2 + " a fait un puissance 4!");
        }
    }
}
