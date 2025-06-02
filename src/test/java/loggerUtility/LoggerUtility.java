package loggerUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import proiectFinal.LogInTest;

public class LoggerUtility {


    private static final Logger logger = LogManager.getLogger();

    public static void startTest(String testName) {
        logger.info("===== EXEXUTION STARTED: " + testName + " ===== ");
    }

    public static void finishTest(String testName) {
        logger.info("===== EXEXUTION FINISHED: " + testName + " ===== ");
    }

    public static void infoLog(String message) {
        logger.info(message);
    }

    public static void errorLog(String message){
        logger.error(message);
    }

}