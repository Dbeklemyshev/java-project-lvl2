package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;

@Command(name = "App", version = "App 1.0",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")

public class App implements Runnable{
    @Option(names = { "-f", "--format" }, description = "output format [default: stylish]")
    String format = "stylish";

    @Parameters(paramLabel = "filepath1",
            description = "path to first file")
    private static String filepath1;

    @Parameters(paramLabel = "filepath2",
            description = "path to second file")
    private static String filepath2;

    @Override
    public void run() {
    }

    public static void main(String[] args) throws Exception {
        int exitCode = new CommandLine(new App()).execute(args);
        try {
            String json1 = getJsonData(filepath1);
            String json2 = getJsonData(filepath2);
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map1 = objectMapper.readValue(json1, Map.class);
            Map<String, Object> map2 = objectMapper.readValue(json2, Map.class);
            System.out.println(map1);
            System.out.println(map2);
            Map<String, String> res = genDiff(map1, map2);
            System.out.println(getStringValuesMap(res));
        } catch (Exception e) {
            System.out.println("An error has occurred in main()!");
            e.printStackTrace();
        }
        System.exit(exitCode);
    }
    private static String getJsonData(String filepath) throws Exception {
        String json = "";
        try {
            Path path = Paths.get(filepath);
            json = Files.readString(path);
        } catch (Exception e) {
            System.out.println("An error has occurred in getJsonData()!");
            e.printStackTrace();
        }
        return json;
    }

    private static Map<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, String> result = new LinkedHashMap<>();
        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        for (String key: keys) {
            if(!map1.containsKey(key)) {
                result.put(key, "+ " + key + ": " + map2.get(key));
            } else if (!map2.containsKey(key)) {
                result.put(key, "- " + key + ": " + map1.get(key));
            } else if (map1.get(key).equals(map2.get(key))) {
                result.put(key, "  " + key + ": " + map1.get(key));
            } else {
                result.put(key, "- " + key + ": " + map1.get(key) + "\n+ " + key + ": " + map2.get(key));
            }
        }
        return result;
    }

    private static String getStringValuesMap (Map<String, String> map) {
        String result = "{";
        for(Map.Entry<String, String> mapEntity: map.entrySet()) {
            result += "\n" + mapEntity.getValue();
        }
        result += "\n}";
        return result;
    }
}