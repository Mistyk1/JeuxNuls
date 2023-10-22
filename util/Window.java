package util;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Window extends Application{
    private static String[] arguments;



    //---------- Question pour un Carton ----------
    public static class WindowQPUC{
        public static void start(Stage primaryStage){
            List<Stage> stages = new ArrayList<Stage>();
            stages.add(primaryStage);

            primaryStage.setOnCloseRequest(e -> {
                for (Stage stage : stages){
                    stage.close();
                }
            });

            Button button = new Button();
            button.setText("Open a New Window");

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    Label secondLabel = new Label("I'm a Label on new Window");

                    StackPane secondaryLayout = new StackPane();
                    secondaryLayout.getChildren().add(secondLabel);

                    Scene secondScene = new Scene(secondaryLayout, 230, 100);

                    Stage newWindow = new Stage();
                    stages.add(newWindow);
                    newWindow.setTitle("Fenêtre n°" + stages.size());
                    newWindow.setScene(secondScene);

                    // Set position of second window, related to primary window.
                    newWindow.setX(primaryStage.getX() + 200);
                    newWindow.setY(primaryStage.getY() + 100);

                    newWindow.setOnCloseRequest(e -> {
                        int idx = stages.indexOf(newWindow);
                        stages.remove(newWindow);
                        for (int i = idx; i < stages.size(); i++){
                            if (stages.get(i) == null){
                                stages.set(i, stages.get(i+1));
                            }
                            stages.get(i).setTitle("Fenêtre n°" + (i+1));
                        }
                    });

                    newWindow.show();
                }
            });

            StackPane root = new StackPane();
            root.getChildren().add(button);

            Scene scene = new Scene(root, 450, 250);

            primaryStage.setTitle("Question pour un Carton");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }
    //---------------------------------------------



    //---------- Jeu de Cartes PubertRP ----------
    public static class WindowCartes{
        public static void start(Stage primaryStage){
            Label label = new Label("Faire genre qu'il y a des trucs haha");

            StackPane root = new StackPane();
            root.getChildren().add(label);

            Scene scene = new Scene(root, 450, 250);

            primaryStage.setTitle("Jeu de cartes");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }
    //---------------------------------------------



    @Override
    public void start(final Stage primaryStage) {
        if (arguments[0].equals("qpuc")){
            WindowQPUC.start(primaryStage);
        } else if (arguments[0].equals("cartes")){
            WindowCartes.start(primaryStage);
        }
    }

    public static void main(String[] args) {
        arguments = args;
        launch();
    }
}
