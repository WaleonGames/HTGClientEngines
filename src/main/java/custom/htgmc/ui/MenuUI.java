package custom.htgmc.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuUI {

    public static Scene createMenu(Stage primaryStage) {
        // Tworzymy przyciski
        Button startGameButton = new Button("Rozpocznij grę");
        Button settingsButton = new Button("Ustawienia");
        Button exitButton = new Button("Wyjdź");

        // Akcja dla przycisku "Wyjdź"
        exitButton.setOnAction(e -> primaryStage.close());

        // Akcja dla przycisku "Ustawienia"
        settingsButton.setOnAction(e -> {
            // Przechodzimy do SettingsUI
            primaryStage.setScene(SettingsUI.createSettings(primaryStage));
        });

        startGameButton.setOnAction(e -> {
            primaryStage.setScene(MultiplayerUI.createMultiplayer(primaryStage));
        });

        // Ustawienia stylu dla przycisków
        startGameButton.setPrefWidth(300);  // Powiększenie szerokości
        settingsButton.setPrefWidth(300);  // Powiększenie szerokości
        exitButton.setPrefWidth(300);  // Powiększenie szerokości

        // Przyciski - wygląd
        startGameButton.setStyle(
                "-fx-background-color: linear-gradient(#61a2b1, #2A5058);" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 20px;" +  // Zwiększenie rozmiaru czcionki
                        "-fx-padding: 15px 30px;" +  // Zwiększenie paddingu
                        "-fx-pref-height: 60px;" +  // Powiększenie wysokości
                        "-fx-pref-width: 300px;"  // Powiększenie szerokości
        );
        settingsButton.setStyle(
                "-fx-background-color: linear-gradient(#61a2b1, #2A5058);" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 20px;" +  // Zwiększenie rozmiaru czcionki
                        "-fx-padding: 15px 30px;" +  // Zwiększenie paddingu
                        "-fx-pref-height: 60px;" +  // Powiększenie wysokości
                        "-fx-pref-width: 300px;"  // Powiększenie szerokości
        );
        exitButton.setStyle(
                "-fx-background-color: linear-gradient(#61a2b1, #2A5058);" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 20px;" +  // Zwiększenie rozmiaru czcionki
                        "-fx-padding: 15px 30px;" +  // Zwiększenie paddingu
                        "-fx-pref-height: 60px;" +  // Powiększenie wysokości
                        "-fx-pref-width: 300px;"  // Powiększenie szerokości
        );

        // Tworzymy logo Minecraft
        Image minecraftLogo = new Image(MenuUI.class.getResourceAsStream("/images/minecraft_title.png"));
        ImageView logoImageView = new ImageView(minecraftLogo);

        // Styl logo (powiększone)
        logoImageView.setFitWidth(600);  // Powiększenie szerokości logo
        logoImageView.setFitHeight(400);  // Powiększenie wysokości logo
        logoImageView.setPreserveRatio(true);  // Zachowanie proporcji
        logoImageView.setTranslateY(-100);  // Przesunięcie logo w górę

        // Układ pionowy (VBox) dla przycisków
        VBox vbox = new VBox(40); // Zwiększenie odstępu 40px między przyciskami
        vbox.getChildren().addAll(logoImageView, startGameButton, settingsButton, exitButton);
        vbox.setAlignment(Pos.CENTER); // Wyśrodkowanie przycisków w VBoxie
        vbox.setSpacing(40); // Zwiększenie odstępów między przyciskami

        // Układ typu StackPane, który pozwala na wyśrodkowanie VBoxa
        StackPane root = new StackPane();
        root.getChildren().add(vbox);
        root.setAlignment(Pos.CENTER); // Wyśrodkowanie VBoxa w StackPane

        // Tworzymy tło
        Image backgroundImage = new Image(MenuUI.class.getResourceAsStream("/images/background.jpg"));
        javafx.scene.layout.BackgroundImage background = new javafx.scene.layout.BackgroundImage(backgroundImage,
                javafx.scene.layout.BackgroundRepeat.NO_REPEAT,
                javafx.scene.layout.BackgroundRepeat.NO_REPEAT,
                javafx.scene.layout.BackgroundPosition.CENTER,
                new javafx.scene.layout.BackgroundSize(javafx.scene.layout.BackgroundSize.AUTO, javafx.scene.layout.BackgroundSize.AUTO, false, false, true, true));
        // Ustawiamy tło dla StackPane
        root.setBackground(new javafx.scene.layout.Background(background));

        // Tworzymy scenę o wymiarach 1200x800
        Scene scene = new Scene(root, 1600, 1000);

        return scene;
    }
}
