package output;
import factory.Output;

public class ConsoleOutput implements Output {
    @Override
    public void sendData(Object data) {
        System.out.println("\nEnviando datos a ConsoleOutput: " + data);
    }
}