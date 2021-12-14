package br.com.jhegnerlabs.app;

import br.com.jhegnerlabs.scheduler.TimerTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;

public class App {

    static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("***** Iniciando a aplicacao *****");
        Timer timer = new Timer();
        timer.schedule(new TimerTaskService(), 0,120000L);

    }

}
