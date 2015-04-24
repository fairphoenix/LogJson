package com.pb.nkk.log.logger;

import ch.qos.logback.classic.LoggerContext;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by anatoliy on 23.04.2015.
 */
public final class StashLoggerFactory {

    static public StashLogger getLogger(String name){
        return new StashLoggerImpl(LoggerFactory.getLogger(name));
    }

    static {
        ILoggerFactory icontext = LoggerFactory.getILoggerFactory();
        if(icontext instanceof LoggerContext){
            LoggerContext context = (LoggerContext) icontext;
            List<String> frameworkPackages = context.getFrameworkPackages();
            //frameworkPackages.add("com.pb.nkk.log.logger");
//            frameworkPackages.add("com.pb.nkk.log.layout");
        }
    }

    static public StashLogger getLogger(Class clazz){
        return new StashLoggerImpl(LoggerFactory.getLogger(clazz));
    }

}
