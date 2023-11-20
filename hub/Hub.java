package hub;

import jeux.*;
import util.Color;
import util.Terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public abstract class Hub{
    private static Scanner sc = new Scanner(System.in);

    private static void write(String path, String str){
        try{
            str = System.getProperty("user.name") + ": " + str;
            File file = new File(path);
            Scanner scFile = new Scanner(file);
            while (scFile.hasNextLine()){
                str = scFile.nextLine() + "\n" + str;
            }
            scFile.close();
            FileWriter fileW = new FileWriter(path);
            fileW.write(str);
            fileW.close();
        } catch (IOException  e){
            Terminal.error(e, "Le fichier n'a pas pu être ouvert");
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
            Terminal.error(e, "Le fichier n'a pas pu être ouvert");
        }
    }

    public static char jouer(Class<?> cls){
        char c = 'r';
        while (c == 'r'){
            c = '#';
            try {
                cls.getDeclaredConstructor(new Class[0]).newInstance();
            } catch (InstantiationException e) {
                Terminal.error(e, "Erreur d'instanciation");
            } catch (IllegalAccessException e) {
                Terminal.error(e, "Impossible d'instancier la classe ciblée");
            } catch (NoSuchMethodException e) {
                Terminal.error(e, "La classe ciblée ne possède pas cette méthode");
            } catch (InvocationTargetException e) {
                Terminal.error(e, "Erreur de ciblage d'invocation de classe");
            } catch (Exception e) {
                Terminal.error(e, "Erreur inconnue");
            }
            System.out.println(Color.color("\nActions du hub:\n- H|h: Hub\n- R|r: Recommencer\n- 0: Quitter", Color.BLUE));
            while (!(c == '0' || c == 'h' || c == 'r')){
                System.out.print("> ");
                c = sc.next().toLowerCase().charAt(0);
            }
        }
        return c;
    }

    private static void printHub(List<String> arguments, boolean idea){
        System.out.println(Color.color("----- Hub -----", Color.BLUE));
        System.out.println("[1] Démineur");
        System.out.println("[2] Knucklebones");
        System.out.println("[3] " + Color.color("Puissance 4" + Color.RESET, Color.RED));
        System.out.println("[4] " + Color.color("2048" + Color.RESET, Color.RED));
        if (arguments.contains("noJavaFx")){
            System.out.println("[5] " + Color.color("Question pour un Carton", Color.RED));
            System.out.println("[6] " + Color.color("Jeu de la Vie", Color.RED));
        } else {
            System.out.println("[5] Question pour un Carton");
            System.out.println("[6] Jeu de la Vie");
        }
        if (idea){
            System.out.println("[/] " + Color.color("Voir idées", Color.GREEN));
        } else {
            System.out.println("[/] " + Color.color("Proposer une idée de jeu", Color.GREEN));
        }
        System.out.println("[0] Quitter");
        System.out.println(Color.BLUE + "---------------" + Color.RESET);
    }

    public static void main(String[] args){
        List<String> arguments = Arrays.asList(args);
        boolean idea = (System.getProperty("user.name").equals("maxime.blot.etu") || System.getProperty("user.name").equals("blotm")) && (args.length != 0 && args[0].equals("idea"));
        char choix = 'h';
        Terminal.clearScreen();
        while (choix != '0'){
            printHub(arguments, idea);
            while (choix < '/' || choix > '6'){
                System.out.print("> ");
                choix = sc.next().toLowerCase().charAt(0);
            } if (choix == '/'){
                if (idea){
                    Terminal.clearScreen();
                    see("./hub/.users_idea");
                } else {
                    System.out.print("Idée de jeu à proposer: ");
                    String idee = sc.next();
                    write("./hub/.users_idea", idee);
                    Terminal.clearScreen();
                    System.out.println("Merci! Ton idée sera prise en compte et sera (probablement) développée plus tard");
                }
                choix = 'h';
            } else if (choix == '1'){
                choix = jouer(Demineur.class);
            } else if (choix == '2'){
                choix = jouer(Knucklebones.class);
            } else if (choix == '3'){
                //choix = jouer(Puissance4.class);
                Terminal.clearScreen();
                System.out.println("Puissance 4 en cours de construction");
                choix = '#';
            } else if (choix == '4'){
                //choix = jouer(DZQH.class);
                Terminal.clearScreen();
                System.out.println("2048 en cours de construction");
                choix = '#';
            } else if (choix == '5'){
                if (arguments.contains("noJavaFx")){
                    System.out.println(Color.color("Javafx est nécessaire pour jouer à Question pour un Carton", Color.RED));
                    choix = '#';
                } else {
                    //choix = jouer(QuestionPourUnCarton.class);
                    Terminal.clearScreen();
                    System.out.println("Question pour un Carton en cours de construction");
                    choix = '#';
                }
            } else if (choix == '6'){
                if (arguments.contains("noJavaFx")){
                    System.out.println(Color.color("Javafx est nécessaire pour jouer au Jeu de la Vie", Color.RED));
                    choix = '#';
                } else {
                    choix = jouer(GameOfLife.class);
                }
            }
        }
    }
}
