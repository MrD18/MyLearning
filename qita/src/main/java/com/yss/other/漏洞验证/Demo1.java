package com.yss.other.漏洞验证;

import org.apache.log4j.Logger;

/**
 * @Author: dhao
 * @Date: 2021/6/4 3:51 下午
 */
public class Demo1 {
    private static Logger LOGGER = Logger.getLogger(Demo1.class);

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            LOGGER.info("Shutdown hook initiated.");
        }));
    }

    public void processAndExit() {
        process();
        LOGGER.info("Calling System.exit().");
        System.exit(0);
    }

    public void processAndHalt() {
        process();
        LOGGER.info("Calling Runtime.getRuntime().halt().");
        Runtime.getRuntime().halt(0);
    }

    private void process() {
        LOGGER.info("Process started.");
    }


}
