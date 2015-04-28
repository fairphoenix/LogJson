package com.pb.nkk.log.logger;

import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;


/**
 * Created by anatoliy on 23.04.2015.
 */
public final class StashLoggerFactory {

    static {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        //Скрываем информацию при логгировании стектрейса об обертке над logback
        loggerContext.getFrameworkPackages().add("com.pb.nkk.log.logger");
        loggerContext.getFrameworkPackages().add("com.pb.nkk.log.layout");
        loggerContext.getFrameworkPackages().add("ch.qos.logback");
        loggerContext.getLoggerContextRemoteView().getName();
    }

    static public StashLogger getLogger(String name){
        return new StashLoggerImpl(LoggerFactory.getLogger(name));
    }

    static public StashLogger getLogger(Class clazz){
        return new StashLoggerImpl(LoggerFactory.getLogger(clazz));
    }

}
