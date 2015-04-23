package com.pb.nkk.log;

import com.google.gson.GsonBuilder;
import com.pb.nkk.log.data.DebugStashLogData;
import com.pb.nkk.log.data.ErrorStashLogData;
import com.pb.nkk.log.data.MdcLogAttr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.helpers.BasicMarkerFactory;

/**
 * Created by anatoliy on 09.04.2015.
 */
public class TestLog {

    public static void main(String[] args) {
        StashLogger logger = StashLoggerFactory.getLogger(TestLog.class);

//        MDC.put("DURATION", "qwerty");
//        MDC.put("REQUEST_URI", "qwerty");
//        MDC.put("REQUEST_BODY", "qwerty"); // и другие
//        BasicMarkerFactory markerFactory = new BasicMarkerFactory();
//        logger.info(markerFactory.getMarker("OUTREQ"), "Hello OUTREQ");
//
//
//        logger.error("Hello error");
//        logger.debug("Hello debug");

        MDC.put(MdcLogAttr.LOGIN.toString(), "dn110191sav");

        DebugStashLogData logData = new DebugStashLogData().setSid("sidTest").setRef("refTest");
        System.out.println(logData);
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(logData));
        logger.error2stash(new ErrorStashLogData());

        //logger.debug2stash(new DebugStashLogData().setSid("sidTest").setRef("refTest"));


//        try{
//            throw new SecurityException("Boom!");
//        }
//        catch (Exception ex){
//            logger.error(ex.getMessage(), ex);
//        }
        MDC.clear();

    }
}
