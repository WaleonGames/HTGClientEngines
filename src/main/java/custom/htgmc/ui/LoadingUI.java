package custom.htgmc.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import custom.htgmc.ui.MenuUI;

public class LoadingUI {

    private static Stage primaryStage;  // Stage dla przekazywania do kolejnej sceny
    private static ProgressBar progressBar;  // Statyczny pasek postępu

    public static Scene createLoadingScene(Stage stage) {
        primaryStage = stage;  // Przypisujemy przekazany Stage

        // Tworzymy etykietę, która będzie informować o ładowaniu
        Label loadingLabel = new Label("Ładowanie silnika...");
        loadingLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: white;");

        // Tworzymy pasek postępu
        progressBar = new ProgressBar(0);  // Wartość początkowa = 0
        progressBar.setPrefWidth(500);  // Ustawiamy szerokość paska postępu

        // Układ pionowy (VBox) dla tekstu i paska postępu
        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(loadingLabel, progressBar);
        vbox.setAlignment(Pos.CENTER);

        // Układ typu StackPane, który pozwala na wyśrodkowanie VBoxa
        StackPane root = new StackPane();
        root.getChildren().add(vbox);

        // Tworzymy scenę
        Scene scene = new Scene(root, 1600, 1000);
        scene.setFill(javafx.scene.paint.Color.BLACK);  // Tło czarne

        // Wyświetlamy scenę
        primaryStage.setScene(scene);
        primaryStage.show();

        return scene;
    }

    // Metoda aktualizująca pasek postępu
    public static void updateProgressBar(double progress) {
        if (progressBar != null) {
            progressBar.setProgress(progress);
        }
    }

    // Metoda zmieniająca scenę na MenuUI po zakończeniu ładowania
    public static void switchToMenuUI() {
        // Ustawiamy scenę MenuUI po zakończeniu ładowania
        primaryStage.setScene(MenuUI.createMenu(primaryStage));
    }
}
