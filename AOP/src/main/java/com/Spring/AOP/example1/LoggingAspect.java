package com.Spring.AOP.example1;

import java.security.PublicKey;
import java.util.logging.Logger;

public class LoggingAspect {
    private Logger logger
            = Logger.getLogger(LoggingAspect.class.getName());
    public void before(){
        logger.info("Entering method");
    }
    public void after(){
        logger.info("Exiting method");

    }
}
