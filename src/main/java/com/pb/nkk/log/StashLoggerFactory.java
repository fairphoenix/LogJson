package com.pb.nkk.log;

import org.slf4j.LoggerFactory;

/**
 * Created by anatoliy on 23.04.2015.
 */
public final class StashLoggerFactory {

    static public StashLogger getLogger(String name){
        return new StashLoggerImpl(LoggerFactory.getLogger(name));
    }

    static public StashLogger getLogger(Class clazz){
        return new StashLoggerImpl(LoggerFactory.getLogger(clazz));
    }

}
