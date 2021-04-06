import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author zhangjin
 */
public class ConfigurationParse {
    private static final Logger logger = LogManager.getLogger(ConfigurationParse.class);

    public static void main(String[] args) {
        if (args.length < 1) {
            throw new RuntimeException("args can't be null");
        }
        logger.info("NTM");
        SingletonPattern pattern = SingletonPattern.getInstance();
        pattern.check(args[0]);
    }
}
