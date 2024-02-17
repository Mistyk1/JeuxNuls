package fr.mistyk1.jeux.javafx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import fr.mistyk1.util.Color;
import fr.mistyk1.util.MultiThreading;
import fr.mistyk1.util.Terminal;
import fr.mistyk1.util.javafx.Window;

public class QuestionPourUnCarton {
    private static final Random rand = new Random();
    private static final Scanner sc = new Scanner(System.in, "UTF-8");
    private static final String presentateur = Color.color("présentateur", Color.YELLOW);
    private static final String PATH_TO_SOUNDS = "../../../../assets/questionPourUnCarton/";
    private static String nom;

    public QuestionPourUnCarton(){
        main(null);
    }





    //---- Énumération Question ----
    private static enum Question{
        PrenomPresentateur("Comment est ce que je m'appelle?", 
                  "Bernard", "Pr\u00E9sentateur", "Nicolas", "Gilgamesh le destructeur de réalités", "Je n'ai pas de pr\u00E9nom",
                  "Pr\\u00E9sentateur!", "C'est simple, pr\\u00E9sentateur.", "Pr\\u00E9sentateur?", "euuuuh bernard", "RÉPONSE N°3", "Je ne sais pas?", "ooga", "Gilgamesh le destructeur de r\u00E9alit\u00E9s",
                  "Bernard!", "Pr\\u00E9sentateur!", "Nicolas!", "Gilgamesh le destructeur de r\u00E9alit\u00E9s!", "Vous n'avez pas de pr\\u00E9nom!", 
                  "Il se trouve que je m'appelle bel et bien Présentateur! (merci papa et maman pour ce magnifique prénom)", 
                  "Il se trouve que je m'appelle bel et bien Présentateur! (merci papa et maman pour ce magnifique prénom)", 
                  "Il se trouve que je m'appelle bel et bien Présentateur! (merci papa et maman pour ce magnifique prénom)", 
                  "Il se trouve que je m'appelle bel et bien Présentateur! (merci papa et maman pour ce magnifique prénom)", 
                  "Il se trouve que je m'appelle bel et bien Présentateur! (merci papa et maman pour ce magnifique prénom)", 2),
        TroisPlusTrois("Combien font 3 + 3?", 
                  "6", "12", "-493,45", "Pr\u00E9sentateur", "Les mathématiques sont un mensonge",
                  "6", "12", "-493,45! Non non non attendez-", "euuuuuuuuuuh", Color.bold("*bruit forts de calculs*"), "6?", Color.bold("*est confus*"), "Pr\\u00E9sentateur",
                  "6", "12", "-493,45", "Pr\\u00E9sentateur", "Les math\u00E9matiques ne sont pas réelles et sont un concept imaginé par notre cerveau pour contextualiser et rationnaliser l'univers nous environant.", 
                  "Oui, c'est 6!", 
                  "12?", 
                  "-493,45?! Comment en êtes vous venu à ce résultat?!", 
                  "Quoi, mais... C'est la r\u00E9ponse \u00E0 la une autre question...", 
                  "Vous venez littéralement de répondre avec un nombre", 1),
        ComposantFer("Quel est le composant principal du fer?", 
                  "L'élément atomique n°26", "De la mystérieuse poudre blanche (de la farine)", "Votre m\u00E8re", "Le néant absolu", "N'importe quoi sauf du fer",
                  "Oulah...", "Mais aucune de ces réponses ne font sens!", "Du fer.", "eh ta daronne mdr", "ÉLÉMENT ATOMIQUE N°26", "Le néant", "Votre progénitrice.", "DE LA COCAÏNE" + Color.bold("*sniffe un maximum de drogues dures*"),
                  "L'\\u00E9l\\u00E9ment atomique n\\u00B026", "De la farine?", "Votre mère! >:D", "Rien.", "Absolument tout sauf du fer.", 
                  "Nicolas, c'est si dur à dire \"Élément atomique n°26\"?!", 
                  Color.bold("*le présentateur vous regarde suspicieusement*"), 
                  "Si vous continuez comme ça vous allez vite dégager.", 
                  "Comment ça rien?!", 
                  "Il n'y a pas de fer dans du fer? Est-ce que vous r\u00E9fl\u00E9chissez?", 1),
        Femme("Pourquoi ma femme m'a quitt\u00E9?", 
                  "Car je suis parti achet\u00E9 du lait", "Car je suis un mari extr\u00EAmement infid\u00E8le", "Car je ne fesais rien pour faire avancer le mariage", "Car j'ai jet\u00E9 le chat par la fen\u00EAtre", "Toute les r\u00E9ponses du dessus",
                  "...", "???", "Vous êtes infidèle?", "t'es juste un ▉▉▉▉▉▉ toi en fait", Color.bold("*de la fumée commence à sortir de V-43.7*"), "Vous...", "", "...",
                  "Vous êtes... parti acheter du lait?", "Vous \u00EAtes... infidèle?", "Vous \u00EAtes... un paresseux?", "Vous \u00EAtes... un homme extrêmement cruel?", "Vous \u00EAtes... la pire ordure n'ayant jamais existé?", 
                  "Personne n'a bon.", 
                  "Personne n'a bon.", 
                  "Personne n'a bon.", 
                  "Personne n'a bon.", 
                  "o)_o)'", 5),
        Cheval("Quelle est la couleur du cheval blanc d'Henry IV?", 
                  "Vert", "Blanc", "Marron-Rouge-Bleu", "Gris", "Transparent",
                  "Gris?", "Il doit forcément être blanc.", "Bah blanc", "euuuuuuu gri", Color.bold("*bruits incompréhensibles de robot*"), "Transparent!", "ooga ooga", "Vert.",
                  "Vert", "Blanc", "Marron-Rouge-Bleu", "Gris", "Transparent", 
                  "Il est radioactif ce cheval?", 
                  "Non :)", 
                  "C'est quel genre de couleur ça?", 
                  "Non, il n'y a pas de poussière sur le cheval.", 
                  "Il est vrai que j'aime bien faire des chevaux en verre lors de mes heures perdues...", 5),
        Oui("Oui?", 
                  "je sais pas haha", "stiti", "fi", "Oui", "Non",
                  "De quoi oui?", "Bien évidemment.", "Mais ce n'est même pas une question...", "tg", "TRUE", "-STITI HAHAHAHA CHUI TROP DROLE", "booga", "Non. Pas le moins du monde. Aucunement. Absolument pas. Que nenni. 0%. Jamais.",
                  "je euh je je euh je je je euh je euh euh", "-stiti haha :)", "-fi haha :)", "Oui.", "Non.", 
                  "-_-", 
                  ":|", 
                  ":|", 
                  ":)", 
                  "-bril", 4),
        Robot("Suis-je un robot?", 
                  "Probablement", "Oui", "Non", "Je ne sais pas", "Ananas",
                  "Oui?", "Machine?", "Vous? Un robot? C'est trop complexe à faire un robot de votre envergure.", "euuhh jsp", Color.bold("*émet des bruits étranges*"), "Un robot? Non?", "ooga booga", "Les robots n'existent pas.",
                  "Probablement je pense", "J'en suis sûr.", "Impossible.", "Alors là, bonne question", "Un ananas", 
                  "Comment ", 
                  "Vous êtes vraiment sûr?", 
                  "Ah, c'est probable.", 
                  "Je ne sais pas du tout si j'en suis un! :D", 
                  "mmmmh miam", 4),
        PommeMasseSoleil("Pierre a 6 pommes. Il en donne 2 à Quentin et 3 à Marc. Quelle est la masse du soleil?", 
                  "1,98892×10^30 kilogrammes", "1 pomme", "2,98468×10^29 kilogrammes", "1,98892×10^33 kilogrammes", "6 grammes",
                  "Euuuh...", "Pardon? Vous insinuez que la Terre tourne autour du soleil?", "1,98892×10^30 kilogrammes", "euuuuh chépa 6 grames?", "ERREUR DE CALCUL", "O_O", "ooga oog booga", "Pierre a 1 pomme.",
                  "1,98892×10^30 kilogrammes évidemment!", "Pierre a 1 pomme.", "2,98468×10^29 kilogrammes évidemment!", "1,98892×10^33 kilogrammes évidemment!", "6 grammes évidemment!", 
                  "Eeet " + nom + ", Nicolas et bumba ont raison!", 
                  "En effet Pierre a 1 pomme à la fin mais ce n'est pas la question posée.", 
                  "Eeet Nicolas et bumba ont raison!", 
                  "Eeet Nicolas et bumba ont raison!", 
                  "Vous vous rendez compte du danger dans lequel nous serions si le soleil fesait 6 grammes?!", 1),
        Truc5("#", 
                  "#", "#", "#", "#", "#",
                  "#", "#", "#", "#", "#", "#", "#", "#",
                  "#", "#", "#", "#", "#", 
                  "#", 
                  "#", 
                  "#", 
                  "#", 
                  "#", 5),
        Polynome("Nous savons tous que les polyn\u00F4mes de Tchebychev de seconde esp\u00E8ce sont d\u00E9finis par cette relation de r\u00E9currence:\n" + //
                "U[n+1] = 2XU[n] - U[n-1], Pour tout n >= 1 avec U[0] = 1 et U[1] = 2X\n" + //
                "Quel polyn\u00F4me de Tchebychev de seconde esp\u00E8ce correspond \u00E0 la 7\u00E8me occurence?", 
                  "U[7] = 16X\u2074-12X\u00B2+1", "U[7] = 128X\u2077-192X\u2075+80X\u00B3-8X", "U[7] = 64X\u2077-112X\u2075+56X\u00B3-7X", "U[7] = 256X\u2078-448X\u2076+240X\u2074-40X\u00B2+1", "Aucune des r\u00E9ponses du dessus",
                  "U[7] = 128X\u2077-192X\u2075+80X\u00B3-8X", "U[7] = 128X\u2077-192X\u2075+80X\u00B3-8X", "PARDON?????", "U[7] = 128X\u2077-192X\u2075+80X\u00B3-8X", "U[7] = 128X\u2077-192X\u2075+80X\u00B3-8X", "U[7] = 128X\u2077-192X\u2075+80X\u00B3-8X", "U[7] = 128X\u2077-192X\u2075+80X\u00B3-8X", "U[7] = 128X\u2077-192X\u2075+80X\u00B3-8X",
                  "U[7] = 16X\u2074-12X\u00B2+1", "U[7] = 128X\u2077-192X\u2075+80X\u00B3-8X", "U[7] = 64X\u2077-112X\u2075+56X\u00B3-7X", "U[7] = 256X\u2078-448X\u2076+240X\u2074-40X\u00B2+1", "Aucune de ces réponses ne sont bonnes", 
                  "Eeeet il se trouve que seul Albert et " + nom + " n'a pas trouvé la réponse, bien que ce soit une connaissance basique.", 
                  "Eeeet il se trouve que seul Albert n'a pas trouvé la réponse, bien que ce soit une connaissance basique.", 
                  "Eeeet il se trouve que seul Albert et " + nom + " n'a pas trouvé la réponse, bien que ce soit une connaissance basique.", 
                  "Eeeet il se trouve que seul Albert et " + nom + " n'a pas trouvé la réponse, bien que ce soit une connaissance basique.", 
                  "Eeeet il se trouve que seul Albert et " + nom + " n'a pas trouvé la réponse, bien que ce soit une connaissance basique.", 2);

        private String intitule;
        private String[] choix;
        private String[] reponses;
        private String[] reponsesJoueur;
        private String[] reponsesPresentateur;
        private int correct;
        private static String[] noms = new String[]{"Brigitte", "Gabriel", "Nicolas", "Jules", "V-43.7", "Mathéo", null, "bumba", "Albert"};

        private Question(String intitule,
                        String choix1, String choix2, String choix3, String choix4, String choix5,
                        String reponseBrigitte, String reponseGabriel, String reponseNicolas, String reponseJules, String reponseV437, String reponseMatheo, String reponseBumba, String reponseAlbert,
                        String reponseJ1, String reponseJ2, String reponseJ3, String reponseJ4, String reponseJ5,
                        String reponseP1, String reponseP2, String reponseP3, String reponseP4, String reponseP5, int correct){
            this.intitule = intitule;
            this.choix = new String[]{choix1, choix2, choix3, choix4, choix5};
            this.reponses = new String[]{reponseBrigitte, reponseGabriel, reponseNicolas, reponseJules, reponseV437, reponseMatheo, randomText(), reponseBumba, reponseAlbert};
            this.reponsesJoueur = new String[]{reponseJ1, reponseJ2, reponseJ3, reponseJ4, reponseJ5};
            this.reponsesPresentateur = new String[]{reponseP1, reponseP2, reponseP3, reponseP4, reponseP5};
            this.correct = correct;
        }

        public static List<Question> listeQuestions(){
            List<Question> liste = new ArrayList<>();
            for (Question q : Question.values()){
                liste.add(q);
            }
            Collections.shuffle(liste);
            return liste;
        }

        public String getIntitule(){
            return intitule;
        }

        public String getChoix(int xugfjudfgdfhjdfgdkifsllfjkih){
            return choix[xugfjudfgdfhjdfgdkifsllfjkih];
        }

        public String getReponse(int xugfjudfgdfhjdfgdkifsllfjkih){
            return reponses[xugfjudfgdfhjdfgdkifsllfjkih];
        }

        public String getReponseJoueur(int xugfjudfgdfhjdfgdkifsllfjkih){
            return reponsesJoueur[xugfjudfgdfhjdfgdkifsllfjkih];
        }

        public String[] getReponsesPresentateur(){
            return reponsesPresentateur;
        }

        public int getCorrect(){
            return correct;
        }
    }
    //-----------------------





    public static MediaPlayer sound(String fileName, int volume){ // Volume de x = x% du volume initial
        MediaPlayer mp = null;
        try {
            mp = new MediaPlayer(new Media(QuestionPourUnCarton.class.getResource(PATH_TO_SOUNDS + fileName).toExternalForm()));
            mp.setVolume(volume / 100.0);
        } catch (Exception e) {
            System.out.println(Color.color("Erreur de lecture du fichier audio (" + e.getMessage() + ")", Color.RED));
        }
        return mp;
    }
    // Ex:
    //
    // MediaPlayer vineBoom = sound("vine_boom.wav", 20);
    // vineBoom.play()

    public static void sleep(double s){
        try {
            Thread.sleep((int)(s*1000));
        } catch (InterruptedException e){
            System.out.print("");
        }
    }

    public static void ecrire(String txt, double sleepTime){
        for (int i = 0; i < txt.length(); i += 1){
            System.out.print(txt.charAt(i));
            sleep(0.02);
        }
        System.out.println();
        sleep(sleepTime);
    }

    public static void ecrire(String txt){
        ecrire(txt, 0);
        sc.nextLine();
    }

    public static void ecrire(String personnage, String txt, double sleepTime){
        personnage += ": ";
        for (int i = 0; i < personnage.length(); i += 1){
            System.out.print(personnage.charAt(i));
            sleep(0.02);
        }
        ecrire(txt, sleepTime);
    }

    public static void ecrire(String personnage, String txt){
        ecrire(personnage, txt, 0);
        sc.nextLine();
    }

    public static void ecrireNoEnter(String txt, double sleepTime){
        for (int i = 0; i < txt.length(); i += 1){
            System.out.print(txt.charAt(i));
            sleep(0.02);
        }
        System.out.println();
        sleep(sleepTime);
    }

    public static void ecrireNoEnter(String personnage, String txt, double sleepTime){
        personnage += ": ";
        for (int i = 0; i < personnage.length(); i += 1){
            System.out.print(personnage.charAt(i));
            sleep(0.02);
        }
        ecrireNoEnter(txt, sleepTime);
    }

    public static String randomText(){
        String randomText = "";
        for (int i = 0; i < (rand.nextInt(150)+50); i += 1){
            randomText += (char)(rand.nextInt(167)+33);
        }
        return Color.bold(randomText);
    }

    public static void terminal(String txt, int waitCycle){
        for (int i = 0; i < waitCycle; i += 1){
            System.out.print("\b|");
            sleep(0.55);
            System.out.print("\b ");
            sleep(0.55);
        }
        for (int i = 0; i < txt.length(); i += 1){
            System.out.print(txt.charAt(i));
            sleep(0.095);
        }
        System.out.println();
    }
    

    public static void terminal(String txt){
        terminal(txt, 0);
    }

    public static int choixChemin(String... choix){
        for (int i = 0; i < choix.length; i += 1){
            System.out.print("[");
            sleep(0.02);
            System.out.print(i);
            sleep(0.02);
            System.out.print("] ");
            sleep(0.02);
            for (int j = 0; j < choix[i].length(); j += 1){
                System.out.print(choix[i].charAt(j));
                sleep(0.02);
            }
            System.out.println();
        }
        try {
            return sc.nextInt();
        } catch (InputMismatchException e){
            return 0;
        }
    }

    public static int poserQuestion(List<Question> questions, int vies, String nom){
        Question q = questions.remove(0);
        ecrireNoEnter(presentateur, q.getIntitule(), 0.5);
        for (int i = 0; i < 5; i += 1){
            ecrireNoEnter("["+(i+1)+"] "+q.getChoix(i), 0);
        }
        int choix;
        System.out.println();
        do {
            System.out.print("> ");
            try {
                choix = sc.nextInt();
            } catch (InputMismatchException e){
                choix = 0;
            }
        } while (!(choix >= 1 && choix <= 5));
        if (!(q.getCorrect() == choix)){
            vies -= 1;
        }
        for (int i = 0; i < 10; i += 1){
            if (i < 8){
                ecrireNoEnter(Question.noms[i], q.getReponse(i), 0.5);
            } else if (i == 8){
                ecrireNoEnter(nom, q.getReponseJoueur(choix-1), 0.5);
            } else {
                ecrireNoEnter(Question.noms[i-1], q.getReponse(i-1), 0.5);
            }
        }
        ecrire(presentateur, q.getReponsesPresentateur()[choix-1]);
        return vies;
    }

    public static void rappelVies(int vies){
        String v = "" + vies;
        if (vies == 5 || vies == 4){
            v = Color.color(v, Color.GREEN_BOLD);
        } else if (vies == 3 || vies == 2){
            v = Color.color(v, Color.YELLOW_BOLD);
        } else if (vies == 1){
            v = Color.color(v, Color.RED_BOLD);
        }
        ecrire(Color.bold("[Il vous reste " + v + " vies]"));
    }

    public static boolean isFinished(int vies){
        if (vies > 0){
            rappelVies(vies);
            return false;
        }
        return true;
    }

    public static void finalSpeech(String nom){
        ecrire(presentateur, "Il se trouve que " + nom + " n'a plus de vies, il va donc devoir nous quitter...");
        ecrire(presentateur, "Dites lui tous adieu!");
        ecrire("Toute la scène", "ADIEUUUU!");
        ecrire(Color.bold("Alors que vous quitter le plateau de tournage, vous sentez le désespoir et la misère s'abattre immédiatement sur vous. Cet incroyable carton de 3 mètres cube vous est désormais inaccessible à jamais."));
        ecrire(Color.color("\nMAUVAISE FIN", Color.RED_BOLD), 1);
    }





    //----------------------------------------------------------------------------------------------------------





    public static void main(String[] args){
        com.sun.javafx.application.PlatformImpl.startup(() -> {});

        Terminal.clearScreen();

        MultiThreading.execute(e -> Window.main(new String[]{"carton"}), e -> Window.main(new String[]{"cartes"}));

        System.out.print("Entrez votre nom svp: ");
        nom = sc.nextLine();

        Terminal.clearScreen();

        if (nom.equals("votre nom svp")){
            sleep(2);
            ecrireNoEnter("Putain mais t'est super drôle toi", 2);
            Terminal.clearScreen();
            sleep(5);
            ecrireNoEnter("ratio", 1);
            nom = "Catin";
        } else if (nom.equals("Presentateur")){
            cheminPresentateur();
            return ;
        } else if (nom.equals("amogus") || nom.equals("among us")){
            cheminSus();
            return ;
        } else {
            ecrireNoEnter("Pour des raisons qui devrait se comprendrent, les gros mots sont censuré ██████ SA MÈRE LA GROSSE ████ SA RACE DE █████ ok ça fonctionne", 3);
        }

        Terminal.clearScreen();
        
        int vies = 5;
        List<Question> questions = Question.listeQuestions();


        // Introduction


        ecrire(Color.bold("Alors que vous vous approchez de la scène de tournage, vous entendez toute la scène parler entre eux, comme si ils était tous excités."));
        ecrire(Color.bold("En même temps c'est normal, vous n'êtes pas sur n'importe quel plateau de tournage."));
        ecrire(Color.bold("Bienvenue dans l'expérience qui aura probablement le moins de sens dans votre vie...\n"), 0.5);
        ecrire(presentateur, Color.color("Question pour un Carton!", Color.BLUE_BOLD));
        ecrire(presentateur, "Bienvenue tout le monde dans ce show aussi chaotique qu'imprévisible!");
        ecrire(presentateur, "Je vous en prie, asseyez vous. Tout nos participants sont présents!");
        ecrire(presentateur, "Ils sont au grand nombre de 10, sont aussi divers que variés et répondrons à de nombreuses questions sans intérêts ou logique thématique particulière afin de gagner ce magnifique carton de 3 mètres cube!");
        ecrire(presentateur, "Assez de blabla, laissont nos participants se présenter.");


        // Présentations


        String randomName = "";
        for (int i = 0; i < rand.nextInt(20)+10; i += 1){
            randomName += (char)(rand.nextInt(167)+33);
        }
        Question.noms[6] = randomName;

        ecrire("Brigitte", "Bonjour je m'apelle Brigitte, j'ai 74 ans et ce carton est à mes yeux une nécéssité absolue. Voyez-vous, j'ai 35 chats dans mon appartement et ils adorerais s'amuser avec ce carton.");
        ecrire("Gabriel", "Mes frères, mes soeurs. Nous sommes réunis en ce lieu afin de me faire gagner en intellect et, bien évidemment, me faire gagner cette boite cartonnée.");
		ecrire("Nicolas", "Bonjour, Nicolas, 26 ans, étudiant en infor-\n", 0);
        ecrire("Jules", "oe euuuuuuh moi jai bsoin de cet boit pour la mettr dan mon appart");
        ecrire("V-43.7", Color.bold("*bruits incompréhensibles de robot*"));
        System.out.print(nom + ": "); sc.next(); System.out.println();
        ecrire("Mathéo", Color.bold("*est confus par rapport aux autres participants*")); sc.nextLine();
		ecrire(randomName, randomText());
        ecrire("bumba", "ooga booga" + Color.bold(" *se cogne plusieurs fois la tête avec une masse en bois*"));
        ecrire("Albert", "Je ne peut m'imaginer sans ce carton. Je dois le gagner, ou alors mon existance ne serait qu'un ab\u00EEme sans sens. Ce carton est pour moi l'objectif de ma vie, le sens m\u00EAme de ma destin\u00E9e, le fil rouge de mon existence. J'ai r\u00EAv\u00E9 jours et nuits de ce carton depuis mes 2 ans. Je ne fait qu'envoyer des lettres d'inscriptions \u00E0 ce show depuis mes 3 ans dans l'unique but de pouvoir vivre avec ce carton. J'ai pass\u00E9 30 ans de ma vie \u00E0 m'entrainer, de minuit \u00E0 23 heures 50, chaque jours de chaque semaines de chaque mois de chaque ann\u00E9es. Ma vie tourne autour de ce carton, je me dois donc aujourd'hui de marquer une nouvelle phase de ma vie et de gagner ce carton.");


        ecrire(presentateur, "Que de magnifiques présentations! \u00C7a devrait impressioner les spectateur tout en donnant de la prestance au participants! (sauf Nicolas)");
        ecrire(presentateur, "Ne tardons donc pas avec notre première question!");


        // Question 1


        ecrireNoEnter(Color.bold("Question 1\n"), 0.5);
        vies = poserQuestion(questions, vies, nom);
        if (isFinished(vies)){
            finalSpeech(nom);
            return ;
        }


        // Transition


        ecrire(presentateur, "Que d'engouement de la part du public pour cette première question! Je peut sentir leur exitation à travers leurs cris!");
		ecrire(presentateur, "Alalah, je sens que ce show va vraiment être incroy-");
		ecrire("Nicolas", "Excusez moi monsieur Présentateur? Je me demandais pourquoi-");
		ecrire(presentateur, "Selon le contrat d'inscription que vous avez signé mon cher Nicolas, vous n'êtes pas autorisé à poser de question. Ici c'est moi qui les pose.");
		ecrire("Nicolas", "Autant pour moi...");
		ecrire(presentateur, "Je suis même autorisé à retirer une vie dans ce cas précis, ce que je vais faire de suite :)");
		ecrire("Nicolas", ":(");
		ecrire(presentateur, "Bref, passons de suite à la question suivante!");


        // Question 2


        ecrireNoEnter(Color.bold("Question 2\n"), 0.5);
        vies = poserQuestion(questions, vies, nom);
        if (isFinished(vies)){
            finalSpeech(nom);
            return ;
        }


        // Transition


        ecrire(presentateur, "Après cette question d'une complexité exceptionnellement grande, laissez moi vous raconter une anecdote de ma vie.");
        ecrire(presentateur, "C'était il y a 35 ans, j'était à l'école primaire avec mon meilleur ami: Chanteur.");


        // Flashback 1


		ecrireNoEnter(Color.bold("Il y a 35 ans..."), 0.5);
        ecrire(Color.color("Présentateur (enfant)", Color.YELLOW), "Bonjour toi. Tu fait quoi?");
        ecrire("Chanteur (enfant)", "Je donne un super concert à tout ces cailloux!");
        ecrire(Color.color("Présentateur (enfant)", Color.YELLOW), "Waaa, c'est trop bien! Je peux jouer avec toi?");
        ecrire("Chanteur (enfant)", "Désolé, mais tout les tickets sont pris. Tu peut te mettre dans la poubelle si tu veut.");
        ecrire(Color.color("Présentateur (enfant)", Color.YELLOW), "Trop bien! " + Color.bold("*plonge dans la poubelle et regarde Chanteur donner un concert*"));
        ecrireNoEnter(Color.bold("15 minutes plus tard..."), 0.75);
        ecrire("Chanteur (enfant)", "Alors, qu'est ce que tu en dit?");
        ecrire(Color.color("Présentateur (enfant)", Color.YELLOW), "Tu a chanté les deux mêmes notes en boucle pendant 15 minutes mais sinon j'ai adoré! :D");
        ecrire("Chanteur (enfant)", "Dit, tu veut devenir mon copain?");
        ecrire(Color.color("Présentateur (enfant)", Color.YELLOW), "OUIIIIIIIIIII *O*");
        ecrireNoEnter(Color.bold("Et nous sommes de retour au présent."), 0.5);


        // Fin du flashback


        ecrire(presentateur, "Et c'est ainsi que je suis fait mon tout premier ami.");
        ecrire(presentateur, "J'espère que vous avez aimés cette anecdote, car elle n'a strictement rien à voir avec le show.");
        ecrire(presentateur, "Sur toute cette émotion, la troisième question!");


        // Question 3


        ecrireNoEnter(Color.bold("Question 3\n"), 0.5);
        vies = poserQuestion(questions, vies, nom);
        if (isFinished(vies)){
            finalSpeech(nom);
            return ;
        }


        // Transition


        ecrire(presentateur, "Passons. J'ai une petite faim d'un coup, pas vous?");
        ecrireNoEnter("Nicolas", "Ah tiens, moi au-", 0);
        ecrire(presentateur, "Non.");
        ecrire(presentateur, "Et vous " + nom + ", vous avez faim?");
		System.out.print(nom + ": "); sc.next(); System.out.println();
        ecrire(presentateur, "Il faut que je vous avoue quelque chose " + nom + ". La vérité est que je ne vous ait pas écouté.");
        ecrire(presentateur, "Sur ce, je vais aller me chercher un Twix™. " + Color.bold("*Se lève de sa chaise et va chercher un Twix*"));
        for (int i = 0; i < 8; i += 1){
            ecrireNoEnter("...", 1);
        }
        ecrire(presentateur, "Mmmh, ce Twix fut étonnamment bon.");
        ecrire(presentateur, "Alors, la quatrième question...");
        ecrire(presentateur, "Oh zut, j'ai fait tomber mon deuxième Twix™ dessus!");
        ecrire(presentateur, "Tant pis, je vais faire ma propre quatrième question.");
        ecrire(presentateur, "Donc...");


        // Question 4


        ecrireNoEnter(Color.bold("Question 4\n"), 0.5);
        vies = poserQuestion(questions, vies, nom);
        if (isFinished(vies)){
            finalSpeech(nom);
            return ;
        }


        // Transition


        ecrire(presentateur, "Oh regardez, une superbe INTERLUDE SPÉCIALE!");

		
		// Interlude spéciale 1

		
		ecrireNoEnter(Color.bold("INTERLUDE SPÉCIALE"), 0.5);
        ecrire(presentateur, "Durant cette interlude spéciale vous avez tous une chance de regagner une vie!");
        ecrire(presentateur, "Mais pour cela vous devez répondre à une question...");
        ecrire(presentateur, "De quelle couleur est ma cravate?\n> ");
        ecrire("Brigitte", "Bleu?");
        ecrire("Gabriel", "Vert!");
        ecrire("Nicolas n'a pas trouvé la réponse.");
        ecrire("Jules", "rouj");
        ecrire("V-43.7", "#AO37DF");
        System.out.print(nom + ": "); sc.next(); System.out.println();
        ecrire("Mathéo", "Mathéo n'a pas trouvé la réponse.");
        ecrire(randomName, randomText());
        ecrire("bumba", "ooga ooga");
        ecrire("Albert", "Toute les couleurs du spectre en même temps!");
        ecrire(presentateur, "Et bien il se trouve que vous avez tous faux. Je n'ai pas de cravate.");
        ecrireNoEnter(Color.bold("FIN DE L'INTERLUDE SPÉCIALE"), 0.5);


        // Transition

        
        ecrire(presentateur, "Quel dommage que personne n'ait réussi à regagner de vies!");
        ecrireNoEnter(presentateur, "...", 1);
        ecrire(presentateur, "Quelque chose ne va pas...");
        ecrire(presentateur, Color.bold("*regarde sa montre*"));
        ecrire(presentateur, "Oh non!");
        ecrire(presentateur, "Le jour est arrivé!");
        ecrireNoEnter(presentateur, "Je vais mourir d'un arrêt cardiaque d'ici 3...", 1);
        ecrireNoEnter(presentateur, "2...", 1);
        ecrireNoEnter(presentateur, "1...", 1);
        ecrire(presentateur, Color.bold("*attend*"));
        ecrire(presentateur, Color.bold("*se questionne*"));
        ecrire(presentateur, Color.bold("*sort un calendrier et le regarde*"));
        ecrire(presentateur, "Autant pour moi, ce jour arrivera la semaine prochaine.");
        ecrire(presentateur, "Désormais, la question 5!");


        // Question 5


        ecrireNoEnter(Color.bold("Question 5\n"), 0.5);
        vies = poserQuestion(questions, vies, nom);
        if (isFinished(vies)){
            finalSpeech(nom);
            return ;
        }


        // Transition


        ecrire(presentateur, "ATTENDEZ UNE MINUTE!");
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrire(presentateur, "Quelqu'un arrive...");
        ecrire("Chanteur", "BONSOIR TOUT LE MONDE!!!");
        ecrire(presentateur, "Chanteur!");
        ecrire(Color.bold("*Toute la foule se met à crier*"));
        ecrire("Chanteur", Color.bold("*Prend une guitare*"));
        ecrire(Color.bold("*Toute la foule se tait*"));
        ecrireNoEnter("...", 1);
        //MediaPlayer soloEpique = sound("solo_épique.wav", 20);
        //soloEpique.play()
        ecrireNoEnter("Chanteur", Color.bold("*SOLO DE GUITARE EPIQUE*"), 5);
        ecrire(presentateur, "Viens ici espèce de ████████!");
        ecrire(Color.bold("*Grosse poignée de main bien virile*"));
        ecrire("Chanteur", "Alors tu devient quoi vieux ██████?");
        ecrire(presentateur, "Pas grand chose, j'ai percé à la télé et maintenant je fait un show télévisé.");
        ecrire("Chanteur", "██████, pas mal.");
        ecrire(presentateur, "Par contre fait gaffe aux ██████ que tu dit, ce show est Family Friendly.");
        ecrire("Chanteur", "█████ désolé.");
        ecrire(presentateur, "Bon on a peut être pas le temps pour les retrouvailles, il faut continuer le show.");
        ecrire("Chanteur", "Ok pas de soucis.");
        ecrire(presentateur, "Du coup euuuuuh... On en était ou déjà...");
        ecrire(presentateur, "Oui c'est vrai question 6!");


        // Question 6


        ecrireNoEnter(Color.bold("Question 6\n"), 0.5);
        vies = poserQuestion(questions, vies, nom);
        if (isFinished(vies)){
            finalSpeech(nom);
            return ;
        }


        // Transition


        ecrire(presentateur, "Aaaaaaah, ce fut une bien bonne question :D");
        ecrire("Chanteur", "Dit moi, j'aurais une question Présentateur.");
        ecrire("Chanteur", "Serais-ce possible d'emporter avec moi celui-là?" + Color.bold("*pointe " + nom + " du doigt*"));
        ecrire(presentateur, "Bonne question, c'est à lui qu'il faut demander (même si techniquement je peux toujours choisir car selon le contrat d'inscription il m'appartient)");

        if (choixChemin("Rester sur le plateau", "Sortir du plateau") == 1){
            cheminDehors();
            return ;
        }
        
        ecrire(presentateur, "");
    }





    //----------------------------------------------------------------------------------------------------------





    public static void cheminPresentateur(){
        Terminal.clearScreen();

        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrire(presentateur, Color.bold("*regarde l'heure*"));
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrire(presentateur, Color.bold("*regarde à nouveau l'heure*"));
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrire(presentateur, "Mais ou est-il?");
        ecrire(presentateur, "Il est sensé être là, et le show aurait même déjà commencé!");
        ecrire(presentateur, Color.bold("*regarde encore l'heure*"));
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrire(presentateur, Color.bold("*regarde une dernière fois l'heure*"));
        ecrire(presentateur, "Bon, je vais essayer quelque chose.\n", 2);
        System.out.print(Color.color("DEBUG MODE INITIALISED\n\n", Color.RED));
        terminal("public class CheckJoueur{\n\tpublic static void main(String[] args){\n\t\tJoueur j = QuestionPourUnCarton.getJoueur();\n\t\tif (j == null){\n\t\t\tSystem.out.println(\"Il n'y a aucun joueur\");\n\t\t} else {\n\t\t\tSystem.out.println(\"IL Y A UN JOUEUR! YIPPEEEEEEE\");\n\t\t}\n\t}\n}", 2);
        sleep(1);
        System.out.print("\nPS C:\\Users\\presentateur\\Desktop\\QuestionPourUnCarton> ");
        sleep(1.5);
        System.out.println(Color.color("c:; cd 'c:\\Users\\presentateur\\Desktop\\QuestionPourUnCarton'; ", Color.CYAN) + "&" + Color.color(" 'C:\\Program Files\\Java\\jdk1.8.0_321\\bin\\java.exe' '-cp' 'C:\\Users\\presentateur\\AppData\\Roaming\\Code\\User\\workspaceStorage\\4c1f9d31f4b103fa083ee66fd6b94ca1\\redhat.java\\jdt_ws\\CheckJoueur_9d1e0b84\\bin' 'CheckJoueur' ", Color.CYAN));
        sleep(0.2);
        Terminal.clearScreen();
        System.out.println("Il n'y a aucun joueur\n");
        sleep(2);
        ecrire(presentateur, "Ah ._.");
        ecrire(presentateur, "euuuuuuh");
        ecrire(presentateur, "ok euuuh je fait quoi\n", 0);
        boolean correct = false;
        while (!correct){
            switch (choixChemin("Créer un nouveau joueur", "Ne rien faire")) {
                case 0:
                    correct = true;
                    ecrire(presentateur, "Ok je pourrais essayer de créer un nouveau joueur.");
                    ecrire(presentateur, Color.bold("*met des lunettes de soleil*"));
                    ecrire(presentateur, "C'est parti.");
                    terminal("public class CreateJoueur extends QuestionPourUnCarton{\n\tpublic static Joueur createNewJoueur(){\n\t\tJoueur j = new Joueur();\n\t\tj.name(\"Joueur\");\n\t\tj.setVies(5);\n\t\treturn j;\n\t}\n\n\tpublic static void main(String[] args){\n\t\tJoueur j = createNewJoueur();\n\t\tsuper.main(new String[j.toString()]);\n\t}\n}", 1);
                    sleep(1);
                    System.out.print("\nPS C:\\Users\\presentateur\\Desktop\\QuestionPourUnCarton> ");
                    sleep(1.5);
                    System.out.println(Color.color("c:; cd 'c:\\Users\\presentateur\\Desktop\\QuestionPourUnCarton'; ", Color.CYAN) + "&" + Color.color(" 'C:\\Program Files\\Java\\jdk1.8.0_321\\bin\\java.exe' '-cp' 'C:\\Users\\presentateur\\AppData\\Roaming\\Code\\User\\workspaceStorage\\4c1f9d31f4b103fa083ee66fd6b94ca1\\redhat.java\\jdt_ws\\CreateJoueur_9d1e0b84\\bin' 'CreateJoueur' ", Color.CYAN));
                    sleep(0.2);
                    Terminal.clearScreen();
                    sleep(1.5);
                    ecrire(presentateur, "ça fonctionne...");
                    ecrire(presentateur, "ÇA FONCTIO", 0);
                    System.out.println("Exception in thread \"main\" exceptions.CorruptedPlayerException: Player data corrupted\n\tat CreateJoueur.main(CreateJoueur.java:8)\n\tat QuestionPourUnCarton.main(QuestionPourUnCarton.java:202)");
                    return ;
                case 1:
                    correct = true;
                    ecrire(presentateur, "bon");
                    ecrire(presentateur, "J'ai plus aucun choix");
                    ecrire(presentateur, "Je n'ai qu'à attendre ici jusqu'à ce que cet endroit ne cesse d'exister.");
                    while (true){
                        int r = rand.nextInt(100);
                        if (r < 10){
                            ecrire(presentateur, "...");
                        } else if (r < 20){
                            ecrire(presentateur, ":|");
                        }
                        sc.nextLine();
                    }
                default: break;
            }
        }
    }

    public static void cheminSus(){
        Terminal.clearScreen();

        ecrire(presentateur, "SUS");
        ecrire(presentateur, "SUS SUS AMONGUS");
        ecrire(presentateur, "SUSSY SUS AMONG US");
    }
    
    public static void cheminDehors(){
        ecrire(presentateur, nom + " veux sortir du plateau? Alors ça c'est inatendu!");
        ecrire("Chanteur", "Comment lui en vouloir? Avec moi la gloire l'attend forcément!");
        ecrire(nom, "La gloire?!");
        ecrire("Chanteur", "Et oui " + nom + ", tu vas devenir célèbre.");
        ecrire("Chanteur", "Allez, viens.");
        ecrire(Color.bold("Et vous voici hors du plateau de tournage, dans la limousine de Chanteur."));
        ecrire(Color.bold("\"Cette limousine est extraordinaire...\" vous vous dites, alors que vous contemplez ce manignifique véhicule d'environ 42 mètres de long."));
        ecrire("Chanteur", "Alors dit moi, que fesait-tu sur ce plateau télé?");

        switch (choixChemin("Je voulais gagner un grand carton", "Je souhaitait m'inscrire dans l'histoire de n'importe quelle manière", "J'avais juste envie de participer à quelque chose pour une fois dans ma vie :')", "¯\\_(ツ)_/¯")) {
            case 0:
                ecrire("Chanteur", "Juste un grand carton? Tu as des attentes simples, j'aime ça.");
                ecrire(nom, "Ce carton me tentait vraiment, mais une carrière dans la musique? Comment je peux refuser ça?");
                break;
            case 1:
                ecrire("Chanteur", "Alors tu vas être servi sur un plateau d'argent.");
                switch (new Random().nextInt(3)) {
                    case 0:
                        ecrire("Chanteur", "Tu va probablement devenir un batteur de légende...");
                        break;
                    case 1:
                        ecrire("Chanteur", "Tu va probablement devenir un guitariste de légende...");
                        break;
                    case 2:
                        ecrire("Chanteur", "Tu va probablement devenir un pianiste de légende...");
                        break;
                    default:
                        break;
                }
            case 2:
                ecrire("Chanteur", "Et voici donc que ta vie pris un tournant aussi immédiat qu'innatendu, bouleversant toute tes émotions...");
                ecrire("Chanteur", "Tu va cartonner, crois moi.");
                break;
            case 3:
                ecrire("Chanteur", "Tu ne sais pas?" + Color.bold("*rigole*"));
                ecrire("Chanteur", "Elle est bonne celle-là! En plus d'un musicien tu vas être comédien?!");
                ecrire("Chanteur", "Mais quel génie!");
                break;
            default:
                ecrire("Chanteur", "Juste un grand carton? Tu as des attentes simples, j'aime ça.");
                ecrire(nom, "Ce carton me tentait vraiment, mais une carrière dans la musique? Comment je peux refuser ça?");
                break;
        }

        Terminal.clearScreen();

        ecrire(Color.bold("Après 40 minutes de discussion sur des sujets aussi divers que variées..."));
        ecrire("Chanteur", "Tu va te plaire ici.");
        ecrire(Color.bold("*Vous sortez tout les deux de la limousine*"));
        ecrire("Chanteur", "Bienvenue dans mon manoir!");
        ecrire(nom, "Wow, mais c'est énorme! Est-ce qu'un bâtiment aussi grand est légal?");
        ecrire("Chanteur", "Techniquement non mais tout le terrain m'appartient et je suis riche donc oui!");
        ecrire("Chanteur", "Allez, ne reste pas dehors! Je vais te faire visiter.");
        ecrire(Color.bold("*Vous entre tout les deux dans le manoir de Chanteur*"));
        ecrire(Color.bold("*Vous avez l'impression que le manoir est plus grand à l'intérieur qu'à l'extérieur*"));
        ecrire("Chanteur", "Prépare toi à une visite d'enfer!");
        ecrire("Chanteur", "On commence avec le salon, qui possède 2 télés, une énorme baie vitrée (6 mètres de haut quand même) et plusieurs canapés.");
        ecrire("Chanteur", "Sur la gauche on a le couloir qui mène aux 4 chambres, 2 salles de bain, 3 pièces de jeux et les quelques autres pièces.");
        ecrire("Chanteur", "Devant nous on a la cuisine, divisée en 3 parties: là ou on cuisine des trucs, là ou on mange des trucs et l'autre partie.");
        ecrire("Chanteur", "Sur la droite on a l'escalier qui mêne du 2ème au 8ème étage, mais si tu veux il y a un ascenceur qui lui va jusqu'au 16ème si tu n'est pas assez courageux.");
        ecrire("Chanteur", "Après il y a-", 0);
        ecrire(nom, "Ok ok je pense avoir compris la maison est grande c'est nickel");
        ecrire("Chanteur", "Exactement! Mon manoir possède 33 étages, fait environ 7km de superficie, possède nombre de piscines, cuisines, chambres et tout autres pièces dont tu peux rêver, et tout ça à l'intérieur du bâtiment principal seulement!");
        ecrire(nom, "Dit moi, tu fait des fêtes souvent?");
        ecrire("Chanteur", "Tout les soirs.");
        ecrire(nom, "Combien de personnes environ?");
        ecrire("Chanteur", Color.bold("*Compte sur ses doigts*"));
        ecrire("Chanteur", "6... 7... 8...");
        ecrire("Chanteur", "Ouais environ 8 millions de personnes.");
        ecrire(nom, "ah ouais quand même");

        //à finir
    }
}
