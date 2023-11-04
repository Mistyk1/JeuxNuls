package util.windows;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jeux.GameOfLife.LifePlateau;

public class WindowLife extends Stage{
    private LifePlateau plateau;
    private static boolean pause;
    private static int speed;
    private static WindowLife instance;
    private GridPane grid;

    public WindowLife(){
        if (instance == null){
            instance = this;
            this.plateau = LifePlateau.plateauToWindow(this);
            pause = false;
            speed = 500;

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
            Slider slider = new Slider(100, 1000, 500);
            slider.setBlockIncrement(1);
            slider.valueProperty().addListener((observable, oldValue, newValue) -> {
                speed = newValue.intValue();
                String str = "Vitesse du jeu: ";
                if (speed < 10){
                    str += "   ";
                } else if (speed < 100 && speed >= 10){
                    str += "  ";
                } else if (speed < 1000 && speed >= 100){
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

            grid = giveGrid();

            VBox v = new VBox(h, grid);
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

    private GridPane giveGrid(){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
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
        return grid;
    }

    private StackPane givePane(int y, int x, GridPane grid){
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        colorPane(pane, plateau.getCell(x, y));
        pane.setOnMouseClicked(e -> {
            plateau.changeState(x, y);
            colorPane(pane, plateau.getCell(x, y));
        });
        return pane;
    }

    private void colorPane(StackPane pane, boolean state){
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

    public void refresh(){
        if (exists() && grid != null){
            int rows = plateau.getNbRows();
            int cols = plateau.getNbCols();
            for (int i = 0; i < rows; i += 1) {
                for (int j = 0; j < cols; j += 1) {
                    colorPane((StackPane)grid.getChildren().get(i*rows+j), plateau.getCell(j, i));
                }
            }
        }
    }
}