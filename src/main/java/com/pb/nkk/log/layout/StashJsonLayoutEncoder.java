package com.pb.nkk.log.layout;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.encoder.LayoutWrappingEncoder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pb.nkk.log.filler.FillerFactoryImpl;

/**
 * Created by anatoliy on 24.04.2015.
 */
public class StashJsonLayoutEncoder extends LayoutWrappingEncoder<ILoggingEvent> {

    private boolean prettyPrinting = false;

    public void setPrettyPrinting(boolean prettyPrinting) {
        this.prettyPrinting = prettyPrinting;
    }

    @Override
    public void start() {
        StashJsonLayout patternLayout = new StashJsonLayout();
        patternLayout.setFillerFactory(new FillerFactoryImpl());
        Gson gson = prettyPrinting ? new GsonBuilder().setPrettyPrinting().create() : new Gson();
        patternLayout.setGson(gson);
        patternLayout.setContext(context);
        patternLayout.start();
        this.layout = patternLayout;
    }

}
