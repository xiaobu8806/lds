import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author zhangjin
 */
public class ConfigurationParse {
    private static final Logger logger = LogManager.getLogger(ConfigurationParse.class);

    public static void main(String[] args) {
        logger.info("NTM");
        SingletonPattern pattern = SingletonPattern.getInstance();
        pattern.check(args[0]);
    }
}
