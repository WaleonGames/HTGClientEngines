package custom.htgmc.utils;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class VersionServerUtils {

    // Sprawdzenie wersji serwera
    public static boolean isVersionCompatible(String serverAddress, int serverPort, String requiredVersion) {
        try (Socket socket = new Socket(serverAddress, serverPort)) {
            // Zakładając, że serwer Minecraft wysyła wersję podczas handshake (protokół 1.7+)
            // Próbujemy pobrać dane o wersji przez protokół handshaking
            // Możesz użyć Minecraft Protocol Library lub napisać własny protokół
            byte[] versionRequest = createHandshakeRequest(requiredVersion);
            socket.getOutputStream().write(versionRequest);
            socket.getOutputStream().flush();

            // Teraz czekamy na odpowiedź serwera (wymaga implementacji handshakingu)
            byte[] response = new byte[1024];
            socket.getInputStream().read(response);

            // Przykładowe sprawdzenie odpowiedzi w zależności od protokołu
            // Możesz sprawdzić, czy odpowiedź serwera zawiera wersję, która odpowiada wymaganej
            String responseString = new String(response, StandardCharsets.UTF_8);
            return responseString.contains(requiredVersion);

        } catch (IOException e) {
            e.printStackTrace();
            return false; // Jeśli wystąpił błąd połączenia lub odczytu
        }
    }

    // Metoda tworząca zapytanie o wersję serwera (w tym przypadku symulacja)
    private static byte[] createHandshakeRequest(String requiredVersion) {
        // Symulowanie zapytania o wersję serwera (w prawdziwej implementacji to będzie bardziej zaawansowane)
        // Protokół Minecraft w wersji 1.7+ wysyła odpowiednie pakiety handshake, które wymagają kodowania
        return ("HandshakeRequest:" + requiredVersion).getBytes(StandardCharsets.UTF_8);
    }
}
