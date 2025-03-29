import java.util.Scanner;

import adapter.*;
import factory.*;
import output.*;
import input.*;


public class Client {
    private Input input;
    private Output output;
    private DataTypeAdapter adapter;
    
    public Client(InputOutputFactory factory, DataTypeAdapter adapter) {
        this.input = factory.createInput();
        this.output = factory.createOutput();
        this.adapter = adapter;
    }
    
    public void processData() {
        Object data = input.getData();
        
        // Mostrar tipo de dato original
        System.out.println("\nDato ingresado: " + data);
        System.out.println("Tipo original: " + data.getClass().getSimpleName());
        
        // Convertir con adaptador
        Object adaptedData = adapter.adapt(data);

        // Verificar conversión y mostrar el tipo de dato final
        if (adaptedData != null) {
            System.out.println("Dato convertido: " + adaptedData);
            System.out.println("Tipo convertido: " + adaptedData.getClass().getSimpleName());
            output.sendData("Dato: " + adaptedData + " (Tipo: " + adaptedData.getClass().getSimpleName() + ")");
        } else {
            System.out.println("Error en la conversión. No se enviaron datos.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputOutputFactory factory;
        DataTypeAdapter adapter = null;
        
        while (true) {
            System.out.println("Seleccione el modo de operación:");
            System.out.println("1. Consola");
            System.out.println("2. Frame");
            System.out.println("3. Web");
            System.out.print("Ingrese su opción: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Error: Debe ingresar un número válido.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1) {
                factory = new ConsoleInputOutputFactory();
            } else if (choice == 2) {
                factory = new FrameInputOutputFactory();
            } else if (choice == 3) {
                factory = new WebInputOutputFactory();
            } else {
                System.out.println("Opción no válida, intente de nuevo.");
                continue;
            }

            System.out.println("\nSeleccione el tipo de conversión:");
            System.out.println("1. String a Integer");
            System.out.println("2. String a Float");
            System.out.println("3. Integer a String");
            System.out.print("Ingrese su opción: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Error: Debe ingresar un número válido.");
                scanner.next();
                continue;
            }

            int adapterChoice = scanner.nextInt();
            scanner.nextLine();
            
            if (adapterChoice == 1) {
                adapter = new StringToIntegerAdapter();
            } else if (adapterChoice == 2) {
                adapter = new StringToFloatAdapter();
            } else if (adapterChoice == 3) {
                adapter = new IntToStringAdapter();
            } else {
                System.out.println("Opción no válida, intente de nuevo.");
                continue;
            }

            Client client = new Client(factory, adapter);
            client.processData();
            break;
        }
    }
}