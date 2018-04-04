package com.udp.nb.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version 1.0
 * @date 18/3/11 上午11:39
 */
public class ExecutorsUtil {

    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static ExecutorService getExecutor(){
        return executor;
    }

}
