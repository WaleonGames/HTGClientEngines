package custom.htgmc.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SettingsUI {

    public static Scene createSettings(Stage primaryStage) {
        // Tworzymy przyciski dla ustawień
        Button backButton = new Button("Wróć do menu");

        // Akcja dla przycisku "Wróć"
        backButton.setOnAction(e -> {
            // Przechodzimy z powrotem do głównego menu
            primaryStage.setScene(MenuUI.createMenu(primaryStage));
        });

        // Układ pionowy (VBox) dla przycisku
        VBox vbox = new VBox(20);
        vbox.getChildren().add(backButton);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);

        // Układ typu StackPane
        StackPane root = new StackPane();
        root.getChildren().add(vbox);

        // Tworzymy scenę dla ustawień
        Scene scene = new Scene(root, 1600, 1000);

        return scene;
    }
}
