import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * The Grid class extends the JavaFX Application class and creates a simple graphical user interface (GUI)
 * with a specified size for the window using FXML for the layout.
 */
public class Grid extends Application{
    private static final int GRID_CANVAS_WIDTH_SIZE = 300;

    private static final int GRID_HEIGHT_SIZE = 330;

    /**
     * The start method is called when the application is launched.
     * It loads the FXML layout, creates a scene with specified width and height,
     * and sets it on the primary stage.
     *
     * @param stage The primary stage for this application, onto which the scene is set.
     * @throws Exception If an error occurs during loading the FXML file or creating the scene.
     */
    public void start(Stage stage) throws Exception{
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("Grid.fxml"));
        Scene scene = new Scene(root, GRID_CANVAS_WIDTH_SIZE, GRID_HEIGHT_SIZE);
        stage.setTitle("Grid");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method is the entry point for the application.
     * It launches the JavaFX application by calling the launch() method.
     *
     * @param args Command line arguments (not used in this case).
     */
    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
        System.out.println();
    }
}
