package com.pb.nkk.log.layout;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.CoreConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pb.nkk.log.data.StashLogData;
import com.pb.nkk.log.logger.LogDataWriter;
import com.pb.nkk.log.logger.LogDataWriterImpl;

/**
 * Created by anatoliy on 24.04.2015.
 */
public class StashPattenLayout extends PatternLayout {

    private Gson gson;

    private LogDataWriter logDataWriter;

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public void setLogDataWriter(LogDataWriter logDataWriter) {
        this.logDataWriter = logDataWriter;
    }

    public StashPattenLayout() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        logDataWriter = new LogDataWriterImpl();
    }

    @Override
    public String doLayout(ILoggingEvent event) {
        if(event.getArgumentArray() != null){
            StringBuilder buf = new StringBuilder(128);
            for(Object obj: event.getArgumentArray()){
                if(obj instanceof StashLogData){
                    logDataWriter.writeFromEvent(event, (StashLogData) obj);
                    buf.append(gson.toJson(obj));
                } else {
                    buf.append(obj);
                }
                buf.append(CoreConstants.LINE_SEPARATOR);
            }
            return super.doLayout(event) + buf;
        }
        return super.doLayout(event);
    }
}
