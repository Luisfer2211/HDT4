import java.util.ArrayList;

public class StackWithArrayList<T> implements IStack<String> {

    private ArrayList<String> internalArrayList;

    public StackWithArrayList() {
        internalArrayList = new ArrayList<>();
    }

    @Override
    public int count() {
        return internalArrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return internalArrayList.isEmpty();
    }

    @Override
    public void push(String value) {
        internalArrayList.add(value);
    }

    @Override
    public String pop() {
        String tempValue = null;
        if (!internalArrayList.isEmpty()) {
            tempValue = internalArrayList.remove(internalArrayList.size() - 1);
        }
        return tempValue;
    }

    @Override
    public String peek() {
        String tempValue = null;
        if (!internalArrayList.isEmpty()) {
            tempValue = internalArrayList.get(internalArrayList.size() - 1);
        }
        return tempValue;
    }
}
