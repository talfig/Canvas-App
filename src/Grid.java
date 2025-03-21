import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Grid extends Application{

    private static final int GRID_CANVAS_WIDTH_SIZE = 300;

    private static final int GRID_HEIGHT_SIZE = 300;

    public void start(Stage stage) throws Exception{
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("Grid.fxml"));
        Scene scene = new Scene(root, GRID_CANVAS_WIDTH_SIZE, GRID_HEIGHT_SIZE);
        stage.setTitle("Grid");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
        System.out.println();
    }
}