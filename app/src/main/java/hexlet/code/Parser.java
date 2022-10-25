package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.util.Map;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Parser {
    public static String getFileData(String filepath) throws Exception {
        String str = "";
        try {
            Path path = Paths.get(filepath);
            str = Files.readString(path);
        } catch (Exception e) {
            System.out.println("An error has ossured in getJsonFromFile()!");
            e.printStackTrace();
        }
        return str;
    }

    public static Map<String, Object> parseFile(String filepath)  throws Exception {
        String dataFromFile = getFileData(filepath);
        Map<String, Object> map;
        ObjectMapper objectMapper;
        if (filepath.endsWith(".json")) {
            objectMapper = new ObjectMapper();
        } else {
            objectMapper = new ObjectMapper(new YAMLFactory());
        }
        map = objectMapper.readValue(dataFromFile, Map.class);
        return map;
    }
}
