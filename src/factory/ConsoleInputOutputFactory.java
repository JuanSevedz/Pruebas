package factory;
import input.ConsoleInput;
import output.ConsoleOutput;

public class ConsoleInputOutputFactory implements InputOutputFactory {
    @Override
    public Input createInput() {
        return new ConsoleInput();
    }

    @Override
    public Output createOutput() {
        return new ConsoleOutput();
    }
}