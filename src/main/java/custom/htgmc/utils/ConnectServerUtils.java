package custom.htgmc.utils;

public class ConnectServerUtils {

    // Metoda symulująca próbę połączenia z serwerem
    public static boolean connectToServer(String serverName) {
        // W tej metodzie można dodać logikę połączenia z serwerem
        // Na przykład możesz użyć Java Sockets do sprawdzenia, czy serwer jest osiągalny
        // W tej wersji jest to tylko symulacja
        System.out.println("Próba połączenia z serwerem: " + serverName);

        // Symulujemy połączenie: Zwróć 'true' jeśli połączenie udane, 'false' jeśli nieudane
        if (serverName.equals("Serwer 1")) {
            return true; // Serwer 1 jest dostępny
        } else {
            return false; // Inne serwery są offline
        }
    }
}
