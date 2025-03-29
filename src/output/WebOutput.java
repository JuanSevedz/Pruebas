package output;

import factory.Output;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class WebOutput implements Output {
    @Override
    public void sendData(Object data) {
        try {
            Desktop.getDesktop().browse(new URI("file:///C:/Users/Juans/OneDrive/Escritorio/pruebaFrame/web/Output.html"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}