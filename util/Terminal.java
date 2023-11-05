package util;

import java.io.IOException;

public abstract class Terminal {
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
            }
        } catch (IOException | InterruptedException  e) {  
            System.out.println(Color.color("Problème de rafraichissement du terminal", Color.RED));
        }
    }

    public static void error(Exception e, String msg){
        System.out.println(Color.color(msg + "\n", Color.RED) + Color.YELLOW);
        e.printStackTrace();
        System.out.print(Color.RESET);
    }
}