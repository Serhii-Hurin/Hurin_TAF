package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Storage {

    private static Storage instance;
    private static Map<String, Object> storage = new HashMap<>();

    private Storage() {
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public static void rememberThatThe(String key, Object value) {
        storage.put(key, value);
    }

    public static Object whatIsThe(String key) {
        if (storage.containsKey(key)) {
            return storage.get(key);
        } else {
            throw new NoSuchElementException("Key '" + key + "' not found");
        }
    }

}
