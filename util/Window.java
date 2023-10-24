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
    public static class WindowQPUC extends Stage{
        public WindowQPUC(){
            List<Stage> stages = new ArrayList<Stage>();
            stages.add(this);

            setOnCloseRequest(e -> {
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
                    newWindow.setX(stages.get(0).getX() + 200);
                    newWindow.setY(stages.get(0).getY() + 100);

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

            setTitle("Question pour un Carton");
            setScene(scene);
            show();
        }
    }
    //---------------------------------------------



    //---------- Jeu de Cartes PubertRP ----------
    public static class WindowCartes extends Stage{
        public WindowCartes(){
            Label label = new Label("Faite genre qu'il y a des trucs haha");

            StackPane root = new StackPane();
            root.getChildren().add(label);

            Scene scene = new Scene(root, 450, 250);

            setTitle("Jeu de cartes");
            setScene(scene);
            show();
        }
    }
    //---------------------------------------------



    @Override
    public void start(final Stage primaryStage) {
        if (arguments[0].equals("qpuc")){
            new WindowQPUC();
        } else if (arguments[0].equals("cartes")){
            new WindowCartes();
        }
    }

    public static void main(String[] args) {
        arguments = args;
        launch();
    }
}
