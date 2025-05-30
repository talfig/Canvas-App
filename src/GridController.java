import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.util.HashSet;
import java.util.Set;
import java.security.SecureRandom;

/**
 * The GridController class handles the logic for interacting with the grid canvas in the JavaFX application.
 * It is responsible for filling the grid with random cells and drawing the grid layout on the canvas.
 */
public class GridController {
    @FXML
    private Canvas canv;

    private GraphicsContext gc;

    private static final SecureRandom randomNumbers = new SecureRandom();

    private static final int CANVAS_WIDTH_SIZE = 300;

    private static final int CANVAS_HEIGHT_SIZE = 300;

    private final int OFFSET = 10;

    /**
     * This method is called when the user triggers the "Fill Grid" action.
     * It fills the grid with randomly placed cells while ensuring no two cells overlap.
     * The grid is first cleared, then randomly generated cells are drawn on the grid.
     *
     * @param event The ActionEvent triggered when the user interacts with the UI.
     */
    @FXML
    void fillGrid(ActionEvent event) {
        int fillSize = CANVAS_WIDTH_SIZE * CANVAS_HEIGHT_SIZE / (OFFSET * OFFSET * 10);
        gc.clearRect(0, 0, CANVAS_WIDTH_SIZE, CANVAS_HEIGHT_SIZE);
        drawMatrix();

        // Create a set to store already used positions
        Set<String> usedPositions = new HashSet<>();

        for (int i = 0; i < fillSize; i++) {
            int row, col;
            String position;

            // Keep generating random positions until a unique one is found
            do {
                row = randomNumbers.nextInt(CANVAS_WIDTH_SIZE / OFFSET) * OFFSET;
                col = randomNumbers.nextInt(CANVAS_HEIGHT_SIZE / OFFSET) * OFFSET;
                position = row + "," + col;
            } while (usedPositions.contains(position)); // Retry if position is already used

            // Add the new position to the set of used positions
            usedPositions.add(position);

            // Draw the rectangle
            gc.fillRect(row, col, OFFSET, OFFSET);
        }
    }

    /**
     * This method draws the grid matrix on the canvas by drawing horizontal and vertical lines.
     * Each grid line is spaced according to the offset value to create a structured grid.
     */
    public void drawMatrix() {
        // Draw horizontal grid lines
        for (int row = 0; row < CANVAS_HEIGHT_SIZE; row += OFFSET) {
            gc.strokeLine(0, row, CANVAS_WIDTH_SIZE, row);
        }

        // Draw vertical grid lines
        for (int col = 0; col < CANVAS_WIDTH_SIZE; col += OFFSET) {
            gc.strokeLine(col, 0, col, CANVAS_HEIGHT_SIZE);
        }
    }

    /**
     * This method initializes the controller. It sets up the graphics context for the canvas
     * and draws the initial grid matrix when the application starts.
     */
    public void initialize() {
        gc = canv.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        drawMatrix();
    }
}
