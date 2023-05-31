import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class Hub{
    private static Scanner sc = new Scanner(System.in);
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    //private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    //private static final String PURPLE = "\u001B[35m";
    //private static final String CYAN = "\u001B[36m";

    private static void write(String path, String str){
        try{
            str = System.getProperty("user.name") + ": " + str;
            File file = new File(path);
            Scanner scFile = new Scanner(file);
            str = scFile.next();
            str += scFile.nextLine();
            /*while (scFile.hasNextLine()){
                str = scFile.next() + "\n" + str;
            }*/
            scFile.close();
            FileWriter fileW = new FileWriter(path);
            fileW.write(str);
            fileW.close();
        } catch (IOException  e){
            System.out.println("Erreur");
            e.printStackTrace();
        }
    }

    private static void see(String path){
        try {
            File file = new File(path);
            Scanner scFile = new Scanner(file);
            while (scFile.hasNextLine()){
                System.out.println(scFile.nextLine());
            }
            scFile.close();
        } catch (IOException e){
            System.out.println("Erreur");
            e.printStackTrace();
        }
    }
    
    public static char retour(){
        char c = '#';
        //System.out.println(BLUE + "\nActions du hub:\n- H|h: Hub\n- R|r: Recommencer\n- 0: Quitter" + RESET);
        System.out.println(BLUE + "\nActions du hub:\n- H|h: Hub\n- 0: Quitter" + RESET);
        while (c != '0' && c != 'h' && c != 'H'){
            System.out.print("> ");
            c = sc.next().charAt(0);
        }
        return c;
    }

    public static void main(String[] args){
        char choix = 'h';
        String temp;
        while (choix != '0'){
            if (choix == 'h' || choix == 'H'){
                System.out.println(BLUE + "----- Hub -----" + RESET);
                System.out.println("[1] Démineur");
                System.out.println("[2] Knucklebones");
                System.out.println("[3] " + RED + "Puissance 4" + RESET);
                System.out.println("[4] " + RED + "2048" + RESET);
                if ((!System.getProperty("user.name").equals("maxime.blot.etu")) || (args.length != 0 && args[0] != "debug")){
                    System.out.println("[/] " + GREEN + "Proposer une idée de jeu" + RESET);
                } else {
                    System.out.println("[/] " + GREEN + "Voir idées" + RESET);
                }
                System.out.println("[.] " + GREEN + "Voir le Changelog" + RESET);
                System.out.println("[0] Quitter");
                System.out.println(BLUE + "---------------" + RESET);
            }
            while (choix < '.' || choix > '4'){
                System.out.print("> ");
                temp = sc.next();
                if (temp.length() == 1){
                    choix = temp.charAt(0);
                } else {
                    choix = '#';
                }
            } if (choix == '/'){
                if ((!System.getProperty("user.name").equals("maxime.blot.etu")) || (args.length != 0 && args[0] != "debug")){
                    System.out.print("Idée de jeu à proposer: ");
                    String idee = sc.next();
                    write("/home/infoetu/maxime.blot.etu/dev/JeuxNuls/Hub/.users_idea", idee);
                    System.out.println("Merci! Ton idée sera prise en compte et sera (probablement) développée plus tard");
                } else {
                    see("/home/infoetu/maxime.blot.etu/dev/JeuxNuls/Hub/.users_idea");
                }
                choix = 'h';
            } else if (choix == '.'){
                see("/home/infoetu/maxime.blot.etu/dev/JeuxNuls/changelog");
                choix = 'h';
            } else if (choix == '1'){
                Demineur.main(null);
                choix = retour();
            } else if (choix == '2'){
                Knucklebones.main(null);
                choix = retour();
            } else if (choix == '3'){
                //Puissance4.main(null);
                System.out.println("Puissance 4 en cours de construction");
                choix = '#';
            } else if (choix == '4'){
                //DZQH.main(null);
                System.out.println("2048 en cours de construction");
                choix = '#';
            }
        }
    }
}