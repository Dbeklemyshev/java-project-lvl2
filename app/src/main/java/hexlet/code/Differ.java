package hexlet.code;

import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        List<Map<String, Object>> resList = makeDiffList(filepath1, filepath2);
        String generateResult = Formatter.getStringFormat(resList, "stylish");
        return generateResult;
    }

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        List<Map<String, Object>> resList = makeDiffList(filepath1, filepath2);
        String generateResult = Formatter.getStringFormat(resList, format);
        return generateResult;
    }

    public static List<Map<String, Object>> makeDiffList(String filepath1, String filepath2) {
        List<Map<String, Object>> diffList = new LinkedList<>();
        try {
            Map<String, Object> map1 = Parser.parseFile(filepath1);
            Map<String, Object> map2 = Parser.parseFile(filepath2);
            diffList = genDiff(map1, map2);
        } catch (Exception e) {
            System.out.println("An error has ossured in Differ()!");
            e.printStackTrace();
        }
        return diffList;
    }

    private static List<Map<String, Object>> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        List<Map<String, Object>> resultList = new LinkedList<>();
        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        for (String key : keys) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("key", key);
            resultMap.put("oldValue", map1.get(key));
            resultMap.put("newValue", map2.get(key));
            if (!map1.containsKey(key)) {
                resultMap.put("status", "add");
            } else if (!map2.containsKey(key)) {
                resultMap.put("status", "remove");
            } else if (map1.get(key) == null && map2.get(key) != null) {
                resultMap.put("status", "change");
            } else if (map1.get(key) != null && map2.get(key) == null) {
                resultMap.put("status", "change");
            } else if (map1.get(key) == null && map2.get(key) == null || map1.get(key).equals(map2.get(key))) {
                resultMap.put("status", "unchange");
            } else {
                resultMap.put("status", "change");
            }
            resultList.add(resultMap);
        }
        return resultList;
    }
}
