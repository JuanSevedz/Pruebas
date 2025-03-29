package input;

import factory.Input;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;


public class WebInput implements Input {
    @Override
    public Object getData() {
        try {
            Desktop.getDesktop().browse(new URI("file:///C:/Users/Juans/OneDrive/Escritorio/pruebaFrame/web/Input.html"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        // Esperar a que el usuario ingrese el dato
        System.out.println("Por favor, ingrese el dato en la página web y presione Enter en la consola para continuar.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Esperar a que el usuario presione Enter

        return "Dato recibido desde la web"; // Esto se actualizará si logras integrar comunicación real
    }
}