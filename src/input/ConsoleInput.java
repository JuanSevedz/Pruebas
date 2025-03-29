package input;

import factory.Input;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    
    @Override
    public Object getData() {
        System.out.print("Ingrese datos: ");
        return scanner.nextLine();
    }
}