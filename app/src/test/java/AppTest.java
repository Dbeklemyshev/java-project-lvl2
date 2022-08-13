/*
 * This Java source file was generated by the Gradle 'init' task.
 */
//package app;
import hexlet.code.App;
import hexlet.code.Differ;
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
    void appJsonDifferGenerate() {
        String filepath1 = "src/test/resources/file1_1.json";
        String filepath2 = "src/test/resources/file2_2.json";
        String result = "{"
                + "\n  chars1: [a, b, c]"
                + "\n- chars2: [d, e, f]"
                + "\n+ chars2: false"
                + "\n- checked: false"
                + "\n+ checked: true"
                + "\n- default: null"
                + "\n+ default: [value1, value2]"
                + "\n- id: 45"
                + "\n+ id: null"
                + "\n- key1: value1"
                + "\n+ key2: value2"
                + "\n  numbers1: [1, 2, 3, 4]"
                + "\n- numbers2: [2, 3, 4, 5]"
                + "\n+ numbers2: [22, 33, 44, 55]"
                + "\n- numbers3: [3, 4, 5]"
                + "\n+ numbers4: [4, 5, 6]"
                + "\n+ obj1: {nestedKey=value, isNested=true}"
                + "\n- setting1: Some value"
                + "\n+ setting1: Another value"
                + "\n- setting2: 200"
                + "\n+ setting2: 300"
                + "\n- setting3: true"
                + "\n+ setting3: none"
                + "\n}";
        String diff = Differ.generate(filepath1, filepath2);
        assertEquals(diff, result);
    }

    @Test
    void appYmlDifferGenerate() {
        String filepath1 = "src/test/resources/file1_1.yml";
        String filepath2 = "src/test/resources/file2_2.json";
        String result = "{"
                + "\n  chars1: [a, b, c]"
                + "\n- chars2: [d, e, f]"
                + "\n+ chars2: false"
                + "\n- checked: false"
                + "\n+ checked: true"
                + "\n- default: null"
                + "\n+ default: [value1, value2]"
                + "\n- id: 45"
                + "\n+ id: null"
                + "\n- key1: value1"
                + "\n+ key2: value2"
                + "\n  numbers1: [1, 2, 3, 4]"
                + "\n- numbers2: [2, 3, 4, 5]"
                + "\n+ numbers2: [22, 33, 44, 55]"
                + "\n- numbers3: [3, 4, 5]"
                + "\n+ numbers4: [4, 5, 6]"
                + "\n+ obj1: {nestedKey=value, isNested=true}"
                + "\n- setting1: Some value"
                + "\n+ setting1: Another value"
                + "\n- setting2: 200"
                + "\n+ setting2: 300"
                + "\n- setting3: true"
                + "\n+ setting3: none"
                + "\n}";
        String diff = Differ.generate(filepath1, filepath2);
        assertEquals(diff, result);
    }

    /*
    @Test
    void appJsonDifferGenerate() {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String result = "{"
            + "\n- follow: false"
            + "\n  host: hexlet.io"
            + "\n- proxy: 123.234.53.22"
            + "\n- timeout: 50"
            + "\n+ timeout: 20"
            + "\n+ verbose: true"
            + "\n}";
        String diff = Differ.generate(filepath1, filepath2);
        assertEquals(diff, result);
    }

    @Test
    void appYmlDifferGenerate() {
        String filepath1 = "src/test/resources/file1.yml";
        String filepath2 = "src/test/resources/file2.json";
        String result = "{"
                + "\n- follow: false"
                + "\n  host: hexlet.io"
                + "\n- proxy: 123.234.53.22"
                + "\n- timeout: 50"
                + "\n+ timeout: 20"
                + "\n+ verbose: true"
                + "\n}";
        String diff = Differ.generate(filepath1, filepath2);
        assertEquals(diff, result);
    }
     */
}