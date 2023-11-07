package util;

import javafx.application.Application;
import javafx.stage.Stage;

import util.windows.*;

// NE PAS METTRE ABSTRACT
public class Window extends Application{
    private static String argument;

    @Override
    public void start(final Stage primaryStage) {
        if (argument.equals("carton")){
            new WindowQPUC();
        } else if (argument.equals("cartes")){
            //new WindowCartes();
        } else if (argument.equals("gameoflife")){
            new WindowLife();
        }
    }

    public static void main(String[] args){
        argument = args[0];
        launch();
    }
}