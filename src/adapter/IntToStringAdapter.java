package adapter;

import factory.DataTypeAdapter;

public class IntToStringAdapter implements DataTypeAdapter {
    @Override
    public Object adapt(Object data) {
        return String.valueOf(data);
    }
}
