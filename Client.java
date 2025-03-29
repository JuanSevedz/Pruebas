import java.util.Scanner;

import factory.ConsoleInputOutputFactory;
import factory.FrameInputOutputFactory;
import factory.Input;
import factory.InputOutputFactory;
import factory.Output;
import factory.WebInputOutputFactory;

public class Client {
    private Input input;
    private Output output;
    
    public Client(InputOutputFactory factory) {
        this.input = factory.createInput();
        this.output = factory.createOutput();
    }
    
    public void processData() {
        Object data = input.getData();
        output.sendData(data);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputOutputFactory factory = null;
        
        while (true) {
            System.out.println("Seleccione el modo de operación:");
            System.out.println("1. Consola");
            System.out.println("2. Frame");
            System.out.println("3. Web");
            System.out.print("Ingrese su opción: ");
            
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                
                if (choice == 1) {
                    factory = new ConsoleInputOutputFactory();
                } else if (choice == 2) {
                    factory = new FrameInputOutputFactory();
                } else if (choice == 3) {
                    factory = new WebInputOutputFactory();
                } else {
                    System.out.println("Opción inválida, por favor intente nuevamente.");
                    continue;
                }
                break;
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar entrada inválida
            }
        }
        
        Client client = new Client(factory);
        client.processData();
    }
}