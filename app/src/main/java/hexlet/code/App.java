package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "App", version = "App 1.0",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")

public class App implements Runnable {
    @Option(names = { "-f", "--format" },  defaultValue = "stylish", description = "output format [default: stylish]")
    private static String format;

    @Parameters(paramLabel = "filepath1",
            description = "path to first file")
    private static String filepath1;

    @Parameters(paramLabel = "filepath2",
            description = "path to second file")
    private static String filepath2;

    public final String getGreeting() {
        return "Hello World!";
    }

    @Override
    public void run() {
    }

    public static void main(String[] args) throws Exception {
        int exitCode = new CommandLine(new App()).execute(args);
        String diff = Differ.generate(filepath1, filepath2);
        System.exit(exitCode);
    }
}
