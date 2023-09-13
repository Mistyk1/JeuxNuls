package hub;

import jeux.*;
import util.Color;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Hub{
    private static Scanner sc = new Scanner(System.in);

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
            error(e, "Le fichier n'a pas pu être ouvert");
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
            error(e, "Le fichier n'a pas pu être ouvert");
        }
    }

    private static void error(Exception e, String msg){
        System.out.println(Color.RED + msg + Color.YELLOW);
        e.printStackTrace();
        System.out.print(Color.RESET);
    }

    public static char jouer(Class<?> cls){
        char c = '#';
        while (c == '#'){
            try {
                cls.getDeclaredConstructor(new Class[0]).newInstance();
            } catch (InstantiationException e) {
                error(e, "Erreur d'instanciation");
            } catch (IllegalAccessException e) {
                error(e, "Impossible d'instancier la classe ciblée");
            } catch (NoSuchMethodException e) {
                error(e, "La classe ciblée ne possède pas cette classe");
            } catch (InvocationTargetException e) {
                error(e, "Erreur de ciblage d'invocation de classe");
            }
            System.out.println(Color.BLUE + "\nActions du hub:\n- H|h: Hub\n- R|r: Recommencer\n- 0: Quitter" + Color.RESET);
            while (c != '0' && c != 'h' && c != 'H' && c != 'r' && c != 'R'){
                System.out.print("> ");
                c = sc.next().charAt(0);
            }
            if (c == 'r' || c == 'R'){ c = '#'; }
        }
        return c;
    }

    public static void main(String[] args){
        List<String> arguments = Arrays.asList(args);
        boolean idea = (System.getProperty("user.name").equals("maxime.blot.etu") || System.getProperty("user.name").equals("blotm")) && (args.length != 0 && args[0].equals("idea"));
        char choix = 'h';
        String temp;
        while (choix != '0'){
            if (choix == 'h' || choix == 'H'){
                System.out.println(Color.BLUE + "----- Hub -----" + Color.RESET);
                System.out.println("[1] Démineur");
                System.out.println("[2] Knucklebones");
                System.out.println("[3] " + Color.RED + "Puissance 4" + Color.RESET);
                System.out.println("[4] " + Color.RED + "2048" + Color.RESET);
                System.out.println("[5] " + Color.RED + "Tetros" + Color.RESET);
                if (arguments.contains("noJavaFx")){
                    System.out.println("[6] " + Color.RED + "Question pour un Carton" + Color.RESET);
                } else {
                    System.out.println("[6] Question pour un Carton");
                }
                if (idea){
                    System.out.println("[/] " + Color.GREEN + "Voir idées" + Color.RESET);
                } else {
                    System.out.println("[/] " + Color.GREEN + "Proposer une idée de jeu" + Color.RESET);
                }
                System.out.println("[0] Quitter");
                System.out.println(Color.BLUE + "---------------" + Color.RESET);
            }
            while (choix < '/' || choix > '6'){
                System.out.print("> ");
                temp = sc.next();
                if (temp.length() == 1){
                    choix = temp.charAt(0);
                } else {
                    choix = '#';
                }
            } if (choix == '/'){
                if (idea){
                    see("./.users_idea");
                } else {
                    System.out.print("Idée de jeu à proposer: ");
                    String idee = sc.next();
                    write("./.users_idea", idee);
                    System.out.println("Merci! Ton idée sera prise en compte et sera (probablement) développée plus tard");
                }
                choix = 'h';
            } else if (choix == '1'){
                choix = jouer(Demineur.class);
            } else if (choix == '2'){
                choix = jouer(Knucklebones.class);
            } else if (choix == '3'){
                //choix = jouer(Puissance4.class);
                System.out.println("Puissance 4 en cours de construction");
                choix = '#';
            } else if (choix == '4'){
                //choix = jouer(DZQH.class);
                System.out.println("2048 en cours de construction");
                choix = '#';
            } else if (choix == '5'){
                //choix = jouer(Tetros.class);
                System.out.println("Tetros en cours de construction");
                choix = '#';
            } else if (choix == '6'){
                if (arguments.contains("noJavaFx")){
                    System.out.println(Color.RED + "Javafx est nécessaire pour jouer à Question pour un Carton" + Color.RESET);
                    choix = '#';
                } else {
                    //choix = jouer(QuestionPourUnCarton.class);
                    System.out.println("Question pour un Carton en cours de construction");
                    choix = '#';
                }
            }
        }
    }
}