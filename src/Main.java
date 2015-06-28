/**
 * Created by oj on 6/23/15.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main extends Application {
    private BorderPane root;
    private Stage stage;
    private Scene scene;
    private GridPane gridPane;
    private List<String> lines;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        root = new BorderPane();
        scene = new Scene(root, 600, 500); //width and height of application
        stage.setScene(scene);
        stage.setTitle("Main Application");  //text for the title bar of the window

        scene.getStylesheets().add("styles.css");

        gridPane = new GridPane();
        root.setCenter(gridPane);
        root.setTop(new HBox(new Text("IASAS Schools")));

        ColumnConstraints cc = new ColumnConstraints(80);
        gridPane.getColumnConstraints().add(cc);

        try {
            lines = Files.readAllLines(Paths.get("./src/data.csv"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        for (int i = 0; i < lines.size(); i++) {

            String[] data = lines.get(i).split(",");

            gridPane.addRow(i ,new Text(data[0]), new Text(data[1]));

        }
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}