package custom.htgmc.utils;

import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import custom.htgmc.ui.LoadingUI;

public class LoadingUtils {

    // Metoda symulująca ładowanie silnika
    public static void simulateLoading() {
        Thread loadingThread = new Thread(() -> {
            double progress = 0.0;

            while (progress < 1.0) {
                try {
                    // Symulujemy proces ładowania, zwiększając postęp co 100ms
                    Thread.sleep(100);
                    progress += 0.01;  // Zwiększamy postęp o 1%

                    // Aktualizujemy pasek postępu w głównym wątku aplikacji
                    final double currentProgress = progress;
                    Platform.runLater(() -> LoadingUI.updateProgressBar(currentProgress));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Po zakończeniu ładowania, przełączamy na MenuUI
            Platform.runLater(() -> LoadingUI.switchToMenuUI());
        });

        loadingThread.setDaemon(true);  // Ustawiamy wątek jako daemon, aby nie blokował zamknięcia aplikacji
        loadingThread.start();  // Uruchamiamy wątek
    }
}
