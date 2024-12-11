package custom.htgmc;

import javafx.application.Application;
import javafx.stage.Stage;
import custom.htgmc.ui.LoadingUI;
import custom.htgmc.utils.LoadingUtils;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("HTG Client Engine - 1.0 alfa");

        // Wyświetlamy ekran ładowania
        LoadingUI.createLoadingScene(primaryStage);

        // Uruchamiamy proces ładowania
        LoadingUtils.simulateLoading();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
