package input;

import javax.swing.JOptionPane;

import factory.Input;

public class FrameInput implements Input {
    @Override
    public Object getData() {
        return JOptionPane.showInputDialog("Ingrese datos:");
    }
}