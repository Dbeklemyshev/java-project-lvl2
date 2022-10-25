/*
 * This Java source file was generated by the Gradle 'init' task.
 */
//package app;
import hexlet.code.App;
import hexlet.code.Differ;
//import hexlet.code.Formatter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    @Test
    void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }

    @Test
    void appJsonDifferGenerateStylish() throws Exception {
        String filepath1 = "src/test/resources/file1_1.json";
        String filepath2 = "src/test/resources/file2_2.json";
        String format = "stylish";
        String result = "{"
                + "\n    chars1: [a, b, c]"
                + "\n  - chars2: [d, e, f]"
                + "\n  + chars2: false"
                + "\n  - checked: false"
                + "\n  + checked: true"
                + "\n  - default: null"
                + "\n  + default: [value1, value2]"
                + "\n  - id: 45"
                + "\n  + id: null"
                + "\n  - key1: value1"
                + "\n  + key2: value2"
                + "\n    numbers1: [1, 2, 3, 4]"
                + "\n  - numbers2: [2, 3, 4, 5]"
                + "\n  + numbers2: [22, 33, 44, 55]"
                + "\n  - numbers3: [3, 4, 5]"
                + "\n  + numbers4: [4, 5, 6]"
                + "\n  + obj1: {nestedKey=value, isNested=true}"
                + "\n  - setting1: Some value"
                + "\n  + setting1: Another value"
                + "\n  - setting2: 200"
                + "\n  + setting2: 300"
                + "\n  - setting3: true"
                + "\n  + setting3: none"
                + "\n}";
        String diff = Differ.generate(filepath1, filepath2, format);
        assertEquals(diff, result);
    }

    @Test
    void appYmlDifferGenerateStylish() throws Exception {
        String filepath1 = "src/test/resources/file1_1.yml";
        String filepath2 = "src/test/resources/file2_2.yml";
        String format = "stylish";
        String result = "{"
                + "\n    chars1: [a, b, c]"
                + "\n  - chars2: [d, e, f]"
                + "\n  + chars2: false"
                + "\n  - checked: false"
                + "\n  + checked: true"
                + "\n  - default: null"
                + "\n  + default: [value1, value2]"
                + "\n  - id: 45"
                + "\n  + id: null"
                + "\n  - key1: value1"
                + "\n  + key2: value2"
                + "\n    numbers1: [1, 2, 3, 4]"
                + "\n  - numbers2: [2, 3, 4, 5]"
                + "\n  + numbers2: [22, 33, 44, 55]"
                + "\n  - numbers3: [3, 4, 5]"
                + "\n  + numbers4: [4, 5, 6]"
                + "\n  + obj1: {nestedKey=value, isNested=true}"
                + "\n  - setting1: Some value"
                + "\n  + setting1: Another value"
                + "\n  - setting2: 200"
                + "\n  + setting2: 300"
                + "\n  - setting3: true"
                + "\n  + setting3: none"
                + "\n}";
        String diff = Differ.generate(filepath1, filepath2, format);
        assertEquals(diff, result);
    }

    @Test
    void appJsonDifferGeneratePlain() throws Exception {
        String filepath1 = "src/test/resources/file1_1.json";
        String filepath2 = "src/test/resources/file2_2.json";
        String format = "plain";
        String result = "Property 'chars2' was updated. From [complex value] to false"
                + "\nProperty 'checked' was updated. From false to true"
                + "\nProperty 'default' was updated. From null to [complex value]"
                + "\nProperty 'id' was updated. From 45 to null"
                + "\nProperty 'key1' was removed"
                + "\nProperty 'key2' was added with value: 'value2'"
                + "\nProperty 'numbers2' was updated. From [complex value] to [complex value]"
                + "\nProperty 'numbers3' was removed"
                + "\nProperty 'numbers4' was added with value: [complex value]"
                + "\nProperty 'obj1' was added with value: [complex value]"
                + "\nProperty 'setting1' was updated. From 'Some value' to 'Another value'"
                + "\nProperty 'setting2' was updated. From 200 to 300"
                + "\nProperty 'setting3' was updated. From true to 'none'";
        String diff = Differ.generate(filepath1, filepath2, format);
        assertEquals(diff, result);
    }

    @Test
    void appYmlDifferGeneratePlain() throws Exception {
        String filepath1 = "src/test/resources/file1_1.yml";
        String filepath2 = "src/test/resources/file2_2.yml";
        String format = "plain";
        String result = "Property 'chars2' was updated. From [complex value] to false"
                + "\nProperty 'checked' was updated. From false to true"
                + "\nProperty 'default' was updated. From null to [complex value]"
                + "\nProperty 'id' was updated. From 45 to null"
                + "\nProperty 'key1' was removed"
                + "\nProperty 'key2' was added with value: 'value2'"
                + "\nProperty 'numbers2' was updated. From [complex value] to [complex value]"
                + "\nProperty 'numbers3' was removed"
                + "\nProperty 'numbers4' was added with value: [complex value]"
                + "\nProperty 'obj1' was added with value: [complex value]"
                + "\nProperty 'setting1' was updated. From 'Some value' to 'Another value'"
                + "\nProperty 'setting2' was updated. From 200 to 300"
                + "\nProperty 'setting3' was updated. From true to 'none'";
        String diff = Differ.generate(filepath1, filepath2, format);
        assertEquals(diff, result);
    }

    @Test
    void appJsonDifferGenerateJson() throws Exception {
        String filepath1 = "src/test/resources/file1_1.json";
        String filepath2 = "src/test/resources/file2_2.json";
        String format = "json";
        String result = "{\"newValue\":[\"a\",\"b\",\"c\"],"
                + "\"oldValue\":[\"a\",\"b\",\"c\"],"
                + "\"key\":\"chars1\","
                + "\"status\":\"unchange\"}"
                + "{\"newValue\":false,"
                + "\"oldValue\":[\"d\",\"e\",\"f\"],"
                + "\"key\":\"chars2\","
                + "\"status\":\"change\"}"
                + "{\"newValue\":true,"
                + "\"oldValue\":false,"
                + "\"key\":\"checked\","
                + "\"status\":\"change\"}"
                + "{\"newValue\":[\"value1\",\"value2\"],"
                + "\"oldValue\":null,"
                + "\"key\":\"default\","
                + "\"status\":\"change\"}"
                + "{\"newValue\":null,"
                + "\"oldValue\":45,"
                + "\"key\":\"id\","
                + "\"status\":\"change\"}"
                + "{\"newValue\":null,"
                + "\"oldValue\":\"value1\","
                + "\"key\":\"key1\","
                + "\"status\":\"remove\"}"
                + "{\"newValue\":\"value2\","
                + "\"oldValue\":null,"
                + "\"key\":\"key2\","
                + "\"status\":\"add\"}"
                + "{\"newValue\":[1,2,3,4],"
                + "\"oldValue\":[1,2,3,4],"
                + "\"key\":\"numbers1\","
                + "\"status\":\"unchange\"}"
                + "{\"newValue\":[22,33,44,55],"
                + "\"oldValue\":[2,3,4,5],"
                + "\"key\":\"numbers2\","
                + "\"status\":\"change\"}"
                + "{\"newValue\":null,"
                + "\"oldValue\":[3,4,5],"
                + "\"key\":\"numbers3\","
                + "\"status\":\"remove\"}"
                + "{\"newValue\":[4,5,6],"
                + "\"oldValue\":null,"
                + "\"key\":\"numbers4\","
                + "\"status\":\"add\"}"
                + "{\"newValue\":{\"nestedKey\":\"value\",\"isNested\":true},"
                + "\"oldValue\":null,"
                + "\"key\":\"obj1\","
                + "\"status\":\"add\"}"
                + "{\"newValue\":\"Another value\","
                + "\"oldValue\":\"Some value\","
                + "\"key\":\"setting1\","
                + "\"status\":\"change\"}"
                + "{\"newValue\":300,"
                + "\"oldValue\":200,"
                + "\"key\":\"setting2\","
                + "\"status\":\"change\"}"
                + "{\"newValue\":\"none\","
                + "\"oldValue\":true,"
                + "\"key\":\"setting3\","
                + "\"status\":\"change\"}";
        String diff = Differ.generate(filepath1, filepath2, format);
        assertEquals(diff, result);
    }

    @Test
    void appYmlDifferGenerateJson() throws Exception {
        String filepath1 = "src/test/resources/file1_1.yml";
        String filepath2 = "src/test/resources/file2_2.yml";
        String format = "json";
        String result = "{\"newValue\":[\"a\",\"b\",\"c\"],"
                + "\"oldValue\":[\"a\",\"b\",\"c\"],"
                + "\"key\":\"chars1\","
                + "\"status\":\"unchange\"}"
                + "{\"newValue\":false,"
                + "\"oldValue\":[\"d\",\"e\",\"f\"],"
                + "\"key\":\"chars2\","
                + "\"status\":\"change\"}"
                + "{\"newValue\":true,"
                + "\"oldValue\":false,"
                + "\"key\":\"checked\","
                + "\"status\":\"change\"}"
                + "{\"newValue\":[\"value1\",\"value2\"],"
                + "\"oldValue\":null,"
                + "\"key\":\"default\","
                + "\"status\":\"change\"}"
                + "{\"newValue\":null,"
                + "\"oldValue\":45,"
                + "\"key\":\"id\","
                + "\"status\":\"change\"}"
                + "{\"newValue\":null,"
                + "\"oldValue\":\"value1\","
                + "\"key\":\"key1\","
                + "\"status\":\"remove\"}"
                + "{\"newValue\":\"value2\","
                + "\"oldValue\":null,"
                + "\"key\":\"key2\","
                + "\"status\":\"add\"}"
                + "{\"newValue\":[1,2,3,4],"
                + "\"oldValue\":[1,2,3,4],"
                + "\"key\":\"numbers1\","
                + "\"status\":\"unchange\"}"
                + "{\"newValue\":[22,33,44,55],"
                + "\"oldValue\":[2,3,4,5],"
                + "\"key\":\"numbers2\","
                + "\"status\":\"change\"}"
                + "{\"newValue\":null,"
                + "\"oldValue\":[3,4,5],"
                + "\"key\":\"numbers3\","
                + "\"status\":\"remove\"}"
                + "{\"newValue\":[4,5,6],"
                + "\"oldValue\":null,"
                + "\"key\":\"numbers4\","
                + "\"status\":\"add\"}"
                + "{\"newValue\":{\"nestedKey\":\"value\",\"isNested\":true},"
                + "\"oldValue\":null,"
                + "\"key\":\"obj1\","
                + "\"status\":\"add\"}"
                + "{\"newValue\":\"Another value\","
                + "\"oldValue\":\"Some value\","
                + "\"key\":\"setting1\","
                + "\"status\":\"change\"}"
                + "{\"newValue\":300,"
                + "\"oldValue\":200,"
                + "\"key\":\"setting2\","
                + "\"status\":\"change\"}"
                + "{\"newValue\":\"none\","
                + "\"oldValue\":true,"
                + "\"key\":\"setting3\","
                + "\"status\":\"change\"}";
        String diff = Differ.generate(filepath1, filepath2, format);
        assertEquals(diff, result);
    }
}
