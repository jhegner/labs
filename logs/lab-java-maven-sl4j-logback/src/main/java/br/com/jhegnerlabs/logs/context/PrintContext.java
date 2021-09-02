package br.com.jhegnerlabs.logs.context;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintContext {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(PrintContext.class);

        logger.info("Imprimindo o contexto no Appender Padrao (ConsoleAppender) autoconfigurado");

        // print internal state
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
    }
}
