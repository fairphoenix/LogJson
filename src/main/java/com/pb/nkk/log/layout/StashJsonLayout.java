package com.pb.nkk.log.layout;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pb.nkk.log.data.StashLogData;
import com.pb.nkk.log.filler.Filler;
import com.pb.nkk.log.filler.FillerFactory;

/**
 * Created by anatoliy on 24.04.2015.
 */
public class StashJsonLayout extends LayoutBase<ILoggingEvent> {

    private Gson gson;

    private FillerFactory fillerFactory;

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public void setFillerFactory(FillerFactory fillerFactory) {
        this.fillerFactory = fillerFactory;
    }

    public String doLayout(ILoggingEvent event) {
        Object[] argumentArray = event.getArgumentArray();
        if (argumentArray != null && argumentArray.length > 0) {
            StringBuilder buf = new StringBuilder(128);
            //Берем первый аргумен, так как передача нескольких не предусмотрена
            Object argObj = argumentArray[0];
            if (argObj instanceof StashLogData) {
                Filler filler = fillerFactory.createFillerByData((StashLogData) argObj);
                filler.fillData((StashLogData) argObj, event);
                buf.append(gson.toJson(argObj));
                return buf.toString();
            }
        }
        return CoreConstants.EMPTY_STRING;
    }
}
