package util;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jeux.GameOfLife.LifePlateau;

public class Window extends Application{
    private static String argument;



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

            setResizable(false);
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

            setResizable(false);
            setTitle("Jeu de cartes");
            setScene(scene);
            show();
        }
    }
    //---------------------------------------------



    //---------- Jeu de la Vie ----------
    public static class WindowLife extends Stage{
        private LifePlateau plateau;
        private static boolean pause;
        private static int speed;
        private static WindowLife instance;

        public WindowLife(){
            if (instance == null){
                instance = this;
                this.plateau = LifePlateau.plateauToWindow();
                pause = false;
                speed = 10;

                // Pause
                Button b = new Button("   Pause   ");
                b.setOnAction(e -> {
                    if (pause){
                        pause = false;
                        b.setText("   Pause   ");
                    } else {
                        pause = true;
                        b.setText("Reprendre");
                    }
                });
                
                // Vitesse
                Label vit = new Label("Vitesse du jeu: " + Integer.toString(speed));
                Slider slider = new Slider(1, 100, 10);
                slider.setBlockIncrement(1);
                slider.valueProperty().addListener((observable, oldValue, newValue) -> {
                    speed = newValue.intValue();
                    String str = "Vitesse du jeu: ";
                    if (speed < 10){
                        str += "  ";
                    } else if (speed < 100 && speed >= 10){
                        str += " ";
                    }
                    vit.setText(str + Integer.toString(speed));
                });
                HBox hVitesse = new HBox(vit, slider);
                hVitesse.setAlignment(Pos.CENTER_RIGHT);
                hVitesse.setSpacing(10);

                // Reste
                HBox h = new HBox(b, hVitesse);
                h.setAlignment(Pos.CENTER);
                h.setSpacing((plateau.getNbCols()*8)/2);

                GridPane g = new GridPane();
                g.setAlignment(Pos.CENTER);
                giveGrid(g);

                VBox v = new VBox(h, g);
                v.setAlignment(Pos.CENTER);

                StackPane root = new StackPane(v);
                root.setAlignment(Pos.BOTTOM_CENTER);

                Scene scene = new Scene(root, plateau.getNbRows()*15, plateau.getNbCols()*15+25);

                setOnCloseRequest(e -> { instance = null; });
                setResizable(false);
                setTitle("Jeu de la Vie");
                setScene(scene);
                show();
            }
        }

        public static boolean exists(){
            return instance != null;
        }

        private void giveGrid(GridPane grid){
        int rows = plateau.getNbRows();
        int cols = plateau.getNbCols();
        for (int i = 0; i < rows; i += 1){
            RowConstraints row = new RowConstraints(15);
            grid.getRowConstraints().add(row);
        }
        for (int i = 0; i < cols; i += 1) {
            ColumnConstraints column = new ColumnConstraints(15);
            grid.getColumnConstraints().add(column);
        }
        for (int i = 0; i < rows; i += 1) {
            for (int j = 0; j < cols; j += 1) {
                grid.add(givePane(i, j, grid), i, j);
            }
        }
        }

        private Pane givePane(final int y, final int x, GridPane grid){
            Pane pane = new Pane();
            colorPane(pane, plateau.getCell(x, y));
            pane.setOnMouseClicked(e -> {
                plateau.changeState(x, y);
                colorPane(pane, plateau.getCell(x, y));
            });
            return pane;
        }

        private void colorPane(Pane pane, boolean state){
            if (state) {
                pane.setStyle("-fx-border-color: black; -fx-background-color: white;");
            } else {
                pane.setStyle("-fx-border-color: black; -fx-background-color: #101010;");
            }
        }

        public static boolean getPause(){
            return pause;
        }

        public static int getSpeed(){
            return speed;
        }
    }
    //------------------------------------



    @Override
    public void start(final Stage primaryStage) {
        if (argument.equals("carton")){
            new WindowQPUC();
        } else if (argument.equals("cartes")){
            new WindowCartes();
        } else if (argument.equals("gameoflife")){
            new WindowLife();
        }
    }

    public static void main(String[] args) {
        argument = args[0];
        launch();
    }
}
