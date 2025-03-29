package output;

import javax.swing.JOptionPane;

import factory.Output;

public class FrameOutput implements Output {
    @Override
    public void sendData(Object data) {
        JOptionPane.showMessageDialog(null,data);
    }
}