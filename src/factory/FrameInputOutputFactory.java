package factory;

import input.FrameInput;
import output.FrameOutput;

public class FrameInputOutputFactory implements InputOutputFactory {
    @Override
    public Input createInput() {
        return new FrameInput();
    }

    @Override
    public Output createOutput() {
        return new FrameOutput();
    }
}