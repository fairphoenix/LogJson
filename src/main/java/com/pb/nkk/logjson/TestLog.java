package com.pb.nkk.logjson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.Marker;
import org.slf4j.helpers.BasicMarker;
import org.slf4j.helpers.BasicMarkerFactory;

/**
 * Created by anatoliy on 09.04.2015.
 */
public class TestLog {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(TestLog.class);

        MDC.put("DURATION", "qwerty");
        MDC.put("REQUEST_URI", "qwerty");
        MDC.put("REQUEST_BODY", "qwerty"); // и другие
        BasicMarkerFactory markerFactory = new BasicMarkerFactory();
        logger.info(markerFactory.getMarker("OUTREQ"), "Hello OUTREQ");


        logger.error("Hello error");
        logger.debug("Hello debug");

        try{
            throw new SecurityException("Boom!");
        }
        catch (Exception ex){
            logger.error(ex.getMessage(), ex);
        }
        MDC.clear();

    }
}
