package jeux;

import java.util.Random;
import java.util.Scanner;

import util.Color;

public class Demineur{
    private static final Scanner sc = new Scanner(System.in);

    public Demineur(){
        main(null);
    }





    //---- Classe Plateau ----
    private static class Plateau{
        private int largeur;
        private int longueur;
        private int proba;
        private int[][] mines;
        private boolean[][] trouve;

        Plateau(int largeur, int longueur, int proba){
            this.largeur = largeur;
            this.longueur = longueur;
            this.proba = proba;
            this.mines = new int[largeur][longueur];
            this.trouve = new boolean[largeur][longueur];

            this.placerMines();
            this.calculerProxi();
        }

        public boolean[][] getTrouve(){
            return trouve;
        }

        private void placerMines(){
            Random rand = new Random();
            for (int i = 0; i < largeur; i += 1){
                for (int j = 0; j < longueur; j += 1){
                    if (rand.nextInt(100) <= proba){
                        mines[i][j] = -1;
                    }
                    trouve[i][j] = false;
                }
            }
        }

        private void calculerProxi(){
            for (int i = 0; i < largeur; i += 1){
                for (int j = 0; j < longueur; j += 1){
                    if (mines[i][j] != -1){
                        for (int k = -1; k < 2; k += 1){
                            for (int l = -1; l < 2; l += 1){
                                if ((i+k >= 0 && i+k <= largeur-1 && j+l >= 0 && j+l <= longueur-1) && (mines[i+k][j+l] == -1)){
                                    mines[i][j] += 1;
                                }
                            }
                        }
                    }
                }
            }
        }

        public String stringTab(){
            String str = "   ";
            for (int i = 0; i < longueur; i += 1){
                if (i < 9){
                    str += i + 1 + " ";
                } else {
                    str += i + 1 + "";
                }
            }
            str += "\n\n";
            for (int i = 0; i < largeur; i += 1){
                if (i < 9){
                    str += i + 1 + "  ";
                } else {
                    str += i + 1 + " ";
                }
                for (int j = 0; j < longueur; j += 1){
                    if (trouve[i][j]){
                        if (mines[i][j] > 0){
                            str += Color.GREEN + "" + mines[i][j] + " " + Color.RESET;
                        } else if (mines[i][j] == 0){
                            str += Color.WHITE + "" + mines[i][j] + " " + Color.RESET;
                        } else {
                            str += Color.RED + "@ " + Color.RESET;
                        }
                    } else {
                        str += Color.CYAN + "# " + Color.RESET;
                    }
                }
                str += "\n";
            }
            return str;
        }

        public boolean estBombe(int x, int y){
            return (mines[x][y] == -1);
        }

        public void devoilerMines(int x, int y){
            for (int i = 0; i < x; i += 1){
                for (int j = 0; j < y; j += 1){
                    if (mines[i][j] == -1){
                        trouve[i][j] = true;
                    }
                }
            }
        }

        public void voisinVide(int x, int y, int[] coo, int fonct){
            if (mines[coo[0]][coo[1]] == 0 && trouve[coo[0]][coo[1]] != true){
                trouve[coo[0]][coo[1]] = true;
                if (fonct != 1){
                    if (coo[0] < x-1){
                        voisinVide(x, y, new int[]{coo[0]+1, coo[1]}, -1);
                    }
                }
                if (fonct != -1){
                    if (coo[0] > 0){
                        voisinVide(x, y, new int[]{coo[0]-1, coo[1]}, 1);
                    }
                }
                if (fonct != 2){
                    if (coo[1] < y-1){
                        voisinVide(x, y, new int[]{coo[0], coo[1]+1}, -2);
                    }
                }
                if (fonct != -2){
                    if (coo[1] > 0){
                        voisinVide(x, y, new int[]{coo[0], coo[1]-1}, 2);
                    }
                }
            } else if (mines[coo[0]][coo[1]] > 0 && trouve[coo[0]][coo[1]] != true){
                trouve[coo[0]][coo[1]] = true;
            }
        }

        public boolean finPartie(int x, int y){
            int verif = 0;
            for (int i = 0; i < x; i += 1){
                for (int j = 0; j < y; j += 1){
                    if ((mines[i][j] != -1 && trouve[i][j] == true) || (mines[i][j] == -1 && trouve[i][j] == false)){
                        verif += 1;
                    }
                }
            }
            return (verif+1 == x * y);
        }
    }
    //------------------------




    
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
        Plateau p = new Plateau(largeur, longueur, proba);
        boolean fin = false;
        boolean bombe = false;
        boolean verif = false;
        boolean verifAlt = false;
        int[] coo = new int[2];
        while (!fin && !bombe){
            System.out.println(p.stringTab());
            while (!verifAlt){
                System.out.print("Choisissez une ligne ");
                while (!verif){
                    System.out.print("> ");
                    coo[0] = sc.nextInt()-1;
                    verif = ((coo[0] >= 0 && coo[0] < largeur));
                    if (!verif){
                        System.out.print(Color.RED + "Hors limite " + Color.RESET);
                    }
                }
                verif = false;
                System.out.print("Choisissez une colonne ");
                while (!verif){
                    System.out.print("> ");
                    coo[1] = sc.nextInt()-1;
                    verif = ((coo[1] >= 0 && coo[1] < longueur));
                    if (!verif){
                        System.out.print(Color.RED + "Hors limite " + Color.RESET);
                    }
                }
                verif = false;
                verifAlt = !p.getTrouve()[coo[0]][coo[1]];
                if (!verifAlt){
                    System.out.println(Color.RED + "Case déjà vérifiée" + Color.RESET);
                }
            }
            verifAlt = false;
            bombe = p.estBombe(coo[0], coo[1]);
            fin = p.finPartie(largeur, longueur);
            if (!bombe){
                p.voisinVide(largeur, longueur, coo, 0);
            } else {
                p.getTrouve()[coo[0]][coo[1]] = true;
            }
        }
        System.out.println(p.stringTab());
        if (bombe){
            System.out.println(Color.RED + "BOOM!" + Color.RESET);
            System.out.print("Souhaitez vous voir l'emplacement de toute les mines? (y/n) > ");
            rep = sc.next().charAt(0);
            if (rep == 'y' || rep == 'Y'){
                p.devoilerMines(largeur, longueur);
                System.out.println(p.stringTab());
            }
        } else if (fin){
            System.out.println(Color.GREEN + "Félicitation!" + Color.RESET);
        }
    }
}
