import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.util.HashSet;
import java.util.Set;
import java.security.SecureRandom;

public class GridController {
    @FXML
    private Canvas canv;

    private GraphicsContext gc;

    private static final SecureRandom randomNumbers = new SecureRandom();

    private static final int CANVAS_WIDTH_SIZE = 300;

    private static final int CANVAS_HEIGHT_SIZE = 330;

    private final int OFFSET = 10;

    @FXML
    void fillGrid() {
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
                position = row + "," + col; // Unique string for each position
            } while (usedPositions.contains(position)); // Retry if position is already used

            // Add the new position to the set of used positions
            usedPositions.add(position);

            // Draw the rectangle
            gc.fillRect(row, col, OFFSET, OFFSET);
        }
    }

    public void drawMatrix() {
        for (int row = 0; row < CANVAS_HEIGHT_SIZE; row += OFFSET) {
            gc.strokeLine(0, row, CANVAS_WIDTH_SIZE, row);
        } for (int col = 0; col < CANVAS_WIDTH_SIZE; col += OFFSET) {
            gc.strokeLine(col, 0, col, CANVAS_HEIGHT_SIZE);
        }
    }

    public void initialize() {
        gc = canv.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        drawMatrix();
    }
}
