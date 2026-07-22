import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class logging_config {

    public static Logger getLogger() {
        Logger logger = Logger.getLogger("DevOpsLogger");
        logger.setUseParentHandlers(false);

        try {
            FileHandler file = new FileHandler("app.log", true);
            file.setFormatter(new SimpleFormatter());
            logger.addHandler(file);
        } catch (IOException ignored) {}

        logger.setLevel(Level.INFO);
        return logger;
    }
}