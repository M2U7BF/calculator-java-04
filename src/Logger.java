import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static final String LOG_FILE = "java.log";
    private static final boolean APPEND_TO_LOG = true;

    private PrintWriter logWriter;

    public Logger() {
        try {
            // ログファイルを作成または追記モードで開く
            File file = new File(LOG_FILE);
            FileWriter fileWriter = new FileWriter(file, APPEND_TO_LOG);
            logWriter = new PrintWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String message) {
        logWriter.println(message);
        logWriter.flush();
    }

    public void close() {
        logWriter.close();
    }
}
