package ar.com.fravega.fravegaChallenge.utils;

import org.slf4j.Logger;

public class LogsUtils {

	private LogsUtils() {

	}

	public static void info(Logger logger, String message) {
		logger.info(message);
	}

	public static void error(Logger logger, String message) {
		logger.error(message);
	}
}
