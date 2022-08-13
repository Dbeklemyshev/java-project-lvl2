package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.util.Map;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Parser {
    public static String getDataFromFile(String filepath) throws Exception {
        String str = "";
        try {
            Path path = Paths.get(filepath);
            str = Files.readString(path);
        } catch (Exception e) {
            System.out.println("error in getJsonFromFile");
            e.printStackTrace();
        }
        return str;
    }

    public static Map<String, Object> parseFile(String filepath)  throws Exception {
        String dataFromFile = getDataFromFile(filepath);
        Map<String, Object> map = null;
        if (filepath.endsWith(".json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            map = objectMapper.readValue(dataFromFile, Map.class);
        } else {
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            map = objectMapper.readValue(dataFromFile, Map.class);
        }
        return map;
    }
}