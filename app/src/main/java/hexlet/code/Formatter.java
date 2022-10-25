package hexlet.code;

import java.util.Map;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Formatter {
    public static String getStringFormat(List<Map<String, Object>> list, String format) throws Exception {
        if (format.equals("plain")) {
            return getStringValuesPlain(list);
        } else if (format.equals("json")) {
            return getStringValuesJson(list);
        } else {
            return getStringValuesStylish(list);
        }
    }

    private static String getStringValuesJson(List<Map<String, Object>> list) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = "";
        for (Map<String, Object> map: list) {
            result += objectMapper.writeValueAsString(map);
        }
        return result;
    }

    private static String getStringValuesStylish(List<Map<String, Object>> list) {
        String result = "{";
        for (Map<String, Object> map: list) {
            if (map.get("status") == "add") {
                result += "\n  + " + map.get("key") + ": " + map.get("newValue");
            } else if (map.get("status") == "remove") {
                result += "\n  - " + map.get("key") + ": " + map.get("oldValue");
            } else if (map.get("status") == "change") {
                result += "\n  - " + map.get("key") + ": " + map.get("oldValue")
                        + "\n  + " + map.get("key") + ": " + map.get("newValue");
            } else {
                result += "\n    " + map.get("key") + ": " + map.get("oldValue");
            }
        }
        result += "\n}";
        return result;
    }

    private static String getStringValuesPlain(List<Map<String, Object>> list) {
        boolean firstEnter = true;
        String result = "";
        for (Map<String, Object> map: list) {
            if (!map.get("status").equals("unchange") && !firstEnter) {
                result += "\n";
            }
            if (!map.get("status").equals("unchange")) {
                firstEnter = false;
            }
            if (map.get("status").equals("add")) {
                result += "Property '" + map.get("key")
                        + "' was added with value: " + getValue(map.get("newValue"));
            } else if (map.get("status").equals("remove")) {
                result += "Property '" + map.get("key") + "' was removed";
            } else if (map.get("status").equals("change")) {
                result += "Property '" + map.get("key") + "' was updated. From "
                        + getValue(map.get("oldValue"))
                        + " to " + getValue(map.get("newValue"));
            }
        }
        return result;
    }

    private static String getValue(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof Integer || value instanceof Boolean) {
            return value.toString();
        }
        return "[complex value]";
    }
}
