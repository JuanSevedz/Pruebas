package factory;

import input.WebInput;
import output.WebOutput;

public class WebInputOutputFactory implements InputOutputFactory {
    @Override
    public Input createInput() {
        return new WebInput();
    }

    @Override
    public Output createOutput() {
        return new WebOutput();
    }
}