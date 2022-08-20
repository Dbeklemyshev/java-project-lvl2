package hexlet.code;

import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class Differ {
    public static String generate(String filepath1, String filepath2) {
        String generateResult = "";
        try {
            Map<String, Object> map1 = Parser.parseFile(filepath1);
            Map<String, Object> map2 = Parser.parseFile(filepath2);
            Map<String, List<String>> res = genDiff(map1, map2);
            generateResult = getStylish(res);
        } catch (Exception e) {
            System.out.println("An error has ossured in main()!");
            e.printStackTrace();
        }
        return generateResult;
    }

    private static Map<String, List<String>> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, List<String>> result = new LinkedHashMap<>();
        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        for (String key: keys) {
            List<String> listValues = new LinkedList<>();
            if (!map1.containsKey(key)) {
                listValues.add("add");
                listValues.add("");
                listValues.add(map2.get(key).toString());
                result.put(key, listValues);
            } else if (!map2.containsKey(key)) {
                listValues.add("remove");
                listValues.add(map1.get(key).toString());
                listValues.add("");
                result.put(key, listValues);
            } else if (map1.get(key) == null && map2.get(key) != null) {
                listValues.add("change");
                listValues.add("null");
                listValues.add(map2.get(key).toString());
                result.put(key, listValues);
            } else if (map1.get(key) != null && map2.get(key) == null) {
                listValues.add("change");
                listValues.add(map1.get(key).toString());
                listValues.add("null");
                result.put(key, listValues);
            } else if (map1.get(key) == null && map2.get(key) == null || map1.get(key).equals(map2.get(key))) {
                listValues.add("unchange");
                if (map1.get(key) == null) {
                    listValues.add("null");
                } else {
                    listValues.add(map1.get(key).toString());
                }
                if (map2.get(key) == null) {
                    listValues.add("null");
                } else {
                    listValues.add(map2.get(key).toString());
                }
                result.put(key, listValues);
            } else {
                listValues.add("change");
                listValues.add(map1.get(key).toString());
                listValues.add(map2.get(key).toString());
                result.put(key, listValues);
            }
        }
        return result;
    }

    private static String getStylish(Map<String, List<String>> map) {
        List<String> list = new LinkedList<>();
        String result = "{";
        for (Map.Entry<String, List<String>> mapEntity: map.entrySet()) {
            list.clear();
            list.addAll(mapEntity.getValue());
            if (list.get(0) == "add") {
                result += "\n" + "+ " + mapEntity.getKey() + ": " + list.get(2);
            } else if (list.get(0) == "remove") {
                result += "\n" + "- " + mapEntity.getKey() + ": " + list.get(1);
            } else if (list.get(0) == "change") {
                result += "\n" + "- " + mapEntity.getKey() + ": " + list.get(1)
                        + "\n+ " + mapEntity.getKey() + ": " + list.get(2);
            } else {
                result += "\n" + "  " + mapEntity.getKey() + ": " + list.get(1);
            }
        }
        result += "\n}";
        return result;
    }
}
