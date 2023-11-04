package util.windows;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class WindowQPUC extends Stage{
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

        setResizable(false);
        setTitle("Question pour un Carton");
        setScene(scene);
        show();
    }
}