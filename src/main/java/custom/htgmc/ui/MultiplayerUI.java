package custom.htgmc.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import custom.htgmc.utils.ConnectServerUtils;
import custom.htgmc.utils.VersionServerUtils;

public class MultiplayerUI {

    public static Scene createMultiplayer(Stage primaryStage) {
        // Ładowanie pliku CSS
        String cssFile = MultiplayerUI.class.getResource("/css/multiplayer.css").toExternalForm();

        // HEADER
        Label headerLabel = new Label("Status Serwerów Minecraft mc.htgmc.pl");
        headerLabel.getStyleClass().add("header-label");

        // MAIN - Tworzymy kafelki
        GridPane serverTiles = new GridPane();
        serverTiles.setHgap(20); // Odstęp w poziomie między kafelkami
        serverTiles.setVgap(20); // Odstęp w pionie między kafelkami
        serverTiles.setAlignment(Pos.CENTER);

        // Dodajemy serwery do kafelków
        serverTiles.add(createServerTile("Serwer 1", "Online", "1.19"), 0, 0);
        serverTiles.add(createServerTile("Serwer 2", "Offline", "1.16"), 1, 0);
        serverTiles.add(createServerTile("Serwer 3", "Online", "1.18"), 0, 1);
        serverTiles.add(createServerTile("Serwer 4", "Offline", "1.14"), 1, 1);

        serverTiles.getStyleClass().add("server-tiles");

        // FOOTER
        Button backButton = new Button("Powrót do menu");
        backButton.setOnAction(e -> primaryStage.setScene(MenuUI.createMenu(primaryStage)));
        backButton.getStyleClass().add("back-button");

        // Tworzymy układ
        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(headerLabel, serverTiles, backButton);
        vbox.setAlignment(Pos.CENTER);

        // Układ typu StackPane
        StackPane root = new StackPane();
        root.getChildren().add(vbox);
        root.setAlignment(Pos.CENTER);

        // Tworzymy tło
        Image backgroundImage = new Image(MultiplayerUI.class.getResourceAsStream("/images/background.jpg"));
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        root.setBackground(new Background(background));

        // Tworzymy scenę
        Scene scene = new Scene(root, 1600, 1000);
        scene.getStylesheets().add(cssFile);  // Załadowanie pliku CSS

        return scene;
    }

    // Pomocnicza metoda do tworzenia kafelka serwera z nazwą, statusem i przyciskiem "Dołącz"
    private static VBox createServerTile(String serverName, String status, String serverVersion) {
        VBox tile = new VBox(10);
        tile.setAlignment(Pos.CENTER);

        // Etykieta z nazwą serwera
        Label serverNameLabel = new Label(serverName);
        serverNameLabel.getStyleClass().add("server-name");

        // Etykieta ze statusem
        Label statusLabel = new Label(status);
        if (status.equals("Online")) {
            statusLabel.getStyleClass().add("online-server");
        } else {
            statusLabel.getStyleClass().add("offline-server");
        }

        // Przycisk "Dołącz na serwer"
        Button joinButton = new Button("Dołącz na serwer");
        joinButton.setOnAction(e -> {
            if (status.equals("Online")) {
                // Sprawdzamy wersję serwera przed próbą połączenia
                boolean isCompatible = VersionServerUtils.isVersionCompatible("mc.htgmc.pl", 25565, serverVersion);
                if (isCompatible) {
                    boolean connected = ConnectServerUtils.connectToServer(serverName);
                    showConnectionStatus(connected);
                } else {
                    showVersionMismatch();
                }
            } else {
                showConnectionStatus(false);
            }
        });

        // Dodajemy nazwę serwera, status oraz przycisk "Dołącz"
        tile.getChildren().addAll(serverNameLabel, statusLabel, joinButton);
        tile.getStyleClass().add("server-tile");

        return tile;
    }

    // Metoda do wyświetlania komunikatu o statusie połączenia
    private static void showConnectionStatus(boolean success) {
        Alert alert = new Alert(success ? AlertType.INFORMATION : AlertType.ERROR);
        alert.setTitle(success ? "Sukces" : "Błąd");
        alert.setHeaderText(success ? "Połączono z serwerem!" : "Nie udało się połączyć.");
        alert.setContentText(success ? "Połączenie z serwerem zostało nawiązane." : "Spróbuj ponownie później.");
        alert.showAndWait();
    }

    // Metoda do wyświetlania komunikatu o niekompatybilnej wersji
    private static void showVersionMismatch() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Wersja niekompatybilna");
        alert.setHeaderText("Serwer nie obsługuje tej wersji protokołu!");
        alert.setContentText("Spróbuj połączyć się z serwerem na odpowiedniej wersji.");
        alert.showAndWait();
    }
}
