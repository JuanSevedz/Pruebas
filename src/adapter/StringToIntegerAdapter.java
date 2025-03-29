package adapter;

import factory.DataTypeAdapter;

public class StringToIntegerAdapter implements DataTypeAdapter {
    @Override
    public Object adapt(Object data) {
        try {
            return Integer.parseInt((String) data);
        } catch (NumberFormatException e) {
            System.out.println("Error: No se puede convertir a Integer.");
            return null;
        }
    }
}
