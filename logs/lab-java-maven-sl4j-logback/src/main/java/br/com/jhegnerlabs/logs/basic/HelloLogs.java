package br.com.jhegnerlabs.logs.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloLogs {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(HelloLogs.class);

        logger.info("Hello for info log");
        logger.debug("Hello for info debug");
        logger.warn("Hello for info warn");
        logger.error("Hello for info error");

    }
}
