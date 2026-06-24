import java.util.HashMap;
import java.util.Map;

public class OperationFactory {
    private static final Map<String, Operation> operationMap = new HashMap<>();

    static {
        operationMap.put("+", new AddOperation());
        operationMap.put("-", new SubOperation());
        operationMap.put("*", new MultiOperation());
    }

    public static boolean exists(String operator) {
        return operationMap.containsKey(operator);
    }

    public static Operation getOperation(String operator) {
        return operationMap.get(operator);
    }
}