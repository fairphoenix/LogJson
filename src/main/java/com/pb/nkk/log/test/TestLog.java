package com.pb.nkk.log.test;

import com.pb.nkk.log.data.ErrorStashLogData;
import com.pb.nkk.log.data.MdcLogAttr;
import com.pb.nkk.log.logger.StashLogger;
import com.pb.nkk.log.logger.StashLoggerFactory;
import org.slf4j.MDC;

import java.util.Map;

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

        MDC.put("MY_ATTR", "SUPER value 123");
        MDC.put(MdcLogAttr.LOGIN.toString(), "dn110191sav");
//        DebugStashLogData logData = new DebugStashLogData().setSid("sidTest").setRef("refTest");
//        System.out.println(logData);
//        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(logData));
        logger.error2stash(new ErrorStashLogData().setErrText("Ooops...").setErrCode("123"));
        //logger.debug2stash(new DebugStashLogData().setSid("sidTest").setRef("refTest"));


        try{
            throw new SecurityException("Boom!");
        }
        catch (Exception ex){
            logger.error(ex.getMessage(), ex);
        }
        MDC.clear();


    }
}
