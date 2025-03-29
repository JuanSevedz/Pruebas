package adapter;
import factory.DataTypeAdapter;


public class StringToFloatAdapter implements DataTypeAdapter {
    @Override
    public Object adapt(Object data) {
        try {
            return Float.parseFloat((String) data);
        } catch (NumberFormatException e) {
            System.out.println("Error: No se puede convertir a Float.");
            return null;
        }
    }
}
